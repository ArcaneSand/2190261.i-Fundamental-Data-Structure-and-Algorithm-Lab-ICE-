import java.util.ArrayList;

public class BSTList {
	BSTNodeList root;
	int size;
	
	public BSTList() {
		root = null;
		size = 0;
	}
	
	public BSTList(BSTNodeList root, int size) {
		this.root = root;
		this.size = size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}

	public void makeEmpty() {
		root = null;
		size = 0;
	}
	
	public BSTNodeList find(Comparable v) { 
		BSTNodeList temp = root;
		while((temp!=null)&&(temp.dataList.get(0).compareTo(v)!=0)) {
			if(temp.dataList.get(0).compareTo(v)>0) {
				temp = temp.left;
			}else {
				temp = temp.right;
			}
		}
		if(temp==null) {
			return null;
		}else {
			if(temp.dataList.contains((Pairdata)v)) {
				return temp;
			}else {
				return null;
			}
		}
		
	}
	
	public BSTNodeList insert(Comparable v) {
		BSTNodeList parent = null;
		BSTNodeList temp = root;
		
		Pairdata p = (Pairdata)v;
		
		while((temp!=null)&&(temp.dataList.get(0).compareTo(p)!=0)) {
			if(temp.dataList.get(0).compareTo(p)>0) {
				parent = temp;
				temp = temp.left;
			}else if(temp.dataList.get(0).compareTo(p)<0) {
				parent = temp;
				temp = temp.right;
			}
		}
		if(temp==null) {
			ArrayList<Pairdata> data = new ArrayList<Pairdata>();
			data.add((Pairdata)v);
			BSTNodeList n = new BSTNodeList(data,null,null,parent);
			if(parent==null) {
				root = n;
			}else if(parent.dataList.get(0).compareTo(v)>0) {
				parent.left = n;
			}else {
				parent.right = n;
			}
			size++;
			return n;
		}else {
			if(temp.dataList.contains(p)) {
				return temp;
			}else {
				temp.dataList.add(p);
				size++;
				return temp;
			}
			
		}

	}
	
	public BSTNodeList findMin(BSTNodeList n) {
		BSTNodeList temp = n;
		if (temp == null)
			return null;
		while (temp.left != null) {
			temp = temp.left;
		}
		return temp;
	}

	

	
}
