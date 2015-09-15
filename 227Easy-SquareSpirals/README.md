https://www.reddit.com/r/dailyprogrammer/comments/3ggli3/20150810_challenge_227_easy_square_spirals/

#Challenge Description

Take a square grid, and put a cross on the center point, like this:
```
+ + + + +

+ + + + +

+ + X + +

+ + + + +

+ + + + +
```
The grid is 5-by-5, and the cross indicates point 1. Let's call the top-left corner location (1, 1), so the center point is at location (3, 3). Now, place another cross to the right, and trace the path:
```
+ + + + +

+ + + + +

+ + X-X +

+ + + + +

+ + + + +
```
This second point (point 2) is now at location (4, 3). If you continually move around anticlockwise as much as you can from this point, you will form a square spiral, as this diagram shows the beginning of:
```
+ + + + +

+ X-X-X .
  |   | .
+ X X-X .
  |     |
+ X-X-X-X

+ + + + +
```
Your challenge today is to do two things: convert a point number to its location on the spiral, and vice versa.
Formal Inputs and Outputs

###Input Specification

On the first line, you'll be given a number S. This is the size of the spiral. If S equals 5, then the grid is a 5-by-5 grid, as shown in the demonstration above. S will always be an odd number.
You will then be given one of two inputs on the next line:
You'll be given a single number N - this is the point number of a point on the spiral.
You'll be given two numbers X and Y (on the same line, separated by a space) - this is the location of a point on the spiral.
###Output Description

If you're given the point number of a point, work out its location. If you're given a location, find out its point number.
