# Unit 4: Navigation and app architecture

Kotlin implementations for all three pathways in [Android Basics Unit 4](https://developer.android.com/courses/android-basics-compose-firebase/unit-4).

Open each app folder separately in Android Studio. Kotlin source files are under `app/src/main/java`; lesson tests are under `app/src/test` and `app/src/androidTest` where supplied. See [the Kotlin file index](KOTLIN_FILES.md) for direct links.

| Pathway | Folder | Completed work |
| --- | --- | --- |
| 1 | DessertClickerLifecycle | Activity lifecycle logging and rememberSaveable |
| 1 | DessertClickerApp | Dessert Clicker with ViewModel and UI state |
| 1 | UnscrambleApp | ViewModel, StateFlow, game logic, and unit tests |
| 2 | CupCakeApp | Existing navigation implementation plus official navigation and screen tests |
| 2 | LunchTrayApp | Multi-screen order navigation and checkout |
| 3 | ReplyApp | Adaptive navigation, list/detail layout, and adaptive UI tests |
| 3 | SportsApp | Adaptive list/detail sports browser |
| 3 | MyCityApp | Original Explore Ottawa app with categories, Jetpack Navigation, adaptive navigation rail and list/detail panes, and saved favorites |

The lesson apps are Google's published solutions, retaining their original copyright notices and licenses. Repositories use the prefix `https://github.com/google-developer-training/basic-android-kotlin-compose-training-` with these suffixes and branches:

- `dessert-clicker`: `main` for lifecycle, `viewmodel` for architecture practice.
- `unscramble`, `lunch-tray`, `reply-app`, and `sports`: `main`.
- `cupcake`: `main`, downloaded as `CupcakeReference` for comparison and test sources. Existing CupCakeApp main source matched the official solution and was preserved.

MyCityApp uses offline Ottawa sample content with three categories and three places per category. It uses compact screens below 600 dp, a navigation rail from 600 dp, and two panes from 840 dp. Favorite IDs are held by a ViewModel in SavedStateHandle. No photos or API keys are required.

Use JDK 17 for the older Gradle lesson projects. Let Android Studio install the SDK/dependencies requested by each project. Run `gradlew.bat :app:assembleDebug :app:testDebugUnitTest` from an app folder. Instrumented tests require a running Android emulator/device; run `gradlew.bat :app:connectedDebugAndroidTest` for apps with those tests.

These files cover coding exercises. Watching videos, taking quizzes, and marking progress in your Google learning account are separate activities.

## Verification

Checked the downloaded branches, lifecycle logging, source/test file presence, and confirmed the existing Cupcake main source matches Google's solution. No Kotlin TODO markers remain in the projects.

Attempted MyCityApp's debug build and unit tests with JDK 17. Gradle configuration proceeded, but the build stopped because Android SDK platform `android-34` is missing locally. The build and tests have therefore not passed. Install Android SDK Platform 34 in Android Studio's SDK Manager, sync, and rerun the command above. Instrumented UI tests have not been run on a device/emulator.
