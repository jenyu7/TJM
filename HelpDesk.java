public class HelpDesk{
    private ArrayPriorityQueue<Ticket> problemQueue;

    public HelpDesk(){
	problemQueue = new ArrayPriorityQueue();
    }

    public String toString()
    {
	return problemQueue.toString();
    }


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
