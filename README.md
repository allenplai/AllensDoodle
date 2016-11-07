Allens Doodle
=================

An Android app that allows to draw something on your phone. [Support](http://twitter.com/allenplai)

![demo](http://i.imgur.com/4gwXIDN.gif)

###Code
* **DoodleView.Java** is a custom view and is the canvas of where the user can draw. It has all the functions of changing color, brush size, 
undo and clear by using the [Path](https://developer.android.com/reference/android/graphics/Path.html)
and [Paint](https://developer.android.com/reference/android/graphics/Paint.html) class


* **MainActivity.Java** handles the all the Seek Bars and the onClickMethods and then calls methods provided in DoodleView class.

* **activity_main.xml** is the layout of the app. It uses gridLayout to hold all the seek bars on the bottom of the DoodleView.

###References
Here is the list of references used to make this app

* Basic Android
  * https://www.youtube.com/watch?v=2-mmH_nOE9Q&feature=youtu.be - Step by step tutorial of how to make a calculator
* Doodle
  * https://youtu.be/ktbYUrlN_Ws - Quick Intro to Creating a Custom View in Android - Step by step tutorial of how to get a Doodle working made by Prof. Jon Froehlich
* SeekBar
  * http://stackoverflow.com/questions/9792888/android-seekbar-set-progress-value
  * https://developer.android.com/reference/android/widget/SeekBar.html
* Layout
 * https://developer.android.com/guide/topics/ui/declaring-layout.html







