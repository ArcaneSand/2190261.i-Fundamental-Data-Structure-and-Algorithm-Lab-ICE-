package logic;

public class CardCounter {
	
	private UnitCard card;
	private int count;
	
	public String toString() {
		return  this.getCardName() + " x " + this.getCount();
	}
	
	public CardCounter(UnitCard card,int count) {
		this.card = card;
		setCount(count);
	}
	
	public void setCount(int count) {
		if(count<0)count=0;
		this.count = count;
	}
	
	public UnitCard getCard() {
		return this.card;
		//return String.format("%s (POW: %d, HP: 0)",getCardName(),getCardObj().getPower());
	}

	public String getCardName() {
		return this.card.getName();
	}
	
	public int getCount() {
		return this.count;
	}
	
	public UnitCard getCardObj() {
		return this.card;
	}
}