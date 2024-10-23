Arsen Tinalin 
SE-2329

This is a quick guide to the fourth assignment. 

This project demonstrates several common design patterns, 
each applied to different scenarios. Below is a brief 
explanation of each pattern and how it is implemented.


## Run instructions
1. Clone the repository or download the files.
2. Compile the project using the IDE or command line:
```bash
javac Main.java


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


PaymentSystem class:

Uses the Strategy pattern to handle multiple payment methods, such as 
credit card, PayPal, and cryptocurrency. Each payment method is 
encapsulated in a separate strategy class, making it easy to 
switch between them without modifying the main shopping cart logic. 
This allows the system to adapt to new payment methods by simply 
adding new strategies.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



WeatherMonitoring class:

It uses the Observer Pattern to manage multiple display devices 
that update automatically when weather data changes. 
The 'WeatherStation' acts as the subject, notifying all registered 
observers when new data is available. Displays like 
'CurrentConditionsDisplay', 'StatisticsDisplay', and 
'ForecastDisplay' implement the 'WeatherDisplay' interface to react 
to updates. The system ensures that adding new displays or 
changing weather conditions triggers automatic updates.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


RemoteControl class:

The RemoteControl uses the Command pattern to control various 
smart home devices (like TV, stereo, and lights). Each action is 
encapsulated as a command object, allowing the remote to execute 
or undo operations. This decouples the remote's behavior from the 
specific devices, enabling the easy addition of new commands and 
devices in the future.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



OrderProcessing class:

The OrderProcessing follows the State Pattern, where the behavior 
of an order depends on its current state, such as New, Paid, 
Shipped, Delivered, or Cancelled. The 'State' interface defines 
actions with concrete state classes implementing these actions 
differently based on the order’s status. The 'Order' class manages 
state transitions, allowing for flexible and accurate handling of 
orders.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


ExpenseApproval class:

The ExpenseApproval is built using the Chain of Responsibility 
pattern, where expense requests are routed through a hierarchy of
approvers like Team Leads, Managers, and CEOs. Each approver has a 
spending limit, and if the request exceeds it, the approver passes 
it to the next higher authority. This ensures a scalable and flexible 
approval flow, where approvers can be added or modified easily.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


ChatRoomAPP class:

This class uses the Mediator Pattern to manage communication 
between users in a chat room. The 'ChatMediator' interface defines 
methods to send messages and add users, with the 'ChatRoom' class 
acting as the mediator. Users, represented by the 'User' abstract 
class and concrete classes like 'RegularUser' and 'PremiumUser', 
send and receive messages via the mediator, ensuring loose coupling 
between users and centralized message management.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


DocumentVersionControl class:

Implements the Memento pattern to allow users to save and restore 
different versions of a text document. Each version is stored 
as a memento, while the caretaker manages the list of versions, 
providing the ability to roll back to a specific state. 
This simplifies the management of document versions without 
exposing the document's internal structure.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



ShapeArea class:

The ShapeArea class implements the Visitor Pattern to calculate 
the area of different shapes. The 'Shape' interface defines concrete 
shapes like 'Circle', 'Rectangle', and 'Triangle' implement this 
interface. The 'Visitor' interface provides specific 'visit()' methods 
for each shape, and the 'AreaCalculator' visitor performs the 
area calculations. The 'Drawing' class holds a collection of 
shapes and calculates their areas using the visitor.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


ReportGeneration class:

The ReportGeneration class uses the Template Method pattern to 
generate different types of reports (e.g., PDF, HTML). The abstract 
ReportGenerator class defines the overall structure of the report 
creation process, while concrete subclasses provide specific 
implementations for formatting headers, bodies, and footers. 
This ensures consistency in the report generation process while 
allowing flexibility in report formats.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



PlaylistManagement class:

This uses the Iterator Pattern to allow traversal of songs in 
different orders, such as sequential, shuffled, or filtered by genre. 
The 'Playlist' class stores a collection of songs, and iterators like 
'SequentialIterator', 'ShuffleIterator', and 'GenreFilterIterator' 
implement 'hasNext()' and 'next()' methods to control the traversal 
order. The playlist provides different iterator types, allowing 
flexible traversal options for different user preferences.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


Main class:

The Main class is the entry point of the application that 
demonstrates the functionality of each design pattern in the system. 
Each one is tested with appropriate scenarios to show how they work 
in practice.






