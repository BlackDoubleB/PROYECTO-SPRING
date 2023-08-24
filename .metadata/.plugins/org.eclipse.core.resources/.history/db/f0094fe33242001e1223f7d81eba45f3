package edu.pe.idat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pe.idat.model.HorarioReserva;
import edu.pe.idat.response.DataResponse;
import edu.pe.idat.service.HorarioReservaService;

@RestController
@RequestMapping("/api/horario")
public class HorariosApiController {

	@Autowired
	private HorarioReservaService horarioReservaService;
	
	@GetMapping("{fecha}")
	@PreAuthorize("hasRole('CONSUMIDOR')")
	public DataResponse<HorarioReserva> listarHorarios(@PathVariable String fecha) {
		
		try {
			
			var horarios = horarioReservaService.findAllByFecha(fecha);
			
			return new DataResponse<HorarioReserva>(horarios);
			
		}catch(Exception e) {
			
			return DataResponse.fail();
			
		}
		
	}
	
}
