package model;

public enum Position {
	
	STUERMER, VERTEIDIGER, TORWART;

	/**
	 * Gibt true zurück, wenn im Bezeichner dieses enum Objektes 
	 * die Zeichenkette searchString vorkommt (sonst false)
	 */
	public boolean contains(String searchString) {
		if (this.name().contains(searchString))
			return true;
		else 
			return false;
	}

}
