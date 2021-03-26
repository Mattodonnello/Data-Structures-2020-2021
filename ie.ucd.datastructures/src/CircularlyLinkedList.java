import java.util.Iterator;


public class CircularlyLinkedList<E> implements List<E> {
    //---------------- nested Node class ----------------
    /**
     * Singly linked node, which stores a reference to its element and
     * to the subsequent node in the list.
     */
    private static class Node<E> {
        private E element;
        private Node<E> next;
        public Node<E> prev;
        
    	public Node(E e, Node<E> n) {
    	    //if (e == null) throw new NullPointerException();
    		element = e;
    		next = n; 
    	}
    	public E getElement() { 
    		return element; 
    	}
    } //----------- end of nested Node class -----------

    // instance variables of the CircularlyLinkedList
    /** The designated cursor of the list */
    private Node<E> tail = null;                  // we store tail (but not head)

    /** Number of nodes in the list */
    private int size = 0; // number of nodes in the list
    /** Constructs an initially empty list. */
    public CircularlyLinkedList() { }             // constructs an initially empty list

    // access methods
    /**
     * Returns the number of elements in the linked list.
     * @return number of elements in the linked list
     */
    public int size() { return size; }

    /**
     * Tests whether the linked list is empty.
     * @return true if the linked list is empty, false otherwise
     */
    public boolean isEmpty() { return size == 0; }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
    	Node<E> heads = tail.next;
        int count = 0; /* index of Node we are
                          currently looking at */
        while (heads != null)
        {
            if (count == i)
                return heads.element;
            count++;
            heads = heads.next;
        }
        return (E) heads;
    }

    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {
    	 if(i == 0) {
      	   addFirst(e);
      }
         else if(i<0 || i> size) {
      	   throw new IndexOutOfBoundsException();
         }
         Node<E> curr = tail.next; 
         
         for(int k =0; k<i-1; ++k) {
      	   curr = curr.next;
         }
         curr.next = new Node(e, curr.next);
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
    	Node<E> current = tail.next;
    	if (tail.next == null) {
    		throw new RuntimeException("cannot delete");
    		}
    	if (i == 0) {
            tail.next = tail.next.next;
        } else {
            for (int k = 0; k < i - 1; k++) {
                current = current.next;
            }
            current.next = current.next.next;   
        }
    	return current.element;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    /**
     * Returns (but does not remove) the first element of the list
     * @return element at the front of the list (or null if empty)
     */
    public E first() {             // returns (but does not remove) the first element
        if(tail.next == null) {
        	return null;
        }
        return tail.next.element;
    }

    /**
     * Returns (but does not remove) the last element of the list
     * @return element at the back of the list (or null if empty)
     */
    public E last() {              // returns (but does not remove) the last element
    	if(tail == null) {
        	return null;
        }
        return tail.element;
    }

    // update methods
    /**
     * Rotate the first element to the back of the list.
     */
    public void rotate() {         // rotate the first element to the back of the list
    addLast(tail.next.element);
    removeFirst();
    }

    /**
     * Adds an element to the front of the list.
     * @param e  the new element to add
     */
    public void addFirst(E e) {                // adds element e to the front of the list
     tail = new Node<E>(e, tail); 
   	 ++size;
    }

    /**
     * Adds an element to the end of the list.
     * @param e  the new element to add
     */
    public void addLast(E e) {                 // adds element e to the end of the list
        Node<E> newest = new Node<E>(e, null); // node will eventually be the tail
        Node<E> last = tail.next;
        if(last == null) {
        	tail.next = newest;    
        	}
        else {
        	while (last.next != null) { // advance to the last node
        		last = last.next;
        		}
        	last.next= newest; // new node after existing tail
        	}
        size++;
    }

    /**
     * Removes and returns the first element of the list.
     * @return the removed element (or null if empty)
     */
    public E removeFirst() {                   // removes and returns the first element
        Node<E> curr = tail.next;
        E e = tail.next.element;
     if (tail.next.next != null) {
        tail.next.next.prev = null;
      }
       else{
       tail = null;
       }
       tail.next = tail.next.next;

     return e;
    }

    /**
     * Produces a string representation of the contents of the list.
     * This exists for debugging purposes only.
     */
    public String toString() {
        Node <E> curr = tail.next;
        StringBuilder sb = new StringBuilder();
        sb.append("["); 
        while(curr.next!=null) {
        	sb.append(curr.getElement());
        	sb.append(", ");
        	curr=curr.next;
        }
        if(curr.next==null && curr!=null) {
        	sb.append(curr.getElement());
        }
        sb.append("]");
        return sb.toString();
    }


    public static void main(String [] args) {
        //ArrayList<String> all;
        //LinkedList<String> ll;
	    
	    CircularlyLinkedList<String> ll = new CircularlyLinkedList<>();

        String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

        for (String s : alphabet) {
            ll.addFirst(s);
            ll.addLast(s);
        }
        System.out.println(ll.toString());

        ll.rotate();
        System.out.println(ll.toString());
        ll.rotate();
        System.out.println(ll.toString());

    }
}
