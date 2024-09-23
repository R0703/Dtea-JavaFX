package main;

import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class welcomeCustomerPage {
	Stage stage;
	Scene scene;
	BorderPane bp;
	FlowPane fp;
	VBox vb;
	
	Label welcomeLbl;
	Button continueBtn;
	File file;
	Media media;
	MediaPlayer mediaPlayer;
	MediaView mediaView;
	
	
	public void init() {
		
		welcomeLbl = new Label("Welcome to Dtea !");
		continueBtn = new Button("Continue");
		vb = new VBox();
		
		file = new File("Assets/video.mp4");
		media = new Media(file.toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaView = new MediaView(mediaPlayer);
		mediaPlayer.setAutoPlay(true);
		
		vb.getChildren().addAll(welcomeLbl);
		fp = new FlowPane(Orientation.VERTICAL);
		bp = new BorderPane();
		fp.getChildren().addAll(vb, mediaView, continueBtn);
		vb.setAlignment(Pos.CENTER);
        fp.setVgap(10);
        fp.setAlignment(Pos.CENTER);
		bp.setCenter(fp);
		bp.setPadding(new Insets(0, 0, 15, 0));
		
		welcomeLbl.setTextAlignment(TextAlignment.CENTER);
		scene = new Scene(bp, 600, 600);
		
		continueBtn.setOnAction(e->{
		    CataloguePage cataloguePage = new CataloguePage(); // go to catalogue and cart page
		    cataloguePage.start(stage); // display catalogue and cart page
		    mediaPlayer.stop();
		});
	}
	
	public void styling() {
		scene.getStylesheets().add("main/style.css");
		 mediaView.setFitWidth(300);  
	     mediaView.setFitHeight(200); 
	     continueBtn.setPrefWidth(300);
	     
	     welcomeLbl.setStyle("-fx-font-size: 26px;");
	}
	
	public welcomeCustomerPage(Stage stage) {
		this.stage = stage;
		init();
		styling();
		stage.setScene(scene);
		stage.setTitle("Dtea");
		stage.show();
	}
}
