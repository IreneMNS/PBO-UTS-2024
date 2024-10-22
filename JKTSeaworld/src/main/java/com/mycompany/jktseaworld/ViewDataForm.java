/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jktseaworld;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author NITRO V15
 */
public class ViewDataForm extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Data Pengunjung Seaworld");

        // Membuat TableView
        TableView<Visitor> table = new TableView<>();

        TableColumn<Visitor, String> nameColumn = new TableColumn<>("Nama");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));

        TableColumn<Visitor, Integer> ageColumn = new TableColumn<>("Usia");
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        table.getColumns().addAll(nameColumn, ageColumn);

        // Data Dummy
        ObservableList<Visitor> visitorData = FXCollections.observableArrayList(
            new Visitor("John Doe", "1234"),
            new Visitor("Jane Smith", "abcd")
        );
        
        table.setItems(visitorData);

        VBox vbox = new VBox(table);
        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
