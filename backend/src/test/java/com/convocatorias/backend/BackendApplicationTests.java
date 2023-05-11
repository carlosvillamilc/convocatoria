package com.convocatorias.backend;

import com.convocatorias.backend.controller.ConvocatoriaController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class BackendApplicationTests {
	@Autowired
	ConvocatoriaController convocatoriaController;
	@Test
	void contextLoads() {
		Assertions.assertThat(convocatoriaController).isNot(null);
	}

}
