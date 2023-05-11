package com.convocatorias.backend.entity;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Builder;


@Builder
@Entity
@Table(name="convocatoria")
public class Convocatoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private LocalDateTime fechaCreacion;

    private LocalDateTime fechaPublicacion;
    @Column(columnDefinition = "TEXT")
    private String descripcion;
    private boolean estado;
    private Perfil perfil;

    public Convocatoria(String nombre, LocalDateTime fechaPublicacion, String descripcion, boolean estado, Perfil perfil){
        this.nombre = nombre;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaPublicacion = fechaPublicacion;
        this.descripcion = descripcion;
        this.estado = estado;
        this.perfil = perfil;
    }

    public Convocatoria(int id, String nombre, LocalDateTime fechaPublicacion, LocalDateTime fechaCreacion, String descripcion, boolean estado, Perfil perfil){
        this.id = id;
        this.nombre = nombre;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaPublicacion = fechaPublicacion;
        this.descripcion = descripcion;
        this.estado = estado;
        this.perfil = perfil;
    }

    public Convocatoria(String nombre, LocalDateTime fechaPublicacion,String descripcion, Perfil perfil){
        this.nombre = nombre;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaPublicacion = fechaPublicacion;
        this.descripcion = descripcion;
        this.estado = true;
        this.perfil = perfil;
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

    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDateTime fechaPublicacion) {
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
