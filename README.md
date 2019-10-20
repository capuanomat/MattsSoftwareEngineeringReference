# Languages-References
Personal reference of all programming languages I've studied for ease of access and later review

I'm going to go back and try to add all the non-trivial programs I've written in each of those languages.

# Why do I do this?
You know how sometimes you have to implement a certain feature in your code and you realize "Hmmm, I've implemented this before but I forgot how/where." 
Well that's why. Now if I'm programming in Python and I forgot how I previously used scikit-learn's decision tree algorithm, I don't have
to go back and look through 50 different folders of python assignments I've done. I just come here and tada!


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
