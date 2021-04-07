public class LinkedStack<E> implements Stack<E> {

	private SinglyLinkedList<E> list = new SinglyLinkedList<>();
	
	// an empty list
	public LinkedStack() {
	} 
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<list.size(); i++) {
		sb.append(list.get(i));
		sb.append(", ");	
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		LinkedStack <Integer> ll = new LinkedStack <Integer>();
		ll.push(1);
		ll.push(2);
		ll.push(3);
		ll.push(4);
		ll.push(5);
		System.out.println(ll);
		ll.pop();
		System.out.println(ll);
		System.out.println(ll.pop());
		System.out.println(ll);
		System.out.println(ll.top());
	}

	@Override
	public int size() {
	return list.size();
	}

	@Override
	public boolean isEmpty() {
	if(list.size() == 0) {
		return true;
	}
	else return false;
	}

	@Override
	public void push(E e) {
	list.addFirst(e);	
	}

	@Override
	public E top() {
	E e = list.get(0);
	return e;
	}

	@Override
	public E pop() {
	E e = list.get(0);
	list.removeFirst();
	return e;
	}

}
