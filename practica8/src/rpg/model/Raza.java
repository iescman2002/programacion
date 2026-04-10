package rpg.model;

public class Raza {
    Integer id; // PK
    String nombre;
    Integer bonificado_vida;
    Integer bonificado_fuerza;

    public Raza(Integer id, String nombre, Integer bonificado_vida, Integer bonificado_fuerza) {
        this.id = id;
        this.nombre = nombre;
        this.bonificado_vida = bonificado_vida;
        this.bonificado_fuerza = bonificado_fuerza;
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

    public Integer getBonificado_vida() {
        return bonificado_vida;
    }
    public void setBonificado_vida(Integer bonificado_vida) {
        this.bonificado_vida = bonificado_vida;
    }

    public Integer getBonificado_fuerza() {
        return bonificado_fuerza;
    }
    public void setBonificado_fuerza(Integer bonificado_fuerza) {
        this.bonificado_fuerza = bonificado_fuerza;
    }
}
