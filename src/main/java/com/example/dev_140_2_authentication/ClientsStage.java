package com.example.dev_140_2_authentication;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientsStage {
    public ClientsStage() {
    }

    public void show() throws SQLException, IOException {
        Stage stage = new Stage();
        VBox root = new VBox();
        root.getChildren().addAll(this.tableView());
        Scene scene = new Scene(root, 960.0, 720.0);
        stage.setTitle("Клиенты");
        stage.setScene(scene);
        stage.show();
    }

    private TableView<PersonDto> tableView() throws SQLException, IOException {
        TableView<PersonDto> tableView = new TableView<>();
        TableColumn<PersonDto, Integer> idCol = new TableColumn<>("Id");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<PersonDto, String> jobCol = new TableColumn<>("Jobtitle");
        jobCol.setCellValueFactory(new PropertyValueFactory<>("jobtitle"));
        TableColumn<PersonDto, String> fioCol = new TableColumn<>("Firstnamelastname");
        fioCol.setCellValueFactory(new PropertyValueFactory<>("firstnamelastname"));
        TableColumn<PersonDto, String> phoneCol = new TableColumn<>("Phone");
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        TableColumn<PersonDto, String> emailCol = new TableColumn<>("Email");
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        TableColumn<PersonDto, String> countCol = new TableColumn<>("Count domains");
        countCol.setCellValueFactory(new PropertyValueFactory<>("count"));
        tableView.getColumns().addAll(new TableColumn[]{idCol, jobCol, fioCol, phoneCol, emailCol, countCol});
        tableView.setOnMouseClicked((mouseEvent) -> {
            int count = mouseEvent.getClickCount();
            if (count == 2 && mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                PersonDto personDto = (PersonDto) tableView.getSelectionModel().getSelectedItem();
                try {
                    new ClientsDomainsStage(personDto).show();
                } catch (SQLException | IOException e) {
                    throw new RuntimeException(e);
                }
            }

        });
        tableView.setOnKeyPressed((keyEvent) -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                PersonDto personDto = (PersonDto) tableView.getSelectionModel().getSelectedItem();
                try {
                    new ClientsDomainsStage(personDto).show();
                } catch (SQLException | IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        tableView.setItems(FXCollections.observableList(new ArrayList<>(new Repository().findAllPersonsDto())));
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setMaxWidth(Double.MAX_VALUE);
        tableView.setMaxHeight(Double.MAX_VALUE);
        VBox.setVgrow(tableView, Priority.ALWAYS);
        return tableView;
    }

}
