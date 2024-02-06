
public class ZoomaList extends CDLinkedList {
	int score = 0;

	public ZoomaList() {
		super();
	}

	public ZoomaList(CDLinkedList l) {
		header = l.header;
		size = l.size;
	}
	public void TestList() throws Exception{
		System.out.println(printList());
	}
	public void insert(int value, Iterator p) throws Exception {
		//fill code 
		DListIterator p1 = (DListIterator)p;
		oldInsert(value,p);
		
		DListIterator sameValueBegin = new DListIterator(p1.currentNode);
		while(sameValueBegin.previous()==value) {
		}
		sameValueBegin.next();
		DListIterator sameValueEnd = new DListIterator(sameValueBegin.currentNode.nextNode);
		int count = 1;
		while(sameValueEnd.next()==value) {
			count ++;
		}
		
		if(count<3)return;
		score += count;

		removeBetween(sameValueBegin, sameValueEnd, count);
		
		while(sameValueBegin.currentNode.data==sameValueEnd.currentNode.data){
			value = sameValueBegin.currentNode.data;
			while(sameValueBegin.previous()==value) {
			}
			sameValueBegin.next();
			
			sameValueEnd = new DListIterator(sameValueBegin.currentNode.nextNode);
			count = 1;
			
			while(sameValueEnd.next()==value) {
				count ++;
			}
			
			if(count<3)return;
			score += count;
			removeBetween(sameValueBegin, sameValueEnd, count);
			
		}	

	}
	
	public void oldInsert(int value, Iterator p) throws Exception {
		//fill code 
		if (p == null || !(p instanceof DListIterator))
			throw new Exception();
		DListIterator p2 = (DListIterator) p;
		if (p2.currentNode == null)
			throw new Exception();

		DListIterator p3 = new DListIterator(p2.currentNode.nextNode);
		DListNode n = new DListNode(value, p3.currentNode, p2.currentNode);
		p2.currentNode.nextNode = n;
		p3.currentNode.previousNode = n;
		size++;
	
	}

	
	public void removeBetween(DListIterator left, DListIterator right, int inc) {
		//fill code
		if(left.currentNode==right.currentNode||left.currentNode.nextNode==right.currentNode)return;
		size -= inc;
		left.currentNode.nextNode = right.currentNode;
		right.currentNode.previousNode = left.currentNode;
		
	}

}
