//Ticket Class
public class Ticket implements Comparable{

	//Instance Variables 
    private static int IDNum = 0;
    private int ID;
    private int VIPLevel;
    private String problem;
    private boolean solved;
    private String userName;

	//Default Constructor
    public Ticket()
	{
		ID = IDNum;
		IDNum += 1;
		//System.out.println(IDNum);
		VIPLevel = 0;
		problem = "Unnamed";
		solved = false;
		userName = "Unknown User";
    }

	//Overloaded Constructor
    public Ticket(int vip, String name, String issue)
	{
		ID = IDNum;
		IDNum += 1;
		//System.out.println(IDNum);
		VIPLevel = vip;
		userName = name;
		problem = issue;
    }
	
	//toString() Method
	 public String toString()
	{
		String ret = "";
		ret += ("\nVIPLevel: " + VIPLevel);
		ret += ("\nTicket ID: " + ID);
		ret += ("\nSubmitted by: " + userName);
		ret += ("\nIssue: " + problem);
		ret += ("\nSolved? " + solved);
		ret += "\n";
		return ret;

    }
	
	//Marks a problem as solved
    public boolean fix()
	{
		solved = true;
		return false;
    }
	
	/********
	 * int compareTo(Ticket other)
	 * Precondition: Two Tickets are involved, one the invoker of the method and one the parameter. VIP levels of the Tickets * have already been set. 
	 * Post-condition: An int is returned based on the VIP level of one Ticket in relation to the other. 
	 * a. If both Tickets have the same VIP value, then return 0. 
	 * b. If the caller Ticket has a higher VIP value (lower priority), then return 1. 
	 * c. Else, return -1. 
	 ********/
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
    }

	//ACCESSORS
	
	//Returns VIP Level of problem
    public int getVIP()
	{
		return VIPLevel;
    }
	
	//Returns ID number of problem
    public int getID()
	{
		return ID;
    }
	
	//Returns description of problem
    public String getProblem()
	{
		return problem;
    }
	
	//Returns name of user who issued the problem
    public String getName()
	{
		return userName;
    }
	
	//Returns status of problem (solved or not)
    public boolean getStatus()
	{
		return solved;
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
