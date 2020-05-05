# Languages-References
Personal reference of all programming languages I've studied. Contains basic programming language notes to remember, specific topics related to a certain language, and some general software engineering notes.

## TODO:
- Clean up Java repo
- Clean up Python repo
- Decide which other repos you want to keep
- Add PID C++ code to C++ directory

# Frequently Used
## Common Terminal Commands
| Description        | Command | Example |
|--------------------|---|---|
| Search for files  | `find . -name <file_name>`                  | `find ../ -name executor.py` |
| Search for directories | `find . -name <directory_name> -type d` | `find . -name visibilityPackage -type d` |
| Find source installation of a language | `whereis <language>`    | `whereis python3` |
 


## Git
| Description        | Command |
|--------------------|---|
| Create branch  | `git branch <branch_name>` |
| Delete branch | `git branch -d <branch_name>`   |
| Push local branch to remote first time| `git push -u origin <branch_name>` |
| Push local branch to remote | `git checkout <branch_name>; git push origin <branch_name>` |
| Delete remote branch | `git push origin --delete feature/login` |
| Resetting (Undoing all past local commits) |`git reset --hard HEAD~<num_commits> |

Merging vs. Rebasing: https://www.atlassian.com/git/tutorials/merging-vs-rebasing

## Pimp up your Terminal hoe
https://medium.com/@ivanaugustobd/your-terminal-can-be-much-much-more-productive-5256424658e8


# Less Frequent
## Cronjobs
Open the cron table in edit mode:
`crontab -e`

See the cron table:
`crontab -l`


# Other General Software Engineering Knowledge

### Heap and Stack Memory Allocation
https://www.geeksforgeeks.org/stack-vs-heap-memory-allocation/

### UML Diagrams
- https://tallyfy.com/uml-diagram/
- https://www.visual-paradigm.com/guide/uml-unified-modeling-language/what-is-class-diagram/
- http://www.cs.sjsu.edu/~pearce/modules/lectures/uml2/class/index.htm
- http://agilemodeling.com/style/classDiagram.htm
- http://www.cs.utsa.edu/~cs3443/uml/uml.html
