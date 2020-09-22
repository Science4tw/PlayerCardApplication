package controller;

import java.util.LinkedList;

import exceptions.EmptyFieldException;
import javafx.event.ActionEvent;
import model.PlayerCard;
import model.PlayerCardCollection;
import view.MainPane;

public class MainController {
	
	// Instanzvariablen referenzieren das Model und die View
	private PlayerCardCollection playerCards;
	private MainPane mainPane;
	
	/**
	 * Konstruktor für den Controller der Applikation
	 * (PlayerCardCollection (das Model) wird als Parameter übergeben)
	 */
	public MainController(PlayerCardCollection playerCards) {
		this.playerCards = playerCards;
	}
	
	/**
	 * Setter für die View der Applikation
	 */
	public void setMainView(MainPane mainPane) {
		this.mainPane = mainPane;
	}
	
	/**
	 * Wird ausgeführt, sobald in der   
	 * View eine Suche gestartet wird
	 */
	public void search(ActionEvent e){
		String searchString = mainPane.getSearchString();
		LinkedList<PlayerCard> result = this.playerCards.search(searchString);
		this.mainPane.setSearchResult(result);
		this.mainPane.updateStatus("Suche durchgeführt");
	}
	
	/**
	 * Wird ausgeführt, sobald in der   
	 * View eine neue Karte erfasst wird
	 */
	public void processNewCard(ActionEvent e) {
		try {
			PlayerCard newCard = this.mainPane.getPlayerCard();
			this.playerCards.add(newCard);
			this.mainPane.updateStatus("Karte hinzugefügt: " + newCard);
		} catch (EmptyFieldException exception) {
			this.mainPane.updateStatus(exception.getMessage());
		}
	}
}
