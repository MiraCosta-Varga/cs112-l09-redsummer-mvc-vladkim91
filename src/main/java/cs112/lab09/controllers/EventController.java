package cs112.lab09.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class EventController {

    @FXML
    private Label locationLabel;
    @FXML
    private Label descriptionLabel;
    @FXML
    private Label dateLabel;
    @FXML
    private Label revisedDescriptionLabel;
    @FXML
    private ImageView eventImageView;

    private String citationUrl;

    public void initData(String location, String date, String description, String revisedDescription, String imageUrl, String citationUrl) {
        locationLabel.setText(location);
        dateLabel.setText(date);
        descriptionLabel.setText(description);
        revisedDescriptionLabel.setText(revisedDescription);

        if (imageUrl != null) {
            try {
                eventImageView.setImage(new Image(getClass().getResourceAsStream("/images/" + imageUrl)));
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error loading image: " + imageUrl);
            }
        }

        this.citationUrl = citationUrl;
    }

    @FXML
    private void onCitationLinkClick() {
        try {
            URI uri = new URI("https://www.example.com"); // Test with a real URL
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(uri);
            } else {
                System.out.println("Desktop browsing is not supported on this platform.");
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            System.out.println("Failed to open the link.");
        }
    }

    @FXML
    private void onCloseButtonClick(ActionEvent event) {
        Stage stage = (Stage) locationLabel.getScene().getWindow();
        stage.close();
    }
}
