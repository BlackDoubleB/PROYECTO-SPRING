package edu.pe.idat.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import edu.pe.idat.model.HorarioReserva;
import edu.pe.idat.repository.HorarioReservaRepository;
import edu.pe.idat.request.HorarioReservaCreateRequest;

@Service
public class HorarioReservaService {

	@Autowired
	private HorarioReservaRepository horarioReservaRepository;
	
	public void create(HorarioReservaCreateRequest request) {
		
		horarioReservaRepository.create(request.getFecha(), request.getHorario(), request.getNumeroMesas());
		
	}
	
	public List<HorarioReserva> findAll(){
		
		return horarioReservaRepository.findAll(Sort.by(Direction.DESC, "Fecha"));
		
	}

	public List<HorarioReserva> findAllByFecha(String fecha) throws ParseException{
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsedDate = dateFormat.parse(fecha);
        java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
		
		return horarioReservaRepository.findAllByFecha(sqlDate);
		
	}
	
	public void delete(Number idHorario) {
		
		horarioReservaRepository.deleteById(idHorario);
		
	}
}
