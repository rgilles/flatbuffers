@echo off
rem Copyright 2014 Google Inc. All rights reserved.
rem
rem Licensed under the Apache License, Version 2.0 (the "License");
rem you may not use this file except in compliance with the License.
rem You may obtain a copy of the License at
rem
rem     http://www.apache.org/licenses/LICENSE-2.0
rem
rem Unless required by applicable law or agreed to in writing, software
rem distributed under the License is distributed on an "AS IS" BASIS,
rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
rem See the License for the specific language governing permissions and
rem limitations under the License.

rem Compile then run the Java test.

set batch_file_dir=%~d0%~p0
set targetdir=%batch_file_dir%\target


if exist "%targetdir%" (
    echo clean target
    rmdir /Q /S %targetdir%
)

mkdir %targetdir%

rem remove previous class from previous build style
@echo Deleting old class files in source folders
del /S ..\java\*.class
del /S *.class

@echo Compile
javac -g -d %targetdir% -classpath %batch_file_dir%\..\java;%batch_file_dir%;%batch_file_dir%\namespace_test;%batch_file_dir%\keysearch_test JavaTest.java
@echo Execute JavaTest
java -ea -classpath %targetdir% JavaTest

rmdir /Q /S %targetdir%
