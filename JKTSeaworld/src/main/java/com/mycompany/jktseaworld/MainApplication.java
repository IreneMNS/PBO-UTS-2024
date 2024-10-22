/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jktseaworld;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author NITRO V15
 */
public class MainApplication extends Application {

    private User loggedInUser;

    @Override
    public void start(Stage primaryStage) {
        // Menampilkan form login pertama kali
        showLoginForm(primaryStage);
    }

    // Form Login
    private void showLoginForm(Stage stage) {
        stage.setTitle("Login Seaworld Jakarta");

        // Membuat label dan input text untuk username dan password
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginButton = new Button("Login");

        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            
            // Untuk contoh, kita hardcode admin user (user nyata bisa dari database)
            Admin admin = new Admin("admin", "admin123");

            if (admin.login(username, password)) {
                loggedInUser = admin; // Menyimpan user yang berhasil login
                showMainMenu(stage);  // Pindah ke menu utama setelah login berhasil
            } else {
                // Pesan jika login gagal
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Username atau Password salah!");
                alert.showAndWait();
            }
        });

        // Layout untuk login form
        GridPane grid = new GridPane();
        grid.add(usernameField, 0, 0);
        grid.add(passwordField, 0, 1);
        grid.add(loginButton, 0, 2);

        Scene scene = new Scene(grid, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

    // Menu utama setelah login (pilih input data atau lihat data)
    private void showMainMenu(Stage stage) {
        stage.setTitle("Menu Utama");

        Button inputDataButton = new Button("Input Data Pengunjung");
        Button viewDataButton = new Button("Lihat Data Pengunjung");

        inputDataButton.setOnAction(e -> showInputDataForm(stage));
        viewDataButton.setOnAction(e -> showViewDataForm(stage));

        // Layout untuk menu utama
        GridPane grid = new GridPane();
        grid.add(inputDataButton, 0, 0);
        grid.add(viewDataButton, 0, 1);

        Scene scene = new Scene(grid, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

    // Menampilkan Form Input Data
    private void showInputDataForm(Stage stage) {
        InputDataForm inputDataForm = new InputDataForm();
        inputDataForm.start(stage);  // Panggil form input data
    }

    // Menampilkan Form Lihat Data
    private void showViewDataForm(Stage stage) {
        ViewDataForm viewDataForm = new ViewDataForm();
        viewDataForm.start(stage);  // Panggil form lihat data
    }

    public static void main(String[] args) {
        launch(args);
    }
}