# Movie Sample App
Fetch  https://www.themoviedb.org Api to show the popular Movies in Grid View.
The app has following packages:**
**data**: It contains all the data accessing and manipulating components.
**di**: Dependency providing classes using Dagger2.
**ui**: View classes along with their corresponding ViewModel.
**utils**: Utility classes.

**Flow of App**

**Screen 1 :**
1.	Form contains two text fields : one is email and other one is password
2.	Email must be valid email address
3.	Password size limitation between 8 - 15 characters
4.	Submit button to be enabled only in case of email & password are valid otherwise it will be disabled
5.	Once Submit button is active move to next screen without any Remote API Call.
once the form validate move to next screen on submit button pressed 
**Screen 2 :**
1.	Using Restful Web APIs load the list of popular Movies on this screen in a grid view with number of columns as 2.
2.	Each Item contains the name and image. Name to be taken from the “title” and image from “poster_path” from the response
## Tech stack & Open-source libraries
- Minimum SDK level 21
- Kotlin
- Corutines 
- Flow
- JetPack
  - Lifecycle - dispose observing data when lifecycle state changes.
  - ViewModel - UI related data holder, lifecycle aware.
  - Live Data  
- **Architecture**
  - MVVM Architecture
  - Repository pattern
  - Hilt - dependency injection
  - DataBinding  - Android DataBinding kit for notifying data changes to UI layers.
**Network Library**
- [Retrofit2 & Gson](https://github.com/square/retrofit) - constructing the REST API
- [OkHttp3](https://github.com/square/okhttp) - implementing interceptor
**Image Loading Library**
-Glide
 
