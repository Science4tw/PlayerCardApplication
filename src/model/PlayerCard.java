package model;

public class PlayerCard {
	
	// Globaler Zähler für alle PlayerCard Objekte
	public static int globalCardCount = 0;
	
	// Instanzvariablen für PlayerCard Objekte
	private String playerName, clubName;
	private Nationality nationality;
	private Position position;
	private int cardNumber;

	/**
	 * Konstruktor für PlayerCard Objekte
	 */
	public PlayerCard(String playerName, String clubName, Nationality nationality, Position position) {
		this.playerName = playerName;
		this.clubName = clubName;
		this.nationality = nationality;
		this.position = position;
		this.cardNumber = globalCardCount++;
	}

	/**
	 * Zeichenkettenrepräsentation für PlayerCard Objekte
	 */
	public String toString() {
		return this.playerName + ", " + this.clubName + ", " + this.nationality
				+ ", " + this.cardNumber+", "+this.position;
	}

	/**
	 * Gibt true zurück, wenn in einer der Instanzvariablen dieses PlayerCard 
	 * Objektes die Zeichenkette searchString vorkommt (sonst false)
	 */
	public boolean contains(String searchString) {
		String cardNumberAsString = Integer.toString(cardNumber);
		return this.playerName.contains(searchString) ||
				this.clubName.contains(searchString) ||
				this.nationality.contains(searchString) ||
				this.position.contains(searchString) ||
				cardNumberAsString.contains(searchString);
	}
}
