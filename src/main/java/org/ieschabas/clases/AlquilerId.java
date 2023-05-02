package org.ieschabas.clases;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class AlquilerId implements Serializable {

	private long idAlquiler;
	private long idCliente;
	private long idPelicula;

	public long getIdAlquiler() {
		return idAlquiler;
	}

	public void setIdAlquiler(long idAlquiler) {
		this.idAlquiler = idAlquiler;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public long getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(long idPelicula) {
		this.idPelicula = idPelicula;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idAlquiler, idCliente, idPelicula);
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
		return idAlquiler == other.idAlquiler && idCliente == other.idCliente && idPelicula == other.idPelicula;
	}

	@Override
	public String toString() {
		return "AlquilerId [idAlquiler=" + idAlquiler + ", idCliente=" + idCliente + ", idPelicula=" + idPelicula + "]";
	}

}
