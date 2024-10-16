Arsen Tinalin 
SE-2329

This is a quick guide to the third assignment. 

This project demonstrates several common design patterns, 
each applied to different scenarios. Below is a brief 
explanation of each pattern and how it is implemented.


## Run instructions
1. Clone the repository or download the files.
2. Compile the project using the IDE or command line:
```bash
javac Main.java


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


AudioPlayer class:

AudioAdapter class implements the Adapter pattern, 
allowing an MP3-only player to support WAV and AAC files
by converting their formats. This lets the player handle 
different audio types without changing the existing player code.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


RemoteControl class:

RemoteControl class uses the Bridge pattern to control different 
electronic devices (TV, DVD Player, Sound System) from various 
manufacturers. This decouples the remote control abstraction from 
the specific devices, allowing flexibility in how the remote 
interacts with different devices.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


MenuSystem class:


Menu class implements the Composite pattern to create complex menu 
structures for a restaurant. A Menu can contain MenuItems or other Menus, 
forming a hierarchical structure that can be managed uniformly, 
enabling operations like adding, removing, and printing the menu items.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


PizzaOrdering class:

ToppingDecorator class uses the Decorator pattern, allowing customers 
to customize their pizzas by adding various toppings 
(Cheese, Mushroom, Pepperoni, etc.) dynamically.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


SmartHome class:

SmartHomeFacade class implements the Facade pattern, providing 
a simplified interface to control multiple smart home devices 
(lights, thermostat, security system, entertainment system) 
through common methods like leaveHome() and movieMode(). 
This centralizes control of different subsystems into one interface.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


CharacterRendering class:

CharacterFactory class realizes the Flyweight pattern to minimize 
memory usage when rendering large amounts of text in a text editor. 
The factory reuses Character objects with intrinsic states 
(e.g., character value, font) and handles their 
extrinsic states (e.g., position) to optimize memory efficiency.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


OnlineLearning class:

ProxyVideoLecture class uses the Proxy pattern for lazy loading of 
video lectures in an online learning platform. The video is only 
loaded when the user starts playing it, reducing resource usage by 
delaying the creation of the RealVideoLecture object until necessary.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


Main class:

It provides for the sequential use of each pattern, the creation of 
class instances, and the calling of methods to demonstrate the work 
of the entire project





