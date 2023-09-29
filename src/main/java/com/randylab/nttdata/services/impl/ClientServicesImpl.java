package com.randylab.nttdata.services.impl;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.randylab.nttdata.entities.Client;
import com.randylab.nttdata.exceptions.ServiceException;
import com.randylab.nttdata.model.ClientTO;
import com.randylab.nttdata.repositories.ClientRepository;
import com.randylab.nttdata.services.ClientService;

@Service
public class ClientServicesImpl implements ClientService {

	private ClientRepository clientRepository;

	public ClientServicesImpl(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	private static Logger _logger = LoggerFactory.getLogger(ClientServicesImpl.class);

	@Override
	public ClientTO getByDocumentTypeAndDocumentNumber(String documentType, Integer documentNumber) {
		try {
			_logger.info("Start method getByDocumentTypeAndDocumentNumber");
			validateClientDocumentType(documentType);
			Client client = clientRepository.findByDocumentTypeAndDocumentNumber(documentType, documentNumber);

			if (client == null)
				throw new ServiceException("001", "CLIENT NOT FOUND", HttpStatus.NOT_FOUND);

			return new ClientTO(client.getId(), client.getDocumentType(), client.getDocumentNumber(),
					client.getFirstName(), client.getLastName(), client.getPhone(), client.getAddress(),
					client.getCity());
		} catch (ServiceException e1) {
			throw e1;
		} catch (Exception e) {
			_logger.error("Error method getByDocumentTypeAndDocumentNumber", e);
			throw new ServiceException("000", "INTERNAL SERVER ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private void validateClientDocumentType(String documentType) {
		if (!Arrays.asList("C", "P").contains(documentType)) {
			throw new ServiceException("002", "Only you can insert C and P how document type", HttpStatus.BAD_REQUEST);
		}
	}
}
