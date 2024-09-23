package main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import java.util.ArrayList;
import javafx.scene.image.Image;
import java.io.File;
import java.net.MalformedURLException;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import java.io.File;
import menu.Menu;

public class CataloguePage extends Application {
	
	private MediaPlayer mediaPlayer;
    private Media media;
    
    // buat simpan data item di katalog menu dan orderan user
	ArrayList<Menu> menuList = new ArrayList<>();
	ArrayList<Menu> cartList = new ArrayList<>();
    
	@Override
    public void start(Stage primaryStage) {
		playAudio(); // buat start playing audio pas lagi di page ini
		
    	VBox vb = new VBox(10);
    	vb.setPrefWidth(800);
        vb.setAlignment(Pos.CENTER);
        vb.setPadding(new Insets(10));

        // set page title
        Label titleLbl = new Label("Enjoy our tea");
        titleLbl.setPrefWidth(800);
        titleLbl.setAlignment(Pos.CENTER);
        titleLbl.setStyle("-fx-font-size: 24px;");

        vb.getChildren().add(titleLbl);

        // init data yang dimasukin ke katalog menu
        menuList.add(new Menu("Lemon Tea", "Assets/lemon_tea.jpg", 20000, 10, "A refreshing infusion of black tea subtly brightened by the zesty essence of fresh lemons, offering a tangy and invigorating flavor profile."));
        menuList.add(new Menu("Black Tea", "Assets/black_tea.jpg", 10000, 20, "A robust and full-bodied brew, characterized by its deep, malty notes and a bold, satisfying taste that makes it a classic choice for tea enthusiasts."));
        menuList.add(new Menu("Apple Tea", "Assets/apple_tea.jpg", 25000, 20, "A delightful infusion blending the sweetness of ripe apples with the comforting warmth of tea, creating a fruity and aromatic beverage that evokes the essence of a crisp autumn day."));
        menuList.add(new Menu("Honey Tea", "Assets/honey_tea.jpg", 30000, 20, "A soothing concoction that combines the natural sweetness of honey with the mellow tones of tea, resulting in a comforting and mildly sweetened drink that is perfect for relaxation."));
        menuList.add(new Menu("Milk Tea", "Assets/milk_tea.jpg", 35000, 0, "A rich and creamy fusion of tea and milk, offering a harmonious balance of bold tea flavors and the velvety smoothness of milk, creating a comforting and indulgent beverage enjoyed worldwide."));
        
        GridPane gp = new GridPane();
        gp.setHgap(10); 
        gp.setVgap(10);
        gp.setPrefWidth(550);
        gp.setPrefHeight(500);
        gp.setStyle("-fx-padding: 10;");

        for (int i = 0; i < menuList.size(); i++) {
            VBox card = catalogItem(menuList.get(i), i);
            gp.add(card, i % 2, i / 2); // kolom untuk katalog menu
        }
        
        // scrollpane untuk katalog menu
        ScrollPane gridScrollPane = new ScrollPane(gp);
        gridScrollPane.setFitToWidth(true);

        // sidebox untuk nampung cartbox
        VBox sideBox = new VBox(10);
        sideBox.setPadding(new Insets(10));
        sideBox.setStyle("-fx-border-color: gray; -fx-padding:10;");
        sideBox.setPrefWidth(200);
        sideBox.setPrefHeight(500);
        
        // cartbox fungsinya gantiin List untuk nampung orderan yang di drag and drop
        VBox cartBox = new VBox(10);
        cartBox.setStyle("-fx-border-color: gray; -fx-padding:10;");

        // set label cartbox
        Label cartLbl = new Label("Your Cart");
        cartLbl.setPrefWidth(150);
        cartLbl.setStyle("-fx-font-size: 18px;");
        
        // drag and drop function
        cartBox.setOnDragOver(event -> {
            if (event.getGestureSource() != sideBox && event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });

        cartBox.setOnDragDropped(event -> {
            Dragboard db = event.getDragboard();
            boolean success = false;
            if (db.hasString()) {
                int index = Integer.parseInt(db.getString());
                Menu draggedMenu = menuList.get(index);
                if (draggedMenu.getStock() > 0) {
                    cartList.add(draggedMenu);
                    draggedMenu.setStock(draggedMenu.getStock() - 1); 
                    updatesideBox(cartBox);
                    updateGridPane(gp);
                    success = true;
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning");
                    alert.setHeaderText(null);
                    alert.setContentText("Sorry, this item is out of stock!");
                    alert.showAndWait();
                }
            }
            event.setDropCompleted(success);
            event.consume();
        });
        
        // purchase button, klik = order sukses -> cartbox kosong
        Button purchaseBtn = new Button("Purchase");
        purchaseBtn.setStyle("-fx-background-color: turquoise; -fx-text-fill: white;");
        purchaseBtn.setOnAction(e -> {
            sideBox.getChildren().clear();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Purchase Successful");
            alert.setHeaderText(null);
            alert.setContentText("Your purchase has been successful. Please re-login to place new order.");
            alert.showAndWait();
        });
        
        // scrollpane buat cartbox
        ScrollPane sideGridScrollPane = new ScrollPane(cartBox);
        sideGridScrollPane.setFitToWidth(true);
        
        sideBox.getChildren().addAll(cartLbl, sideGridScrollPane, purchaseBtn);
        
        HBox hb = new HBox(10);
        hb.setPadding(new Insets(10));
        hb.getChildren().addAll(gridScrollPane, sideBox);

        // logout button, klik = go to loginPage
        Button logoutBtn = new Button("Logout");
        logoutBtn.setStyle("-fx-background-color: turquoise; -fx-text-fill: white;");
        logoutBtn.setOnAction(e -> {
        	new LoginPage(primaryStage);
        	mediaPlayer.stop();
        });

        VBox logoutBtnBox = new VBox();
        logoutBtnBox.getChildren().add(logoutBtn);
        logoutBtnBox.setAlignment(Pos.BOTTOM_RIGHT);
        logoutBtnBox.setPadding(new Insets(10));
        
        vb.getChildren().addAll(hb, logoutBtnBox);
        
        Scene scene = new Scene(vb, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Catalogue and Cart Window");
        primaryStage.show();
    }

	// box untuk 1 item yang ada di katalog menu
    private VBox catalogItem(Menu menu, int index) {
    	VBox vb2 = new VBox(5);
    	vb2.setPrefWidth(300);
        vb2.setStyle("-fx-border-color: gray; -fx-padding: 10;");

        // imageview -> display image dari item yang ada di katalog menu
        String imagePath = menu.getLinkToImageFile();
        File imageFile = new File(imagePath);
        
        Image image = null;
        
        try {
            image = new Image(imageFile.toURI().toURL().toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(225);
        imageView.setFitHeight(200);

        // text -> display informasi nama, harga,  stok dan deskripsi dari item yang ada di katalog menu
        Text menuNameText = new Text(menu.getName());
        menuNameText.setStyle("-fx-font-size: 14px;");

        Text priceText = new Text("Price: " + menu.getPrice());
        priceText.setStyle("-fx-font-size: 12px;");
        	
        Text stockText = new Text("Stock: " + menu.getStock());
        stockText.setStyle("-fx-font-size: 12px;");

        Text descriptionText = new Text(menu.getDescription());
        descriptionText.setStyle("-fx-font-size: 12px; -fx-text-alignment: justify;");
        descriptionText.wrappingWidthProperty().set(225); 

        vb2.getChildren().addAll(imageView, menuNameText, priceText, stockText, descriptionText);
        
        vb2.setOnDragDetected(event -> {
            Dragboard db = vb2.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putString(String.valueOf(index)); 
            db.setContent(content);
            event.consume();
        });
        
        return vb2;
    }
    
    // box untuk setiap 1 item dari katalog menu yang di drop ke cartbox
    private HBox cartItem(Menu menu) {
    	HBox hb2 = new HBox(10);
        hb2.setStyle("-fx-border-color: gray; -fx-padding: 10;");

        // display image dari 1 item yang di drop ke cartbox
        String imagePath = menu.getLinkToImageFile();
        File imageFile = new File(imagePath);
        
        Image image = null;
        
        try {
            image = new Image(imageFile.toURI().toURL().toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        imageView.setPreserveRatio(true);

        // display info nama, harga dari 1 item yang di drop ke cartbox
        VBox vbText = new VBox(5);

        Text menuNameText = new Text(menu.getName());
        menuNameText.setStyle("-fx-font-size: 14px;");

        Text priceText = new Text("Price: " + menu.getPrice());
        priceText.setStyle("-fx-font-size: 12px;");

        vbText.getChildren().addAll(menuNameText, priceText);
        hb2.getChildren().addAll(imageView, vbText);
        return hb2;
    }
    
    private void updatesideBox(VBox sideBox) {
        sideBox.getChildren().clear();
        for (Menu menu : cartList) {
            HBox card = cartItem(menu);
            sideBox.getChildren().add(card);
        }
    }

    private void updateGridPane(GridPane gridPane) {
        gridPane.getChildren().clear();
        for (int i = 0; i < menuList.size(); i++) {
            VBox card = catalogItem(menuList.get(i), i);
            int finalI = i;
            
            card.setOnDragDetected(event -> {
                Dragboard db = card.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                content.putString(String.valueOf(finalI));
                db.setContent(content);
                event.consume();
            });

            gridPane.add(card, i % 2, i / 2);
        }
    }

    // audio
    private void playAudio() {
    	String audioFilePath = "Assets/piano.mp3";
        Media media = new Media(new File(audioFilePath).toURI().toString());

        mediaPlayer = new MediaPlayer(media);

        mediaPlayer.play();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
