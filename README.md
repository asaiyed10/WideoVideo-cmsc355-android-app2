# WideoVideo-cmsc355-android-app

Iteration 1:

-In this iteration, we created the basic UI for our app. We can mostly navigate around the activities using the current UI. We will implement more functions to it in later iterations. 

-The camera activity (the activity linked to Record button) works best with API 21. The Nexus 5X API 24 (Nougat) couldn't even open its built in camera so it wouldn't work with this app.

-The settings activity doesn't change the camera's values yet. It contains the buttons for now. Since it isn't completed, we didn't close the user story 2, we will continue to work on it in later iterations.

-The Espresso tests should be run individually. When bundled together, they don't run very well (may be it only happens on my emulator).

Iteration 2 

-Share button is working fine but our emulator doesnt have the share apps (Facebook, Dropbox, etc) that are supposed to show up on the screen when Share button is pressed. The tutorials that taught me the methods to do the share button did it in a similar way and it is working fine. Other than that, the share button code is working if it was on a real phone that has other sharing apps. 
