package view;

import java.util.LinkedList;

import controller.MainController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.PlayerCard;

public class SearchPane extends VBox {
	
	// Kontrollelemente dieses Behälters
	private TextField searchField;
	private Button searchButton;
	private Label resultBox;
	
	/**
	 * Konstruktor instanziiert alle nötigen Kontrollelemente 
	 * und fügt sie diesem Behälter hinzu
	 * Der Button searchButton und das TextField searchField wird via 
	 * Methodenreferenz an die Methode search aus dem MainController angehängt
	 */
	public SearchPane(MainController mainController) {
		this.searchField = new TextField();
		this.searchField.setMaxWidth(150);
		this.searchButton = new Button("Suche");
		this.resultBox = new Label();
		this.getChildren().addAll(this.searchField, this.searchButton, this.resultBox);
		
		this.searchButton.setOnAction(mainController::search);
		this.searchField.setOnAction(mainController::search);
		
		// einige Formatierungen
		this.setStyle("-fx-background-color: lemonchiffon");
		this.setAlignment(Pos.CENTER);
		this.setSpacing(20);
	}
	
	/**
	 * Getter für die eingegebene Zeichenkette  
	 * im TextField searchField
	 */
	public String getSearchString() {
		return this.searchField.getText();
	}

	/**
	 * Setter für das Suchergebnis
	 */
	public void setSearchResult(LinkedList<PlayerCard> result) {
		if (result != null) {
			String stringResult = "Gefundene Karten:\n";
			for (PlayerCard pc : result) {
				stringResult += pc +"\n";
			}
			this.resultBox.setText(stringResult);
		} else {
			this.resultBox.setText("Keine Karte gefunden...");
		}
	}
}
