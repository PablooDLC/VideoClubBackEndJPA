package org.ieschabas.clases;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

@Embeddable
public class AlquilerId implements Serializable {

	private Date fechaAlquiler;
	private Usuario idCliente;
	private Pelicula idPelicula;

	public AlquilerId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AlquilerId(Pelicula idPelicula, Usuario idCliente, Date fechaAlquiler) {
		super();
		this.fechaAlquiler = fechaAlquiler;
		this.idCliente = idCliente;
		this.idPelicula = idPelicula;
	}

	public Date getFechaAlquiler() {
		return fechaAlquiler;
	}

	public void setFechaAlquiler(Date fechaAlquiler) {
		this.fechaAlquiler = fechaAlquiler;
	}

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	public Usuario getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Usuario idCliente) {
		this.idCliente = idCliente;
	}

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	public Pelicula getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(Pelicula idPelicula) {
		this.idPelicula = idPelicula;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaAlquiler, idCliente, idPelicula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlquilerId other = (AlquilerId) obj;
		return fechaAlquiler == other.fechaAlquiler && idCliente == other.idCliente && idPelicula == other.idPelicula;
	}

	@Override
	public String toString() {
		return "AlquilerId [idAlquiler=" + fechaAlquiler + ", idCliente=" + idCliente + ", idPelicula=" + idPelicula
				+ "]";
	}

}
