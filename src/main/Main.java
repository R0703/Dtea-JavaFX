package main;

import java.util.ArrayList;

import account.Account;
import menu.Menu;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{

	public static ArrayList<Account>accounts = new ArrayList<>();
	public static ArrayList<Menu>menu = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		new LoginPage(primaryStage);
	}

}
