public class Ticket /*implements Comparable*/{

    private int ID;
    private int VIPLevel;
    private String problem;
    private boolean solved;
    private String userName;

    public Ticket(){
	ID = 0;
	VIPLevel = 0;
	problem = "Unnamed";
	solved = false;
	userName = "Name of User";
    }

    public Ticket(int id, int vip, String name, String issue){
	ID = id;
	VIPLevel = vip;
	userName = name;
	problem = issue;
    }

    public int VIP(){
	return VIPLevel;
    }


}
