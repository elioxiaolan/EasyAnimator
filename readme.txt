Overview

This project is a final project "Easy Animator" using the classic Model-View-Controller architecture. In the model, we used two linkedhashmap lists to 
give the right shapes we need to use in the view. In the view, we designed three kinds of view——textview, svgview and visual-view. In the controller, 
we used the controller to control whether to run animation of text, svg or visual.

Model

In order to implement the function, we designed three important interfaces to do this. They are ShapeInterface, MotionInterface and ProcessInterface. 
The first two interfaces are helper interface which ficilitate the implementation the final interface—ProcessInterface.

ShapeInterface: 
In this interface, we designed the functionalities that the shapes need to have. Then we used an abstract class to implement the details  of ShapeInterface. 
We designed two kinds of shapes which are rectangle and ellipse.

AbstractShape: 
In this abstract class, it implements most basic and common method that shapes need like getX and getWidth.

Rectangle: 
It is a subclass which extends from the AbstractShape. It represents the rectangle shape.

Ellipse: 
It is a subclass which extends from the AbstractShape. It represents the Ellipse shape.

Shapes: 
It is an enum class which contains two kinds of shape type. They are rectangle and ellipse.

MotionInterface: 
In this interface, we designed the functionalities that the motions need to have. Then we used an abstract class to implement the details
of MotionInterface.

ChangeColor: 
A class which can change the red, green and blue value which determine the final color of the shape.

ChangePosition: 
A class which can change the x and y coordinate of the shape.

ChangeSize: 
A class that can change the width and height of the shape to change the size of the shape.

ProcessInterface: 
In this interface, we designed the functionalities that the animator need to have. 

ProcessImpl: 
This class models the whole animator.

View

We have three view types in this project. They are visual view, text view and svg view.

Textview:
It describes how these shapes will move as the animation proceeds from start to finish.

Svgview:
It translates the two important list(mapOfShape and mapOfMotions)to the svg format.

VisualView
The visual view use the getstate method in the ProcessImpl to get the list of shapes in a certain tick and then use the Swing(JFrame and JPanel)to paint it in the canvas. 
We can paint all the ticks in the given time and we get the animation.

Controller

In the controller, we run the animation by the method runAnimation and if the type of view is text view, it will call the runTextView and print the view in string . 
If the type of view is svg view, it will call the runSvgView and we can get the svgview in a file. And if the view is visual view, it will call the runVisualView. 
And by using a while loop, we get every tick's picture and then we get the animation.
