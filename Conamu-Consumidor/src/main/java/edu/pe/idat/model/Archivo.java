package edu.pe.idat.model;

import java.sql.Blob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "archivos")
public class Archivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_Archivo")
	private int idArchivo;
	
	@Column(name = "Nombre_Archivo")
	private String nombreArchivo;
	
	@Column(name = "Extension")
	private String extension;
	
	@Column(name = "Tipo")
	private String tipo;
	
	@Column(name = "Archivo")
	@Lob
	private Blob archivo;

	public int getIdArchivo() {
		return idArchivo;
	}

	public void setIdArchivo(int idArchivo) {
		this.idArchivo = idArchivo;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Blob getArchivo() {
		return archivo;
	}

	public void setArchivo(Blob archivo) {
		this.archivo = archivo;
	}
	
}
