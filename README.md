# Languages-References
Personal reference of all programming languages I've studied. Contains basic programming language notes to remember, specific topics related to a certain language, and some general software engineering notes.

# TODO:
- Clean up Java repo
- Clean up Python repo
- Decide which other repos you want to keep
- Add PID C++ code to C++ directory

# Common Terminal Commands
Search for files: `find . -name <file_name>` \
Search for directories `find . -name <directory_name> -type d`

## Git
Delete branch: `git branch -d <branch_name>`  
Create branch: `git branch <branch_name>`  
Push local branch to remote: `git checkout <branch_name>; git push origin <branch_name>`  
- For le first time: `git push -u origin <branch_name>`  
Delete remote branch: `git push origin --delete feature/login`  

Merging vs. Rebasing: https://www.atlassian.com/git/tutorials/merging-vs-rebasing


## Python Virtual environments
https://www.youtube.com/watch?v=N5vscPTWKOk
Used to separate the versions, packages, and dependencies for your project.
- Go into your working directory  
- Create a virtual environment with:  
`virtualenv <name_of_env>`

- Activate environment with:  
(On Unix) `source <name_of_env>/bin/activate`
(On Windows) `source activate <name_of_env>`

- Check which environment you are in with:  
`which python`
- Check which pip version you are using in that environment:  
`which pip`
- Check what packages you have installed in that environment:  
`pip list`
- Note: You might want to `pip install` basic packages like numpy, pytz, psutil

- To export all these packages and their version numbers into another package (what this does is create a list of all your packages, their versions, and stores it in a text file so you can use it in other environments):  
`pip freeze --local > requirements.txt`

- To install those packages from another virtual environment:  
`pip install -r requirements.txt`

- Exit your local environment to go back to global:  
(Unix)`deactivate`
(Windows)`source deactivate`

- To delete an environment, deactivate first and then just:  
`rm -rf <env_name>`

### Heap and Stack Memory Allocation
https://www.geeksforgeeks.org/stack-vs-heap-memory-allocation/

### UML Diagrams
- https://tallyfy.com/uml-diagram/
- https://www.visual-paradigm.com/guide/uml-unified-modeling-language/what-is-class-diagram/
- http://www.cs.sjsu.edu/~pearce/modules/lectures/uml2/class/index.htm
- http://agilemodeling.com/style/classDiagram.htm
- http://www.cs.utsa.edu/~cs3443/uml/uml.html
