# Android Project using Kotlin Gradle Script

This is an example of a standard App (with a root `build.gradle` and a module `build.gradle`) that uses Kotlin on gradle scripts.

This code is based on several examples at [Gradle Kotlin Script](https://github.com/gradle/gradle-script-kotlin/tree/master/samples) repository.

Note this is still a experimental Gradle feature, so not meant to be used in a real App.

## How to use

This example was implemented using Kotlin 1.1-M03 EAP. It won't work with current stable releases.

I couldn't make it work either running from Android Studio, but it did using the terminal:

```
./gradlew installDebug
```

##License

    Copyright 2016 Antonio Leiva

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.