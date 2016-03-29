[![Build Status](https://travis-ci.org/wm-ci/WmCiJava.svg?branch=develop)](https://travis-ci.org/wm-ci/WmCiJava)
[![Coverity Scan Build Status](https://scan.coverity.com/projects/5457/badge.svg)](https://scan.coverity.com/projects/5457)

# WmCiJava
> The Java Api backend for [WmCi (WebMethods Testing Automation Framework)](https://github.com/wm-ci/WmCi/tree/develop)

[How to install](#how-to-install)


## Testing Framework
The testing framework backend is totally hold on `com.wmci.assertion.Eval` class, a total of 12 testing methods are offered in the backend, each one has it's own counterpart `WebMethods IS` `Java Service` on `WmCi.assertion` package, see below the supported methods:

   |Java Method|IS Java Service
---|---|---
1.|Eval.equal(String input, String compare)|WmCi.assertion:equal
2.|Eval.notEqual(String input, String compare)|WmCi.assertion:notEqual
3.|Eval.matches(String input, String compare)|WmCi.assertion:matches
4.|Eval.contains(String input, String compare)|WmCi.assertion:contains
5.|Eval.notContains(String input, String compare)|WmCi.assertion:notContains
6.|Eval.decode(String input, String compare, String[] conditions)|WmCi.assertion:decode
7.|Eval.greatThan(String input, String compare)|WmCi.assertion:greatThan
8.|Eval.greatThanEqual(String input, String compare)|WmCi.assertion:greatThanEqual
9.|Eval.isNull(String input)|WmCi.assertion:isNull
10.|Eval.isNotNull(String input)|WmCi.assertion:isNotNull
11.|Eval.lessThan(String input, String compare)|WmCi.assertion:lessThan
12.|Eval.lessThanEqual(String input, String compare)| WmCi.assertion:lessThanEqual



## Utility API
Utility Api backend is served on `com.wmci.util.Util` class, a total of 4 testing methods are offered, each one has it's own counterpart `WebMethods IS` `Java Service` on `WmCi.util` package, see below the supported methods:

   |Java Method|IS Java Service
---|---|---
1.|Util.nvl(String input, String defaultValue, boolean treatEmptyAsNull)|WmCi.util:nvl
2.|Util.decode(String input, String[] conditions, String defaultValue)|WmCi.util:decode
3.|Util.doNotMapNullOrBlanks(String input)|WmCi.util:doNotMapNullOrBlanks
4.|Util.buildPairConditionsArray(String input)|WmCi.util:buildPairConditionsArray


## How to install
Clone this Git project from this repository into your preferred `your_temp_folder`, then recreate the Jar using Gradle building system, and then copy the jar into `WmCi` package static directory.

[How to install Gradle if you don't have installed](https://docs.gradle.org/current/userguide/installation.html)
```
cd /your_temp_folder
git clone https://github.com/wm-ci/WmCiJava.git
cd WmCiJava

# Create the Jar
gradle jar

find . -name *.jar
# You will see the created Jar file:
#    ./build/libs/WmCiJava-0.1.0.jar

# Copy Jar to the your IS Instance
cd your_IS_home_directory
cp /your_temp_folder/./build/libs/WmCiJava-0.1.0.jar packages/WmCi/code/jars/static/WmCiJava.jar
```
