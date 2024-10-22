/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jktseaworld;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author NITRO V15
 */
public class InputDataForm extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Form Input Data Pengunjung");

        // Membuat Label dan Inputan
        Label nameLabel = new Label("Nama:");
        TextField nameField = new TextField();

        Label ageLabel = new Label("Usia:");
        TextField ageField = new TextField();

        Label genderLabel = new Label("Jenis Kelamin:");
        ToggleGroup genderGroup = new ToggleGroup();
        RadioButton maleRadio = new RadioButton("Laki-laki");
        maleRadio.setToggleGroup(genderGroup);
        RadioButton femaleRadio = new RadioButton("Perempuan");
        femaleRadio.setToggleGroup(genderGroup);

        Label ticketLabel = new Label("Tiket:");
        ComboBox<String> ticketCombo = new ComboBox<>();
        ticketCombo.getItems().addAll("Reguler", "VIP", "Anak-anak");

        CheckBox agreeBox = new CheckBox("Saya setuju dengan syarat dan ketentuan.");

        Button submitButton = new Button("Submit");

        // Layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(8);
        grid.setHgap(10);
        grid.add(nameLabel, 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(ageLabel, 0, 1);
        grid.add(ageField, 1, 1);
        grid.add(genderLabel, 0, 2);
        grid.add(maleRadio, 1, 2);
        grid.add(femaleRadio, 2, 2);
        grid.add(ticketLabel, 0, 3);
        grid.add(ticketCombo, 1, 3);
        grid.add(agreeBox, 1, 4);
        grid.add(submitButton, 1, 5);

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
