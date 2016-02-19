# CS407_Homework1
# Author: Graham Nygard   
Android Homework 1 for CS407 Mobile Applications

This android application was constructed for homework #1 of CS407 Mobile Applications at the University of Wisconsin - Madison.
This application is a simple two question quiz (one image question, one word problem. The applications has one Activity that
utilizes Fragments and a FragmentManager to switch from screen to screen. The Fragments contained are as follows:

1) StartFragment -    Responsible for supplying the user with the directions on how the app's quiz will be administered.

2) PictureFragment -  Contains the first quiz question. The question on this screen relates to 1 of a possible 3 famous paintings
                      displayed to the user, and the user may submit their answer into an EditText. Depending on the output of a
                      random number generator, the picture and corresponding correct answer will switch in the PictureFragment View.
                      This was implemented to add variety to the quiz questions.
                      
3) TextFragment -     Contains the second quiz question. The question on this screen is a simple word problem, in which the user
                      inputs their answer via a CheckBox.
                      
4) ResultFragment -   Responsible for displaying the user's quiz score along with which questions they answered correctly or
                      incorrectly. The user has the option to restart the quiz or exit the quiz from this Fragment.

Demo link:  https://youtu.be/OdZyWC1GYDk
