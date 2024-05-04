@echo off
rem Batch script to initialize Git repository, commit changes, pull remote changes, and push to GitHub

rem Initialize Git repository
git init

rem Add all files to the staging area
git add .

rem Commit changes with a default message
git commit -m "Initial commit"

rem Set the remote origin to the GitHub repository URL including the subdirectory path
git remote add origin https://github.com/nexustech101/Java/tree/main/Algorithms%20%26%20Data%20Structures

rem Pull changes from the main branch of the remote repository
git pull origin main --allow-unrelated-histories

rem Push changes to the main branch of the remote repository
git push -u origin main

rem Ignore this script file by adding it to the .gitignore file
echo commit.bat >> .gitignore

rem Display success message
echo Initial commit pushed to GitHub successfully!
pause
