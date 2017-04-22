//HelpDesk manages Tickets
public class HelpDesk
{
	//Instance Variables
    private ArrayPriorityQueue<Ticket> problemQueue;

	//Default Constructor
    public HelpDesk()
	{
		problemQueue = new ArrayPriorityQueue();
    }

	//toString() Method
    public String toString()
    {
		return problemQueue.toString();
    }

	//how helpful is the help desk? 
    public static void main(String[] args)
    {
		HelpDesk swann = new HelpDesk();
		swann.problemQueue.add(new Ticket(5, "Patrick", "eaten by a lion"));
		swann.problemQueue.add(new Ticket(1, "Mohaney", "got run over by a cr**py purple scion"));
		System.out.println(swann);
		System.out.println(swann.problemQueue.removeMin());
		System.out.println(swann.problemQueue.peekMin());
    }

}
