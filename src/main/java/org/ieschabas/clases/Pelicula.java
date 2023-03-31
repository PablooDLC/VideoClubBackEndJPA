package org.ieschabas.clases;

import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import org.ieschabas.enums.Categoria;
import org.ieschabas.enums.Formato;
import org.ieschabas.enums.Valoracion;

/**
 * Esta clase funciona para recoger y establecer ocho campos.
 * 
 * @author alumno
 *
 */

@Entity
public class Pelicula {

	private int id;
	private String titulo;
	private String descripcion;
	private int añopublicacion;
	private String duracion;
	private Categoria categoria;
	private Formato formato;
	private Valoracion valoracion;
	private List<PeliculaActor> relPeliculaActor;
	private List<PeliculaDirector> relPeliculaDirector;

	/**
	 * Constructor vacio
	 */
	public Pelicula() {
		super();
	}

	/**
	 * Constructor sobrecargado
	 * 
	 * @param id
	 * @param titulo
	 * @param descripcion
	 * @param añopublicacion
	 * @param duracion
	 * @param categoria
	 * @param formato
	 * @param valoracion
	 */
	public Pelicula(String titulo, String descripcion, int añopublicacion, String duracion, Categoria categoria,
			Formato formato, Valoracion valoracion) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.añopublicacion = añopublicacion;
		this.duracion = duracion;
		this.categoria = categoria;
		this.formato = formato;
		this.valoracion = valoracion;
	}

	/**
	 * Recoge el campo
	 * 
	 * @return
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Recoge el campo
	 * 
	 * @return
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Establece el campo
	 * 
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Recoge el campo
	 * 
	 * @return
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece el campo
	 * 
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Recoge el campo
	 * 
	 * @return
	 */
	public int getAñopublicacion() {
		return añopublicacion;
	}

	/**
	 * Establece el campo
	 * 
	 * @param añopublicacion
	 */
	public void setAñopublicacion(int añopublicacion) {
		this.añopublicacion = añopublicacion;
	}

	/**
	 * Recoge el campo
	 * 
	 * @return
	 */
	public String getDuracion() {
		return duracion;
	}

	/**
	 * Establece el campo
	 * 
	 * @param duracion
	 */
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	/**
	 * Recoge el campo
	 * 
	 * @return
	 */
	
	@Enumerated(EnumType.STRING)
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * Establece el campo
	 * 
	 * @param string
	 */
	public void setCategoria(Categoria string) {
		this.categoria = string;
	}

	/**
	 * Recoge el campo
	 * 
	 * @return
	 */
	@Enumerated(EnumType.STRING)
	public Formato getFormato() {
		return formato;
	}

	/**
	 * Establece el campo
	 * 
	 * @param string
	 */
	public void setFormato(Formato string) {
		this.formato = string;
	}

	/**
	 * Recoge el campo
	 * 
	 * @return
	 */
	@Enumerated(EnumType.STRING)
	public Valoracion getValoracion() {
		return valoracion;
	}

	/**
	 * Establece el campo
	 * 
	 * @param valoracion
	 */
	public void setValoracion(Valoracion valoracion) {
		this.valoracion = valoracion;
	}

	public List<PeliculaActor> getRelPeliculaActor() {
		return relPeliculaActor;
	}

	public void setRelPeliculaActor(List<PeliculaActor> relPeliculaActor) {
		this.relPeliculaActor = relPeliculaActor;
	}

	public List<PeliculaDirector> getRelPeliculaDirector() {
		return relPeliculaDirector;
	}

	public void setRelPeliculaDirector(List<PeliculaDirector> relPeliculaDirector) {
		this.relPeliculaDirector = relPeliculaDirector;
	}

	@Override
	public int hashCode() {
		return Objects.hash(añopublicacion, categoria, descripcion, duracion, formato, id, titulo, valoracion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelicula other = (Pelicula) obj;
		return añopublicacion == other.añopublicacion && categoria == other.categoria
				&& Objects.equals(descripcion, other.descripcion) && Objects.equals(duracion, other.duracion)
				&& formato == other.formato && id == other.id && Objects.equals(titulo, other.titulo)
				&& valoracion == other.valoracion;
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", añopublicacion="
				+ añopublicacion + ", duracion=" + duracion + ", categoria=" + categoria + ", formato=" + formato
				+ ", valoracion=" + valoracion + "]";
	}
	
	

}
