
public class StudentList extends CDLinkedList {
    // you can write additional methods.

	// implement this method
	public void swapNode(DListIterator i1, DListIterator i2) {
		DListNode posti1 = i1.currentNode.nextNode;
		DListNode prei1 = i1.currentNode.previousNode;
		DListNode posti2 = i2.currentNode.nextNode;
		DListNode prei2 = i2.currentNode.previousNode;
		
		prei1.nextNode = i2.currentNode;
		i2.currentNode.previousNode = prei1;
		
		posti1.previousNode = i2.currentNode;
		i2.currentNode.nextNode = posti1;
		
		prei2.nextNode = i1.currentNode;
		i1.currentNode.previousNode = prei2;
		
		posti2.previousNode = i1.currentNode;
		i1.currentNode.nextNode = posti2;
	}
	
	// implement this method
	public void insertList(DListIterator i1, CDLinkedList lst) throws Exception{
		if(lst.isEmpty())return;
		DListNode p1 = i1.currentNode;
		DListNode p2 = i1.currentNode.nextNode;
		DListNode firstMember = lst.header.nextNode;
		DListNode lastMember = lst.header.previousNode;
		
		p1.nextNode = firstMember;
		firstMember.previousNode = p1;
		
		p2.previousNode=lastMember;
		lastMember.nextNode=p2;
	}

	// implement this method
	public void gender(String g) throws Exception {
		DListIterator h = new DListIterator(header);
		DListIterator itr = new DListIterator(header);
		while(itr.hasNext()&& itr.currentNode.nextNode != header) {
			Student s = (Student)itr.next();
			if(s.getSex()==g) {
				remove(findPrevious(itr));
				insert(s, h);
				h.next();
			}
		}
	}

}
