package rpg.model;

public class Personajes_Habilidades {
    Integer id_personaje; // PK y FK de Personaje
    Integer id_habilidad; // PK y FK de Habilidad
    Boolean equipada_combate;

    public Personajes_Habilidades(Integer id_personaje, Integer id_habilidad, Boolean equipada_combate) {
        this.id_personaje = id_personaje;
        this.id_habilidad = id_habilidad;
        this.equipada_combate = equipada_combate;
    }

    public Integer getId_personaje() {
        return id_personaje;
    }
    public void setId_personaje(Integer id_personaje) {
        this.id_personaje = id_personaje;
    }

    public Integer getId_habilidad() {
        return id_habilidad;
    }
    public void setId_habilidad(Integer id_habilidad) {
        this.id_habilidad = id_habilidad;
    }

    public Boolean getEquipada_combate() {
        return equipada_combate;
    }
    public void setEquipada_combate(Boolean equipada_combate) {
        this.equipada_combate = equipada_combate;
    }
}
