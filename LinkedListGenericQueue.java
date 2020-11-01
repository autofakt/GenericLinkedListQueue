import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.*;

class Queue<Item> implements Iterable<Item> {
    private int n;         // number of elements on queue
    private Node first;    // beginning of queue
    private Node last;     // end of queue

    // helper linked list class
    private class Node {
        private Item item;   // the item in the node
        private Node next;   // reference to next item
    }

    public Queue() {
        first = null;
        last = null;
        n = 0;
    }

    /**
     * Returns true if this queue is empty.
     *
     * @return {@code true} if this queue is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

   
    public int size() {
        return n;
    }

    public int length() {
        return n;
    }


    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("No Elements in Queue, Add element first");
        return first.item;
    }

  
    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        n++;
    }


    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("No Elements in Queue, Add element first");
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }

    /**
     * Returns a string representation of this queue.
     *
     * @return the sequence of items in FIFO order, separated by spaces
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + "\n");
        return s.toString();
    }


    /**
     * Returns an iterator that iterates over the items in this queue in FIFO order.
     *
     * @return an iterator that iterates over the items in this queue in FIFO order
     */
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node current = first;  // node containing current item

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}


class Employee{
	private String name;
	private int wage;
	
	public Employee() {
		this.name = "";
		this.wage = 0;
	}
	
	public Employee(String name, int wage) {
		this.name = name;
		this.wage = wage;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getWage() {
		return this.wage;
	}
	public String toString() {
		StringBuilder s = new StringBuilder();
        s.append("Employee Name: " + this.getName() + " - Hourly Wage: $" +this.getWage());
        return s.toString();
		
	}
	
}
public class LinkedListGenericQueue {
	
	public static void printQueue(Queue<Employee> queue) {
		System.out.println("\nState of Queue: ");
		System.out.println(queue.toString());
	}
	
	public static void printMenu() {
		System.out.println("QUEUE MENU");
		System.out.println("1: Add Entry (enqueue)");
		System.out.println("2: Remove Entry (dequeue)");
		System.out.println("3: QUIT");
		System.out.print("Please enter selection: ");
	}
	

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		Queue<Employee> queue = new Queue<Employee>();
		Employee Alfonso = new Employee("Alfonso", 15);
		queue.enqueue(Alfonso);
		Employee Bob = new Employee("Bob", 17);
		queue.enqueue(Bob);
		Employee Carol = new Employee("Carol", 21);
		queue.enqueue(Carol);
		Employee Deborah = new Employee("Deborah", 18);
		queue.enqueue(Deborah);
		Employee Elaine = new Employee("Elaine", 22);
		queue.enqueue(Elaine);
	
		
		
		
		
		int selection = -1;
		while(selection != 3) {
		printQueue(queue);
		printMenu();
		selection = keyboard.nextInt();
		if(selection==1) {
			keyboard.nextLine();
			System.out.println("Employee Name:");
			String tempName = keyboard.nextLine();
			System.out.println("Employee Hourly Wage:");
			int tempWage = keyboard.nextInt();
			Employee temp = new Employee(tempName, tempWage);
			queue.enqueue(temp);			
		}
		if(selection==2 && queue.size()!=0) {
		queue.dequeue();
		}
		else if(selection==2 && queue.size()==0) {
			System.out.println("Error: No more items in QUEUE\n");
		}
		}
		System.out.println("Thank you, goodbye!");
		
		

	}

}
