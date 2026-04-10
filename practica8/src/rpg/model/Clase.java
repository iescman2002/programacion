package rpg.model;

public class Clase {
    Integer id; // PK
    String nombre;

    public Clase(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    @Override
    public String toString() {
        return "Clase {" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
