package rpg.dao;

import rpg.exception.DatoInvalidoException;
import rpg.exception.RecursoNoEncontradoException;
import rpg.model.Clase;
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
    public void verPersonajesMasRicos() throws RecursoNoEncontradoException, DatoInvalidoException {
        ordenarPersonajesOroMayorAMenor();
        verPodio();
    }
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

    public void censoDeClases() throws SQLException, RecursoNoEncontradoException, DatoInvalidoException {
        HashMap<String, Integer> clases_cantidad = new HashMap<>(); // La clave será la clase y el valor la cantidad
        HashMap<Integer, Integer> auxiliar = new HashMap<>(); // Mapa auxiliar donde la clave será el id_clase y el valor la cantidad

        for (Personaje personaje : this.personajes) {
            if (!auxiliar.containsKey(personaje.getId_clase())) { // Si no tenemos guardado el id_clase del personaje aún
                auxiliar.put(personaje.getId_clase(),1); // Añadimos al mapa auxiliar la clase con 1 de cantidad
            }
            else { // Si el id_clase ya se encuentra en el mapa auxiliar
                auxiliar.replace(personaje.getId_clase(),auxiliar.get(personaje.getId_clase())+1); // Le sumo 1 a la cantidad actual del id_item
            }
        }

        ClaseDAO claseDAO = new ClaseDAO();
        List<Clase> clases = claseDAO.getClases();

        // Rellenar HashMap
        for (Clase clase : clases) {
            if (auxiliar.containsKey(clase.getId())) { // Si la id_clase está en auxiliar:
                clases_cantidad.put(clase.getNombre(),auxiliar.get(clase.getId())); // Inserto en el HashMap la clave El nombre de la clase y el valor la cantidad que está guardada en auxiliar.
            }
        }
        // Imprimir cuantos personajes existen de cada clase:
        for (String clase : clases_cantidad.keySet()) {
            System.out.println(clase+": "+clases_cantidad.get(clase));
        }
        logger.escribirLog("["+LocalDate.now()+"] INFO: Censo de clases mostrado.");
    }
}