package edu.pe.idat.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pe.idat.service.ArchivoService;

@RestController
@RequestMapping("/api/media")
public class MediaApiController {

	@Autowired
	private ArchivoService archivoService;
	
	
	@GetMapping("{filename:.+}")
	public ResponseEntity<Resource> getFile(@PathVariable String filename) throws IOException, SQLException{
		
		var archivo = archivoService.findOneByNombreArchivo(filename);
		
		if(!archivo.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		InputStreamResource resource = new InputStreamResource(archivo.get().getArchivo().getBinaryStream());
		
		return ResponseEntity
				.ok()
				.header(HttpHeaders.CONTENT_TYPE, archivo.get().getTipo())
				.body(resource);
		
	}
	
}
