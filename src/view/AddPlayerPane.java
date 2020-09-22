package view;

import controller.MainController;
import exceptions.EmptyFieldException;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.Nationality;
import model.PlayerCard;
import model.Position;

public class AddPlayerPane extends GridPane {
	
	// Kontrollelemente dieses Behälters
	private ChoiceBox<Nationality> nationalityChoiceBox;
	private TextField nameField, clubField;
	private RadioButton forwardButton, backButton, goalieButton;
	private HBox buttonBox;
	private Button addButton;
	private Label nationLabel, nameLabel, clubLabel;

	/**
	 * Konstruktor instanziiert alle nötigen Kontrollelemente 
	 * und fügt sie diesem Behälter hinzu
	 * Der Button addButton wird via Methodenreferenz an die 
	 * Methode processNewCard aus dem MainController angehängt
	 */
	public AddPlayerPane(MainController mainController) {
		// ChoiceBox zur Auswahl der Nationalit�t
		this.nationLabel = new Label("Nationalit�t");
		this.add(this.nationLabel, 1, 1);
		this.nationalityChoiceBox = new ChoiceBox<Nationality>();
		Nationality[] nationalities = Nationality.values();
		for (Nationality nationality : nationalities)
			this.nationalityChoiceBox.getItems().add(nationality);
		this.add(this.nationalityChoiceBox, 2, 1);
		
		// TextField zur Eingabe des Spielernamen und des Clubs
		this.nameLabel = new Label("Spielername");
		this.add(this.nameLabel, 1, 2);
		this.nameField = new TextField();
		this.add(this.nameField, 2, 2);
		this.clubLabel = new Label("Club");
		this.add(this.clubLabel, 1, 3);
		this.clubField = new TextField();
		this.add(this.clubField, 2, 3);
		
		// RadioButton (in einer HBox organisiert) 
		// Auswahl: STUERMER, VERTEIDIGER, TORWART
		this.forwardButton = new RadioButton(Position.values()[0].name());
		this.backButton = new RadioButton(Position.values()[1].name());
		this.goalieButton = new RadioButton(Position.values()[2].name());
		this.forwardButton.setSelected(true);
		ToggleGroup tg = new ToggleGroup();
		this.forwardButton.setToggleGroup(tg);
		this.backButton.setToggleGroup(tg);
		this.goalieButton.setToggleGroup(tg);
		this.buttonBox = new HBox();
		this.buttonBox.getChildren().addAll(this.forwardButton, this.backButton, this.goalieButton);
		this.add(buttonBox, 2, 5);
		
		// Button zum Hinzufügen der Karte 
		// (verbunden via Methodenreferenz mit dem MainController)
		this.addButton = new Button("Hinzufügen");
		this.add(this.addButton, 2, 6);
		this.addButton.setOnAction(mainController::processNewCard);
				
		// ein paar wenige Formatierungen
		this.setStyle("-fx-background-color: lemonchiffon");
		this.setAlignment(Pos.CENTER);
		this.setHgap(20);
		this.setVgap(10);
	}
	
	/**
	 * Liest die ChoiceBox, die TextField, die RadioButton aus, 
	 * instanziiert mit diesen Angaben ein neues PlayerCard Objekt und 
	 * gibt dieses zurück (Falls eine Angabe fehlt wird eine 
	 * EmptyFieldException geworfen)
	 */
	public PlayerCard getPlayerCard() throws EmptyFieldException{
			String playerName = this.nameField.getText();
			if (playerName.length() == 0) 
				throw new EmptyFieldException("Spielername fehlt...");
			String clubName = this.clubField.getText();
			if (clubName.length() == 0) 
				throw new EmptyFieldException("Clubname fehlt...");
			Nationality nationality = this.nationalityChoiceBox.getSelectionModel().getSelectedItem();
			if (nationality == null) 
				throw new EmptyFieldException("Nationalit�t fehlt...");
		
			Position position = null;
			if (this.forwardButton.isSelected())
				position = Position.STUERMER;
			if (this.backButton.isSelected())
				position = Position.VERTEIDIGER;
			if (this.goalieButton.isSelected())
				position = Position.TORWART;
			PlayerCard playerCard = new PlayerCard(playerName, clubName, nationality, position);
			return playerCard;	
	}

	/**
	 * Setzt alle Eingaben im Behälter zurück
	 */
	public void reset() {
		this.nationalityChoiceBox.getSelectionModel().clearSelection();
		this.nameField.setText("");
		this.clubField.setText("");
	}
}
