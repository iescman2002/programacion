package rpg.model;

public class Personaje {
    Integer id; // PK
    String nombre;
    Integer nivel;
    Integer oro;
    Integer vida_actual;
    Integer id_raza; // FK de Raza
    Integer id_clase; // FK de Clase
    Integer id_ciudad_actual; // FK de Ciudad

    public Personaje(Integer id, String nombre, Integer nivel, Integer oro, Integer vida_actual, Integer id_raza, Integer id_clase, Integer id_ciudad_actual) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
        this.oro = oro;
        this.vida_actual = vida_actual;
        this.id_raza = id_raza;
        this.id_clase = id_clase;
        this.id_ciudad_actual = id_ciudad_actual;
    }

    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNivel() {
        return this.nivel;
    }
    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Integer getOro() {
        return oro;
    }
    public void setOro(Integer oro) {
        this.oro = oro;
    }

    public Integer getVida_actual() {
        return this.vida_actual;
    }
    public void setVida_actual(Integer vida_actual) {
        this.vida_actual = vida_actual;
    }

    public Integer getId_raza() {
        return this.id_raza;
    }
    public void setId_raza(Integer id_raza) {
        this.id_raza = id_raza;
    }

    public Integer getId_clase() {
        return this.id_clase;
    }
    public void setId_clase(Integer id_clase) {
        this.id_clase = id_clase;
    }

    public Integer getId_ciudad_actual() {
        return this.id_ciudad_actual;
    }
    public void setId_ciudad_actual(Integer id_ciudad_actual) {
        this.id_ciudad_actual = id_ciudad_actual;
    }
}
