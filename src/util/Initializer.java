package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Nationality;
import model.PlayerCard;
import model.Position;

public class Initializer {
	
	// URL zu Datei mit initialen Spielerkarten
	private static String url = "\\ProgProjekte\\EclipseProjekte\\PlayerCardApplication\\src\\resources\\players.txt";

	/**
	 * Liest eine Datei mit initialen Spielerkarten ein,
	 * instanziiert für jede Zeile ein neues PlayerCard Objekt und fügt dieses der 
	 * Liste initialCollection hinzu (diese Liste wird zurückgegeben)
	 */
	public static ArrayList<PlayerCard> init() throws FileNotFoundException {
		ArrayList<PlayerCard> initialCollection = new ArrayList<PlayerCard>();
		Scanner fileReader = new Scanner(new File(url));
		Scanner lineScanner;
		while (fileReader.hasNext()) {
			String line = fileReader.nextLine();
			lineScanner = new Scanner(line);
			lineScanner.useDelimiter(";");
			String playerName = lineScanner.next();
			String clubName = lineScanner.next();
			String n = lineScanner.next();
			Nationality nationality = Nationality.valueOf(n);
			String p = lineScanner.next();
			Position position = Position.valueOf(p);
			PlayerCard pc = new PlayerCard(playerName, clubName, nationality, position);
			initialCollection.add(pc);
		}
		return initialCollection;
	}
}
