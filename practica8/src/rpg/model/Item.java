package rpg.model;

public class Item {
    Integer id; // PK
    String nombre;
    String tipo;
    Integer precio_oro;
    Integer bonificador_ataque;
    Integer bonificador_defensa;

    public Item(Integer id, String nombre, String tipo, Integer precio_oro, Integer bonificador_ataque, Integer bonificador_defensa) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio_oro = precio_oro;
        this.bonificador_ataque = bonificador_ataque;
        this.bonificador_defensa = bonificador_defensa;
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

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getPrecio_oro() {
        return precio_oro;
    }
    public void setPrecio_oro(Integer precio_oro) {
        this.precio_oro = precio_oro;
    }

    public Integer getBonificador_ataque() {
        return bonificador_ataque;
    }
    public void setBonificador_ataque(Integer bonificador_ataque) {
        this.bonificador_ataque = bonificador_ataque;
    }

    public Integer getBonificador_defensa() {
        return bonificador_defensa;
    }
    public void setBonificador_defensa(Integer bonificador_defensa) {
        this.bonificador_defensa = bonificador_defensa;
    }
}
