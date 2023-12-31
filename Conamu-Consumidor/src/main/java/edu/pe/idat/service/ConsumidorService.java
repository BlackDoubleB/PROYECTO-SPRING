package edu.pe.idat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import edu.pe.idat.model.Consumidor;
import edu.pe.idat.model.Persona;
import edu.pe.idat.model.Rol;

import edu.pe.idat.repository.ConsumidorRepository;
import edu.pe.idat.request.UsuarioCreateRequest;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ConsumidorService {

	@Autowired
	private ConsumidorRepository consumidorRepository;
	
	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private RolesService rolesService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public List<Consumidor> findAll(){
		return consumidorRepository.findAll();
	}
	
	public Optional<Consumidor> findOneByUsuarioOptional(String usuario) {
		return consumidorRepository.findOneByUsuario(usuario);
	}
	
	public Consumidor findOneByUsuario(String usuario) {
		var consumidor = consumidorRepository.findOneByUsuario(usuario);
		
		if(!consumidor.isPresent()) {
			throw new EntityNotFoundException("No se encontró el Usuario con username ".concat(usuario));
		}
		
		return consumidor.get();
	}
	
	public Consumidor findById(Integer idConsumidor) {
		
		var consumidor = consumidorRepository.findById(idConsumidor);
		
		if(!consumidor.isPresent()) {
			throw new EntityNotFoundException("No se encontró el estado con id ".concat(idConsumidor.toString()));
		}
		
		return consumidor.get();
		
	}
	
	@Transactional
	public Consumidor addPersonaConsumidor (UsuarioCreateRequest request) {
		
		Persona persona = new Persona();
		persona.setDni(request.getDni());
		persona.setCorreo(request.getCorreo());
		persona.setNombreCompletos(request.getNombreCompletos());
		persona.setTelefono(request.getTelefono());
		
		Rol rol = rolesService.findById(Integer.parseInt(request.getRol()));
		
		Consumidor trabajador = new Consumidor();
		trabajador.setUsuario(request.getUsuario());
		trabajador.setContrasena(passwordEncoder.encode(request.getContrasena()));
		trabajador.setPersona(persona);
		trabajador.setRol(rol);
		
		personaService.addPersona(persona);
		
		return consumidorRepository.save(trabajador);
		
	}
	
}
