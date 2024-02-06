
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
		
		//same as Insert in CDLinked
		oldInsert(value,p);
		
		/*the strategy is to iterate to the left and right until find the left and right "cover" 
		  that not have the same value as the value insert
		  11122(2)233 --> 11 [1] 22(2)2 [3] 3*/
		
		//Iterate to the left until find the value that not the same as the insert value
		DListIterator sameValueBegin = new DListIterator(p1.currentNode);
		/*since previous will move iterator left one time before return the value, it will happen
		 * every time the condition of loop is checked whether condition is true or not*/
		while(sameValueBegin.previous()==value) {
		}
		/*must move back to the right one position due to function previous() will return 
		 the value of origin data instead of data after move (why?) see more in DListiterator*/
		sameValueBegin.next();
		
		/*starting from the left "cover" move right one position so the data will be the same
		 * as value then iterate till finding the different value*/  
		DListIterator sameValueEnd = new DListIterator(sameValueBegin.currentNode.nextNode);
		int count = 1;
		while(sameValueEnd.next()==value) {
			count ++;
		}
		
		if(count<3)return;
		score += count;
		
		//remove between the left and right cover if same value happen more than 3
		removeBetween(sameValueBegin, sameValueEnd, count);
		
		//check for the chain reaction
		/*the strategy here is checking for the left and right cover data since there will be
		 * chain remove only when both cover have the same value(if not just leave them be cuz
		 * we don't want them remove if they have more than 3 since beginning).
		 * After that it pretty much the same as the origin remove */
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
	
	//same as Insert in CDLinked
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
		
		//swap nextNode reference of left and right
		left.currentNode.nextNode = right.currentNode;
		right.currentNode.previousNode = left.currentNode;
		
	}

}
