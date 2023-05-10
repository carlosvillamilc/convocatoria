package com.convocatorias.backend.entity;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="convocatoria")
public class Convocatoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private LocalDate fechaCreacion;

    private LocalDate fechaPublicacion;
    @Column(columnDefinition = "TEXT")
    private String descripcion;
    private boolean estado;
    private Perfil perfil;

    public Convocatoria(String nombre, LocalDate fechaCreacion, LocalDate fechaPublicacion, String description, boolean estado, Perfil perfil){
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.fechaPublicacion = fechaPublicacion;
        this.descripcion = description;
        this.estado = estado;
        this.perfil = perfil;
    }

    public Convocatoria(String nombre, LocalDate fechaCreacion, LocalDate fechaPublicacion){
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.fechaPublicacion = fechaPublicacion;
        this.descripcion = "test";
        this.estado = true;
        this.perfil = Perfil.EMPRENDEDOR;
    }

    public Convocatoria(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }


}
