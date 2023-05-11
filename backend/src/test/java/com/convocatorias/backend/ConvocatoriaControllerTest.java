package com.convocatorias.backend;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.convocatorias.backend.controller.ConvocatoriaController;
import com.convocatorias.backend.entity.Convocatoria;
import com.convocatorias.backend.entity.Perfil;
import  com.convocatorias.backend.service.ConvocatoriaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebMvcTest
@Import(ConvocatoriaController.class)
public class ConvocatoriaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConvocatoriaService convocatoriaService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGuardarEmpleado() throws Exception {
        //given
        Convocatoria convocatoria = Convocatoria.builder()
                .nombre("convocatoria test")
                .fechaPublicacion(LocalDateTime.now())
                .descripcion("descripcion convocatoria test")
                .estado(true)
                .perfil(Perfil.OTROS)
                .build();
        given(convocatoriaService.saveConvocatoria(any(Convocatoria.class)))
                .willAnswer((invocation) -> invocation.getArgument(0));

        //when
        ResultActions response = mockMvc.perform(post("/api/v1/convocatorias/crear")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(convocatoria)));

        //then
        response.andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.mensaje",is("Convocatoria Creada")));
    }

    @Test
    void testListarConvocatorias() throws Exception{
        //given
        List<Convocatoria> listaConvocatorias = new ArrayList<>();
        listaConvocatorias.add(Convocatoria.builder().nombre("convocatoria test").fechaPublicacion(LocalDateTime.now()).descripcion("descripcion convocatoria test").estado(true).perfil(Perfil.OTROS).build());
        listaConvocatorias.add(Convocatoria.builder().nombre("convocatoria test1").fechaPublicacion(LocalDateTime.now()).descripcion("descripcion convocatoria test1").estado(true).perfil(Perfil.EMPRENDEDOR).build());
        listaConvocatorias.add(Convocatoria.builder().nombre("convocatoria test2").fechaPublicacion(LocalDateTime.now()).descripcion("descripcion convocatoria test2").estado(false).perfil(Perfil.EMPRENDEDOR).build());
        listaConvocatorias.add(Convocatoria.builder().nombre("convocatoria test3").fechaPublicacion(LocalDateTime.now()).descripcion("descripcion convocatoria test3").estado(false).perfil(Perfil.PROVEEDOR).build());

        given(convocatoriaService.listaConvocatoria()).willReturn(listaConvocatorias);

        //when
        ResultActions response = mockMvc.perform(get("/api/v1/convocatorias/lista"));

        //then
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",is(listaConvocatorias.size())));

    }

    @Test
    void testObtenerConvocatoriaPorId() throws Exception{
        //given
        int convocatoriaId = 1;
        Convocatoria convocatoria = Convocatoria.builder()
                .nombre("convocatoria test")
                .fechaPublicacion(LocalDateTime.now())
                .descripcion("descripcion convocatoria test")
                .estado(true)
                .perfil(Perfil.OTROS)
                .build();

        given(convocatoriaService.getConvocatoria(convocatoriaId)).willReturn(Optional.of(convocatoria));

        //when
        ResultActions response = mockMvc.perform(get("/api/v1/convocatorias/Id/{id}",convocatoriaId));

        //then
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.nombre",is(convocatoria.getNombre())))
                .andExpect(jsonPath("$.descripcion",is(convocatoria.getDescripcion())))
                .andExpect(jsonPath("$.fechaPublicacion",is(convocatoria.getFechaPublicacion())));
    }

    @Test
    void testObtenerConvocatoriaNoEncontrada() throws Exception{
        //given
        int convocatoriaId = 1;
        Convocatoria convocatoria = Convocatoria.builder()
                .nombre("convocatoria test")
                .fechaPublicacion(LocalDateTime.now())
                .descripcion("descripcion convocatoria test")
                .estado(true)
                .perfil(Perfil.OTROS)
                .build();

        given(convocatoriaService.getConvocatoria(convocatoriaId)).willReturn(Optional.empty());

        //when
        ResultActions response = mockMvc.perform(get("/api/v1/convocatorias/Id/{id}",convocatoriaId));

        //then
        response.andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    void testActualizarConvocatoria() throws Exception{
        //given
        int convocatoriaId = 1;
        Convocatoria convocatoria = Convocatoria.builder()
                .nombre("convocatoria test")
                .fechaPublicacion(LocalDateTime.now())
                .descripcion("descripcion convocatoria test")
                .estado(true)
                .perfil(Perfil.OTROS)
                .build();

        Convocatoria convocatoriaActualizada = Convocatoria.builder()
                .nombre("convocatoria test actualizada")
                .fechaPublicacion(LocalDateTime.now())
                .descripcion("descripcion convocatoria test actualizada")
                .estado(false)
                .perfil(Perfil.EMPRENDEDOR)
                .build();
        System.out.println(convocatoria.getId());
        given(convocatoriaService.existsByIdConvocatoria(convocatoriaId)).willReturn(true);
        given(convocatoriaService.getConvocatoria(convocatoriaId)).willReturn(Optional.of(convocatoria));
        given(convocatoriaService.saveConvocatoria(any(Convocatoria.class)))
                .willAnswer((invocation) -> invocation.getArgument(0));

        //when
        ResultActions response = mockMvc.perform(put("/api/v1/convocatorias/actualizar/{id}",convocatoriaId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(convocatoriaActualizada)));

        //then
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.mensaje",is("Convocatoria Actualizada")));
    }

    @Test
    void testActualizarConvocatoriaNoEncontrada() throws Exception{
        //given
        int convocatoriaId = 0;
        Convocatoria convocatoria = Convocatoria.builder()
                .nombre("convocatoria test")
                .fechaPublicacion(LocalDateTime.now())
                .descripcion("descripcion convocatoria test")
                .estado(true)
                .perfil(Perfil.OTROS)
                .build();

        Convocatoria convocatoriaActualizada = Convocatoria.builder()
                .nombre("convocatoria test actualizada")
                .fechaPublicacion(LocalDateTime.now())
                .descripcion("descripcion convocatoria test actualizada")
                .estado(false)
                .perfil(Perfil.EMPRENDEDOR)
                .build();
        given(convocatoriaService.existsByIdConvocatoria(convocatoriaId)).willReturn(false);
        given(convocatoriaService.getConvocatoria(convocatoriaId)).willReturn(Optional.empty());
        given(convocatoriaService.saveConvocatoria(any(Convocatoria.class)))
                .willAnswer((invocation) -> invocation.getArgument(0));

        //when
        ResultActions response = mockMvc.perform(put("/api/v1/convocatorias/actualizar/{id}",convocatoriaId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(convocatoriaActualizada)));

        //then
        response.andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    void testEliminarConvocatoria() throws Exception{
        //given
        int convocatoriaId = 1;
        given(convocatoriaService.existsByIdConvocatoria(convocatoriaId)).willReturn(true);
        willDoNothing().given(convocatoriaService).deleteConvocatoria(convocatoriaId);

        //when
        ResultActions response = mockMvc.perform(delete("/api/v1/convocatorias/borrar/{id}",convocatoriaId));

        //then
        response.andExpect(status().isOk())
                .andDo(print());
    }
}