package com.mycompany.jktseaworld;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class LoginForm extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login Seaworld Jakarta");

        // Membuat Label dan TextField
        Label userLabel = new Label("Username:");
        TextField userTextField = new TextField();

        Label passLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        // Tombol Login
        Button loginButton = new Button("Login");

        loginButton.setOnAction(e -> {
            String username = userTextField.getText();
            String password = passwordField.getText();
            
            User user = new Admin("admin", "admin123"); // contoh user admin
            if (user.login(username, password)) {
                System.out.println("Login berhasil!");
                // Lanjut ke form berikutnya
            } else {
                System.out.println("Login gagal!");
            }
        });

        // Layout
        GridPane grid = new GridPane();
        grid.add(userLabel, 0, 0);
        grid.add(userTextField, 1, 0);
        grid.add(passLabel, 0, 1);
        grid.add(passwordField, 1, 1);
        grid.add(loginButton, 1, 2);

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}