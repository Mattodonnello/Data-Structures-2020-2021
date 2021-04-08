public class ArrayQueue<E> implements Queue<E> {
	public static final int CAPACITY=10;   // default array capacity
	private E[] data;
	private int t = 0;
	
	public ArrayQueue() { 
		this(CAPACITY);   // constructs stack with default capacity
	}
	
	@SuppressWarnings({"unchecked"})
	public ArrayQueue(int capacity) { // constructs stack with given capacity
		data = (E[]) new Object[capacity];     // safe cast; compiler may give warning
		}
	
	public static void main(String[] args) throws Exception {
		ArrayQueue <Integer> ll = new ArrayQueue <Integer>();
		ll.enqueue(1);
		ll.enqueue(2);
		ll.enqueue(3);
		ll.enqueue(4);
		ll.enqueue(5);
		System.out.println(ll);
		ll.dequeue();
		System.out.println(ll);
		ll.enqueue(10);
		ll.enqueue(11);
		System.out.println(ll.dequeue());
		System.out.println(ll);
		System.out.println(ll.dequeue());
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<data.length; i++) {
		sb.append(data[i]);
		sb.append(", ");	
		}
		return sb.toString();
	}

	@Override
	public int size() {
		return (t);
	}

	@Override
	public boolean isEmpty() {
		return (t == 0);
	}

	@Override
	public void enqueue(E e) throws Exception {
		if (t == data.length - 1) {
			throw new Exception("Queue is full. Dequeue some objects");
		}
		this.data[t] = e;
		t++;
	}

	@Override
	public E first() {
	return data[0];
	}

	@Override
	public E dequeue() throws Exception {
		if (isEmpty()) {
			throw new Exception("Queue is empty");
		}
		E e = this.data[0];
		for (int i = 0; i < t; i++) {
			data[i] = data[i + 1];
		}
		t--;
		return e;
}
	}
