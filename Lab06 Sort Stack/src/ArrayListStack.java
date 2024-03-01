import java.util.ArrayList;

public class ArrayListStack implements Stack {
	private ArrayList<Integer> a;

	// implement a default constructor and all methods from interface Stack.
	// Additional methods maybe required in order to run tests.
	public ArrayListStack() {
		makeEmpty();
	}

	public ArrayList<Integer> getA() {
		return a;
	}

	@Override
	public boolean isEmpty() {
		return a.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.a.size()>=10000;
	}

	@Override
	public void makeEmpty() {
		a = new ArrayList<Integer>();
	}

	@Override
	public int top() throws Exception {
		if(this.isEmpty()) {
			throw new EmptyStackException();
		}
		return this.a.get(this.a.size()-1);
	}

	@Override
	public void pop() throws Exception {
		if(this.isEmpty()) {
			throw new EmptyStackException();
		}
		this.a.remove(this.a.size()-1);
	}

	@Override
	public void push(int data) throws Exception {
		a.add(data);
	}

}
