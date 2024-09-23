package main;

import account.Account;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RegisterPage {
	Stage stage;
	Scene scene;
	
	BorderPane bp;
	GridPane gp;
	
	Label registerLbl, emailLbl, passwordLbl, nameLbl, confirmPassLbl;
	TextField emailtf, nametf;
	PasswordField passwordpf, confirmPasspf;
	Button regisBtn;
	Hyperlink loginhp;
	VBox vb0,vb1,vb2,vb3,vb4,vb5;

	
	public void styling() {
		scene.getStylesheets().add("main/style.css");
		registerLbl.setStyle("-fx-font-size: 26px;");
		regisBtn.setPrefWidth(250);
		regisBtn.setPrefHeight(25);
		emailtf.setPrefHeight(35);
		passwordpf.setPrefHeight(35);
		nametf.setPrefHeight(35);
		confirmPasspf.setPrefHeight(35);
		 
		vb0.setAlignment(Pos.CENTER);
		vb5.setAlignment(Pos.CENTER);
		gp.setAlignment(Pos.CENTER);
		 
		gp.setHgap(10);
		gp.setVgap(10);
		 
		vb0.setPadding(new Insets(0, 0, 5, 0));
		vb2.setPadding(new Insets(0, 0, 10, 0));
		vb3.setPadding(new Insets(0, 0, 10, 0));
		vb4.setPadding(new Insets(0, 0, 10, 0));
		vb5.setPadding(new Insets(0, 0, 10, 0));
		 
		regisBtn.setPadding(new Insets(10, 0, 10, 0));
	}
	
	public void init() {
		gp = new GridPane();
		bp = new BorderPane();
		registerLbl = new Label("Register");
		emailLbl = new Label("Email");
		emailtf = new TextField();
		nameLbl = new Label("Name");
		nametf = new TextField();
		passwordLbl = new Label("Password");
		passwordpf = new PasswordField();
		regisBtn = new Button("Register");
		confirmPassLbl = new Label("Confirm password");
		confirmPasspf = new PasswordField();
		loginhp = new Hyperlink("Already a member? Login");
		
		vb0 = new VBox();	
		vb1 = new VBox();
		vb2 = new VBox();
		vb3 = new VBox();
		vb4 = new VBox();
		vb5 = new VBox();
		
		vb0.getChildren().addAll(registerLbl);
		vb1.getChildren().addAll(emailLbl, emailtf);
		vb2.getChildren().addAll(nameLbl, nametf);
		vb3.getChildren().addAll(passwordLbl, passwordpf);
		vb4.getChildren().addAll(confirmPassLbl, confirmPasspf);
		vb5.getChildren().addAll(loginhp);
		
		gp.add(vb0, 0, 0);
		gp.add(vb1, 0, 1);
		gp.add(vb2, 0, 2);
		gp.add(vb3, 0, 3);
		gp.add(vb4, 0, 4);
		gp.add(regisBtn, 0, 5);
		gp.add(vb5, 0, 6);
		
		bp.setCenter(gp);
		
		
//		gp.setPadding(new Insets(20,20,20,20));
//		gp.setHgap(10);
//		gp.setVgap(10);
		
		regisBtn.setOnMouseClicked(e->{
			String email = emailtf.getText();
			String name = nametf.getText();
			String password = passwordpf.getText();
			String confirmPassword = confirmPasspf.getText();
			if (validateNewAccount(email,name,password,confirmPassword)) {
				Main.accounts.add(new Account(email, name, password, confirmPassword));
				new LoginPage(stage);
			}else {
				System.out.println("either gmail or pass is error");
			}
		});
		
		loginhp.setOnAction(e->{
			new LoginPage(stage);
		});
		
		scene = new Scene(bp, 400, 550);
		
	;}
	
	public boolean validateNewAccount(String email, String name, String password, String confirmPassword) {
		if (email.isEmpty()) {
            showAlert("Error", "Email must be filled.");
            return false;
        }
		if (!email.contains("@") || email.indexOf('@') != email.lastIndexOf('@')) {
            showAlert("Error", "Email must contain exactly one '@'.");
            return false;
        }
		if(!email.endsWith(".com")) {
			showAlert("Error gmail", "Gmail must ends with .com");
			return false;
		}if (name.isEmpty()) {
            showAlert("Error", "Name must be filled.");
            return false;
        }
        if (password.isEmpty()) {
            showAlert("Error", "Password must be filled.");
            return false;
        }
        if (confirmPassword.isEmpty()) {
            showAlert("Error", "Confirm Password must be filled.");
            return false;
        }
        else if (!password.equals(confirmPassword)) {
            showAlert("Error", "Password and Confirm Password must match.");
            return false;
        }
		return true;
	}
	
	public void showAlert(String title, String message) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}
	
	public RegisterPage(Stage stage) {
		this.stage = stage;
		init();
		styling();
		stage.setTitle("Dtea Application");
		stage.setScene(scene);
		stage.show();
	}
	
}
