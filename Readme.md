# Online Assessment

Online Assessment is an Android application designed to provide users with a platform to take quizzes on various subjects such as Operating Systems, Android, Python, and Java. The app integrates Firebase for authentication and database management.

## Features

- **User Authentication**: Users can register and log in using Firebase Authentication.
- **Quiz Categories**: Choose from multiple subjects like Operating Systems, Android, Python, and Java.
- **Countdown Timer**: A countdown timer before the quiz starts.
- **Quiz Dashboard**: Interactive quiz interface with multiple-choice questions.
- **Score Sharing**: Share your quiz results with others.
- **Firebase Integration**: Real-time database for storing quiz questions and user data.

## Screenshots

Add screenshots of your app here to showcase its features.

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo/online-assessment.git
   ```
2. Open the project in Android Studio.
3. Replace the existing `google-services.json` file located in `OnlineAssessment\app\google-services.json` with the `google-services.json` file downloaded from your Firebase project.
4. Sync the project with Gradle files.
5. Add your Firebase configuration file (google-services.json) to the app/ directory.
6. Build and run the app on an Android device or emulator.

## Dependencies

The project uses the following dependencies:

- Firebase Authentication
- Firebase Realtime Database
- Circular Progress Bar
- AndroidX Libraries

## Project Structure

      OnlineAssessment/
      ├── app/
      │ ├── src/
      │ │ ├── main/
      │ │ │ ├── java/com/example/onlineassessment/
      │ │ │ │ ├── [MainActivity.java]
      │ │ │ │ ├── [LoginActivity.java]
      │ │ │ │ ├── [RegistrationActivity.java]
      │ │ │ │ ├── [OptionsActivity.java]
      │ │ │ │ ├── [CountdownActivity.java]
      │ │ │ │ ├── [DashboardActivity.java]
      │ │ │ │ ├── [WonActivity.java]
      │ │ │ │ ├── [Modelclass.java]
      │ │ │ ├── res/
      │ │ │ │ ├── layout/
      │ │ │ │ ├── drawable/
      │ │ │ │ ├── values/
      │ ├── [build.gradle]
      ├── [build.gradle]
      ├── [settings.gradle]

## How to Use

1. Launch the app.
2. Register or log in using your email and password.
3. Select a subject from the options provided.
4. Wait for the countdown timer to finish.
5. Answer the quiz questions within the given time.
6. View your score and share it with others.
