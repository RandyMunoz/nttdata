package com.randylab.nttdata.services;

import com.randylab.nttdata.model.ClientTO;

public interface ClientService {

	ClientTO getByDocumentTypeAndDocumentNumber(String documentType, Integer documentNumber);
}
