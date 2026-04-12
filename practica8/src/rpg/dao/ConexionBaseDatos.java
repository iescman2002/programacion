package rpg.dao;

import java.sql.*;

public class ConexionBaseDatos {
    private String url; // La url de la base de datos
    private String user; // El usuario con el que se accede a la base de datos
    private String passwd; // La contraseña del usuario

    Connection connection;
    Statement statement;
    ResultSet resultSet;

    public ConexionBaseDatos() {
        this.url = "jdbc:postgresql://localhost:5432/XRPG";
        this.user = "xrpg_user";
        this.passwd = "xrpg_password";
        try {
            this.connection = DriverManager.getConnection(url,user,passwd); // Probar a hacer la conexion con la base de datos
            this.statement = connection.createStatement();
        }
        catch (SQLException e) {
            System.out.print("Error en la conexión en la base de datos."); // Si no se ha podido conectar manda este mensaje de error.
            e.printStackTrace();
        }
    }
}
