package model;

public enum Nationality {
	
	Brasilien,
	Kolumbien,
	Holland,
	Estland,
	Frankreich,
	Island,
	Jamaika;
	
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
