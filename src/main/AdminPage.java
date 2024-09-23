package main;

import items.Items;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminPage {
	
	VBox vbtitle, vblogout, vb1, vb2, vb3,vb4,vb5,vb6,vb7,vb8;
	VBox vb1b, vb2b, vb3b,vb4b,vb5b,vb6b,vb7b,vb8b;
	VBox vb1a, vb2a, vb3a,vb4a,vb5a,vb6a,vb7a,vb8a;
	VBox vb1h, vb2h, vb3h,vb4h,vb5h,vb6h,vb7h,vb8h;
	VBox vb1m, vb2m, vb3m,vb4m,vb5m,vb6m,vb7m,vb8m;
	
    HBox hbatea, hbateastat, hbbtea, hbbteastat, hbhtea, hbhteastat, hbltea, hblteastat, hbmtea, hbmteastat;
	Image imageapplet, imageblackt, imagehoneyt, imagelemont, imagemilkt;
	ImageView viewimageapplet, viewimageblackt, viewimagehoneyt, viewimagelemont, viewimagemilkt;

    public AdminPage(Stage stage) {
        stage.setTitle("Kel9Dtea - Admin Page");
   
        vbtitle = new VBox();
        vblogout = new VBox();
        vb1 = new VBox();
		vb2 = new VBox();
		vb3 = new VBox();
		vb4 = new VBox();
		vb5 = new VBox();
		vb6 = new VBox();
		vb7 = new VBox();
		vb8 = new VBox();
		vb1b = new VBox();
		vb2b = new VBox();
		vb3b = new VBox();
		vb4b = new VBox();
		vb5b = new VBox();
		vb6b = new VBox();
		vb7b = new VBox();
		vb8b = new VBox();
		vb1a = new VBox();
		vb2a = new VBox();
		vb3a = new VBox();
		vb4a = new VBox();
		vb5a = new VBox();
		vb6a = new VBox();
		vb7a = new VBox();
		vb8a = new VBox();
		vb1h = new VBox();
		vb2h = new VBox();
		vb3h = new VBox();
		vb4h = new VBox();
		vb5h = new VBox();
		vb6h = new VBox();
		vb7h = new VBox();
		vb8h = new VBox();
		vb1m = new VBox();
		vb2m = new VBox();
		vb3m = new VBox();
		vb4m = new VBox();
		vb5m = new VBox();
		vb6m = new VBox();
		vb7m = new VBox();
		vb8m = new VBox();
		
		
		hbatea = new HBox();
		hbateastat = new HBox();
		hbbtea = new HBox();
		hbbteastat = new HBox();
		hbhtea = new HBox();
		hbhteastat = new HBox();
		hbltea = new HBox();
		hblteastat = new HBox();
		hbmtea = new HBox();
		hbmteastat = new HBox();
		
		
        ScrollPane scrollPane = new ScrollPane();
        GridPane grid = new GridPane();
        BorderPane bp = new BorderPane();
       
		
        Label titleLabel = new Label("Manage Items");
        titleLabel.setStyle("-fx-font-size: 24px;");
        Button logoutButton = new Button("Logout");

        Items lemonTea = new Items("Lemon Tea", 20000.0, 9, "A refreshing infusion of black tea subtly brightened by the zesty essence of fresh lemons, offering a tangy and invigorating flavor profile", "file:lemon_tea.png");
        Items blackTea = new Items("Black Tea", 10000.0, 20, "A robust and full-bodied brew, characterized by its deep, malty notes and a bold, satisfying taste that makes it a classic choice for tea enthusiasts", "file:black_tea.png");
        Items appleTea = new Items("Apple Tea", 25000.0, 20, "A delightful infusion blending the sweetness of ripe apples with the comforting warmth of tea, creating a fruity and aromatic beverage that evokes the essence of a crisp autumn day", "file:apple_tea.png");
        Items honeyTea = new Items("Honey Tea", 30000.0, 20, "A soothing concoction that combines the natural sweetness of honey with the mellow tones of tea, resulting in a comforting and mildly sweetened drink that is perfect for relaxation", "file:honey_tea.png");
        Items milkTea = new Items("Milk Tea", 35000.0, 0, "A rich and creamy fusion of tea and milk, offering a harmonious balance of bold tea flavors and the velvety smoothness of milk, creating a comforting and indulgent beverage enjoyed worldwide", "file:honey_tea.png");
        
//        LEMON TEA INIT
        imagelemont = new Image(getClass().getResourceAsStream("/main/lemon_tea.jpg"));
        viewimagelemont = new ImageView(imagelemont);
        viewimagelemont.setImage(imagelemont);
        viewimagelemont.setFitHeight(220);
        viewimagelemont.setFitWidth(220);
        viewimagelemont.setPreserveRatio(true);
 
        Label lemontealbl = new Label("Lemon Tea");
        lemontealbl.setStyle("-fx-font-size: 18px;");
        Label lemonTeaNameLabel = new Label("Item Name");
        TextField lemonTeaNameField = new TextField(lemonTea.getName());
        Label lemonTeaPriceLabel = new Label("Item Price");
        TextField lemonTeaPriceField = new TextField(String.valueOf(lemonTea.getPrice()));
        Label lemonTeaStockLabel = new Label("Item Stock");
        Spinner<Integer> lemonTeaStockSpinner = new Spinner<>(0, 1000, lemonTea.getStock());
        Label lemonTeaDescriptionLabel = new Label("Description");
        TextArea lemonTeaDescriptionArea = new TextArea(lemonTea.getDescription());
        lemonTeaDescriptionArea.setMaxHeight(90);
        lemonTeaDescriptionArea.setWrapText(true);
        Button saveLemonTeaButton = new Button("Save Changes");
        
//        BLACK TEA INIT
        imageblackt = new Image(getClass().getResourceAsStream("/main/black_tea.jpg"));
        viewimageblackt = new ImageView(imageblackt);
        viewimageblackt.setImage(imageblackt);
        viewimageblackt.setFitHeight(220);
        viewimageblackt.setFitWidth(220);
        viewimageblackt.setPreserveRatio(true);
        Label blacktealbl = new Label("Black tea");
        blacktealbl.setStyle("-fx-font-size: 18px;");
        Label blackTeaNameLabel = new Label("Item Name");
        TextField blackTeaNameField = new TextField(blackTea.getName());
        Label blackTeaPriceLabel = new Label("Item Price");
        TextField blackTeaPriceField = new TextField(String.valueOf(blackTea.getPrice()));
        Label blackTeaStockLabel = new Label("Item Stock");
        Spinner<Integer> blackTeaStockSpinner = new Spinner<>(1, 100, blackTea.getStock());
        Label blackTeaDescriptionLabel = new Label("Description");
        TextArea blackTeaDescriptionArea = new TextArea(blackTea.getDescription());
        blackTeaDescriptionArea.setMaxHeight(90);
        blackTeaDescriptionArea.setWrapText(true);
        Button saveBlackTeaButton = new Button("Save Changes");
     
//        APPLE TEA INIT
        imageapplet = new Image(getClass().getResourceAsStream("/main/apple_tea.jpg"));
        viewimageapplet = new ImageView(imageapplet);
        viewimageapplet.setImage(imageapplet);
        viewimageapplet.setFitHeight(220);
        viewimageapplet.setFitWidth(220);
        viewimageapplet.setPreserveRatio(true);
        Label appletealbl = new Label("Apple Tea");
        appletealbl.setStyle("-fx-font-size: 18px;");
        Label appleTeaNameLabel = new Label("Item Name");
        TextField appleTeaNameField = new TextField(appleTea.getName());
        Label appleTeaPriceLabel = new Label("Item Price");
        TextField appleTeaPriceField = new TextField(String.valueOf(appleTea.getPrice()));
        Label appleTeaStockLabel = new Label("Item Stock");
        Spinner<Integer> appleTeaStockSpinner = new Spinner<>(1, 100, appleTea.getStock());
        Label appleTeaDescriptionLabel = new Label("Description");
        TextArea appleTeaDescriptionArea = new TextArea(appleTea.getDescription());
        appleTeaDescriptionArea.setMaxHeight(90);
        appleTeaDescriptionArea.setWrapText(true);
        Button saveAppleTeaButton = new Button("Save Changes");
        
//        HONEY TEA INIT
        imagehoneyt = new Image(getClass().getResourceAsStream("/main/honey_tea.jpg"));
        viewimagehoneyt = new ImageView(imagehoneyt);
        viewimagehoneyt.setImage(imagehoneyt);
        viewimagehoneyt.setFitHeight(220);
        viewimagehoneyt.setFitWidth(220);
        viewimagehoneyt.setPreserveRatio(true);
        Label honeytealbl = new Label("Honey Tea");
        lemontealbl.setStyle("-fx-font-size: 18px;");
        Label honeyTeaNameLabel = new Label("Item Name");
        TextField honeyTeaNameField = new TextField(honeyTea.getName());
        Label honeyTeaPriceLabel = new Label("Item Price");
        TextField honeyTeaPriceField = new TextField(String.valueOf(honeyTea.getPrice()));
        Label honeyTeaStockLabel = new Label("Item Stock");
        Spinner<Integer> honeyTeaStockSpinner = new Spinner<>(1, 100, honeyTea.getStock());
        Label honeyTeaDescriptionLabel = new Label("Description");
        TextArea honeyTeaDescriptionArea = new TextArea(honeyTea.getDescription());
        honeyTeaDescriptionArea.setMaxHeight(90);
        honeyTeaDescriptionArea.setWrapText(true);
        Button saveHoneyTeaButton = new Button("Save Changes");
        
//        MILK TEA INIT
        imagemilkt = new Image(getClass().getResourceAsStream("/main/milk_tea.jpg"));
        viewimagemilkt = new ImageView(imagemilkt);
        viewimagemilkt.setImage(imagemilkt);
        viewimagemilkt.setFitHeight(220);
        viewimagemilkt.setFitWidth(220);
        viewimagemilkt.setPreserveRatio(true);
        Label milktealbl = new Label("Milk Tea");
        milktealbl.setStyle("-fx-font-size: 18px;");
        Label milkTeaNameLabel = new Label("Item Name");
        TextField milkTeaNameField = new TextField(milkTea.getName());
        Label milkTeaPriceLabel = new Label("Item Price");
        TextField milkTeaPriceField = new TextField(String.valueOf(milkTea.getPrice()));
        Label milkTeaStockLabel = new Label("Item Stock");
        Spinner<Integer> milkTeaStockSpinner = new Spinner<>(1, 100, milkTea.getStock());
        Label milkTeaDescriptionLabel = new Label("Description");
        TextArea milkTeaDescriptionArea = new TextArea(milkTea.getDescription());
        milkTeaDescriptionArea.setMaxHeight(90);
        milkTeaDescriptionArea.setWrapText(true);
        Button saveMilkTeaButton = new Button("Save Changes");
        
        
//      ==LAYOUT================================
        vbtitle.getChildren().addAll(titleLabel);
        vblogout.getChildren().addAll(logoutButton);
        
//        LEMON TEA LAYOUT
        vb1.getChildren().addAll(viewimagelemont);
        vb1.setPadding(new Insets(20));
        vb2.setPadding(new Insets(20,0,20,0));
        vb3.getChildren().addAll(lemontealbl);
        vb4.getChildren().addAll(lemonTeaNameLabel, lemonTeaNameField);
        vb5.getChildren().addAll(lemonTeaPriceLabel, lemonTeaPriceField);
        vb6.getChildren().addAll(lemonTeaStockLabel, lemonTeaStockSpinner);
        vb3.setPadding(new Insets(0,0,10,0));
        hblteastat.setPadding(new Insets(0,0,10,0));
        vb4.setPadding(new Insets(0, 10, 0, 0));
        vb5.setPadding(new Insets(0, 10, 0, 0));
        hblteastat.getChildren().addAll(vb4,vb5,vb6);
        vb7.getChildren().addAll(lemonTeaDescriptionLabel, lemonTeaDescriptionArea);
        vb7.setPadding(new Insets(0, 0, 10, 0));
        vb8.getChildren().addAll(saveLemonTeaButton);
        vb8.setAlignment(Pos.CENTER_RIGHT);
        vb2.getChildren().addAll(vb3, hblteastat, vb7, vb8);
        hbltea.getChildren().addAll(vb1,vb2);
        
        grid.add(hbltea, 0,0);
        
//        BLACK TEA LAYOUT
        vb1b.getChildren().addAll(viewimageblackt);
        vb1b.setPadding(new Insets(20));
        vb2b.setPadding(new Insets(20,0,20,0));
        vb3b.getChildren().addAll(blacktealbl);
        vb4b.getChildren().addAll(blackTeaNameLabel, blackTeaNameField);
        vb5b.getChildren().addAll(blackTeaPriceLabel, blackTeaPriceField);
        vb6b.getChildren().addAll(blackTeaStockLabel, blackTeaStockSpinner);
        vb3b.setPadding(new Insets(0,0,10,0));
        hbbteastat.setPadding(new Insets(0,0,10,0));
        vb4b.setPadding(new Insets(0, 10, 0, 0));
        vb5b.setPadding(new Insets(0, 10, 0, 0));
        hbbteastat.getChildren().addAll(vb4b,vb5b,vb6b);
        vb7b.getChildren().addAll(blackTeaDescriptionLabel, blackTeaDescriptionArea);
        vb7b.setPadding(new Insets(0, 0, 10, 0));
        vb8b.getChildren().addAll(saveBlackTeaButton);
        vb8b.setAlignment(Pos.CENTER_RIGHT);
        vb2b.getChildren().addAll(vb3b, hbbteastat, vb7b, vb8b);
        hbbtea.getChildren().addAll(vb1b,vb2b);
        
        grid.add(hbbtea, 0,1);
        
//      APPLE TEA LAYOUT
        vb1a.getChildren().addAll(viewimageapplet);
        vb1a.setPadding(new Insets(20));
        vb2a.setPadding(new Insets(20,0,20,0));
        vb3a.getChildren().addAll(appletealbl);
        vb4a.getChildren().addAll(appleTeaNameLabel, appleTeaNameField);
        vb5a.getChildren().addAll(appleTeaPriceLabel, appleTeaPriceField);
        vb6a.getChildren().addAll(appleTeaStockLabel, appleTeaStockSpinner);
        vb3a.setPadding(new Insets(0,0,10,0));
        hbateastat.setPadding(new Insets(0,0,10,0));
        vb4a.setPadding(new Insets(0, 10, 0, 0));
        vb5a.setPadding(new Insets(0, 10, 0, 0));
        hbateastat.getChildren().addAll(vb4a,vb5a,vb6a);
        vb7a.getChildren().addAll(appleTeaDescriptionLabel, appleTeaDescriptionArea);
        vb7a.setPadding(new Insets(0, 0, 10, 0));
        vb8a.getChildren().addAll(saveAppleTeaButton);
        vb8a.setAlignment(Pos.CENTER_RIGHT);
        vb2a.getChildren().addAll(vb3a, hbateastat, vb7a, vb8a);
        hbatea.getChildren().addAll(vb1a,vb2a);
        
        grid.add(hbatea, 0,2);
        
//      HONEY TEA LAYOUT
        vb1h.getChildren().addAll(viewimagehoneyt);
        vb1h.setPadding(new Insets(20));
        vb2h.setPadding(new Insets(20,0,20,0));
        vb3h.getChildren().addAll(honeytealbl);
        vb4h.getChildren().addAll(honeyTeaNameLabel, honeyTeaNameField);
        vb5h.getChildren().addAll(honeyTeaPriceLabel, honeyTeaPriceField);
        vb6h.getChildren().addAll(honeyTeaStockLabel, honeyTeaStockSpinner);
        vb3h.setPadding(new Insets(0,0,10,0));
        hbhteastat.setPadding(new Insets(0,0,10,0));
        vb4h.setPadding(new Insets(0, 10, 0, 0));
        vb5h.setPadding(new Insets(0, 10, 0, 0));
        hbhteastat.getChildren().addAll(vb4h,vb5h,vb6h);
        vb7h.getChildren().addAll(honeyTeaDescriptionLabel, honeyTeaDescriptionArea);
        vb7h.setPadding(new Insets(0, 0, 10, 0));
        vb8h.getChildren().addAll(saveHoneyTeaButton);
        vb8h.setAlignment(Pos.CENTER_RIGHT);
        vb2h.getChildren().addAll(vb3h, hbhteastat, vb7h, vb8h);
        hbhtea.getChildren().addAll(vb1h,vb2h);
        
        grid.add(hbhtea, 0,3);
       
//      MILK TEA LAYOUT
        vb1m.getChildren().addAll(viewimagemilkt);
        vb1m.setPadding(new Insets(20));
        vb2m.setPadding(new Insets(20,0,20,0));
        vb3m.getChildren().addAll(milktealbl);
        vb4m.getChildren().addAll(milkTeaNameLabel, milkTeaNameField);
        vb5m.getChildren().addAll(milkTeaPriceLabel, milkTeaPriceField);
        vb6m.getChildren().addAll(milkTeaStockLabel, milkTeaStockSpinner);
        vb3m.setPadding(new Insets(0,0,10,0));
        hbmteastat.setPadding(new Insets(0,0,10,0));
        vb4m.setPadding(new Insets(0, 10, 0, 0));
        vb5m.setPadding(new Insets(0, 10, 0, 0));
        hbmteastat.getChildren().addAll(vb4m,vb5m,vb6m);
        vb7m.getChildren().addAll(milkTeaDescriptionLabel, milkTeaDescriptionArea);
        vb7m.setPadding(new Insets(0, 0, 10, 0));
        vb8m.getChildren().addAll(saveMilkTeaButton);
        vb8m.setAlignment(Pos.CENTER_RIGHT);
        vb2m.getChildren().addAll(vb3m, hbmteastat, vb7m, vb8m);
        hbmtea.getChildren().addAll(vb1m,vb2m);
        
        grid.add(hbmtea, 0,4);
        
//		============================
        scrollPane.setContent(grid);
        
        bp.setTop(vbtitle);
        vbtitle.setAlignment(Pos.CENTER);
        vblogout.setAlignment(Pos.BASELINE_RIGHT);
        bp.setCenter(scrollPane);
        bp.setBottom(vblogout);
        bp.setPadding(new Insets(35, 25,25,25));
        
        Scene scene = new Scene(bp, 830, 600);
        stage.setScene(scene);
        stage.show();
        scene.getStylesheets().add("main/style.css");

        saveLemonTeaButton.setOnAction(e -> {
            String name = lemonTeaNameField.getText();
            String price = lemonTeaPriceField.getText();
            int stock = lemonTeaStockSpinner.getValue();
            String description = lemonTeaDescriptionArea.getText();

            if (validateInputs(name, price, stock, description)) {
                lemonTea.setName(name);
                lemonTea.setPrice(Double.parseDouble(price));
                lemonTea.setStock(stock);
                lemonTea.setDescription(description);
                showAlert("Lemon Tea updated successfully");
            }
        });

        saveBlackTeaButton.setOnAction(e -> {
            String name = blackTeaNameField.getText();
            String price = blackTeaPriceField.getText();
            int stock = blackTeaStockSpinner.getValue();
            String description = blackTeaDescriptionArea.getText();

            if (validateInputs(name, price, stock, description)) {
                blackTea.setName(name);
                blackTea.setPrice(Double.parseDouble(price));
                blackTea.setStock(stock);
                blackTea.setDescription(description);
                showAlert("Black Tea updated successfully");
            }
        });
        
        saveAppleTeaButton.setOnAction(e -> {
            String name = appleTeaNameField.getText();
            String price = appleTeaPriceField.getText();
            int stock = appleTeaStockSpinner.getValue();
            String description = appleTeaDescriptionArea.getText();

            if (validateInputs(name, price, stock, description)) {
            	appleTea.setName(name);
            	appleTea.setPrice(Double.parseDouble(price));
            	appleTea.setStock(stock);
            	appleTea.setDescription(description);
                showAlert("Apple Tea updated successfully");
            }
        });
        
        saveHoneyTeaButton.setOnAction(e -> {
            String name = honeyTeaNameField.getText();
            String price = honeyTeaPriceField.getText();
            int stock = honeyTeaStockSpinner.getValue();
            String description = honeyTeaDescriptionArea.getText();

            if (validateInputs(name, price, stock, description)) {
            	honeyTea.setName(name);
            	honeyTea.setPrice(Double.parseDouble(price));
            	honeyTea.setStock(stock);
            	honeyTea.setDescription(description);
                showAlert("Honey Tea updated successfully");
            }
        });
        
        saveMilkTeaButton.setOnAction(e -> {
            String name = milkTeaNameField.getText();
            String price = milkTeaPriceField.getText();
            int stock = milkTeaStockSpinner.getValue();
            String description = milkTeaDescriptionArea.getText();

            if (validateInputs(name, price, stock, description)) {
            	milkTea.setName(name);
            	milkTea.setPrice(Double.parseDouble(price));
            	milkTea.setStock(stock);
            	milkTea.setDescription(description);
                showAlert("Milk Tea updated successfully");
            }
        });

        logoutButton.setOnAction(e -> {
            stage.close();
            new LoginPage(stage);
        });

        viewimagelemont.setOnMouseClicked(e -> {
            new ViewImage(stage);
        });

        viewimageblackt.setOnMouseClicked(e -> {
        	new ViewImageB(stage);
        });
        
        viewimageapplet.setOnMouseClicked(e -> {
        	new ViewImageA(stage);
        });
        
        viewimagemilkt.setOnMouseClicked(e -> {
        	new ViewImageM(stage);
        });
        
        viewimagehoneyt.setOnMouseClicked(e -> {
        	new ViewImageH(stage);
        });
    }

    private boolean validateInputs(String name, String price, int stock, String description) {
        if (name.isEmpty()) {
            showAlert("Item's name must be filled.");
            return false;
        }
        try {
            double priceValue = Double.parseDouble(price);
            if (priceValue < 10000) {
                showAlert("Item's price must be at least 10000.");
                return false;
            }
        } catch (NumberFormatException e) {
            showAlert("Item price must be numeric (float).");
            return false;
        }
        if (stock < 1) {
            showAlert("Item stock must be at least 1.");
            return false;
        }
        if (description.length() < 10) {
            showAlert("Item description must be at least 10 characters.");
            return false;
        }
        return true;
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

