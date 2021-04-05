public class ArrayStack<E> implements Stack<E> {
	public static final int CAPACITY=1000;   // default array capacity
	private E[] data;                        // generic array used for storage
	private int t = -1;                      // index of the top element in stack
	public ArrayStack() { 
		this(CAPACITY);   // constructs stack with default capacity
	} 
	
	@SuppressWarnings({"unchecked"})
	public ArrayStack(int capacity) { // constructs stack with given capacity
		data = (E[]) new Object[capacity];     // safe cast; compiler may give warning
		}

	public static void main(String[] args) throws Exception {
		ArrayStack <Integer> ll = new ArrayStack <Integer>();
		ll.push(1);
		ll.push(2);
		ll.push(3);
		ll.push(4);
		ll.push(5);
		System.out.println(ll);
		ll.pop();
		System.out.println(ll);
		ll.pop();
		System.out.println(ll);
		System.out.println(ll.top());
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
		return (t + 1);
	}

	@Override
	public boolean isEmpty() {
	 return (t == -1);
	}

	@Override
	public void push(E e) throws Exception{
		if(t >= size() ){
			throw new Exception("ERROR:- Stack overflow");
		}
		else {
		data[t+1] = e;
		t++;
		}
	}

	@Override
	public E top() {
	    if (t == -1)
	        return null;
	    else 
	    	return data[0];
	}

	@Override
	public E pop() {
	if(isEmpty()) {
		return null;
	}
	else {
	E e = data[size() - 1];
	data[size()-1]= null;
	t--;
	return e;
	}
}
}
