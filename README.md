[![Build Status](https://travis-ci.org/wm-ci/WmCiJava.svg?branch=develop)](https://travis-ci.org/wm-ci/WmCiJava)
[![Coverity Scan Build Status](https://scan.coverity.com/projects/5457/badge.svg)](https://scan.coverity.com/projects/5457)

# WmCiJava
> The Java Api backend for WmCi (WebMethods Continuous integration)

[Installation guide](#how-to-install)


## Testing Framework
The testing framework backend is totally hold on class `com.wmci.assertion.Eval`, a total of 10 testing methods are offered in the backend, each one has it's counterpart `WebMethods Integration Server` `Java Service` on `WmCi.assertion` package, see below the supported methods:


 | Java Method | IS Java Service|
|-|-|-|
|1.| Eval.equal(String input, String compare) | WmCi.eval:equal |
|2.| Eval.notEqual(String input, String compare) | WmCi.eval:notEqual |
|3.| Eval.matches(String input, String compare) | WmCi.eval:matches |
|4.| Eval.contains(String input, String compare) | WmCi.eval:contains |
|5.| Eval.notContains(String input, String compare) | WmCi.eval:notContains |
|6.| Eval.decode(String input, String compare, String[] conditions) | WmCi.eval:decode |
|7.| Eval.greatThan(String input, String compare) | WmCi.eval:greatThan |
|8.| Eval.greatThanEqual(String input, String compare) | WmCi.eval:greatThanEqual |
|9.| Eval.isNull(String input) | WmCi.eval:isNull |
|10.| Eval.isNotNull(String input) | WmCi.eval:isNotNull |
|11.| Eval.lessThan(String input, String compare) | WmCi.eval:lessThan |
|12.| Eval.lessThanEqual(String input, String compare) | WmCi.eval:lessThanEqual |


## Utility API
TODO:

## How to install
TODO:
