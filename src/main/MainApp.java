package main;

import javafx.application.Application;
import javafx.stage.Stage;
import views.login;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        new login().start(primaryStage); // Llama a la ventana de login
    }

    public static void main(String[] args) {
        launch(args);
    }
}
