public class LinkedDeque<E> implements Deque<E> {
    private Node<E> head = null; // head node of the list (or null if empty)
    private Node<E> last = null;
    private int size;
	
    private static class Node<E> {
    	private E element;  // reference to the element stored at this node
    	private Node<E> next; // reference to the subsequent node in the list  
		public Node<E> prev;
    	public Node(E e, Node<E> n, Node<E> p) {
    	    if (e == null) throw new NullPointerException();
    		element = e;
    		next = n;
    		next = p;
    		}
    	Node(){}
    }
    
    public LinkedDeque() {
        head = null;
        last  = null;
        size = 0;
    }
	
	
	public static void main(String[] args) {
		LinkedDeque <Integer> ll = new LinkedDeque <Integer >();
		ll.addFirst(1);
		ll.addFirst(2);
		ll.addFirst(3);
		ll.addFirst(4);
		ll.addFirst(5);
		System.out.println(ll);
		ll.addFirst(-100);
		ll.addLast(+100);
		System.out.println(ll);
		ll.removeFirst();
		ll.removeLast();
		System.out.println(ll);
	}
	
	public String toString() {
		Node <E> curr = head;
        StringBuilder sb = new StringBuilder();
        sb.append("["); 
        while(curr.next!=null) {
        	sb.append(curr.element);
        	sb.append(", ");
        	curr=curr.next;
        }
        if(curr.next==null && curr!=null) {
        	sb.append(curr.element);
        }
        sb.append("]");
        return sb.toString();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	public Node get(E e)
    {
      Node newNode = new Node(e, null, null);
      return newNode;
    }
	
	@Override
	public E first() {
		if(head == null) {
        	return null;
        }
		else return head.element;
	}

	@Override
	public E last() {
		if(last == null) {
        	return null;
        }
		else return last.element;
	}

	@Override
	public void addFirst(E e) {
		Node newFirst = new Node();
        newFirst.element = e;

        if (head != null) {
            newFirst.next = head;
            head.prev = newFirst;
        }
        head = newFirst;
        if (last == null) last = head;

        size++;
	}

	@Override
	public void addLast(E e) {
        Node newLast = new Node();
        newLast.element = e;

        if (last != null) {
            newLast.prev = last;
            last.next = newLast;
        }
        last = newLast;
        if (head == null) head = last;

        size++;
	}

	@Override
	public E removeFirst() {
        Node oldFirst = head;
        head = head.next;

        if (head == null)
            last = null;
        else
            head.prev = null;

        size--;

        return (E) oldFirst.element;
	}

	@Override
	public E removeLast() {
        Node oldLast = last;
        last = oldLast.prev;

        if (last == null)
            head = null;
        else
            last.next = null;

        size--;

        return (E) oldLast.element;
	}

}
