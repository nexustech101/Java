rem Batch script to initialize Git repository, commit changes, and push to GitHub

rem Initialize Git repository
git init

rem Add all files to the staging area
git add .

rem Commit changes with a default message
git commit -m "Initial commit"

rem Set the remote origin
git remote add origin https://github.com/nexustech101/Java.git

rem Push changes to the main branch of the remote repository
git push -u origin main

rem Ignore this script file by adding it to the .gitignore file
echo init_commit_push.bat >> .gitignore

rem Display success message
echo Initial commit pushed to GitHub successfully!
pause
