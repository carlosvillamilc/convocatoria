package com.convocatorias.backend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class ConvocatoriaDTO {

    //Notación para especificar que el campo no puede venir vacio
    @NotBlank
    private String nombreConvocatoria;
    @Past
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate fechaCreacion;
    @Past
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate fechaPublicacion;

    public ConvocatoriaDTO() {
    }

    public ConvocatoriaDTO(String nombreConvocatoria, LocalDate fechaPublicacion, LocalDate fechaCreacion) {
        this.nombreConvocatoria = nombreConvocatoria;
        this.fechaPublicacion = fechaPublicacion;
        this.fechaCreacion = fechaCreacion;
    }

    public String getNombreConvocatoria() {

        return nombreConvocatoria;
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
}