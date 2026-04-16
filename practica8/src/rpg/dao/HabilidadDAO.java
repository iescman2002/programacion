package rpg.dao;

import rpg.exception.DatoInvalidoException;
import rpg.model.Habilidad;
import rpg.utils.Logger;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HabilidadDAO extends ConexionBaseDatos {
    private List<Habilidad> habilidades;
    private Logger logger;

    public HabilidadDAO() throws DatoInvalidoException {
        this.habilidades = new ArrayList<>();
        this.logger = new Logger();
        precargaHabilidades();
    }

    public List<Habilidad> getHabilidades() {
        return this.habilidades;
    }
    public void setHabilidades(List<Habilidad> habilidades) {
        this.habilidades = habilidades;
    }

    private void precargaHabilidades() throws DatoInvalidoException {
        try {
            this.resultSet = statement.executeQuery("SELECT * FROM HABILIDADES");

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                Integer danio_base = resultSet.getInt("dano_base");
                Integer usos_maximos = resultSet.getInt("usos_maximos");
                Integer id_clase = resultSet.getInt("id_clase");

                habilidades.add(new Habilidad(id, nombre, danio_base, usos_maximos, id_clase));
            }
        }
        catch(SQLException e) {
                logger.escribirLog("["+ LocalDateTime.now() +"] ERROR: No se pudieron cargar las habilidades: " + e.getMessage());
        }
    }
}