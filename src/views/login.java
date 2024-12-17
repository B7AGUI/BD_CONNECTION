package views;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import controller.LoginController;

public class login extends Application { // Cambié Aplication a Application

    @Override
    public void start(Stage primaryStage) {

        // Crear titulo
        Label titulo = new Label("Login");
        titulo.setAlignment(Pos.CENTER);
        titulo.setFont(Font.font("Arial",27));
        // Layout necesario
        GridPane layout = new GridPane();
        //espacing
        layout.setHgap(10);
        layout.setVgap(20);
        layout.setPadding(new Insets(20, 20, 20, 20)); // Ajustar el espacio entre los elementos del layout
        layout.add(titulo,0,0,2,1); // Añadir título en la primera fila, segunda columna, 2 columnas y 1 fila
        
        

        // Crear controles
        TextField txtUsuario = new TextField();
        layout.add(new Label("Usuario"),0,1);
        layout.add(txtUsuario,1,1);
        PasswordField txtContrasena = new PasswordField();
        layout.add(new Label("Contraseña"),0,2);
        layout.add(txtContrasena,1,2);

        Button iniciar = new Button("iniciar sesion");
        layout.add(iniciar, 0, 4);
        //centrar grid en vbox
        VBox root = new VBox();
        root.setAlignment(Pos.TOP_LEFT); // Ajustar la raíz al inicio superior izquierdo
        root.setPadding(new Insets(100, 0, 0, 200)); // Ajustar el desplazamiento
        root.getChildren().addAll(layout);

        // Evento para el botón iniciar
        LoginController loginController = new LoginController();
        iniciar.setOnAction(e -> {
            String usuario = txtUsuario.getText();
            String contrasena = txtContrasena.getText();

            // Delegar al controlador y obtener resultado
            boolean autenticado = loginController.handleLogin(usuario, contrasena);

            // Mostrar mensaje al usuario
            if (autenticado) {
                showAlert(Alert.AlertType.INFORMATION, "Login exitoso", "Bienvenido, " + usuario + "!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Usuario o contraseña incorrectos.");
            }
        });

        // Configurar y mostrar la ventana
        Scene scene = new Scene(root,800,600);
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        
        
        primaryStage.show();
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
