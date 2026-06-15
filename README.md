This is a Kotlin Multiplatform project targeting Android and iOS, implementing an MVVM + Repository pattern to fetch and display user data from the DummyJSON API.

## Features
- Fetches user data from `https://dummyjson.com/users/1`.
- Displays user profile: Image, Name, Age, Gender.
- Displays platform-specific Device Name.
- Built with:
    - Ktor for Networking
    - Kotlinx Serialization
    - Coil 3 for Image Loading
    - Compose Multiplatform for UI
    - MVVM + Repository Architecture

## Project Structure
* [/androidApp](./androidApp) contains the Android application entry point.
* [/iosApp](./iosApp) contains the iOS application entry point.
* [/shared](./shared) contains the shared logic and UI.
    - [commonMain](./shared/src/commonMain/kotlin): Shared ViewModel, Repository, Data models, and Compose UI.
    - [androidMain](./shared/src/androidMain/kotlin): Android-specific platform implementation.
    - [iosMain](./shared/src/iosMain/kotlin): iOS-specific platform implementation.

## Getting Started
### Running the apps

Use the run configurations provided by the run widget in your IDE's toolbar. You can also use these commands and options:

- Android app: `./gradlew :androidApp:assembleDebug`
- iOS app: open the [/iosApp](./iosApp) directory in Xcode and run it from there.

### Running tests

Use the run button in your IDE's editor gutter, or run tests using Gradle tasks:

- Android tests: `./gradlew :shared:testAndroidHostTest`
- iOS tests: `./gradlew :shared:iosSimulatorArm64Test`

---

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…