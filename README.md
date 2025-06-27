Fetch Exercise

Description:
  An Android app that displays a ListView containing items retrieved from a Fetch API that is parsed to exclude items with blank or null names. Items are sorted first by their list id and their name.

Running the Project:
  - Clone the repository: git clone https://github.com/jdcruzjr/FetchExercise.git
  - Open the project in Android Studio
  - Build and run the app on the emulator
 
Prerequisites
  - Android Studio: The project was built on the latest stable version of Android Studio
  - Android SDK: SDK version 36 or higher is required
  - Kotlin: The project uses the latest version of Kotlin

How it works
  - The app fetches the json from the API
  - Json is then parsed and added to a mutable list of a custom FetchItems class
  - The mutable list is sorted
  - Finally, the mutable list is displayed with a custom ArrayAdapter
