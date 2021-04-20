import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class MyArray<E> implements Iterable<E>{

	private E[] arr;
	public MyArray(E [] in) {
		this.arr = Arrays.copyOf(in, in.length);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(E i : this) {
			sb.append(i);
			sb.append(", ");
		}
		sb.append("]");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
	//Integer [] arr = {1,2,3,4,5,6};
		//LinkedList<String> ll = new LinkedList<>();
		String [] arr = {"one", "two", "three"};
		MyArray<String> myarray = new MyArray<String>(arr);
		
		/* Iterator it = myarray.iterator();
		 * for(; it.hasNext() != true;){
		 * Integer i = (Integer) it.next();
		 * print */
		
		for(String i : myarray) {
			System.out.println(i);
		}  
		
		//myarray.forEach(x -> System.out.println(x));
		//myarray.forEach(System.out::println);
	}
	
	class MyIterator implements Iterator<E>{

		int i=0;
		@Override
		public boolean hasNext() {
			System.out.println("hasNext " + i);
			return i <arr.length;
		}

		@Override
		public E next() {
			E ret = (E) arr[i];
			i+=1;
			return ret;
		}
		
	}
	@Override
	public Iterator<E> iterator() {
		return new MyIterator();
	}
}
