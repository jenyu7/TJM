# TJM

Tina Chen, Jen Yu, Mansour Elshawary

Design
ArrayPriorityQueue
uses a binary search algorithm to add an object onto the ArrayList

Ticket

-overridded compareTo method which compares VIPLevels

-contains instance variables: IDNum, ID, VIPLevel, problem, solution, solved, userName

-has accessor and mutator methods

HelpDesk
-has two arraypriorityqueues: problemQueue and solutions

-add method to add tickets to problemQueue

-removeMin method to fix the ticket(change its boolean solved), add to the solution pile, and remove it from the problemQueue

-overloaded removeMin method that takes a String solution and does the same thing removeMin does but with a solution

-findSolution method which takes a VIPLevel input and returns a LinkedList with the tickets in the range (VIPLevel -2)