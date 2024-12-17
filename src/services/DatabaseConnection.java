package services; // Cambia esto según el paquete donde está la clase

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/usuarios"; // Cambia por tu base de datos
    private static final String USER = "postgres"; // Usuario de PostgreSQL
    private static final String PASSWORD = "4282"; // Contraseña configurada en PostgreSQL

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

