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
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class LoginPage {
	Stage stage;
	Scene scene;
	
	Label loginLbl, emailLbl, passwordLbl;
	TextField emailtf;
	PasswordField passwordpf;
	Button loginBtn;
	Hyperlink regishp;
	VBox vb0,vb1,vb2,vb3;
	
	BorderPane bp;
	GridPane gp;
	
	public void styling() {
		 scene.getStylesheets().add("main/style.css");
		 loginLbl.setStyle("-fx-font-size: 26px;");
		 loginBtn.setPrefWidth(250);
		 loginBtn.setPrefHeight(25);
		 emailtf.setPrefHeight(35);
		 passwordpf.setPrefHeight(35);
		 
		 vb0.setAlignment(Pos.CENTER);
		 vb3.setAlignment(Pos.CENTER);
		 gp.setAlignment(Pos.CENTER);
		 
		 gp.setHgap(10);
		 gp.setVgap(10);
		 
		 vb0.setPadding(new Insets(0, 0, 5, 0));
//		 vb1.setPadding(new Insets(0, 0, 10, 0));
		 vb2.setPadding(new Insets(0, 0, 10, 0));
		 loginBtn.setPadding(new Insets(10, 0, 10, 0));
	}
	
	public void init() {
		loginLbl = new Label("Login");
		emailLbl = new Label("Email");
		emailtf = new TextField();
		passwordLbl = new Label("Password");
		passwordpf = new PasswordField();
		
		loginBtn = new Button("Login");
		regishp = new Hyperlink("Not a member? Register");
		
		vb0 = new VBox();	
		vb1 = new VBox();
		vb2 = new VBox();
		vb3 = new VBox();
		gp = new GridPane();
		bp = new BorderPane();
		
		vb0.getChildren().addAll(loginLbl);
		vb1.getChildren().addAll(emailLbl, emailtf);
		vb2.getChildren().addAll(passwordLbl, passwordpf);
		vb3.getChildren().addAll(regishp);
		
		gp.add(vb0, 0, 0);
		gp.add(vb1, 0, 1);
		gp.add(vb2, 0, 2);
		gp.add(loginBtn, 0, 3);
		gp.add(vb3, 0, 4);
		
		bp.setCenter(gp);
		scene = new Scene(bp, 400, 450);
		
//		link to register
		regishp.setOnAction(e->{
			new RegisterPage(stage);
		});
		
//		validation buttonnya
		loginBtn.setOnAction(e->{
			String email = emailtf.getText();
			String password = passwordpf.getText();
			
			if (email.isEmpty()) {
				showAlert("Error", "Email must be filled.");
			}
			
			if (password.isEmpty()) {
				showAlert("Error", "Password must be filled.");
			}
			
			if (email.equals("admin") && password.equals("admin123")) {
                new AdminPage(stage);
            }else if(searchAccount(email,password)) {
				new welcomeCustomerPage(stage);
			}
			else {
				showAlert("Error", "there is no account");
			}
		});
	;}
	
	private boolean searchAccount(String email, String password) {
		for (Account acc : Main.accounts) {
			if(acc.getEmail().equals(email)&&acc.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public void showAlert(String title, String message) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}
	
	public LoginPage(Stage stage) {
		this.stage = stage;
		init();
		styling();
		stage.setTitle("Dtea Application");
		stage.setScene(scene);
		stage.show();
	}

}