import java.lang.reflect.Array;
import java.util.Arrays;

public class QueueArray implements MyQueue {
	protected int[] theArray;
	protected int size; // number of currently stored data.
	protected int front; // index of the first data

	static final int DEFAULT_CAPACITY = 10;

	public QueueArray() {
		this(DEFAULT_CAPACITY);
	}

	public QueueArray(int capacity) {
		theArray = new int[capacity];
		size = 0;
		front = -1;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == theArray.length;
	}

	public void makeEmpty() {
		size = 0;
		front = -1;
	}

	public int size() {
		return size;
	}

	public int front() throws EmptyQueueException {
		if (isEmpty())
			throw new EmptyQueueException();
		return theArray[front];
	}

	public int back() throws EmptyQueueException {
		if (isEmpty())
			throw new EmptyQueueException();
		return theArray[(front + size - 1) % theArray.length];
	}

	/*
	 * return an item at the front of the queue, delete that item. Throw
	 * exception if the queue is empty.
	 */
	public int removeFirst() throws EmptyQueueException {
		if (isEmpty())
			throw new EmptyQueueException();
		size--;

		int frontItem = theArray[front];
		front = (front + 1) % theArray.length;
		return frontItem;
	}

	public void doubleCapacity() { // resize array to twice the original size
		int[] temp = new int[theArray.length * 2];
		
		//cannot use arraycopy because we have to go round the array
		for (int i = 0; i < size; i++) {
			temp[i] = theArray[(front+i)%theArray.length];
		}
		theArray = temp;
		front =0;
	}

	public void insertLast(int data) {
		if (isFull())
			doubleCapacity();
		if(isEmpty())
			front=0;
		theArray[(front + size) % theArray.length] = data;
		size++;
	}
	// 1 2 3 4 5 ++ 2 3
	// 4 3 2 1
	//implement this method.
	public void reverse() throws EmptyQueueException {
		if(isEmpty())
			return;
		int[] temp = new int[size()];
		int sizeQ = size();
		int c = 0;
		while(size()!=0) {
			temp[c] = back();
			size--;
			c++;
		}
		for(int i=0;i<temp.length;i++) {
			System.out.print(temp[i]+" ");
		}
		System.out.println();
		
		size = sizeQ;
		sizeQ = 1;
		c= 0;
		int itr = front;
		while(itr!=(front+size())%theArray.length) {
			theArray[itr]=temp[c];
			c++;
			itr = (itr+1)%theArray.length;
		}
	}
	
	public void printA() throws Exception{
		for(int i =0;i<theArray.length;i++) {
			System.out.print(theArray[i]+" ");
			
		}
		System.out.println();
		System.out.println("------");
	}
	
	public static void main(String[] args) {
		int d = (0)%5;
		System.out.println(d);
	}

}
