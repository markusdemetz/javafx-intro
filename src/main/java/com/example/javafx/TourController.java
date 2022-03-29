package com.example.javafx;


import com.example.javafx.business.MyTourManager;
import com.example.javafx.business.TourManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TourController implements Initializable {

    @FXML
    private TextField listField;

    @FXML
    private Button addButton;

    @FXML
    private ListView listView;

    @FXML
    private TableView<TourTableRow> tableView;

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

    private TourVM tourVM;

    public TourController() {
        TourManager manager = new MyTourManager();
        this.tourVM = new TourVM(manager);
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

        listView.setItems(tourVM.getListItems());
        listView.setOnMouseClicked(e -> {
           listView.getSelectionModel().getSelectedItems().forEach(i -> {
               System.out.println(i);
           });
        });

        addButton.setOnMouseClicked(e -> {
            tourVM.add(listField.textProperty().get());
        });

        tableView.setPlaceholder(new Label("No Tours available!"));
        tableView.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tableView.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tableView.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("description"));

        tableView.setItems(tourVM.getTableRows());
    }
}