https://www.reddit.com/r/dailyprogrammer/comments/33hwwf/20150422_challenge_211_intermediate_ogre_maze/

#Challenge Description

Today we are going to solve a maze. What? Again? Come on, Simpsons did it. Yah okay so we always pick a hero to walk a maze. This time our hero is an Ogre.
An ogre is large. Your run of the mill hero "@" takes up a 1x1 spot. Easy. But our beloved hero today is an ogre.

```
 @@
 @@
```

Ogres take up a 2x2 space instead of a 1x1. This makes navigating a maze tougher as you have to handle the bigger ogre.
So I will give you a layout of a swamp. (Ogres navigate swamps while puny heroes navigate caves. That's the unwritten rules of maze challenges) You will find the path (if possible) for the ogre to walk to his gold.

###Input:

You will read in a swamp. The swamp is laid out in 10x10 spaces. Each space can be the following:
* . - empty spot
* @ - 1/4th of the 2x2 ogre
* $ - the ogre's gold
* O - sink hole - the ogre cannot touch these. All 2x2 of the Ogre manages to fall down one of these (even if it is a 1x1 spot too. Don't be bothered by this - think of it as a "wall" but in a swamp we call them sink holes)

###Output:

You will navigate the swamp. If you find a path you will display the solution of all the spaces the ogre will occupy to get to his gold. Use a "&" symbol to show the muddy path created by the ogre to reach his gold. If there is no path at all then you will output "No Path"
