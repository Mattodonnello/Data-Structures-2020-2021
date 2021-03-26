import java.util.Iterator;

public class DoublyLinkedList<E> implements List<E> {

    //---------------- nested Node class ----------------
    /**
     * Node of a doubly linked list, which stores a reference to its
     * element and to both the previous and next node in the list.
     */
    private static class Node<E> {
    	private E element; // reference to the element stored at this node
    	/** A reference to the preceding node in the list */
    	private Node<E> prev; // reference to the previous node in the list
    	/** A reference to the subsequent node in the list */
    	private Node<E> next;// reference to the subsequent node in the list
    	
    	public Node(E e, Node<E> p, Node<E> n) {
    	element = e;
    	prev = p;
    	next = n;    
    }
    	// Accessor methods
    	public E getElement() { 
    		return element; 
    	}
    	public Node<E> getNext() { 
    		return next; 
    		}
    	public Node<E> getPrev() { 
    		return prev; 
    		}
    	// Modifier methods
    	public void setNext(Node<E> n) { 
    		next = n; 
    		}
    	public void setPrev(Node<E> p) { 
    		prev = p; 
    		}
    } //----------- end of nested Node class -----------

    // instance variables of the DoublyLinkedList
    /** Sentinel node at the beginning of the list */
    private Node<E> header;                    // header sentinel

    /** Sentinel node at the end of the list */
    private Node<E> trailer;                   // trailer sentinel

    /** Number of elements in the list (not including sentinels) */
    private int size = 0;                      // number of elements in the list

    /** Constructs a new empty list. */
    public DoublyLinkedList() {
    	header = new Node<>(null, null, null);      // create header
    	trailer = new Node<>(null, header, null);   // trailer is preceded by header
    	header.setNext(trailer);
    }

    // public accessor methods
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
    	Node<E> heads = header;
        int count = 0; /* index of Node we are
                          currently looking at */
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
        Node<E> newN = new Node<E>(e, null, null);
        // insert as the new head?
        if (i == 0) {
            newN.next = header;
            header = newN;
        } else {
            Node<E> node = header;
            // find position just before the expected one:
            while (--i > 0) {
                node = node.next;
            }
            // insert the new node:
            newN.next = node.next;
            node.next = newN;
        }
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    /**
     * Returns (but does not remove) the first element of the list.
     * @return element at the front of the list (or null if empty)
     */
    public E first() {
        // TODO
        return null;
    }

    /**
     * Returns (but does not remove) the last element of the list.
     * @return element at the end of the list (or null if empty)
     */
    public E last() {
        // TODO
        return null;
    }

    // public update methods
    /**
     * Adds an element to the front of the list.
     * @param e   the new element to add
     */
    public void addFirst(E e) {
    	addBetween(e, header, header.getNext());
    }

    /**
     * Adds an element to the end of the list.
     * @param e   the new element to add
     */
    public void addLast(E e) {
    	addBetween(e, trailer.getPrev(), trailer);
    }

    /**
     * Removes and returns the first element of the list.
     * @return the removed element (or null if empty)
     */
    public E removeFirst() {
    	if (isEmpty()) return null;// nothing to remove
    	return remove(header.getNext()); 
    }

    /**
     * Removes and returns the last element of the list.
     * @return the removed element (or null if empty)
     */
    public E removeLast() {
    	if (isEmpty()) return null; // nothing to remove
    	return remove(trailer.getPrev());
    }

    // private update methods
    /**
     * Adds an element to the linked list in between the given nodes.
     * The given predecessor and successor should be neighboring each
     * other prior to the call.
     *
     * @param predecessor   node just before the location where the new element is inserted
     * @param successor     node just after the location where the new element is inserted
     */
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
    	Node<E> newest = new Node<>(e, predecessor, successor);
    	predecessor.setNext(newest);
    	successor.setPrev(newest);
    	size++;
    }

    /**
     * Removes the given node from the list and returns its element.
     * @param node    the node to be removed (must not be a sentinel)
     */
    private E remove(Node<E> node) {
    	Node<E> predecessor = node.getPrev();
    	Node<E> successor = node.getNext();
    	predecessor.setNext(successor);
    	successor.setPrev(predecessor);
    	size--;
    	return node.getElement();
    }


    /**
     * Produces a string representation of the contents of the list.
     * This exists for debugging purposes only.
     */
    public String toString() {
        String res = "";
        DoublyLinkedList.Node<E> current = header;
        while(current.getNext() != null){
            res += current.getElement();
            if(current.getNext() != null){
                 res += ", ";
            }
            current = current.getNext();
        }
        return "List: " + res;
    }

    public static void main(String [] args) {
    	
		DoublyLinkedList <Integer> ll = new DoublyLinkedList <Integer >();
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
    }
} //----------- end of DoublyLinkedList class -----------
