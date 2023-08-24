package edu.pe.idat.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import edu.pe.idat.model.Archivo;
import edu.pe.idat.repository.ArchivoRepository;

@Service
public class FileDbStorageService implements StorageService{

	@Autowired
	private ArchivoRepository archivoRepository;

	@Override
	public String store(MultipartFile file, String nombreArchivo){
		
		try {
			
			var nombre = nombreArchivo == null ? file.getOriginalFilename() : nombreArchivo;
			var blob = new SerialBlob(file.getBytes());
			
			var arch = archivoRepository.findOneByNombreArchivo(nombre);
			
			if(arch.isPresent()) {
				var a = arch.get();
				a.setArchivo(blob);
				archivoRepository.save(a);
				
				return nombre;
			}
			
			var extension = StringUtils.getFilenameExtension(nombre);
			var tipo = file.getContentType();
			var archivo = new Archivo();
			archivo.setNombreArchivo(nombre);
			archivo.setExtension(extension);
			archivo.setTipo(tipo);
			archivo.setArchivo(blob);
		
			archivoRepository.save(archivo);
			
			return nombre;
			
		} catch (SQLException | IOException e) {
			
			return null;
			
		}
	}

}
