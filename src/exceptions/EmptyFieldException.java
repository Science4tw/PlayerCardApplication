package exceptions;

public class EmptyFieldException extends Exception {

	/**
	 * Repräsentiert die Ausnahmesituation, dass ein Eingabefeld
	 * in der View leer war beim Speichern einer neuen Spielerkarte
	 */
	public EmptyFieldException(String message) {
		super(message);
	}
}
