//SON MODELO DE DATOS ENTANTES PARA ALGUNAS CONSULTAS
package edu.pe.idat.request;
// esta clase es utilizada para recibir los datos que el usuario o
//una aplicación envían cuando quieren crear un nuevo horario de reserva. 

public class HorarioReservaCreateRequest {

	private String fecha;

	private String horario;

	private int numeroMesas;
	

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public int getNumeroMesas() {
		return numeroMesas;
	}

	public void setNumeroMesas(int numeroMesas) {
		this.numeroMesas = numeroMesas;
	}
	
}
