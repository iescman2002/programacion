package rpg.dao;

import rpg.exception.DatoInvalidoException;
import rpg.exception.RecursoNoEncontradoException;
import rpg.model.Personaje;
import rpg.utils.Logger;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class InformesDAO extends ConexionBaseDatos {
    List<Personaje> personajes;
    Logger logger;
    public InformesDAO() throws SQLException, RecursoNoEncontradoException, DatoInvalidoException {
        this.personajes = new ArrayList<>();
        this.logger = new Logger();

        cargarPersonajes();
        ordenarPersonajesOroMayorAMenor();
        verPodio();
    }

    private void cargarPersonajes() throws SQLException {
        this.resultSet = statement.executeQuery("SELECT * FROM PERSONAJES");

        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String nombre = resultSet.getString("nombre");
            Integer nivel = resultSet.getInt("nivel");
            Integer oro = resultSet.getInt("oro");
            Integer vida_actual = resultSet.getInt("vida_actual");
            Integer id_raza = resultSet.getInt("id_raza");
            Integer id_clase = resultSet.getInt("id_clase");
            Integer id_ciudad_actual = resultSet.getInt("id_ciudad_actual");

            personajes.add(new Personaje(id,nombre,nivel,oro,vida_actual,id_raza,id_clase,id_ciudad_actual));
        }
    }
    // Ordenar de mayor a menor
    private void ordenarPersonajesOroMayorAMenor() throws RecursoNoEncontradoException, DatoInvalidoException {
        // Ordeno la lista directamente de this.personajes usando el metodo sort (no devuelve nada solo se encarga de ordenar la lista que le pasao)
        // Donde dentro llamo al comparador que comparará el oro de los personajes
        personajes.sort(Comparator.comparingInt(Personaje::getOro).reversed()); // Sin .reserved ordena de menor a mayor y quiero que ordene de mas a menos por eso pongo reserved
        logger.escribirLog("["+ LocalDate.now() +"] INFO: Lista de personajes ordenada por oro de mayor a menor.");
    }
    private void verPodio(){
        // Ver los 3 mas ricos (seria ver solo los 3 primeros personajes, para los 3 mas pobres pos seria ver los 3 ultimos)
        System.out.println("RANKING DE RICOS:");
        for (int i = 0; i < 3;i++) {
            System.out.println("Rico N"+(i++)+". "+this.personajes.get(i).getNombre()+". Oro: "+this.personajes.get(i).getOro());
        }
    }
}