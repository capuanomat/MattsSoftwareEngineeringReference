# Shebang
Add the following at the top of any python script and you can execute it with `./myscript.py`, instead of `python3 myscript`:
`#!/usr/bin/env python3`

# Python Virtual environments
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

The Pickle module for persisting objects: https://realpython.com/preview/python-pickle-module/


# Other Python knowledge
## Python Logging
https://www.geeksforgeeks.org/logging-in-python/


## \*args and **kwargs
https://pythontips.com/2013/08/04/args-and-kwargs-in-python-explained/


## Shallow and Deep Copies
https://docs.python.org/2/library/copy.html
https://stackoverflow.com/questions/184710/what-is-the-difference-between-a-deep-copy-and-a-shallow-copy

## range vs. xrange
https://www.google.com/search?q=range+vs+xrange+in+python&rlz=1C1CHBF_enUS744US746&oq=range+vs+xr&aqs=chrome.2.0j69i57j0l4.2687j0j7&sourceid=chrome&ie=UTF-8

## The last part about installing Python3 correctly and Python environments is important:
https://opensource.com/article/19/5/python-3-default-mac
