package model;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import util.Initializer;

public class PlayerCardCollection extends LinkedList<PlayerCard>{
	
	/**
	 * Konstruktor für PlayerCardCollection: Initialisiert 
	 * die Liste mit der statischen Methode init
	 */
	public PlayerCardCollection() {
		try {
			this.addAll(Initializer.init());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gibt eine Liste von PlayerCard Objekten zurück, deren
	 * Instanzvariablen die Zeichenkette searchString enthalten
	 * (falls keine entsprechende Karte existiert, wird das leere Objekt 
	 * null zurückgegeben)
	 */
	public LinkedList<PlayerCard> search(String searchString){
		LinkedList<PlayerCard> result = new LinkedList<PlayerCard>();
		for (PlayerCard playerCard : this) {
			if (playerCard.contains(searchString)) {
				result.add(playerCard);
			}
		}
		if (result.size() > 0)
			return result;
		else
			return null;
	}
}
