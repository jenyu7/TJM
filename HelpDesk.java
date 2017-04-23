//HelpDesk manages Tickets
import java.util.LinkedList;
public class HelpDesk
{
	//INSTANCE VARIABLES
    private ArrayPriorityQueue<Ticket> problemQueue;
	private ArrayPriorityQueue<Ticket> solutions;
	private static int nextTicketID;

	//DEFAULT CONSTRUCTOR
    public HelpDesk()
	{
		problemQueue = new ArrayPriorityQueue();
		solutions = new ArrayPriorityQueue();
    }

	//toString() METHOD
    public String toString()
    {
		return problemQueue.toString();
    }
	
	//WRAPPER METHODS
	//See ArrayPriorityQueue class for detailed description of functionality
	
	public void add(int vip, String name, String issue)
	{
		problemQueue.add(new Ticket(nextTicketID++, vip, name, issue));
	}

	public Ticket peekMin()
	{
		return problemQueue.peekMin();
	}
	
	public boolean isEmpty()
	{
		return problemQueue.isEmpty();
	}
	
	//Added functionality: fixes the Ticket, adds it to the solution pile, and then removes it from problemQueue
	public Ticket removeMin()
	{
		//Only add the solution if there was a Ticket that was processed
		if (! isEmpty())
		{
			problemQueue.peekMin().fix();
			solutions.add(problemQueue.peekMin());
		}
		return problemQueue.removeMin();
	}//O(nlogn)
	
	//Overloaded: Provides the solution to the Ticket just processed. 
	public Ticket removeMin(String solution)
	{
		if (! isEmpty())
		{
			problemQueue.peekMin().fix();
			problemQueue.peekMin().setSolution(solution);
			solutions.add(problemQueue.peekMin());
		}
		return problemQueue.removeMin();
	}
	
	//ACCESSORS
	
	//Returns the ArrayPriorityQueue of problems
	public ArrayPriorityQueue<Ticket> getProblems()
	{
		return problemQueue;
	}
	
	//Returns the ArrayPriorityQueue of solutions of already solved problems
	public ArrayPriorityQueue<Ticket> getSolutions()
	{
		return solutions;
	}
	
	//METHODS 
	
	/********
	 * LinkedList<Ticket> findSolutions (int VIPLevel)
	 * Precondition: solutions is an ArrayPriorityQueue containing Tickets that have already been solved. 
	 * Post-condition: A LinkedList of Tickets is returned containing Tickets with a VIP quantity in the range (VIPLevel -2, * VIPLevel + 2). 
	 ********/
	public LinkedList<Ticket> findSolutions(int VIPLevel)
	{
		LinkedList prevSol = new LinkedList();
		for (Ticket t : solutions)
		{
			if ((t.getVIP() < VIPLevel + 2) && (t.getVIP() > VIPLevel - 2))
			{
				prevSol.add(t);
			}
			System.out.println(t.getName() + " " + t.getVIP());
		}
		return prevSol;
	} //O(n)
	
	//how helpful is the help desk? 
    public static void main(String[] args)
    {
		//A regular HelpDesk
		HelpDesk swann = new HelpDesk();
		swann.add(5, "Patrick", "eaten by a lion");
		swann.add(1, "Mohanan", "got run over by a cr**py purple scion");
		swann.add(3, "Stafford", "dried up in a desert");
		swann.add(90, "Becker", "drowned in a hot tub");
		swann.add(4, "Maldonado", "danced to death at a east side night club");
		//expected: All Tickets, highest priority Ticket printed first
		System.out.println(swann);
		//expected: 1, Monahan...
		System.out.println(swann.removeMin());
		//expected: 3, Stafford...
		System.out.println(swann.peekMin());
		swann.removeMin("bring water next time");
		//removing 4, Maldonado
		swann.removeMin();
		//expected: Problems of Monahan and Stafford
		System.out.println("Solved Tickets with VIPLevel around 2:");
		System.out.println(swann.findSolutions(2));
		//System.out.println("Tickets that have been solved:");
		//System.out.println(swann.getSolutions());
		System.out.println();
		
		//Testing adding solutions
		HelpDesk fray = new HelpDesk();
		fray.add(3, "Me", "lost and insecure");
		fray.add(1, "You", "where were you");
		System.out.println(fray.getSolutions());
		fray.add(0, "I", "how to save a life");
		fray.add(1, "I", "lost a friend");
		fray.removeMin("stay up with you all night");
		System.out.println(fray.getSolutions());
		System.out.println();
		
		//Empty ArrayPriorityQueue test...and not adding null objects to the solutions storage
		HelpDesk keane = new HelpDesk();
		System.out.println(keane.removeMin());
		System.out.println(keane.getSolutions());
		
		/*~~~~~~~~TEST*ME~~~~~~~~~~
		 ~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}
