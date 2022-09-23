package br.com.appdahora.javafxaddressapp.controller;
import java.io.IOException;

import br.com.appdahora.javafxaddressapp.model.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class MainApp extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Person> personData = FXCollections.observableArrayList();
    public MainApp() {
// Insira dados de exemplo
        personData.add(new Person("Maia", "Nogueira"));
        personData.add(new Person("Antonio", "Silva"));
        personData.add(new Person("Francisco", "Pereira"));
    }

    public void showPersonOverview() {
        try {
            // Carrega a person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp
                    .class.getResource("view/PersonOverview.fxml"));
            AnchorPane personOverview=(AnchorPane) loader.load();
            // Define a person overview no centro do root layout.
            rootLayout.setCenter(personOverview);
            // Dá ao controlador acesso à the main app.
            PersonOverviewController controller
                    = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Person> getPersonData() {

        return personData;
    }
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");

        initRootLayout();

        showPersonOverview();
    }

    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Stage getPrimaryStage() {
        return primaryStage;
    }

}
