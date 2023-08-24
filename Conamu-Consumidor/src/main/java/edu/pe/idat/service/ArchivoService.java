package edu.pe.idat.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.model.Archivo;
import edu.pe.idat.repository.ArchivoRepository;

@Service
public class ArchivoService {

	@Autowired
	private ArchivoRepository archivoRepository;
	
	public void save(Archivo archivo) {
		archivoRepository.save(archivo);
	}
	
	public Optional<Archivo> findOneByNombreArchivo(String nombreArchivo){
		
		return archivoRepository.findOneByNombreArchivo(nombreArchivo);
	
	}
	
}
