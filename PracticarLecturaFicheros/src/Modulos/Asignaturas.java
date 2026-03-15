package Modulos;

public class Asignaturas {
    private String Nombre;
    private Integer Horas;
    private Integer Temas;

    public Asignaturas(String nombre, Integer horas, Integer temas) {
        Nombre = nombre;
        Horas = horas;
        Temas = temas;
    }

    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Integer getHoras() {
        return Horas;
    }
    public void setHoras(Integer horas) {
        Horas = horas;
    }

    public Integer getTemas() {
        return Temas;
    }
    public void setTemas(Integer temas) {
        Temas = temas;
    }
}
