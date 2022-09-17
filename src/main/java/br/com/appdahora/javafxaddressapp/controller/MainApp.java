package br.com.appdahora.javafxaddressapp.controller;
import java.io.IOException;

import br.com.appdahora.javafxaddressapp.model.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class MainApp extends Application {
    private ObservableList<Person> personData = FXCollections.observableArrayList();
    public MainApp() {
// Insira dados de exemplo
        personData.add(new Person("Maia", "Nogueira"));
        personData.add(new Person("Antonio", "Silva"));
        personData.add(new Person("Francisco", "Pereira"));
    }

    public ObservableList<Person> getPersonData() {
        return personData;
    }
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("view/PersonOverview.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Address App!");
        stage.setScene(scene);
        stage.show();
    }
}
