# Languages-References
Personal reference of all programming languages I've studied. Contains basic programming language notes to remember, specific topics related to a certain language, and some general software engineering notes.

## TODO:
- Clean up Java repo
- Clean up Python repo
- Decide which other repos you want to keep
- Add PID C++ code to C++ directory

# Frequently Used
## Common Terminal Commands
| Description        | Command |
|--------------------|---|
| Search for files  | `find . -name <file_name>`                  |
| Search for directories | `find . -name <directory_name> -type d` |
| Find source installation of a language | `whereis <language, e.g. Python3>`    |
| Echo which shell you are using | `echo $SHELL` |
| ... | `grep - C <...> <...>` |
 Grep: https://www.softwaretestinghelp.com/grep-command-in-unix/


## Git
Excellent tutorials: https://www.atlassian.com/git/tutorials

Merging vs. Rebasing: https://www.atlassian.com/git/tutorials/merging-vs-rebasing

Fetching: https://www.atlassian.com/git/tutorials/syncing/git-fetch

GO OVER THIS AGAIN: https://stackoverflow.com/questions/927358/how-do-i-undo-the-most-recent-local-commits-in-git?page=1&tab=votes#tab-top

| Description        | Command |
|--------------------|---|
| Clone a git directory  | `git clone <repository_url>` |
| Branches |
| Create branch  | `git branch <branch_name>` |
| Create and checkout branch | `git checkout -b <branch_name>` |
| Delete local branch | `git branch -d <branch_name>`   |
| Force delete local branch | `git branch -D <branch_name>`   |
| Delete remote branch | `git push origin --delete <branch_name>` |
| Fetch a remote branch and locally track it | `git checkout --track [remotename]/[branch]` (`remotename` is usually `origin`) |
| Push local branch to remote first time| `git push -u origin <branch_name>` |
| Push local branch to remote | `git checkout <branch_name>; git push origin <branch_name>` |
| <b>Fixing your shit:</b> |
| See entire commit history | `git reflog` |
| Removing from commit environment (undo git add) | `git reset <file_name>`|
| Resetting\* (force undo local commits, can take you to any commit I think) |`git reset --hard HEAD~<num_commits>` |
| Reset HEAD to any past points | `git reset HEAD@{<number,_check_git_reflog_>}` |
| Restore to the previous state of HEAD (\*\*roughly equivalent to `git reset HEAD@{1}` | `git reset ORIG_HEAD` |

\*https://stackoverflow.com/questions/5473/how-can-i-undo-git-reset-hard-head1
\*\*https://stackoverflow.com/questions/964876/head-and-orig-head-in-git


## Pimp up your Terminal! (Well worth the time)
https://medium.com/@ivanaugustobd/your-terminal-can-be-much-much-more-productive-5256424658e8
| Description        | Command |
|--------------------|---|
| Edit your Powerlevel10k Configuration | `vim ~/.p10k.zsh` |


## Cronjobs
Open the cron table in edit mode:
`crontab -e`

See the cron table:
`crontab -l`



# Other General Software Engineering Knowledge (TO SORT & STUDY)

## Design Principles
Separation of Concerns: https://en.wikipedia.org/wiki/Separation_of_concerns
Model-View-Controller: https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller
Model-View-Presenter: https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93presenter

### Heap and Stack Memory Allocation
https://www.geeksforgeeks.org/stack-vs-heap-memory-allocation/

### UML Diagrams
- https://tallyfy.com/uml-diagram/
- https://www.visual-paradigm.com/guide/uml-unified-modeling-language/what-is-class-diagram/
- http://www.cs.sjsu.edu/~pearce/modules/lectures/uml2/class/index.htm
- http://agilemodeling.com/style/classDiagram.htm
- http://www.cs.utsa.edu/~cs3443/uml/uml.html


### Dependency Injection
https://www.youtube.com/watch?v=hBVJbzAagfs


### Consistent Hashing
https://www.youtube.com/watch?v=jznJKL0CrxM
https://www.youtube.com/watch?v=viaNG1zyx1g
https://www.youtube.com/watch?v=zaRkONvyGr8

### Load Balancing

### Floyd’s Tortoise and Hare

### Opencv for Python

### Tensorflow Tutorials

