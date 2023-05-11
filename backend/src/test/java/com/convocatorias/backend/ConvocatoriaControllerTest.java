package com.convocatorias.backend;
import com.convocatorias.backend.controller.ConvocatoriaController;
import com.convocatorias.backend.entity.Convocatoria;
import com.convocatorias.backend.entity.Perfil;
import com.convocatorias.backend.repository.ConvocatoriaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConvocatoriaControllerTest {
    @MockBean
    private ConvocatoriaRepository convocatoriaRepository;
    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public void canRetrieveByIdWhenExists() {
        // given
        given(convocatoriaRepository.getById(2))
                .willReturn(new Convocatoria("convocatoria test",LocalDateTime.now(),"convocatoria test descripcion",true,Perfil.OTROS));

        // when
        ResponseEntity<Convocatoria> convocatoriaResponse = restTemplate.getForEntity("/api/v1/convocatorias/Id/34", Convocatoria.class);
        System.out.println(convocatoriaResponse.getBody());
        // then
        assertThat(convocatoriaResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(convocatoriaResponse.getBody().equals(new Convocatoria()));
    }
}
