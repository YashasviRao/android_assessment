# Roche Android Developer Intern role android_assessment

Tasks to accomplish : 

1. Add Room database to store the data.  If I force close (killing the app process) the app and restart the app, the data should persist.  Meaning I should see the content that was created prior to closing the app.
2. Add a login flow by using the Firebase auth service.

Video recording of the application developed can be viewed at https://drive.google.com/file/d/1gm-MAeur-ALzF2QvemjpHE1qqXrdlQSJ/view?usp=share_link

My Work Results :

- With the help of this feature new users will be able to SignUp and existing users can Sign In.
- Once a user completes the SignUp process, they are redirected to the home page of the application, which displays the inventory list along with a floating action button in the bottom right to add new items to the list.
- User is maintained in loggedin state, once signUp process / signIn process is completed
- The home screen of this application is the Inventory list, consisting of the list of Items that a particular user has. Even when the process is stopped or crashes, this state of the Items list persists and is shown to the user when they open the application again.
- New Items can be added to the Inventory list with the help of the floating action button on the bottom right.
- This way, using room database and firebase authentication this integrated workflow was acheived

Enhancements : 

- User can be informed more clearly and explicitly about their login status by using toast messages, everytime their action has any result that can be better conveyed to them.
- One of the requirements of this tasks was to modify the Wellness tasks screens, that is mentioned as a codelab in the jetpack compose tutorial. I worked on this task as well, trying to integrate the authentication process, with the persistance of the state of the wellness tasks checklist.
I wasn't able to deliver this exact behaviour of the application, however I strived to get it to a working state as close as possible, given the time and the complexity of developing the application using a new tech stack. As a result a checklist is visible to interact with after authentication, but its state is not being persisted yet.
The link to refer to the code of this can be found at : https://github.com/YashasviRao/android_auth
