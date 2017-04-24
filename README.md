# TJM

#### Jen Yu, Tina Chen, Mansour Elsharawy

**_Design_**

*ArrayPriorityQueue* 
 - Underlying ArrayList Structure
 - Generically typed
 - add() method finds where to place objects in the ArrayList based on priority level. 
   - higher priority items --> lower priority items
 - Implements Iterable interface, and includes an iterator() method
   - This means, you can use a for-each loop to iterate through an ArrayPriorityQueue. 

*Ticket*
 - compareTo() method compares the VIP levels of two Tickets
   - returns 1 if the calling Ticket has a greater value VIPLevel (lower priority) than the parameter Ticket 
   - returns 0 is the Tickets have the same VIP value. 
   - otherwise, returns -1. 
 - Objective is to contain a problem that needs to be solved. 

*HelpDesk*
 - Underlying ArrayPriorityQueue structure: one to store problems and one to store solved problems
 - Includes many wrapper functions that invoke methods within the ArrayPriorityQueue class
   - HOWEVER, these wrapper functions also provide added functionality outside of simply invoking a method from another class.
   - Streamline code
 - removeMin() method is overloaded
   - The default one marks the problem on the ArrayPriorityQueue of problems as fixed, removes it, and adds it to the ArrayPriorityQueue of solved Tickets
   - The overloaded one takes in a String as a parameter, which describes the solution to the Ticket being removed. 
 - Added a findSolution(int VIP) function, which returns a LinkedList with all solved Tickets who had VIP levels in the range (VIP-2, VIP+2). 

[Flowchart and UML Diagrams can be found here.](https://docs.google.com/document/d/1WyNgvcG6txAYSdO714Z9QuXsod0vsRF7kKnCLjeFBVw/pub "Team TJM")

**_Embellishments_**
 - Added an iterator to ArrayPriorityQueue. It seemed good to be able to easily iterate through such a Queue, considering that the underlying structure of the class was an ArrayList. It helped in the implementation of findSolutions() [described below] 
 - findSolutions(int VIPLevel) was an addition to the HelpDesk implementation. The idea was that a HelpDesk could find other problems in the past with similar priority levels as a given problem, see if a previous problem matched the given problem, and if so, to pull that solution. This function also used a for-each loop in order to find Tickets within the VIP Level range. 
 - Wrapper functions were utilized in the HelpDesk class. However, the add() and removeMin() methods were not _just_ wrappers, but also provided functionality of their own; add() provided the Ticket with an ID number, and removeMin() would mark Tickets as fixed and add them to the database (ArrayPriorityQueue solutions) of solved Tickets. 
