package com.convocatorias.backend.dto;

import com.convocatorias.backend.entity.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ConvocatoriaDTO {

    @NotBlank
    private String nombre;
    @FutureOrPresent(message = "The date must be in the present or future")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime fechaPublicacion;

    @NotBlank
    @Size(min = 50, max = 255)
    private String descripcion;

    @NotBlank
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Perfil perfil;

    @NotBlank
    @JsonFormat(shape = JsonFormat.Shape.BOOLEAN)
    private boolean estado;

    public ConvocatoriaDTO() {
    }

    public ConvocatoriaDTO(String nombreConvocatoria, LocalDateTime fechaPublicacion, String descripcionConvocatoria,Perfil perfil, boolean estado) {
        this.nombre = nombreConvocatoria;
        this.fechaPublicacion = fechaPublicacion;
        this.descripcion = descripcionConvocatoria;
        this.perfil = perfil;
        this.estado = estado;
    }

    public String getNombre() {

        return nombre;
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
    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}