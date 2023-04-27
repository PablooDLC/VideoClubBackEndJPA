package org.ieschabas.clases;

import java.util.Objects;

import javax.persistence.*;

@Entity
public class Alquiler {

	private int id;
	private String fechaAlquiler;
	private int idCliente;
	private int idPelicula;
	private String fechaRetorno;
	
	public Alquiler() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Alquiler(String fechaAlquiler, int idCliente, int idPelicula, String fechaRetorno) {
		super();
		this.fechaAlquiler = fechaAlquiler;
		this.idCliente = idCliente;
		this.idPelicula = idPelicula;
		this.fechaRetorno = fechaRetorno;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFechaAlquiler() {
		return fechaAlquiler;
	}

	public void setFechaAlquiler(String fechaAlquiler) {
		this.fechaAlquiler = fechaAlquiler;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public String getFechaRetorno() {
		return fechaRetorno;
	}

	public void setFechaRetorno(String fechaRetorno) {
		this.fechaRetorno = fechaRetorno;
	}

	@Override
	public String toString() {
		return "Alquiler [id=" + id + ", fechaAlquiler=" + fechaAlquiler + ", idCliente=" + idCliente + ", idPelicula="
				+ idPelicula + ", fechaRetorno=" + fechaRetorno + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaAlquiler, fechaRetorno, id, idCliente, idPelicula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alquiler other = (Alquiler) obj;
		return Objects.equals(fechaAlquiler, other.fechaAlquiler) && Objects.equals(fechaRetorno, other.fechaRetorno)
				&& id == other.id && idCliente == other.idCliente && idPelicula == other.idPelicula;
	}
	
	
	
}
