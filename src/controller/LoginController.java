package controller;

import services.AuthService;


public class LoginController {

    private AuthService authService;

    public LoginController() {
        // Instancia del servicio de autenticación
        this.authService = new AuthService();
    }

    public boolean handleLogin(String usuario, String contrasena) {
        // Delegar la validación al servicio de autenticación
        boolean autenticado = authService.authenticate(usuario, contrasena);

        if (autenticado) {
            System.out.println("¡Login exitoso! Bienvenido, " + usuario);
        } else {
            System.out.println("Usuario o contraseña incorrectos.");
        }

        // Devolver el resultado de la autenticación
        return autenticado;
    }
}

