Arsen Tinalin 
SE-2329

This is a quick guide to the first assignment. 


Cinema Management System

This is a cinema management system designed to demonstrate the use of 5 design patterns: 
Singleton, Factory, Abstract Factory, Builder, Prototype.


## Run instructions
1. Clone the repository or download the files.
2. Compile the project using the IDE or command line:
```bash
javac Main.java


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Singleton:

Cinemaconfig class implements the realization of Singleton pattern 
where it simply describes the basic information about movies, such as
Cinema name, number of screens, operating hours. 

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Factory pattern:

Moviecreation class uses Factory pattern in which user can create a movie,
specifying its type and title. 

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Abstract factory:

UIG class implements the realization of Abstract Factory pattern, 
it is basically similar to the previous one, where its functionality 
consists of changing interface themes. 

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Builder:

Ticketbooking class is for Builder pattern realization, 
where user sets title of movie, seat number and snacks combo by 
making a chain of method calls.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Prototype:

The last one is MovieSchedule class which realizes Prototype pattern, 
in which user can modify schedule, the code
meanwhile clones the original schedule for change