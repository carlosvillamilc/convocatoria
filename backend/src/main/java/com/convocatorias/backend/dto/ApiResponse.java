package com.convocatorias.backend.dto;

public class ApiResponse {
    private Object convocatoria;
    private String mensaje;

    public ApiResponse(Object convocatoria, String message) {
        this.mensaje = message;
        this.convocatoria = convocatoria;
    }

    public Object getConvocatoria() {
        return convocatoria;
    }

    public void setConvocatoria(Object convocatoria) {
        this.convocatoria = convocatoria;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMessage(String mensaje) {
        this.mensaje = mensaje;
    }
}
