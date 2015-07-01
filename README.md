[![Build Status](https://travis-ci.org/wm-ci/WmCiJava.svg?branch=develop)](https://travis-ci.org/wm-ci/WmCiJava)
[![Coverity Scan Build Status](https://scan.coverity.com/projects/5457/badge.svg)](https://scan.coverity.com/projects/5457)

# WmCiJava
> The Java Api backend for [WmCi (WebMethods Continuous integration)](https://github.com/wm-ci/WmCi)

[Installation guide](#how-to-install)


## Testing Framework
The testing framework backend is totally hold on `com.wmci.assertion.Eval` class, a total of 10 testing methods are offered in the backend, each one has it's own counterpart `WebMethods Integration Server` `Java Service` on `WmCi.assertion` package, see below the supported methods:

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
Download `WmCiJava.jar` from [jar repository](https://scan.coverity.com/projects/5457) into your preferred `download_path`, and then copy the jar into `WmCi` IS Package static directory.

```
$ cd your_IS_home_directory
$ cp /download_path/WmCiJava.jar packages/WmCi/code/jars/static/.
```
