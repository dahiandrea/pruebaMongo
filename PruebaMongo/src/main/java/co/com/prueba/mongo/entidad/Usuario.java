package co.com.prueba.mongo.entidad;

public class Usuario {
    
    private String id;
    private String nombre;
    private Integer edad;
    private String totalPositivos;
    private String totalNegativos;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getEdad() {
        return edad;
    }
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    public String getTotalPositivos() {
        return totalPositivos;
    }
    public void setTotalPositivos(String totalPositivos) {
        this.totalPositivos = totalPositivos;
    }
    public String getTotalNegativos() {
        return totalNegativos;
    }
    public void setTotalNegativos(String totalNegativos) {
        this.totalNegativos = totalNegativos;
    }

    
}

