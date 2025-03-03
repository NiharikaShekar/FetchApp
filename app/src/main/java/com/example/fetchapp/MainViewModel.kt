package com.example.fetchapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _items = MutableLiveData<List<Item>>()
    val items: LiveData<List<Item>> get() = _items
    private val TAG = "MainViewModel"

    fun fetchItems() {
        viewModelScope.launch {
            try {
                Log.d(TAG, "Fetching items...")
                val response = RetrofitClient.instance.getItems()
                Log.d(TAG, "Fetched ${response.size} items")


                val filteredItems = response.filter { !it.name.isNullOrBlank() }
                Log.d(TAG, "Filtered to ${filteredItems.size} items")


                val sortedItems = filteredItems.sortedWith(
                    compareBy<Item> { it.listId }
                        .thenBy {
                            // Extract numbers from name for natural sorting
                            val numMatch = "\\d+".toRegex().find(it.name ?: "")
                            numMatch?.value?.toIntOrNull() ?: Int.MAX_VALUE
                        }
                )

                Log.d(TAG, "Final sorted items: ${sortedItems.size}")
                _items.value = sortedItems
            } catch (e: Exception) {
                Log.e(TAG, "Error fetching items", e)
                e.printStackTrace()
            }
        }
    }
}