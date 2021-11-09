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
| Count number of bytes/lines/characters/words | `wc -(c\|l\|m\|w)` |
| Print length of longest line | `wc -L` |
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


## Style up your Terminal! (Well worth the time)
https://medium.com/@ivanaugustobd/your-terminal-can-be-much-much-more-productive-5256424658e8
| Description        | Command |
|--------------------|---|
| Edit your Powerlevel10k Configuration | `vim ~/.p10k.zsh` |
