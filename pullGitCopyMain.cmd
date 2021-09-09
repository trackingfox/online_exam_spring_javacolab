@echo off

rem "Git Pull" 
git pull

rem echo Copying all java files from this mirror directory to main directory 
xcopy *.java  ..\online_exam_spring\  /S /C /Y /D
xcopy *.csv   ..\online_exam_spring\ /S /C /Y /D


set /p DUMMY=Hit ENTER to continue...
exit