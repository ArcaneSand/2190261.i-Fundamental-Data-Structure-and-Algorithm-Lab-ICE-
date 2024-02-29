
public class BankQueue { // must work for any implementation of DeQ
	DeQ[] counters;
	DeQ special;

	public BankQueue(DeQ[] counters, DeQ special) {
		super();
		this.counters = counters;
		this.special = special;
	}

	//Write this method
	public void distribute() throws Exception {
		int c = 0;
		for(int i=0;i<counters.length;i++) {
			c+=counters[i].size();
		}
		float cfloat = (float)c/(float)((counters.length)+1);
		int cneed = Math.round(cfloat);
		int crem = cneed;
		boolean isAllCor = true;
		while(crem>0) {
			isAllCor = true;
			for(int i=0;i<counters.length;i++) {
				if(counters[i].size()-cneed <= 0)continue;
				isAllCor = false;
				int[] temp = new int[counters[i].size()-cneed];
				int itrT = 0; 
				while(counters[i].size()>cneed) {
					temp[itrT++]=counters[i].removeLast();
				}
				while(itrT>0&&crem>0) {
					special.insertLast(temp[--itrT]);
					crem--;
					if(crem==0 && itrT>0){
						while(itrT>0) {
							counters[i].insertLast(temp[--itrT]);
						}
					}
				}
				if(crem<1)break;
			}
			if(isAllCor) {
				special.insertLast(counters[counters.length-1].removeLast());
				break;
			}
		}
		// 5/3> 2 
		// 11 11 7 -- 8 9 10 11 8 9 10 
		// 4 5
		//
	}

}
