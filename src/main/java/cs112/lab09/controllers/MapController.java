package cs112.lab09.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.stage.Modality;
import javafx.scene.Parent;

import java.io.IOException;

public class MapController {

    @FXML
    private void onBisbeeEventClick(ActionEvent event) throws IOException {
        openEventWindow("Bisbee, Arizona", "July 1919",
                "Event description here",
                "Revised description here",
                "bisbee.png",  // Image for Bisbee
                "https://source-url.com");
    }

    @FXML
    private void onSanFranciscoEventClick(ActionEvent event) throws IOException {
        openEventWindow("San Francisco, CA", "May 15, 1919",
                "The following 'history' was told for many years...",
                "By correcting history, not just rewriting it...",
                "sanfrancisco.jpg",  // Image for San Francisco
                "https://source-url.com");
    }

    @FXML
    private ImageView mapImageView;

    @FXML
    public void initialize() {
          mapImageView.setImage(new Image(getClass().getResourceAsStream("/images/Red-Summer.jpg")));
    }

    private void openEventWindow(String location, String date, String description, String revisedDescription, String imageUrl, String citationUrl) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/cs112/lab09/event-view.fxml"));
        Parent root = loader.load();

        EventController controller = loader.getController();
        controller.initData(location, date, description, revisedDescription, imageUrl, citationUrl);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Event Details");
        stage.show();
    }
}
