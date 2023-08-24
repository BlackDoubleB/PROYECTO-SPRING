package edu.pe.idat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pe.idat.model.Consumidor;
import edu.pe.idat.response.DataResponse;
import edu.pe.idat.service.ConsumidorService;

@RestController
@RequestMapping("/api/consumidor")
public class ConsumidorApiController {

	@Autowired
	private ConsumidorService consumidorService;
	
	@GetMapping("")
	@PreAuthorize("hasRole('CONSUMIDOR')")
	public DataResponse<Consumidor> listarConsumidores() {
		
		try {
			
			var consumidores = consumidorService.findAll();
			
			return new DataResponse<Consumidor>(consumidores);
			
		}catch(Exception e) {
			
			return DataResponse.fail();
			
		}
		
	}
	
	@GetMapping("{idConsumidor}")
	@PreAuthorize("hasRole('CONSUMIDOR')")
	public DataResponse<Consumidor> ObtenerConsumidor(@PathVariable Integer idConsumidor) {
		
		try {
			
			var consumidor = consumidorService.findById(idConsumidor);
			
			return new DataResponse<Consumidor>(consumidor);
			
		}catch(Exception e) {
			
			return DataResponse.fail();
			
		}
		
	}
	
}
