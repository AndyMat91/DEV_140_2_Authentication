package com.example.dev_140_2_authentication;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class ClientsDomainsStage {
    private PersonDto personDto;

    public ClientsDomainsStage(PersonDto personDto) {
        this.personDto = personDto;
    }

    public PersonDto getPersonDto() {
        return personDto;
    }

    public void setPersonDto(PersonDto personDto) {
        this.personDto = personDto;
    }

    public void show() throws SQLException, IOException {
        Stage stage = new Stage();
        VBox root = new VBox();
        root.getChildren().addAll(this.tableView());
        Scene scene = new Scene(root, 960.0, 720.0);
        stage.setTitle("Домены клиента");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    private TableView<Domain> tableView() throws SQLException, IOException {
        TableView<Domain> tableView = new TableView<>();
        TableColumn<Domain, Integer> idCol = new TableColumn<>("Id");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Domain, String> webCol = new TableColumn<>("Webname");
        webCol.setCellValueFactory(new PropertyValueFactory<>("webname"));
        TableColumn<Domain, String> domCol = new TableColumn<>("Domainname");
        domCol.setCellValueFactory(new PropertyValueFactory<>("domainname"));
        TableColumn<Domain, String> ipCol = new TableColumn<>("Ip");
        ipCol.setCellValueFactory(new PropertyValueFactory<>("ip"));
        TableColumn<Domain, Date> dateCol = new TableColumn<>("Datereg");
        dateCol.setCellValueFactory(new PropertyValueFactory<>("datereg"));
        TableColumn<Domain, String> countryCol = new TableColumn<>("Countryreg");
        countryCol.setCellValueFactory(new PropertyValueFactory<>("countryreg"));
        TableColumn<Domain, Integer> personIdCol = new TableColumn<>("Person Id");
        personIdCol.setCellValueFactory(new PropertyValueFactory<>("personid"));
        tableView.getColumns().addAll(new TableColumn[]{idCol, webCol, domCol, ipCol, dateCol, countryCol, personIdCol});
        tableView.setItems(FXCollections.observableList(new ArrayList<>(new Repository().findAllClientsDomains(personDto.getId()))));
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setMaxWidth(Double.MAX_VALUE);
        tableView.setMaxHeight(Double.MAX_VALUE);
        VBox.setVgrow(tableView, Priority.ALWAYS);
        return tableView;
    }
}
