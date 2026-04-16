package rpg.dao;

import rpg.exception.DatoInvalidoException;
import rpg.model.Item;
import rpg.model.Raza;
import rpg.utils.Logger;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RazaDAO extends ConexionBaseDatos {
    private List<Raza> razas;
    private Logger logger;

    public RazaDAO() throws DatoInvalidoException {
        this.razas = new ArrayList<>();
        this.logger = new Logger();
        precargarRazas();
    }

    public List<Raza> getRazas() {
        return this.razas;
    }
    public void setRazas(List<Raza> razas) {
        this.razas = razas;
    }

    private void precargarRazas() throws DatoInvalidoException {
        try{
            this.resultSet = statement.executeQuery("SELECT * FROM RAZAS"); // Hacemos una consulta de TODAS las columnas de la tabla Items.

            while (resultSet.next()) { // Mientras haya otra fila:
                // Guarda los datos de la base de datos en las variables
                Integer id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                Integer bonificador_vida = resultSet.getInt("bonificador_vida");
                Integer bonificador_fuerza = resultSet.getInt("bonificador_fuerza");
                razas.add(new Raza(id, nombre, bonificador_vida, bonificador_fuerza)); // Y crea un personaje que añade a la lista que contiene la información de las bases de datos.
            }
        } catch (SQLException e) {
            logger.escribirLog("["+ LocalDateTime.now() +"] ERROR: No se pudieron cargar las razas: " + e.getMessage());

        }
    }
}
