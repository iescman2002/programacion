import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/XRPG";
        String user = "xrpg_user";
        String pass = "xrpg_password";

        // Probar una consulta de la base de datos:
        try (Connection connection = DriverManager.getConnection(url,user,pass);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM ITEMS")) {
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String tipo = resultSet.getString("tipo");
                Integer precio_oro = resultSet.getInt("precio_oro");
                Integer bonificador_ataque = resultSet.getInt("bonificador_ataque");
                Integer bonificador_defensa = resultSet.getInt("bonificador_defensa");


                System.out.println("ID: "+id);
                System.out.println("nombre: "+nombre);
                System.out.println("tipo: "+tipo);
                System.out.println("precio oro: "+precio_oro);
                System.out.println("bonificador ataque: "+bonificador_ataque);
                System.out.println("bonificador defensa: "+bonificador_defensa);
                System.out.println("-----------------------------------------------------");
            }
        }
        catch (SQLException e) {
            System.out.print("Error en la conexión en la base de datos.");
            e.printStackTrace();
        }
    }
}