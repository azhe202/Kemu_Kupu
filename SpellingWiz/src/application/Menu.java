package application;

import java.io.IOException;
import java.net.MalformedURLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Menu extends CategorySelection{

	private Stage stage;
	private Scene scene;
	private Parent root;
	public static boolean isEnglish = true;
	public static String langExt = "";
	public static String moduleSelected = "NotSelected";

	@FXML
	private ImageView gamesBtn;
	@FXML
	private ImageView practiseBtn;
	@FXML
	private ImageView langToggle;
	
	public void setUpLang(MouseEvent event) {
		
		langToggle.setImage(new Image("./images/langTogglefade"+langExt+".jpg"));
		gamesBtn.setImage(new Image("./images/gamesModule"+langExt+".jpg"));
		practiseBtn.setImage(new Image("./images/practiseModule"+langExt+".jpg"));
	}

	public void chooseGame(MouseEvent event) { 
		try {
			moduleSelected = "GamesModule";
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("./FXML/CategorySelection.fxml"));
			root = loader.load();
			scene = new Scene(root);

			// access the controller and call function to set up the language
			CategorySelection controller = loader.getController();
			controller.setUpLang(event);

			// show GUI to user 
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void choosePractise(MouseEvent event) { 
		try {
			moduleSelected = "PractiseModule";
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("./FXML/PractiseSelection.fxml"));
			root = loader.load();
			scene = new Scene(root);

			// access the controller and call function to set up the language
			PractiseSelection controller = loader.getController();
			controller.setUpLang(event);

			// show GUI to user 
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void chooseToggle(MouseEvent event) {
		if (isEnglish) {
			isEnglish = false;
			langExt = "m";
		} else {
			isEnglish = true;
			langExt = "";
		}
		langToggle.setImage(new Image("./images/langToggle"+langExt+".jpg"));
		gamesBtn.setImage(new Image("./images/gamesModule"+langExt+".jpg"));
		practiseBtn.setImage(new Image("./images/practiseModule"+langExt+".jpg"));
	}

	public void enterGames(MouseEvent event) throws MalformedURLException { 
		gamesBtn.setImage(new Image("./images/gamesModuleSelect"+langExt+".jpg"));
		Sound.playSound("./sounds/switch.wav");
	}

	public void exitGames(MouseEvent event) { 
		gamesBtn.setImage(new Image("./images/gamesModule"+langExt+".jpg"));
	}

	public void enterPractise(MouseEvent event) throws MalformedURLException { 
		practiseBtn.setImage(new Image("./images/practiseModuleSelect"+langExt+".jpg"));
		Sound.playSound("./sounds/switch.wav");
	}

	public void exitPractise(MouseEvent event) { 
		practiseBtn.setImage(new Image("./images/practiseModule"+langExt+".jpg"));
	}

	public void enterToggle(MouseEvent event) throws MalformedURLException { 
		langToggle.setImage(new Image("./images/langToggle"+langExt+".jpg"));
		Sound.playSound("./sounds/switch.wav");
	}

	public void exitToggle(MouseEvent event) { 
		langToggle.setImage(new Image("./images/langTogglefade"+langExt+".jpg"));
	}


}