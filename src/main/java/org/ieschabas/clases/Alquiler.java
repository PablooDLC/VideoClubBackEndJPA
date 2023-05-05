package org.ieschabas.clases;

import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Alquiler {

	
	/*@AttributeOverrides({
		@AttributeOverride(name="fechaAlquiler", column=@Column(name="fechaAlquiler")),
		@AttributeOverride(name="idCliente", column=@Column(name="idCliente")),
		@AttributeOverride(name="idPelicula", column=@Column(name="idPelicula")),
	})*/
	private AlquilerId idCompuesta;
	private long idAlquiler;
	private Date fechaRetorno;
	
	public Alquiler() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Alquiler(Pelicula pelicula, Usuario usuario, Date fechaAlquiler, Date fechaRetorno) {
		super();
		this.idCompuesta = new AlquilerId(pelicula, usuario, fechaAlquiler);
		this.fechaRetorno = fechaRetorno;
	}
	
	@EmbeddedId
	public AlquilerId getIdCompuesta() {
		return idCompuesta;
	}

	public void setIdCompuesta(AlquilerId idCompuesta) {
		this.idCompuesta = idCompuesta;
	}

	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getIdAlquiler() {
		return idAlquiler;
	}

	public void setIdAlquiler(long idAlquiler) {
		this.idAlquiler = idAlquiler;
	}

	public Date getFechaRetorno() {
		return fechaRetorno;
	}

	public void setFechaRetorno(Date fechaRetorno) {
		this.fechaRetorno = fechaRetorno;
	}

	@Override
	public String toString() {
		return "Alquiler [idAlquiler=" + idAlquiler + ", fechaRetorno=" + fechaRetorno + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idAlquiler, fechaRetorno);
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
		return Objects.equals(idAlquiler, other.idAlquiler) && Objects.equals(fechaRetorno, other.fechaRetorno);
	}
	
	
	
}
