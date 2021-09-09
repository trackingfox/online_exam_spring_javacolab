@echo off

rem echo Copying all java files from main directory to this mirror directory; copy all not just changed
xcopy ..\online_exam_spring\*.java  . /S /C /Y /D
xcopy ..\online_exam_spring\*.csv  . /S /C /Y /D

rem "Daily git commit" 
git add --all
git commit -am "Changed file Commit."
git push -u origin main
git pull
set /p DUMMY=Hit ENTER to continue...
exit