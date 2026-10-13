package com.chubb.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.chubb.test.model.dtos.ClientDto;
import com.chubb.test.model.dtos.ServiceResponse;
import com.chubb.test.service.IClientService;

@RestController
@CrossOrigin(origins = { "http://localhost:8080" })
@RequestMapping("/api")
public class ClientController {
	@Autowired
	private IClientService clientService;
	
	@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/clients")
    public ResponseEntity<List<ClientDto>> getClients() {
    	return ResponseEntity.ok(clientService.findAll());
    	
    }

	@CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/client")
    public ResponseEntity<ServiceResponse> saveClient(@RequestBody ClientDto client) {
    	ServiceResponse serviceReponse = new ServiceResponse();
    	int result = clientService.save(client);
    	if (result == 1) {
    		serviceReponse.setSuccess(true);
	    	serviceReponse.setMessage("Client saved with sucesss");
    	}
    	
    	return new ResponseEntity<>(serviceReponse, HttpStatus.OK);
    	
    }

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/client/{idClient}")
	public ResponseEntity<ServiceResponse> deleteClient(@RequestParam int idClient) {
		ServiceResponse serviceReponse = new ServiceResponse();
		int result = clientService.delete(idClient);
		if (result == 1) {
			serviceReponse.setSuccess(true);
			serviceReponse.setMessage("Client saved with sucesss");
		}else {
			serviceReponse.setSuccess(false);
			serviceReponse.setMessage("Client not found");
			return new ResponseEntity<>(serviceReponse, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(serviceReponse, HttpStatus.NO_CONTENT);

	}
	
}
