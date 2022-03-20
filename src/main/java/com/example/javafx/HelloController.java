package com.example.javafx;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TextField listField;

    @FXML
    private Button addButton;

    @FXML
    private ListView listView;

    @FXML
    private ImageView imageView;

    @FXML
    private MenuItem menuClose;

    @FXML
    private MenuItem menuPdf;

    @FXML
    private MenuItem menuFile;

    @FXML
    private MenuItem menuAbout;

    @FXML
    private BorderPane borderPane;

    private ObservableList<String> listItems;

    public HelloController() {
    }

    @FXML
    public void onMenuClicked(ActionEvent e) throws IOException {

        if (e.getSource() == menuClose) {
           // ((Stage) borderPane.getScene().getWindow()).close();
        }

        if (e.getSource() == menuPdf) {
            System.out.println("Export to PDF File!");
        }

        if (e.getSource() == menuFile) {
            System.out.println("Export to File!");
        }

        if (e.getSource() == menuAbout) {
            System.out.println("Show About!");
            Stage stage = new Stage();
            stage.setTitle("About");
            stage.initOwner(borderPane.getScene().getWindow());
            stage.initModality(Modality.WINDOW_MODAL);

            stage.setScene(new Scene(new AboutDialog()));

            stage.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Initialize HelloController!");
        menuClose.setOnAction(e -> {
            System.out.println("Closing by setOnAction.");
            ((Stage)borderPane.getScene().getWindow()).close();;
        });

        listItems = FXCollections.observableArrayList("Item 1", "Item 2", "Item 3");
        listView.setItems(listItems);


        listView.setOnMouseClicked(e -> {
           listView.getSelectionModel().getSelectedItems().forEach(i -> {
               System.out.println(i);
           });
        });

        addButton.setOnMouseClicked(e -> {
            listItems.add(listField.textProperty().get());
        });


    }
}