package com.randylab.nttdata.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.randylab.nttdata.entities.Client;
import com.randylab.nttdata.exceptions.ServiceException;
import com.randylab.nttdata.model.ClientTO;
import com.randylab.nttdata.repositories.ClientRepository;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ClientControllerTest {
	
	private ClientController clientController;
	
	@Autowired
	public ClientControllerTest(ClientController clientController) {
		this.clientController = clientController;
	}
	
	@MockBean
	private ClientRepository clientRepository;
	
	@Test
	@DisplayName(value = "test method get client by document type and document number ok")
	void testMethodGetClientByDocumentTypeAndDocumentNumberOk() {
		when(clientRepository.findByDocumentTypeAndDocumentNumber(any(), any())).thenReturn(createDataClient());
		ResponseEntity<ClientTO> clientTO = clientController.getClientByDocumentTypeAndDocumentNumber("C", 23445322);
		assertEquals(clientTO.getBody().getDocumentNumber(), 23445322);
	}
	
	@Test
	@DisplayName(value = "test method get client by document type and document number failed")
	void testMethodGetClientByDocumentTypeAndDocumentNumberFailed() {
		ServiceException serviceException = assertThrows(ServiceException.class, () -> clientController.getClientByDocumentTypeAndDocumentNumber("Z", 23445322));
		assertEquals("Only you can insert C and P how document type", serviceException.getMessage());
	}
	
	@Test
	@DisplayName(value = "test method get client exception not found")
	void testMethodGetClientNotFound() {
		when(clientRepository.findByDocumentTypeAndDocumentNumber(any(), any())).thenReturn(null);
		ServiceException serviceException = assertThrows(ServiceException.class, () -> clientController.getClientByDocumentTypeAndDocumentNumber("C", 23445322));
		assertEquals("CLIENT NOT FOUND", serviceException.getMessage());
	}
	
	@Test
	@DisplayName(value = "test method get client exception internal server error")
	void testMethodGetClientInternalServerError() {
		when(clientRepository.findByDocumentTypeAndDocumentNumber(any(), any())).thenThrow(NullPointerException.class);
		Exception exception = assertThrows(Exception.class, () -> clientController.getClientByDocumentTypeAndDocumentNumber("C", 23445322));
		assertEquals("INTERNAL SERVER ERROR", exception.getMessage());
	}
	
	@BeforeEach
	void setup() {}
	
	@AfterEach
	void destroy() {}
	
	private Client createDataClient() {
		return new Client(1L, "C", 23445322, "Pedro", "Perez", "312313542", "Calle C", "Bogota");
	}

}
