Super Useful Learning Resources
===============================
- Real Python: Has tutorials on specific topics (e.g. decorators, sending emails with python, etc.)
    - https://realpython.com/
    - https://realpython.com/account/purchases/
- Corey Schafer: Has tutorial series on python libraries and services (e.g. Django, Flask, Pandas)
    - https://www.youtube.com/user/schafer5/featured


Terms to Know
=============

- First-class Entity (Object): A "first-class object" has no restrictions on its use, it is treated the same as any other object. It is an entity that can be dynamically created, destroyed, passed to a function, returned as a value, and have all the rights as other variables in the programming language.
    - Reference: https://stackoverflow.com/questions/245192/what-are-first-class-objects

- Race condition: "An undesirable situation that occurs when a device or system attempts to perform two or more operations at the same time, but because of the nature of the device or system, the operations must be done in the proper sequence to be done correctly."
    - One case might be if commands to read and write a large amount of data are received at almost the same time, then the machine will attempt to overwrite some or all of the old data while it's still being read.
        - You can also get a race condition if instructions are processed in incorrect order
    - **Security vulnerabilities**: When a program that is designed to handle tasks in a specific sequence is asked to perform two or more operations simultaneously, an attacker can take advantage of the time gap between when the service is initiated and when a security control takes effect in order to create a deadlock or thread block situation.
        - Deadlock: two or more threads must wait for a lock in a circular chain, which can crash the entire software system to halt because the locks will never be acquired
        - Thread block: A concurrency defect where one thread calls a long-running operation while holding a lock and preventing the progress of other threads
    - Race conditions can be prevented by serialization of memory or storage access: If read and write commands are received together, the read command is executed and completed first by default
        - You can also prevent some race conditions by implementing a priority scheme, e.g. if two subscribers try to access an available channel at the same time, you might give priority to the subscribers in alphabetical order by default.
        - Hackers can take advantage of race-condition vulnerabilities to gain unauthorized access to networks
    - Reference: https://searchstorage.techtarget.com/definition/race-condition
    - Reference: https://en.wikipedia.org/wiki/Race_condition



