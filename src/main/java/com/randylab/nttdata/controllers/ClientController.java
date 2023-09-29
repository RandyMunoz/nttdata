package com.randylab.nttdata.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.randylab.nttdata.model.ClientTO;
import com.randylab.nttdata.services.ClientService;

@RestController
@RequestMapping("api/client")
@CrossOrigin("*")
public class ClientController {

	private ClientService clientService;

	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}

	@GetMapping("/getClientByDocumentTypeAndDocumentNumber")
	public ResponseEntity<ClientTO> getClientByDocumentTypeAndDocumentNumber(@RequestParam String documentType,
			@RequestParam Integer documentNumber) {
		return new ResponseEntity<ClientTO>(
				clientService.getByDocumentTypeAndDocumentNumber(documentType, documentNumber), HttpStatus.OK);
	}

}
