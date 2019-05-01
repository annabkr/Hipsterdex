# Hipsterdex

Hipsterdex is a console application that, given a URL, will scan the content of a website and assign it a "Hipster Index Score" after evaluating the percentage of hipster words and their respective hipster-ness. 

## Getting Started
These instructions will get a copy of the project up and running on your local machine.

## Installing

Download or clone the repository. In the console, navigate to the project directory. 

Build using the **gradle wrapper**:
```
./gradlew build
```
Run with:
```
./gradlew run
```

## Running the Tests

```
./gradlew test
```

## Built With

* [Gradle](https://gradle.org/releases/) - Dependency management
* [Jflex](https://jflex.de/) - Scanner generator used for lexical analysis 
* [Boilerpipe](https://github.com/kohlschutter/boilerpipe) - Boilerplate Removal and Fulltext Extraction from HTML pages
