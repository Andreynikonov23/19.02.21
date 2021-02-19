package ru.sapteh.controller;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.*;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.dao.DAO;
import ru.sapteh.model.Computer;
import ru.sapteh.services.ComputerServ;

public class Controller {
    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    DAO<Computer, Integer> dao = new ComputerServ(factory);
    ObservableList<Computer> list = FXCollections.observableArrayList();
    Computer computer = new Computer();
    @FXML
    private TableColumn<Computer, Integer> columnId;

    @FXML
    private TableColumn<Computer, String> columnProcessor;

    @FXML
    private TableColumn<Computer, String> columnVideoCard;

    @FXML
    private TableColumn<Computer, String> columnRam;

    @FXML
    private TableColumn<Computer, String> columnHdd;

    @FXML
    private TableColumn<Computer, String> columnPowerSupply;

    @FXML
    private Button buttonNew;

    @FXML
    private Button buttonEdit;

    @FXML
    private Button buttonDelete;

    @FXML
    private TextField textFieldProcessor;

    @FXML
    private TextField textFieldVideoCard;

    @FXML
    private TextField textFieldRam;

    @FXML
    private TextField textFieldHdd;

    @FXML
    private TextField textFieldPowerSupply;

    @FXML
    private TableView<Computer> tableView;

    @FXML
    public void initialize() {
        List<Computer> computerList = dao.findByAll();
        list.addAll(computerList);
        computer.setProcessor(String.valueOf(textFieldProcessor));
        Set<Computer> computers = new HashSet<>();
        computers.add(computer);

        //Вывод данных из базы данных
        columnId.setCellValueFactory(computerIntegerCellDataFeatures ->
                new SimpleObjectProperty<>(computerIntegerCellDataFeatures.getValue().getId()));
        columnProcessor.setCellValueFactory(computerStringCellDataFeatures ->
                new SimpleObjectProperty<>(computerStringCellDataFeatures.getValue().getProcessor()));
        columnVideoCard.setCellValueFactory(computerStringCellDataFeatures ->
                new SimpleObjectProperty<>(computerStringCellDataFeatures.getValue().getVideoCard()));
        columnRam.setCellValueFactory(computerStringCellDataFeatures ->
                new SimpleObjectProperty<>(computerStringCellDataFeatures.getValue().getRam()));
        columnHdd.setCellValueFactory(computerStringCellDataFeatures ->
                new SimpleObjectProperty<>(computerStringCellDataFeatures.getValue().getHdd()));
        columnPowerSupply.setCellValueFactory(computerStringCellDataFeatures ->
                new SimpleObjectProperty<>(computerStringCellDataFeatures.getValue().getPowerSupply()));
        tableView.setItems(list);

        buttonNew.setOnAction(event ->
                dao.create(computer));

        //Добавление данных в базу данных
    }
    }

