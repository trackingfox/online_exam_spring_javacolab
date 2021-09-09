@echo off

rem echo Copying all java files from main directory to this mirror directory
xcopy ..\online_exam_spring\*.java  . /S /C /Y /D
xcopy ..\online_exam_spring\*.csv  . /S /C /Y /D

set /p DUMMY=Hit ENTER to continue...
exit