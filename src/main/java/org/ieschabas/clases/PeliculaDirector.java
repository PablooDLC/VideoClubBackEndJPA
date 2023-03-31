package org.ieschabas.clases;

import javax.persistence.*;

@Entity
public class PeliculaDirector {

	private int idPelicula;
	private int idDirector;
	
	public PeliculaDirector() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PeliculaDirector(int idPelicula, int idDirector) {
		super();
		this.idPelicula = idPelicula;
		this.idDirector = idDirector;
	}

	public int getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public int getIdDirector() {
		return idDirector;
	}

	public void setIdDirector(int idDirector) {
		this.idDirector = idDirector;
	}
	
	
}
