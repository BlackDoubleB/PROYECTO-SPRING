package edu.pe.idat.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pe.idat.model.Archivo;

public interface ArchivoRepository extends JpaRepository<Archivo, Integer>{

	Optional<Archivo> findOneByNombreArchivo(String nombreArchivo);
	
}
