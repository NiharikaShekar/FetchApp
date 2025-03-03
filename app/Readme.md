# Fetch Rewards Coding Challenge

An Android application that retrieves and displays data from the Fetch Rewards API, showcasing my Android development skills in Kotlin.

## Project Overview

This application fetches data from the Fetch Rewards hiring API endpoint and displays it in an organized list with the following specifications:

- Data is grouped by "listId"
- Results are sorted first by "listId" then by "name"
- Items with blank or null names are filtered out
- Data is presented in an easy-to-read, visually appealing list format

## Features

- Clean, modern Material Design UI
- Efficient data processing and filtering
- RecyclerView implementation with section headers for list groups
- MVVM architecture pattern
- Retrofit for API requests
- Card-based UI for improved readability
- Loading indicator for better user experience

## Technical Implementation

- **Language**: Kotlin
- **Architecture**: MVVM (Model-View-ViewModel)
- **Network**: Retrofit with Gson converter
- **UI Components**: RecyclerView, CardView, ConstraintLayout
- **Data Binding**: ViewBinding

## Screenshots

[Screenshots would go here]

## Setup Instructions

1. Clone this repository
2. Open the project in Android Studio
3. Build and run the application on a device or emulator running Android 7.0 (API level 24) or higher

## API

The app fetches data from: https://fetch-hiring.s3.amazonaws.com/hiring.json

## Contact

Feel free to reach out if you have any questions about my implementation!

[Your Name]
[Your Contact Information]