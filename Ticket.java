public class Ticket implements Comparable{

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
	this();
	ID = id;
	VIPLevel = vip;
	userName = name;
	problem = issue;
    }

    public int VIP(){
	return VIPLevel;
    }
    public int id(){
	return ID;
    }
    public String issue(){
	return problem;
    }
    public String name(){
	return userName;
    }
    public boolean fix(){
	solved = true;
	return false;
    }
    public boolean status(){
	return solved;
    }

    public String toString(){
	String ret = "";
	ret += ("\nTicket ID: " + ID);
	ret += ("\nVIPLevel: " + VIPLevel);
	ret += ("\nSubmitted by: " + userName);
	ret += ("\nIssue: " + problem);
	ret += ("\nSolved? " + solved);
	return ret;

    }

    public int compareTo(Object other){
	if(this.VIP() == ((Ticket)other).VIP()){
	    return 0;
	}
	else if(this.VIP() <((Ticket)other).VIP()){
	    return 1;
	}
	else{
	    return -1;
	}
    }

    public static void main(String[] args){
	Ticket ralph = new Ticket();
	System.out.println(ralph);
	Ticket bob = new Ticket(1,3,"Tina Chen", "My computer blew up.");
	System.out.println(bob);
    }




}
