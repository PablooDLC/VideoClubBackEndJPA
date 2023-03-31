package org.ieschabas.clases;

import javax.persistence.*;

@Entity
public class PeliculaActor {

	private int idPelicula;
	private int idActor;
	// private rol;
	
	public PeliculaActor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PeliculaActor(int idPelicula, int idActor) {
		super();
		this.idPelicula = idPelicula;
		this.idActor = idActor;
	}

	public int getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public int getIdActor() {
		return idActor;
	}

	public void setIdActor(int idActor) {
		this.idActor = idActor;
	}
	
	
	
}
