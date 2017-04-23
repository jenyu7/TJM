//Ticket Class
public class Ticket implements Comparable{

	//Instance Variables 
    private int ID;
    private int VIPLevel;
    private String problem;
	private String solution;
    private boolean solved;
    private String userName;

	//Default Constructor
    public Ticket()
	{
		ID = -1;
		//System.out.println(IDNum);
		VIPLevel = 0;
		problem = "Unnamed";
		solved = false;
		userName = "Unknown User";
		solution = "N/A";
    } //O(1)

	//Overloaded Constructor
    public Ticket(int IDNum, int vip, String name, String issue)
	{
		ID = IDNum;
		//System.out.println(IDNum);
		VIPLevel = vip;
		userName = name;
		problem = issue;
		solution = "N/A";
    }//O(1)
	
	//toString() Method
	 public String toString()
	{
		String ret = "";
		ret += ("\nVIPLevel: " + VIPLevel);
		ret += ("\nTicket ID: " + ID);
		ret += ("\nSubmitted by: " + userName);
		ret += ("\nIssue: " + problem);
		ret += ("\nSolved? " + solved);
		if (solved){ret += ("\nSolution: " + solution);}
		ret += "\n";
		return ret;
    }//O(1)
	
	//Marks a problem as solved
    public boolean fix()
	{
		solved = true;
		return false;
    }//O(1)
	
	/********
	 * int compareTo(Ticket other)
	 * Precondition: Two Tickets are involved, one the invoker of the method and one the parameter. VIP levels of the Tickets * have already been set. 
	 * Post-condition: An int is returned based on the VIP level of one Ticket in relation to the other. 
	 * a. If both Tickets have the same VIP value, then return 0. 
	 * b. If the caller Ticket has a higher VIP value (lower priority), then return 1. 
	 * c. Else, return -1. 
	 *********/
    public int compareTo(Object other)
	{
		if(this.getVIP() == ((Ticket)other).getVIP())
		{
			return 0;
		}
		else if(this.getVIP() > ((Ticket)other).getVIP())
		{
			return 1;
		}
		else
		{
			return -1;
		}
    }//O(logn)

	//ACCESSORS
	
	//Returns VIP Level of problem
    public int getVIP()
	{
		return VIPLevel;
    }//O(1)
	
	//Returns ID number of problem
    public int getID()
	{
		return ID;
    }//O(1)
	
	//Returns description of problem
    public String getProblem()
	{
		return problem;
    }//O(1)
	
	//Returns name of user who issued the problem
    public String getName()
	{
		return userName;
    }//O(1)
	
	//Returns status of problem (solved or not)
    public boolean getStatus()
	{
		return solved;
    }//O(1)
	
	//Returns the solution to the problem
	public String getSolution()
	{
		return solution;
	}//O(1)
	
	//Mutator
	public void setSolution(String sol)
	{
		solution = sol;
	}
	
    /**
    public static void main(String[] args){
	Ticket ralph = new Ticket();
	System.out.println(ralph);
	Ticket bob = new Ticket(3,"Tina Chen", "My computer blew up.");
	System.out.println(bob);
	System.out.println(bob.compareTo(ralph));
    }
    **/
}
