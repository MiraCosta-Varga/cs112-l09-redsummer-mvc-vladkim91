package cs112.lab09.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import java.io.IOException;
import javafx.scene.image.Image;

public class MainController {

    @FXML
    private ImageView mainImageView;

    @FXML
    private void initialize() {
        // Load the main image
        mainImageView.setImage(new Image(getClass().getResourceAsStream("/images/Red-Summer.jpg")));
    }

    @FXML
    private void onStartButtonClick(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/cs112/lab09/map-view.fxml"));
        Scene mapScene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(mapScene);
        stage.setTitle("Map of Red Summer Events");
    }

    @FXML
    private void onQuitButtonClick() {
        Platform.exit();
    }

}