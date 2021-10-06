package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RewardScreen implements Initializable{
	
	@FXML
	private ImageView star1;
	@FXML
	private ImageView star2;
	@FXML
	private ImageView star3;
	@FXML
	private ImageView star4;
	@FXML
	private ImageView star5;

	private Stage stage;
	private Scene scene;
	private Parent root;

	public void start() {
		if (GamesModule.score>=1) {
			star1.setImage(new Image("./download.png"));
		} if (GamesModule.score>=2) {
			star2.setImage(new Image("./download.png"));
		} if (GamesModule.score>=3) {
			star3.setImage(new Image("./download.png"));
		} if (GamesModule.score>=4) {
			star4.setImage(new Image("./download.png"));
		} if (GamesModule.score>=5) {
			star5.setImage(new Image("./download.png"));
		}
	}
	
	public void switchToSummary(MouseEvent event) throws IOException { 
			root = FXMLLoader.load(getClass().getResource("Summary.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		start();
		
	}
	
	
	
}