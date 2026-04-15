package rpg.dao;

import rpg.exception.DatoInvalidoException;
import rpg.exception.RecursoNoEncontradoException;
import rpg.model.Habilidad;
import rpg.model.Personaje;
import rpg.model.Personajes_Habilidades;
import rpg.utils.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Personajes_HabilidadesDAO extends ConexionBaseDatos {
    private List<Personajes_Habilidades> personajes_habilidades;
    private Logger logger;

    public Personajes_HabilidadesDAO() throws SQLException {
        this.personajes_habilidades = new ArrayList<>();
        precargarPersonajes_Habilidades();
        this.logger = new Logger();
    }

    public List<Personajes_Habilidades> getPersonajes_habilidades() {
        return this.personajes_habilidades;
    }
    public void setPersonajes_habilidades(List<Personajes_Habilidades> personajes_habilidades) {
        this.personajes_habilidades = personajes_habilidades;
    }

    private void precargarPersonajes_Habilidades() throws SQLException {
        this.resultSet = statement.executeQuery("SELECT * FROM PERSONAJES_HABILIDADES");

        while (resultSet.next()) {
            Integer id_personaje = resultSet.getInt("id_personaje");
            Integer id_habilidad = resultSet.getInt("id_habilidad");
            Boolean equipada_combate = resultSet.getBoolean("equipada_combate");

            personajes_habilidades.add(new Personajes_Habilidades(id_personaje,id_habilidad,equipada_combate));
        }
    }
    public void actualizarPersonajeHabilidades(Personaje personaje) throws SQLException, RecursoNoEncontradoException, DatoInvalidoException {

        HabilidadDAO habilidadDAO = new HabilidadDAO();
        List<Integer> habilidades_personaje= new ArrayList<>(); // Lista que contendrá las id de las habilidades del personaje
        // Obtener el id de las habilidades que tiene el personaje (en base a la clase)
        for (Habilidad habilidad : habilidadDAO.getHabilidades()) {
            if (personaje.getId_clase().equals(habilidad.getId_clase())) { // Si el id de la clase del personaje es igual al de la clase de la habilidad entonces el personaje esa habilidad puede usarla el personaje
                habilidades_personaje.add(habilidad.getId());
            }
        }

        // Insertar las habilidades del personaje y el personaje en la tabla:
        for (Integer idHabilidad : habilidades_personaje) { // Recorro los id de la habilidades
            String sql = "INSERT INTO PERSONAJES_HABILIDADES(id_personaje,id_habilidad,equipada_combate) VALUES(?,?,?)";
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

            preparedStatement.setInt(1,personaje.getId());  // Introduzco el campo del id del personaje
            preparedStatement.setInt(2,idHabilidad);        // Introduzco el campo del id de la habilidad que usara el personaje
            preparedStatement.setBoolean(3,false);        // Por defecto todas las habilidades estan falsas y despues las actualizo

            int rowsAffected = preparedStatement.executeUpdate();
        }
        logger.escribirLog("["+ LocalDateTime.now()+"] INFO: Habilidades del personaje creado cargadas con exito.");
    }

    // Funcion que se encargará de pasar equipada_combate de false a true en la tabla personajes_habilidades
    public void equiparHabilidad(Integer id_personaje, Integer id_habilidad) throws SQLException, RecursoNoEncontradoException, DatoInvalidoException {
        String sql = "UPDATE PERSONAJES_HABILIDADES SET EQUIPADA_COMBATE='TRUE' WHERE id_personaje=? AND id_habilidad=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1,id_personaje);
        preparedStatement.setInt(2,id_habilidad);
        Integer rowsAffected = preparedStatement.executeUpdate();
        logger.escribirLog("["+ LocalDateTime.now()+"] INFO: Habilidad "+id_habilidad+" del personaje "+id_personaje+" equipada.");
    }
    // Funcion que se encargará de pasar equipada_combate de true a false en la tabla personajes_habilidades
    public void desequiparHabilidad(Integer id_personaje, Integer id_habilidad) throws SQLException, RecursoNoEncontradoException, DatoInvalidoException {
        String sql = "UPDATE PERSONAJES_HABILIDADES SET EQUIPADA_COMBATE='FALSE' WHERE id_personaje=? AND id_habilidad=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1,id_personaje);
        preparedStatement.setInt(2,id_habilidad);
        Integer rowsAffected = preparedStatement.executeUpdate();
        logger.escribirLog("["+ LocalDateTime.now()+"] INFO: Habilidad "+id_habilidad+" del personaje "+id_personaje+" equipada.");
    }
}
