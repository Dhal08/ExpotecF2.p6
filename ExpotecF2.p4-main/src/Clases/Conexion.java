package Clases;

import java.sql.*;

public class Conexion {

    Connection cn;
    PreparedStatement ps;
    ResultSet rs;

    public Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Qode_db", "root", "admin");
            System.out.println("Conectado DB");
        } catch (Exception e) {
            System.out.println("Error al cargar el driver: " + e.getMessage());
        }
    }

public int usuarios(String nombre, String email, String password_hash) {
    int res = 0;
    String sql = "INSERT INTO usuarios(nombre, email, password_hash) VALUES(?, ?, ?)";

    try (PreparedStatement ps = cn.prepareStatement(sql)) {
        ps.setString(1, nombre);
        ps.setString(2, email);
        ps.setString(3, password_hash);

        res = ps.executeUpdate();
        System.out.println("Usuario registrado correctamente");
    } catch (Exception e) {
        // CAMBIO AQUÍ: Muestra el error exacto en una ventana flotante
        javax.swing.JOptionPane.showMessageDialog(null, 
            "Error crítico en la base de datos:\n" + e.getMessage(), 
            "Error de SQL", javax.swing.JOptionPane.ERROR_MESSAGE);
        System.out.println("Error al registrar: " + e.getMessage());
    }
    return res;
}

    public boolean loginUsuario(String email, String password_hash) {
        boolean loginExitoso = false;
        String sql = "SELECT id_usuario FROM usuarios WHERE email = ? AND password_hash = ?";

        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password_hash);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    loginExitoso = true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al iniciar sesión: " + e.getMessage());
        }
        return loginExitoso;
    }

    public String obtenerRolUsuario(String email, String password_hash) {
    String rolEncontrado = ""; 
    String sql = "SELECT rol FROM usuarios WHERE email = ? AND password_hash = ? AND estado = 'activo'";
    
    try (PreparedStatement ps = cn.prepareStatement(sql)) {
        ps.setString(1, email);
        ps.setString(2, password_hash);
        
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                rolEncontrado = rs.getString("rol"); 
            }
        }
    } catch (Exception e) {
        System.out.println("Error al validar rol en el inicio de sesión: " + e.getMessage());
    }
    return rolEncontrado; 
}
    
    public Connection getConnection() {
        try {
            // 
            if (cn == null || cn.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Qode_db", "root", "admin");
            }
        } catch (Exception e) {
            System.out.println("Error al recuperar la conexión activa: " + e.getMessage());
        }
        return cn;
    }
}


