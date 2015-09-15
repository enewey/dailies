https://www.reddit.com/r/dailyprogrammer/comments/3ke4l6/20150909_challenge_231_intermediate_set_game/

#Challenge Description

Set is a card game where each card is defined by a combination of four attributes: shape (diamond, oval, or squiggle), color (red, purple, green), number (one, two, or three elements), and shading (open, hatched, or filled). The object of the game is to find sets in the 12 cards drawn at a time that are distinct in every way or identical in just one way (e.g. all of the same color). From Wikipedia: A set consists of three cards which satisfy all of these conditions:
They all have the same number, or they have three different numbers.
They all have the same symbol, or they have three different symbols.
They all have the same shading, or they have three different shadings.
They all have the same color, or they have three different colors.
The rules of Set are summarized by: If you can sort a group of three cards into "Two of ____ and one of _____," then it is not a set.
See the Wikipedia page for the Set game https://en.wikipedia.org/wiki/Set_(game) for for more background.

###Input Description

A game will present 12 cards described with four characters for shape, color, number, and shading: (D)iamond, (O)val, (S)quiggle; (R)ed, (P)urple, (G)reen; (1), (2), or (3); and (O)pen, (H)atched, (F)illed.

###Output Description

Your program should list all of the possible sets in the game of 12 cards in sets of triplets.
