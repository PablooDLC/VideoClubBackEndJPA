package org.ieschabas.clases;

import java.util.Objects;

import javax.persistence.*;

@Entity
public class Alquiler {

	@Id
	@AttributeOverrides({
		@AttributeOverride(name="idAlquiler", column=@Column(name="idAlquiler")),
		@AttributeOverride(name="idCliente", column=@Column(name="idCliente")),
		@AttributeOverride(name="idPelicula", column=@Column(name="idPelicula")),
	})
	private AlquilerId idCompuesta;
	private String fechaAlquiler;
	private String fechaRetorno;
	
	public Alquiler() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Alquiler(String fechaAlquiler, String fechaRetorno) {
		super();
		this.fechaAlquiler = fechaAlquiler;
		this.fechaRetorno = fechaRetorno;
	}

	
	public AlquilerId getIdCompuesta() {
		return idCompuesta;
	}

	public void setIdCompuesta(AlquilerId idCompuesta) {
		this.idCompuesta = idCompuesta;
	}

	public String getFechaAlquiler() {
		return fechaAlquiler;
	}

	public void setFechaAlquiler(String fechaAlquiler) {
		this.fechaAlquiler = fechaAlquiler;
	}

	public String getFechaRetorno() {
		return fechaRetorno;
	}

	public void setFechaRetorno(String fechaRetorno) {
		this.fechaRetorno = fechaRetorno;
	}

	@Override
	public String toString() {
		return "Alquiler [fechaAlquiler=" + fechaAlquiler + ", fechaRetorno=" + fechaRetorno + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaAlquiler, fechaRetorno);
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
		return Objects.equals(fechaAlquiler, other.fechaAlquiler) && Objects.equals(fechaRetorno, other.fechaRetorno);
	}
	
	
	
}
