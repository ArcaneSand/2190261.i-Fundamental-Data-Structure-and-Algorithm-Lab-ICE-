
public class StackUtility {
	static String alphabets = "abcdefghijklmnopqrstuvwxyz";
	
	public static String operate(MyStack s1, MyStack s2) throws Exception {
		StackLinkedList s3 = new StackLinkedList();
		System.out.println(s1.size()%2);
		while(s1.size()-2>=0) {
			boolean operP = s2.top()>=0;
			s2.pop();
			
			int h = s1.top();
			s1.pop();
			int t = s1.top();
			s1.pop();
			
			if(operP) {
				s3.push(h+t);
			}else {
				s3.push(h-t);
			}
			
		}

		StringBuilder sb = new StringBuilder();
		while(!s3.isEmpty()) {
			int temp = s3.top();
			s3.pop();
			sb.append(alphabets.charAt(temp)); 
			
		}
		return sb.toString();
	}
}
