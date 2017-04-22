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
		swann.problemQueue.add(new Ticket(5, "Bob", "LoL"));
		swann.problemQueue.add(new Ticket(1, "Ha", "exploded"));
		System.out.println(swann);
		System.out.println(swann.problemQueue.removeMin());
		System.out.println(swann.problemQueue.peekMin());
    }

}
