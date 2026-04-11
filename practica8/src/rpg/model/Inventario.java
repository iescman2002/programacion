package rpg.model;

public class Inventario {
    Integer id_personaje; // PK y FK de personaje
    Integer id_item; // PK y FK de Item
    Integer cantidad;

    public Inventario(Integer id_personaje, Integer id_item, Integer cantidad) {
        this.id_personaje = id_personaje;
        this.id_item = id_item;
        this.cantidad = cantidad;
    }

    public Integer getId_personaje() {
        return id_personaje;
    }
    public void setId_personaje(Integer id_personaje) {
        this.id_personaje = id_personaje;
    }

    public Integer getId_item() {
        return id_item;
    }
    public void setId_item(Integer id_item) {
        this.id_item = id_item;
    }

    public Integer getCantidad() {
        return cantidad;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Inventario {" +
                "id_personaje=" + id_personaje +
                ", id_item=" + id_item +
                ", cantidad=" + cantidad +
                '}';
    }
}
