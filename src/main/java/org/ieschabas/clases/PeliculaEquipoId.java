package org.ieschabas.clases;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class PeliculaEquipoId implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private int idPelicula;
	private int idEquipo;
	
	public PeliculaEquipoId() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PeliculaEquipoId(int idPelicula, int idEquipo) {
		super();
		this.idPelicula = idPelicula;
		this.idEquipo = idEquipo;
	}
	public int getIdPelicula() {
		return idPelicula;
	}
	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}
	public int getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idEquipo, idPelicula);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PeliculaEquipoId other = (PeliculaEquipoId) obj;
		return idEquipo == other.idEquipo && idPelicula == other.idPelicula;
	}
	@Override
	public String toString() {
		return "PeliculaEquipoId [idPelicula=" + idPelicula + ", idEquipo=" + idEquipo + "]";
	}
	
	
	
	
}
