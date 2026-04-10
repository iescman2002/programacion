package rpg.model;

public class Ciudad {
    Integer id; // PK
    String nombre;
    Integer nivel_minimo_acceso;

    public Ciudad(Integer id, String nombre, Integer nivel_minimo_acceso) {
        this.id = id;
        this.nombre = nombre;
        this.nivel_minimo_acceso = nivel_minimo_acceso;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNivel_minimo_acceso() {
        return nivel_minimo_acceso;
    }
    public void setNivel_minimo_acceso(Integer nivel_minimo_acceso) {
        this.nivel_minimo_acceso = nivel_minimo_acceso;
    }

    @Override
    public String toString() {
        return "Ciudad {" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nivel_minimo_acceso=" + nivel_minimo_acceso +
                '}';
    }
}
