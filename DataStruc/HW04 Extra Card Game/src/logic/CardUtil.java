package logic;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CardUtil {
	
	public static boolean isExistsInList(UnitCard card, ArrayList<UnitCard> list) {
		
		for(UnitCard temp: list) {
			if(temp.equals(card)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isExistsInList(UnitDeck deck, ArrayList<UnitDeck> list) {
		
		for(UnitDeck temp: list) {
			if(temp.equals(deck)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean cardExistsInDeckList(ArrayList<UnitDeck> deckList, UnitCard cardToTest) {
		for(UnitDeck temp: deckList) {
			if(temp.existsInDeck(cardToTest)) return true;
		}
		
		return false;
	}
	
	public static ArrayList<UnitCard> getCardsFromFile(String filename) throws FileNotFoundException{
		
		File fileToRead = new File(filename);
		ArrayList<UnitCard> cardsFromFile = new ArrayList<UnitCard>();

		//TODO: Fill Code
		String line;
		String[] newCard = new String[5];
		try(BufferedReader reader = new BufferedReader(new FileReader(fileToRead))){
			while((line = reader.readLine()) != null){
				newCard = line.split(",");
				UnitCard card = new UnitCard(newCard[0], Integer.parseInt(newCard[1]), Integer.parseInt(newCard[2]), Integer.parseInt(newCard[3]), newCard[4]);
				cardsFromFile.add(card);
			}
			reader.close();
		}catch(IOException e){
			return null;
		}
		
		return cardsFromFile;
	}

	public static void printCardList(ArrayList<UnitCard> cardList, boolean verbose) {
		
		for(int i = 0; i < cardList.size(); i++) {
			System.out.println(i + ") " + cardList.get(i));
			if(verbose) {
				System.out.println("Blood Cost: " + cardList.get(i).getBloodCost());
				System.out.println(cardList.get(i).getFlavorText());
				if(i < cardList.size()-1) System.out.println("-----");
			}
		}
	}
	
	public static void printDeck(UnitDeck ud) {
		
		if(ud.getCardsInDeck().size() == 0) {
			System.out.println("EMPTY DECK");
		}else {
			for(CardCounter cc : ud.getCardsInDeck()) {
				System.out.println(cc);
			}
		}
		
		System.out.println("Total Cards: " + ud.cardCount());
	}
	
	public static void printDeckList(ArrayList<UnitDeck> deckList) {
		
		
		for(int i = 0; i < deckList.size(); i++) {
			System.out.println(i + ") " + deckList.get(i).getDeckName());
			printDeck(deckList.get(i));
			if(i < deckList.size()-1) System.out.println("-----");
		}
	}
}