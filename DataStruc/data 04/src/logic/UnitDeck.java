package logic;

import java.util.ArrayList;

public class UnitDeck {
	private ArrayList<CardCounter> cardsInDeck;
	String deckName;
	
	public UnitDeck(String deckName) {
		setName(deckName);
		cardsInDeck = new ArrayList<CardCounter>();
	}
	
	public void addCard(UnitCard newCard, int count) {
		if(count<0)return;
		boolean isInDeck = false;
		int index = -1;
		
		for (int i =0;i<cardsInDeck.size();i++) {
			CardCounter temp = cardsInDeck.get(i);
			if(temp.getCard()==newCard.getName()) {
				isInDeck = true;
				index = i;
				break;
			}
		}
		
		if(isInDeck||index!=-1) {
			CardCounter card = cardsInDeck.get(index);
			card.setCount(card.getCount()+count);
		}else {
			CardCounter newCounter = new CardCounter(newCard,count);
			cardsInDeck.add(newCounter);
		}
	}
	
	public void removeCard(UnitCard toRemove, int count) {
		
		boolean isInDeck = false;
		int index = -1;
		
		for (int i =0;i<cardsInDeck.size();i++) {
			CardCounter temp = cardsInDeck.get(i);
			if(temp.getCard()== toRemove.getName()) {
				isInDeck = true;
				index = i;
				break;
			}
		}
		
		if(count<0||!isInDeck)return;
		
		CardCounter cardToRemove = cardsInDeck.get(index);
		int c = cardToRemove.getCount();
		if(cardToRemove.getCount()-count <1) {
			cardsInDeck.remove(index);
		}
		cardToRemove.setCount(c-count);
	}
	
	public int cardCount() {
		int count =0;
		for(CardCounter card:cardsInDeck) {
			count += card.getCount();
		}
		return count;
	}
	
	public boolean existInDeck(UnitCard card) {
		for(CardCounter cardCount: cardsInDeck) {
			if(cardCount.getCardObj()== card) {
				return true;
			}
		}
		return false;
	}
	
	public boolean equals(UnitDeck other) {
		if(other.getName().equals(deckName)) {
			return true;
		}
		return false;
	}
	
	public String getName() {
		return deckName;
	}
	
	public void setName(String name) {
		if(name.isBlank())name = "Untitled Deck";
		deckName = name;
	}
}
