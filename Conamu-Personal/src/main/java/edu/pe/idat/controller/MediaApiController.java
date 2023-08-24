package edu.pe.idat.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.pe.idat.service.ArchivoService;
import edu.pe.idat.service.StorageService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/media")
public class MediaApiController {

	@Autowired
	private StorageService storageService;
	
	@Autowired
	private ArchivoService archivoService;
	
	@Autowired
	private HttpServletRequest request;
	
	@PostMapping("upload")
	@PreAuthorize("hasAnyRole('ADMINISTRADOR', 'PERSONAL')")
	public Map<String, String> uploadFile(@RequestParam("file") MultipartFile multipartFile){
		
		String path = storageService.store(multipartFile, "carta.pdf");
		String host = request.getRequestURL().toString().replace(request.getRequestURI(), "");
		String url = ServletUriComponentsBuilder
				.fromHttpUrl(host)
				.path("/api/media/")
				.path(path)
				.toUriString();
		
		return Map.of("url", url);
		
	}
	
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
