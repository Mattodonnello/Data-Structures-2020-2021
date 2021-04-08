public class LinkedQueue<E> implements Queue<E> {
    private Node<E> head = null; // head node of the list (or null if empty)
    private Node<E> last = null;
    private int size;
	
    private static class Node<E> {
    	private E element;  // reference to the element stored at this node
    	private Node<E> next; // reference to the subsequent node in the list  
		public Node<E> prev;
    	public Node(E e, Node<E> n) {
    	    if (e == null) throw new NullPointerException();
    		element = e;
    		next = n;  
    		}
    	Node(){}
    }
    
    public LinkedQueue() {
        head = null;
        last  = null;
        size = 0;
    }

	public static void main(String[] args) {
		LinkedQueue<Integer> q = new LinkedQueue<Integer>();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		System.out.println(q);
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

	@Override
	public void enqueue(E e) {
		Node oldlast = last;
        last = new Node(e, null);
        if (isEmpty()) {
        	head = last;
        }
        else {
        	oldlast.next = last;
        }
        size++;
	}

	@Override
	public E first() {
		if (isEmpty()) {
			return null;
		}
		else return head.element;
	}

	@Override
	public E dequeue() throws Exception {
		if (isEmpty()) {
			throw new Exception("Queue is empty, nothing can be removed");
		}
        E e = head.element;
        head = head.next;
        size--;
        if (isEmpty()) {
        	last = null;  
        }
        return e;
	}

}
