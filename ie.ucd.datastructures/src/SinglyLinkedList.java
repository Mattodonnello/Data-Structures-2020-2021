
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

/**
 * A basic singly linked list implementation.
 */
public class SinglyLinkedList<E> implements Cloneable, Iterable<E>, List<E>{

    //---------------- nested Node class ----------------
    
    /**
     * Node of a singly linked list, which stores a reference to its
     * element and to the subsequent node in the list (or null if this
     * is the last node).
     */
    private static class Node<E> {
    	private E element;  // reference to the element stored at this node
    	private Node<E> next; // reference to the subsequent node in the list  
		public Node<E> prev;
    	public Node(E e, Node<E> n) {
    	    //if (e == null) throw new NullPointerException();
    		element = e;
    		next = n;  
    		} 
    	// Accessor methods
    	public E getElement() { 
    		return element; 
    	}
    	public Node<E> getNext() { 
    		return next; 
    		}
    	// Modifier methods
    	public void setNext(Node<E> n) { 
    		next = n; 
    		}
    } //----------- end of nested Node class -----------

    // instance variables of the SinglyLinkedList
    private Node<E> head = null; // head node of the list (or null if empty)
    private Node<E> tail = null;
    private int size = 0; // number of nodes in the list

    public SinglyLinkedList() {
    }              // constructs an initially empty list

    // access methods

    /**
     * Returns the number of elements in the linked list.
     *
     * @return number of elements in the linked list
     */
    public int size() {
        return size;
    }

    /**
     * Tests whether the linked list is empty.
     *
     * @return true if the linked list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
    	Node<E> heads = head;
        int count = 0; // index of current node we are looking at
        while (heads != null)
        {
            if (count == i)
                return heads.getElement();
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
    	   addFirst(e); // if our index equals zero we just use our add first method
    }
       else if(i<0 || i> size) {
    	   throw new IndexOutOfBoundsException();
       }
       Node<E> curr = head; 
       
       for(int k =0; k<i-1; ++k) { // We loop through to reassign each node
    	   curr = curr.next;
       }
       curr.next = new Node(e, curr.next); 
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
    	Node<E> current = head;
    	if (head == null) {
    		throw new RuntimeException("cannot delete");
    		}
    	if (i == 0) { // If our index is zero we will want rid of our first element 
            head = head.next;
        } else {
            for (int k = 0; k < i - 1; k++) {
                current = current.next;
            }
            current.next = current.next.next;   
        }
    	return current.element;
    }

    /**
     * Returns (but does not remove) the first element of the list
     *
     * @return element at the front of the list (or null if empty)
     */
    public E first() {
        if(head == null) {
        	return null;
        }
        return head.getElement();
    }

    /**
     * Returns the last node of the list
     *
     * @return last node of the list (or null if empty)
     */
    public Node<E> getLast() {
    	if (isEmpty( )) return null;
        return tail;
    }

    /**
     * Returns (but does not remove) the last element of the list.
     *
     * @return element at the end of the list (or null if empty)
     */
    public E last() {
        if (tail.element== null) return null;
        else return tail.getElement();
    }

    // update methods

    /**
     * Adds an element to the front of the list.
     *
     * @param e the new element to add
     */
    public void addFirst(E e) {
    	Node<E> addFront = new Node<E>(e, head);

    	  if(size() != 0) // As long as our node is not empty
    	  {
    	    addFront.next = head;
    	    head = addFront; // addFront becomes the new head of the list
    	    size++; 
    	  } else { // If our node is empty
    	    head = addFront;
    	    tail = addFront;
    	    addFront.next = null;
    	    size++;
    	  }
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param e the new element to add
     */
    public void addLast(E e) {    
    	Node<E> n = new Node<E>(e, null);
        if (isEmpty()) // If empty head is our new node n (tail is also n)
        {  
        	head = n;
        }
        else
        {  tail.next = n;
        }
        tail = n;
        size++;  // we increment the size
    }
    
    public E removeFirst() {
    	if (isEmpty( )) return null; // We can't remove anything as our list is empty
    	E result = head.getElement( );
    	head = head.getNext( ); // original head is removed and new head becomes originals next 
    	size--; // we decrement our size
    	if (size == 0) {
    	tail = null; // If our list is now empty, our tail is null
    	}
    	return result;
    }
    
    public E removeLast(){
    	if(head==null || head.next == null){
            return null;
        }
        Node<E> temp = head;
        
        while(temp.next.next != null) {
        	temp = temp.next;
        }
        temp.next=null;
        return tail.element; 
    }

    @SuppressWarnings({"unchecked"})
    public boolean equals(Object o) {
    	if (this == o) {
            return true;
        }
        return false;
    }

    @SuppressWarnings({"unchecked"})
    public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
        return null;
    }


    /**
     * Produces a string representation of the contents of the list.
     * This exists for debugging purposes only.
     */
    
    public String toString() {
        Node <E> curr = head;
        StringBuilder sb = new StringBuilder(); // create our stringBuilder 
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
        return sb.toString(); // return stringBuilder in string form
    }	
    
    

    private class SinglyLinkedListIterator<E> implements Iterator<E> {
        private Node<E> curr = new Node(head.element, head.next);
        @Override
        public boolean hasNext() {
           return curr.next == null;
        }

        @Override
        public E next() {
            E res = (E) curr.getElement(); 
            curr = curr.next;
            return res;
        }
    }

    public Iterator<E> iterator() {
        return new SinglyLinkedListIterator<E>();
    }

    public static void main(String[] args) {
    	
		SinglyLinkedList <Integer> ll = new SinglyLinkedList <Integer >();
		//LinkedList<Integer>ll=newLinkedList<Integer>();]
		ll.addFirst(0);
		ll.addFirst(1);
		ll.addFirst(3);
		ll.addFirst(4);
		ll.addFirst(5);
		ll.add(3, 2);
		System.out.println(ll);
		ll.addFirst(-100);
		ll.addLast(+100);
		System.out.println(ll);
		ll.removeFirst();
		ll.removeLast();
		System.out.println(ll);
		//Removes the item in the specified index 
		ll.remove(2); 
		System.out.println(ll);
		ll.removeFirst();
		System.out.println(ll);
		ll.removeLast();
		System.out.println(ll);
		ll.removeFirst();
		System.out.println(ll);
		ll.addFirst(9999);
		ll.addFirst(8888);
		ll.addFirst(7777);
	    System.out.println(ll);
	    System.out.println(ll.get(0));
	    System.out.println(ll.get(1));
	    System.out.println(ll.get(2));
	    System.out.println(ll); 

        
        SinglyLinkedList<String> sll = new SinglyLinkedList<String>();
        String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""); 
        
        for (String s : alphabet) {
            sll.addFirst(s);
            sll.addLast(s);
        }
        
        System.out.println(sll.toString());

        for (String s : sll) {
            System.out.print(s + ", ");
        }  
    }
}
