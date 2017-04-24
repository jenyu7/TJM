//Implementation of ArrayPriorityQueue 

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayPriorityQueue<D> implements PriorityQueue<D>, Iterable<D>
{
	//Instance Variables
	//Underlying ArrayList Container for ArrayPriorityQueue
    private ArrayList<D> _data;
	
	//Constructors
	//Default
    public ArrayPriorityQueue()
    {
		_data = new ArrayList();
    }
	
	//Overloaded: point _data to a pre-existing ArrayList
	public ArrayPriorityQueue(ArrayList<D> a)
	{
		_data = a;
	}

	public String toString()
	{
	    return _data.toString();
	}
	
	public Iterator<D> iterator() 
    { 
		return _data.iterator();
    }
	
	//Methods
	/********
	 * Integer peekMin()
	 * Looks at the item of highest priority in the ArrayPriorityQueue
	 * Precondition: _data is a sorted ArrayList, with the items organized from highest priority (smallest integer values) to 
	 * lowest priority (biggest integer values). Item with highest priority is in index 0. 
	 * Post-condition: _data is unchanged. Item in index 0 is returned.
	 ********/
    public D peekMin()
    {
		if (isEmpty()){return null;}
		return _data.get(0);
    } //O(1)
	
	/********
	 * Integer removeMin()
	 * Removes the item of highest priority in the ArrayPriorityQueue
	 * Precondition: _data is a sorted ArrayList, with the items organized from highest priority (smallest integer values) to 
	 * lowest priority (biggest integer values). Item with highest priority is in index 0. 
	 * Post-condition: The first element of _data is removed and returned. All other items are now shifted to the left, and 
	 * the item formerly in index[1] is now of highest priority. 
	 ********/
    public D removeMin()
    {
		if (isEmpty()){return null;}
		//if (_data.get(0) instanceof Ticket){((Ticket)_data.get(0)).fix();}
		return _data.remove(0);
    } //O(n)

	/********
	 * void add(Integer i)
	 * Adds an item into an ArrayPriorityQueue, with its index dependent on the item's priority value
	 * Precondition: _data is a sorted ArrayList, with the items organized from highest priority (smallest integer values) to 
	 * lowest priority (biggest integer values). addBinaryHelp() is a method that conducts a binary search in order to find 
	 * the correct index of an Integer i in an ArrayList in order to maintain sortedness. 
	 * Post-condition: _data is still sorted in terms of priorities, and the new item has been added in its correct position. 
	 ********/
    public void add(D i)
    {
		if (isEmpty())
		{
			_data.add(i);
			return;
		}
		int index = addBinaryHelp(0, _data.size()-1, (Comparable)i);
		if (index == _data.size())
		{
			_data.add(i); 
			return;
		}
		_data.add(index, i);
    } //O(nlogn)

	//Helpers
	
	//Checks if the ArrayPriorityQueue is empty
	//Utilized in robustification in the case of an empty ArrayPriorityQueue
    public boolean isEmpty()
    {
		return _data.size() == 0;
    } //O(1)
	
	//Finds the correct index of an Integer in a sorted array so that sortedness is maintained (lowest --> highest value)
	public int addBinaryHelp(int lo, int hi, Comparable  newVal){
	    if (((lo > hi) || (lo == _data.size())) || (hi == _data.size())){
			return lo;
		}
		else{
			int middle = (lo + hi)/2;
			if (newVal.compareTo(_data.get(middle)) < 0){
				return addBinaryHelp(lo, middle-1, newVal);
			}
			else if (newVal.compareTo(_data.get(middle)) > 0){
				return addBinaryHelp(middle+1, hi, newVal);
			}
			else{
				return middle;
			}
		}
	} //O(logn)
	
	//test da waters
	public static void main(String[] args)
	{
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//Testing functionality
		ArrayList<Integer> greypoupon = new ArrayList();
		greypoupon.add(1);
		greypoupon.add(3);
		greypoupon.add(6);
		greypoupon.add(9);
		greypoupon.add(10);
		ArrayPriorityQueue humble = new ArrayPriorityQueue(greypoupon);
		//expected: 1
		System.out.println(humble.peekMin());
		//expected: 1
		System.out.println(humble.removeMin());
		humble.add(2);
		humble.add(4);
		System.out.println(humble);
		//expected: 2
		System.out.println(humble.removeMin());
		//expected: 3
		System.out.println(humble.peekMin());
		//expected: 3
		System.out.println(humble.removeMin());
		//expected: 4
		System.out.println(humble.peekMin());
		
		//Testing robustness
		
		//an empty queue
		ArrayList<Integer> evian = new ArrayList();
		ArrayPriorityQueue lamar = new ArrayPriorityQueue(evian);
		//expected: null
		System.out.println(lamar.peekMin());
		//expected: null
		System.out.println(lamar.removeMin());
		
		//a stupid user
		ArrayList<String> tedtalk = new ArrayList();
		tedtalk.add(0);
		tedtalk.add("Hello there");
		tedtalk.add("I'm going to add strings to an integer dataset!");
		ArrayPriorityQueue kendrick = new ArrayPriorityQueue(tedtalk);
		~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

		//Testing Tickets
		ArrayPriorityQueue<Ticket> sopranoc = new ArrayPriorityQueue();
		sopranoc.add(new Ticket(0,5, "50", "down in an airplane"));
		sopranoc.add(new Ticket(1,2, "ways", "fried getting suntan"));
		sopranoc.add(new Ticket(2,3, "to", "fell into a cement mix full of quicksand"));
		sopranoc.add(new Ticket(3,0, "say", "met a shark underwater"));
		sopranoc.add(new Ticket(4,1, "goodbye", "fell and no one caught her"));
		sopranoc.add(new Ticket(5,11, "Train", "caught in a mudslide"));
		System.out.println(sopranoc);
		System.out.println(sopranoc.peekMin());
		System.out.println(sopranoc.removeMin());
	}
}
