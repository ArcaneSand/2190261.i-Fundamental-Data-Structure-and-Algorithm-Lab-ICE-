
public class TypingDeadList extends CDLinkedList {
	int score = 0;  //not used in this exam
	DListIterator start = null; // the first position of a word to remove
	DListIterator end = null; // last position of a word to remove

	public TypingDeadList() throws Exception {
		this("");
	}

	public TypingDeadList(String s) throws Exception {
		// initialize the list
		// each data comes from each character in s
		int n = s.length();
		DListIterator d = new DListIterator(header);
		for (int i = n - 1; i >= 0; i--) {
			insert(s.charAt(i), d);
		}

	}

	public void removeWord(String w) throws Exception {
		// remove the first occurrence of w
		// if w is not in the list, do nothing
		// reset start and end to null no matter what
		findWord(w);
		if (start == null)
			return;

		int dec = w.length();
		remove(dec);

	}

	public void check(DListIterator l){
		System.out.println(l.currentNode.data);
	}

	public void findWord(String w) throws Exception {
		// update start and end to mark position of the first occurrence of w
		// The word cannot cross header node
		// If w is not in the list, do nothing.
		// w is assumed never to be an empty string.
		
		//fill code

		char[] chars = w.toCharArray();
		DListIterator itr = new DListIterator(header);
		DListIterator s;
		DListIterator e;
		boolean foundStart = false;
		boolean foundWord = false;
		int index = 0;
		//"abcdefg" fga
		while(itr.next()!=header.data) {
			index++;
			if(itr.currentNode.data == chars[0]){
				foundStart = true;
			}else{foundStart = false;}

			if(foundStart) {
				s = new DListIterator(itr.currentNode);
				e = new DListIterator(itr.currentNode);
				int a = index;
				for(int i = 0; i  < chars.length; i++) {
					if(e.currentNode.data == chars[i]&&e.currentNode.nextNode != header) {
						e.next();
					}else{
						foundStart = false;
						break;
					}
					a++;
				}
				if(foundStart) {
					//System.out.println(index + " " +a);
					e.previous();
					start = s;
					end = e;
					foundWord = true;
				}
			}
			if(foundWord)break;
		}
	}

	public void remove(int dec) throws Exception { // this must be the last method in your code!
		// remove data from start to end, inclusive,
		// if start or end is at header, do nothing.
		// size to remove is one of the known parameter -> reduce the size parameter of
		// the list

		//fill code
		if(dec==0)return;
		if(start==null || end==null)return;
		DListNode preS = start.currentNode.previousNode;
		DListNode postE = end.currentNode.nextNode;

		preS.nextNode = postE;
		postE.previousNode = preS;

		//start = null;
		//end = null;

		size -= dec;
	}

}
