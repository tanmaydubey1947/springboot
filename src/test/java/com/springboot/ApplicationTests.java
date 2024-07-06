package com.springboot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.controller.PatientController;
import com.springboot.entity.Patient;
import com.springboot.repository.PatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTests {

	@Autowired
	private PatientController patientController;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PatientRepository patientRepository;

	@BeforeEach
	public void setup() {
		this.mockMvc= MockMvcBuilders
				.standaloneSetup(PatientController.class)
				.build();
	}

	@Test
	public void addPatientTest() throws Exception {

		Patient patient = new Patient(1L, "Test Name", "Male", "test@gmail.com", 2, "test address");

		when(patientRepository.save(any())).thenReturn(patient);
		//URL -> /addPatient
		//HTTP Method -> POST
		//REQ & RESP -> Patient (Json String)

		mockMvc.perform(MockMvcRequestBuilders
				.post("/addPatient")
				.content(convertObjectAsString(patient))
				.contentType("application/json")
				.accept("application/json"))
				.andExpect(MockMvcResultMatchers.jsonPath("").exists());
	}

	private String convertObjectAsString(Object object) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(object);
	}

}
