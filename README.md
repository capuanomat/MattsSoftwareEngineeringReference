# Software Engineering Reference
A personal reference of any and all essential things that should be known as a software engineer/developer. This includes things like references on specific programming languages, cheat sheets, etc.


# Cheat Sheets
## Terminal Commands
Decent Reference: https://en.wikipedia.org/wiki/List_of_Unix_commands
| Description        | Command |
|--------------------|---|
| <b>Searching</b>|
| Search for files  | `find . -name <file_name>`                  |
| Search for directories | `find . -name <directory_name> -type d` |
| Search for string pattern across all file | `grep - C <string> <directory>` |
| <b>System & Navigation</b>|
| Find source installation of a language | `whereis <language, e.g. Python3>` |
| Echo which shell you are using | `echo $SHELL` |
| Print informatio about system | `uname` |
| Print information about file | `file <fileName>` |
| <b>Windows</b>|
| (Windows) Open directory | `explorer.exe <directory>` |
 Grep: https://www.softwaretestinghelp.com/grep-command-in-unix/


## Git
| Description        | Command |
|--------------------|---|
| <b>General</b> |
| Clone a git directory  | `git clone <repository_url>` |
| View local changes to package | `git status` |
| Add changes to commit environment | `git add <package1> <package2> <etc.> <just do . for all>` |
| Commit changes | `git commit -am "<Commit message>` |
| Pull latest changes in current package| `git pull` |
| Pull latest changes in all sub-directories | `for i in */.git; do ( echo $i; cd $i/..; git pull; ); done`|
| <b>Branches</b> |
| View all local branches in package | `git branch -l` |
| View all remote branches in a package | `git branch -r` |
| Create branch  | `git branch <branch_name>` |
| Create and checkout branch | `git checkout -b <branch_name>` |
| Delete local branch | `git branch -d <branch_name>` |
| Delete multiple local branches  | `git branch -d <branch1> <branch2> <branch3> <etc.>` |
| Force delete local branch | `git branch -D <branch_name>`   |
| Force delete multiple local branches | `git branch -D <branch1> <branch2> <branch3> <etc.>`   |
| Delete remote branch | `git push origin --delete <branch_name>` |
| Delete multiple remote branches | `git push origin --delete <branch1> <branch2> <etc.>` |
| Fetch a remote branch and locally track it | `git checkout --track [remotename]/[branch]` (`remotename` is usually `origin`) |
| Push local branch to remote first time| `git push -u origin <branch_name>` |
| Push local branch to remote | `git checkout <branch_name>; git push origin <branch_name>` |
| <b>Fixing Issues & Undoing Changes</b> |
| See entire commit history | `git reflog` |
| Undo a commit but keep changes | `git reset HEAD^` |
| Undo git add (remove from commit environment) | `git reset <file_name>`|
| Resetting\* (Go to any past state for that package) |`git reset --hard HEAD~<num_commits>` |
| Reset HEAD to any past points | `git reset HEAD@{<number,_check_git_reflog_>}` |
| Restore to the previous state of HEAD (\*\*roughly equivalent to `git reset HEAD@{1}` | `git reset ORIG_HEAD` |

Excellent tutorials: https://www.atlassian.com/git/tutorials

Merging vs. Rebasing: https://www.atlassian.com/git/tutorials/merging-vs-rebasing

Fetching: https://www.atlassian.com/git/tutorials/syncing/git-fetch

GO OVER THIS AGAIN: https://stackoverflow.com/questions/927358/how-do-i-undo-the-most-recent-local-commits-in-git?page=1&tab=votes#tab-top

\*https://stackoverflow.com/questions/5473/how-can-i-undo-git-reset-hard-head1
\*\*https://stackoverflow.com/questions/964876/head-and-orig-head-in-git
\*\*\*https://stackoverflow.com/questions/15772134/can-i-delete-a-git-commit-but-keep-the-changes
https://stackoverflow.com/questions/5737002/how-to-delete-a-stash-created-with-git-stash-create


## Bash Scripting
See: https://devhints.io/bash


## Cronjobs
Reference: https://ostechnix.com/a-beginners-guide-to-cron-jobs/
| Description        | Command |
|--------------------|---|
|Open the cron table in edit mode | `crontab -e` |
|See the cron table | `crontab -l` |


## Pimp up your Terminal! (Well worth the time)
https://medium.com/@ivanaugustobd/your-terminal-can-be-much-much-more-productive-5256424658e8
| Description        | Command |
|--------------------|---|
| Edit your Powerlevel10k Configuration | `vim ~/.p10k.zsh` |


<br>

# Other General Software Engineering Knowledge (TO SORT)
https://github.com/google/eng-practices
https://iansommerville.com/software-engineering-book/
http://index-of.co.uk/Engineering/Software%20Engineering%20(9th%20Edition).pdf


## Fleet & Service Management
### Load Shedding
- Useful for CPU-bound services (could probably be for any other bounding resource, however, if it's measurable)
- ...
- When you have plenty of resources left, what is the throughput you want to satisfy? Call this target throughput. E.g. You want to satisfy 1000TPS.
 - As your monitored resource usage increases, you have your transfer that dictates what load percentage you want to allow (target load) as a function of this usage. For instance at 80% CPU usage maybe you only want to allow 50% of the resources through (0.5 target load).
- To avoid the transferFunction being too responsive to sudden changes in resource utilization, we can apply a utilization filter function before the utilisation is passed to the transfer function instead of just using the raw utilization values.
    - This filter function could just be, for example, an average over fixed time periods (like 10 seconds/30 seconds/60 seconds)
- Ideally you can also prioritize requests, meaning when local resources become constrained you can allow higher priority requests but start throttling lower priority requests.
    - For prioritization you uwill sometimes have Priority 0 (top priority, importance means lower Priority #), for which any request is let through. I.e. any request with Priority 0 is let through, but this should be *reserved for exceptional requests*, otherwise it can leave your service vulnerable to brown outs due to resource over-utilization.

### Load Balancing


### Compiled vs Interpreted Languages
From USC CS102 (Week 15, ppt1): https://bytes.usc.edu/cs102/schedule.html
Compiled (Natively):
- Requires code to be converted to the native machine language of the processor in the target system before it can be run
- Like translating a speech to a different language ahead of time so the speaker can just read it
- Faster
- Often allows programmer closer access to the hardware

Interpreted
- Requires an interpreter program on the target system that will interpret the program source code command by command to the native system at run-time
- Like speaking through an interpreter where the speaker waits while the translator interprets
- Better portability to different systems
- Often abstracts HW functionality with built-in libraries (networking, file I/O, math routines, etc.)

Some languages used for web and desktop apps (e.g. Java and Python) will compile their code to an intermediate form: bytecode
- Then an interpreter can execute the bytecode faster than interpreting the high-level language directly
- A new interpreter can be provided for a new device/platform

Languages like C/C++ compile their code directly to a form that can be executed and run on the device.


## Important Concepts
### Dependency Injection
https://www.youtube.com/watch?v=hBVJbzAagfs

### Cyclomatic Complexity
https://en.wikipedia.org/wiki/Cyclomatic_complexity

### Design Principles
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

### Other
- Complex Systems: https://en.wikipedia.org/wiki/Complex_system
- Systems theory: https://en.wikipedia.org/wiki/Systems_theory
- Decentralised system: https://en.wikipedia.org/wiki/Decentralised_system
- Peer-to-peer: https://en.wikipedia.org/wiki/Peer-to-peer
- Master/slave: https://en.wikipedia.org/wiki/Master/slave_(technology)
- Failover: https://en.wikipedia.org/wiki/Failover
- Client-server model: https://en.wikipedia.org/wiki/Client%E2%80%93server_model



## Algorithmic

### Consistent Hashing
https://www.youtube.com/watch?v=jznJKL0CrxM
https://www.youtube.com/watch?v=viaNG1zyx1g
https://www.youtube.com/watch?v=zaRkONvyGr8

### Floyd’s Tortoise and Hare


## Tools & Tutorials
### Opencv for Python

### Tensorflow Tutorials

