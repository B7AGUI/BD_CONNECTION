package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthService {

    public boolean authenticate(String username, String password) {
        String query = "SELECT * FROM usuarios WHERE username = ? AND password = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Configura los parámetros de la consulta
            statement.setString(1, username);
            statement.setString(2, password);

            // Ejecuta la consulta
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next(); // Si hay resultados, retorna true
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // Si ocurre un error o no hay coincidencias
    }
}
