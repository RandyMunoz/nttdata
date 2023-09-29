package com.randylab.nttdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.randylab.nttdata.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	Client findByDocumentTypeAndDocumentNumber(String documentType, Integer documentNumber);
}
