### Box Spell Checker

Box Speel Checker is a java tool to check the spelling in html files, java, php etc. This tools uses configuration files to determine which root directories, extensions should be validated using [regex].

## Pré-requirements

```
java version 1.8.0
```

## Necessary files

<b>For a quick test, download:</b>
- box-spell-checker.jar
- config.json
- dicionario_pt_BR.json (change or create one for your language)

After that read the 'Execution' topic at the end of this readme

## Installation

Ensure that the java are installed on the machine/server. v


```
$ java -version

Openjdk version "1.8.0_72-internal"
OpenJDK Runtime Environment (build 1.8.0_72-internal-b15)
OpenJDK 64-Bit Server VM (build 25.72-b15, mixed mode)
```

## config.json

This file contains the extensions and root directory of the files that must be validated spellings. If you get through the file names ("files":["index.html","login.html"]) the tool will search only those within the configured directory.

The property 'regex' contains the expression for capture phrases inside the files configured. After check is done, phrases and words will be check in the dictionary.

```
{
  "Extensions": [
    {
      "Extension": "html"
      "Path": "/home/user/temp"
      "Files": [ "index.html", "login.html"]
      "Regex": {
       "Expressions": [
                       "> ([A-zA-Z0-9] +) <\ /"
                       "<Div class = (w +) <\ / div>"
                      ]
       "Group": 1
     }
    },
    {
      "Extension": "java"
      "Path": "/root"
      "Files": [],
      "Regex": {
       "Expressions": [
                       "AB ([0-5] +)"
                      ]
       "Group": 1
     }
    }
  ]
 "DictionaryFile":"./dictionary/dictionary.json"
  }
```

## Dictionary

This file contains all known words and with the correct spelling in the system, validation, must possess.

```
[
  "hous(e|es)"
  "Check-out",
  "m(en|am)"
]
```

The words are written in regurar expressions ([regex]) and can have variations in their lyrics. Ex:

```
check
checker
checking
check up
```

```
check(er|ing|\sup)
```


## Execution

1) Open the terminal in box-spell-checker directory
```sh
user@machine~/box-spell-checker $

```

2) Execute the command

```sh
java -jar box-spell-checker.jar

```

3) Validate the log with errors on console terminal:

```sh
LOG OF EXECUTION - 03/25/2016

1) /home/user/temp/test/text.txt:
- Line 1: 'housess', 'systenm'
- Line 10: 'programmmers'

2) /home/user/temp/test/index.html:
- Line 122: 'Faail'

Result: (2) files (4) errors

```

[//]: # (These are urls of references used in this document)

[regex]: <https://pt.wikipedia.org/wiki/Express%C3%A3o_regular>
