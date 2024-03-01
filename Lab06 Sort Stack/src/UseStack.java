
public class UseStack {
	
	//implement this method.
	public static Stack sort(Stack s) throws Exception {
		
		if(s.isEmpty())return s;
		
		ArrayListStack tmpS1 = new ArrayListStack();
		ArrayListStack tmpS2 = new ArrayListStack();
	   
		tmpS1.push(s.top());
	   	s.pop();

	   	while(!s.isEmpty()) {
		   //[1 2 4]
		   //[3]
		   	if(s.top()<=tmpS1.top()) {
				tmpS1.push(s.top());
			   	s.pop();
		   	}else {
			   	int temp = s.top();
			   	boolean pop = false;
			   	s.pop();
			   	while(!tmpS1.isEmpty()) {
				   	if(temp<=tmpS1.top()&&!pop) {
					   	tmpS2.push(temp);
					   	pop=true;
				   	}
				   	tmpS2.push(tmpS1.top());
				   	tmpS1.pop();
					if(tmpS1.isEmpty()&&!pop) {
						tmpS2.push(temp);
					   	pop=true;
					}
				}
				while(!tmpS2.isEmpty()){
					tmpS1.push(tmpS2.top());
					tmpS2.pop();
				}
			}  	
	   }
	   return tmpS1;
	}
	       
	//for testing purpose
	public static void testL() {
		System.out.println("L detected");
		return;
	}

	public static void testL2(Stack s, ArrayListStack tmpS1, ArrayListStack tmpS2) {
		System.out.println(((ArrayListStack)s).getA());
	   System.out.println(tmpS1.getA());
	   System.out.println(tmpS2.getA());
	   System.out.println("-------------");
	}
}

