package main;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ViewImageB {
	
	Stage stage;
	Scene scene;
	BorderPane bp;
	Image image;
	ImageView viewImage;
	HBox hb;
	Button ZoomInBtn, ZoomOutBtn, RotateLeftBtn, RotateRightBtn, backBtn;
	
	public void init() {
		image = new Image(getClass().getResourceAsStream("/main/black_tea.jpg"));
		hb = new HBox();
		ZoomInBtn = new Button("Zoom in");
		ZoomOutBtn = new Button("Zoom out");
		RotateLeftBtn = new Button("Rotate Left");
		RotateRightBtn = new Button("Rotate Right");
		backBtn = new Button("<- Back");
		viewImage = new ImageView(image);
		bp = new BorderPane();
		scene = new Scene(bp, 600, 600);
		
		hb.getChildren().addAll(ZoomInBtn, ZoomOutBtn, RotateLeftBtn, RotateRightBtn);
		hb.setAlignment(Pos.CENTER);
		hb.setPadding(new Insets(0, 0, 15, 0));
		hb.setSpacing(15);
	}
	
	
	public void layout() {
		viewImage.setImage(image);
		viewImage.setFitHeight(360);
		viewImage.setFitWidth(360);
		viewImage.setPreserveRatio(true);
		bp.setTop(backBtn);
		bp.setCenter(viewImage);
		bp.setBottom(hb);
	}
	
	public void ButtonLogic(){
		
		ZoomOutBtn.setOnMouseClicked(e ->{
			viewImage.setScaleX(0.8);
			viewImage.setScaleY(0.8);
		});
		
		ZoomInBtn.setOnMouseClicked(e ->{
			viewImage.setScaleX(1.2);
			viewImage.setScaleY(1.2);
		});
		
		RotateLeftBtn.setOnMouseClicked(e->{
			viewImage.setRotate(viewImage.getRotate() - 90);
		});
		
		RotateRightBtn.setOnMouseClicked(e->{
			viewImage.setRotate(viewImage.getRotate() + 90);
		});
		
		backBtn.setOnMouseClicked(e->{
			new AdminPage(stage);
		});
	}
	
	public ViewImageB(Stage stage) {
		this.stage = stage;
		init();
		layout();
		ButtonLogic();
		stage.setScene(scene);
		stage.setTitle("Image Preview");
		stage.show();
	}
}
