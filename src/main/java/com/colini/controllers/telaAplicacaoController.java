package com.colini.controllers;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.colini.models.Profile;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class telaAplicacaoController {

    @FXML
    private Button btnTrocar;

    @FXML
    private Button btnTrocar2;

    @FXML
    private ImageView imageImagemPerfil;

    @FXML
    private Label labelLabel1;

    @FXML
    private Label labelLabel2;

    @FXML
    private Pane paneTela;

    // List to store profiles
    private List<Profile> profiles = new ArrayList<>();

    public void initialize() {
        // Create profiles with name, age, and associated image path
        profiles.add(new Profile("Alice", 25, "/images/ducky.png"));
        profiles.add(new Profile("Bob", 30, "/images/doggy.png"));
        profiles.add(new Profile("Carol", 28, "/images/kitty.png"));
        
        Rectangle clip = new Rectangle(426, 256);
        clip.setArcWidth(50);  // Adjust the arc width (corner radius)
        clip.setArcHeight(50); // Adjust the arc height (corner radius)
        

        // Set the clip for the ImageView
        imageImagemPerfil.setClip(clip);


        // Button to show random profile and image
        btnTrocar.setOnAction(e -> showRandomProfile());
        btnTrocar2.setOnAction(e -> showRandomProfile());
    }

    public Profile previousProfile = null;
    // Method to display a random profile and its image
    private void showRandomProfile() {
        Random random = new Random();
        Profile randomProfile = profiles.get(random.nextInt(profiles.size()));
        if (!profiles.isEmpty()) {

            // Get random profile{
            while(true){
                if(previousProfile == null){
                    previousProfile = randomProfile;
                    break;
                }else if(randomProfile != previousProfile){
                    previousProfile = randomProfile;
                    break;
                } else {
                    randomProfile = profiles.get(random.nextInt(profiles.size()));
                    continue;
                }
            } 
            labelLabel1.setText(randomProfile.getName());
            labelLabel2.setText(randomProfile.getAge() + " Anos");
            // Get the image assciated with the profile
            String imagePath = randomProfile.getImagePath();
            InputStream imageStream = getClass().getResourceAsStream(imagePath);

            if (imageStream == null) {
                System.out.println("Error: Image not found at " + imagePath);
            } else {
                Image image = new Image(imageStream);
                imageImagemPerfil.setImage(image);
            }
        }
    }
}
