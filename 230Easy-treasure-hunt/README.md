https://www.reddit.com/r/dailyprogrammer/comments/3j3pvm/20150831_challenge_230_easy_json_treasure_hunt/

#Challenge Description

One of the most common ways for computers to communicate with each other today, especially over the internet, is a format known as JSON. JSON stands for JavaScript Object Notation and has it's origins in JavaScript, but nowadays libraries exist to parse it in pretty much every language in common use. JSON is a pretty great tool for this, because it is very compact and easily parsable, yet it's also very easy for humans to read and write.
There are 6 different fundamental types in JSON:
* null, which usually signifies the absense of a value
* A number, like 3, 4, 5 or 2.718281828 (JSON makes no distinction between integers and floats)
* A boolean, either true or false
* A string, some number of characters between quotation marks: "hello world", for instance
* A list, which is an ordered list of JSON values: [1, 3.14, [null, "popsicle"], false] for instance.
* An "object", which is an unordered list of key-value pairs. The keys are always strings, and the values can be any JSON object: {"key1": [1,2,3], "key2": {"nestedKey": 14}}, for instance.

In strict JSON, the "root" is always an object. Here's a JSON document for demonstration:
```
{
    "name": "William Shakespeare",
    "birthYear" : 1564,
    "dead" : true,
    "deathYear" : 1616,
    "selectedWorks" : [
        {
            "name" : "The Tragedy of Macbeth",
            "written" : 1606,
            "isItAwesome" : true
        },
        {
            "name" : "Coriolanus",
            "written" : 1608,
            "isItAwesome" : "It's alright, but kinda fascist-y"
        }
    ],
    "wife" : {
        "name" : "Anne Hathaway",
        "birthYear" : 1555,
        "dead" : false,
        "deathYear" : "Fun fact, she's a vampire"
    },
    "favoriteWebsites" : [
        "dailysonneter",
        "dailyprogrammer",
        "vine (he's way into 6-second cat videos)"
    ],
    "facebookProfile" : null
}
```
Note that this JSON document has been pretty-printed, which means that a bunch of spaces and indentation has been added in to make it look nicer, but they make no difference. Whitespace that is outside a string has no meaning in JSON.
If you wish to find the name of the first play in the list of selected works, you could say that the "path" to it looks something like this:
```
selectedWorks -> 0 -> name
```
You would say that the value located at this path is "The Tragedy of Macbeth". The value "dailyprogrammer" is located at:
```
favoriteWebsites -> 1
```
Notice that JSON lists are zero-based, so the first item in the list has index 0.
Your challenge today is as follows: you will be given a JSON object, and you will print out the search path that leads to the value "dailyprogrammer". You are allowed to use any JSON parsing libraries that you want to, today's challenge is not about parsing JSON, it's about finding a key hidden in a JSON object. If you wish to write a parser yourself, you are of course allowed to do so (though I personally think that would be a little nuts), but you are absolutely not required to do so in any way.
##Formal inputs & outputs

###Inputs

The input will be a JSON document which contains the string "dailyprogrammer" somewhere as a value. The JSON document is guaranteed to be valid and use no non-ASCII characters.
###Outputs

The search-path for the string "dailyprogrammer", in the format described above. Each "element" of the path will either be an integer (if it's indexing a list) or a string (if it's indexing an object). The elements should be joined together with " `->` " between them.
