
public class PriorityQueue {
	MyQueue q;

	public PriorityQueue(MyQueue q) {
		super();
		this.q = q;
	}

	// implement this.
	public void push(int x) throws Exception {
		
		int[] temp = new int[q.size()+1];
		int c = 0;
		boolean isInsert = false;
		if(q.isEmpty()) {
			q.insertLast(x);
			return;
		}
		while(!q.isEmpty()) {
			int data = top();
			pop();
			if(x<data&&!isInsert) {
				temp[c++]=x;
				isInsert=true;
			}
			temp[c++]=data;
		}
		if (!isInsert) {
	        temp[c++]=x;
	    }
		for(int i = 0;i<c;i++) {
			q.insertLast(temp[i]);
		}
	} 
	/*
	public void push(int x) throws Exception {
	    QueueArray qA = (QueueArray) q;
	    QueueArray temp = new QueueArray(qA.size() + 1);
	    boolean isInsert = false;

	    while (!qA.isEmpty()) {
	        int data = qA.removeFirst();
	        if (x < data && !isInsert) {
	            temp.insertLast(x);
	            isInsert = true;
	        }
	        temp.insertLast(data);
	    }

	    if (!isInsert) {
	        temp.insertLast(x);
	    }

	    q = (MyQueue) temp;
	}
	*/
	// implement this.
	public void pop() throws Exception {
		q.removeFirst();

	}

	// implement this
	public int top() throws Exception {
		return q.front();
	}
	
	public void P()throws Exception {
		System.out.println("P activate");
		if(q.isEmpty())return;
		if(!(q instanceof QueueArray))return;
		
		QueueArray qa = (QueueArray)q;
		qa.printA();
		System.out.println("--------------");
	}

}
