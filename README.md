# TJM

#### Jen Yu, Tina Chen, Mansour Elsharawy

**Design**

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
