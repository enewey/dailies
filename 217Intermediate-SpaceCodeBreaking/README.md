https://www.reddit.com/r/dailyprogrammer/comments/38fjll/20150603_challenge_217_intermediate_space_code/

#Challenge Description

The year 2266 we have encountered alien planets who use very simple encryption to send messages. Lucky for us we intercept all these messages and we can break the code.
The problem is the collection of messages are all from the same space probe. So we are not sure which message is from what system.
Our challenge today is to decode the message and have our solutions determine which planet system the message came from.
####Edit note:

Copying my ASCII data over as input is causing problems. I see that some people who were true heroes and tackled the problem early are seeing this. To fix this we will be altering the challenge. Input will be a set of numbers each represent a byte in the message. Hopefully this will fix the issues.
###Input:

Message broken down into numbers representing the ASCII values of the message between " "
###Output:

The name of the system and the message decoded.
###Encryption and Planet Systems:
```
Omicron V: will take and invert the 5th bit. ( 0001 0000) That is the bit location in the byte where we invert the bit.

Hoth: Takes the value of the ASCII character and adds 10 to it.

Ryza IV: Takes the value of the ASCII character and subtracts 1 to it.

Htrae: reverses the characters.
```

###Validation:

It is not enough to just take the message and decode it in all 4 ways and let you decide which one is right or wrong. You need to have your program/solution determine the right decoding. All messages are in english (I know even in the future on alien planets).
