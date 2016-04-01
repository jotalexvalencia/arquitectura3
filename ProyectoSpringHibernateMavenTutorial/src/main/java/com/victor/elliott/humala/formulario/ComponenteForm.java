package com.victor.elliott.humala.formulario;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="componente")
public class ComponenteForm {
 
    @Id
    @Column(name="id")
    @GeneratedValue
    private Integer id;
 
    @Column(name="nombre")
    private String nombre;
 
    @Column(name="version")
    private String version;
 
    @Column(name="tipo")
    private String tipo;
 
    @Column(name="extension")
    private String extension;
 
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
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getExtension() {
        return extension;
    }
    public void setExtension(String extension) {
        this.extension = extension;
    }
 
    public String toString(){
 
        return "Componente: "+this.id+", "+this.nombre+", "+this.version+", "+this.extension;
    }
}