package view;

import java.util.LinkedList;

import controller.MainController;
import exceptions.EmptyFieldException;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import model.PlayerCard;

public class MainPane extends BorderPane {

	// Zwei Behälter zum Hinzufügen und Suchen 
	// werden in Tabs in einer TabPane organisiert
	private AddPlayerPane addPane;
	private SearchPane searchPane;
	private Tab addTab, searchTab;
	private TabPane centerPane;
	// Information zum aktuellen Status
	private Label statusText;
	
	/**
	 * Konstruktor instanziiert die beiden Behälter 
	 * zum Hinzufügen und Suchen und organisiert diese
	 * in zwei Tabs in einer TabPane
	 */
	public MainPane(MainController mainController) {
		this.addPane = new AddPlayerPane(mainController);
		this.addTab = new Tab();
		this.addTab.setClosable(false);
		this.addTab.setText("Karte Hinzufügen");
		this.addTab.setContent(this.addPane);
		
		this.searchPane = new SearchPane(mainController);
		this.searchTab = new Tab();
		this.searchTab.setClosable(false);
		this.searchTab.setText("Karte Suchen");
		this.searchTab.setContent(this.searchPane);
		
		this.centerPane = new TabPane();
		this.centerPane.getTabs().addAll(this.addTab, this.searchTab);
		this.setCenter(this.centerPane);
		
		this.statusText = new Label("Alles ok...");
		this.setBottom(this.statusText);
	}

	/**
	 * Getter für die eingegebene Zeichenkette  
	 * aus dem Suchbehälter
	 */
	public String getSearchString() {
		return this.searchPane.getSearchString();
	}

	/**
	 * Setter für das Suchergebnis im Suchbehälter
	 */
	public void setSearchResult(LinkedList<PlayerCard> result) {
		this.searchPane.setSearchResult(result);
	}

	/**
	 * Getter für das eingegebene PlayerCard  
	 * Objekt aus der addPane
	 */
	public PlayerCard getPlayerCard() throws EmptyFieldException {
		return this.addPane.getPlayerCard();		
	}

	/**
	 * Setzt den Text im Label statusText gemäss Parameter
	 */
	public void updateStatus(String string) {
		this.addPane.reset();
		this.statusText.setText(string);
	}
}
