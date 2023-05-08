package org.ieschabas.clases;

import java.util.List;
import java.util.Objects;

import javax.persistence.*;

/**
 * Esta clase funciona para recoger y establecer cinco campos.
 * 
 * @author alumno
 *
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "rol", discriminatorType = DiscriminatorType.STRING)
public class Equipo {

	private long id;
	private String nombre;
	private String apellidos;
	private int anyoNac;
	private String pais;
	@Transient
	private transient String rol;
	private List<Pelicula> actorPeli;
	private List<Pelicula> directorPeli;

	/**
	 * Constructor vacio
	 */
	
	public Equipo() {
		super();
	}

	/**
	 * Constructor sobrecargado
	 * 
	 * @param id
	 * @param nombre
	 * @param apellidos
	 * @param anyoNac
	 * @param pais
	 */
	public Equipo(String nombre, String apellidos, int anyoNac, String pais) {
		super();
		this.setNombre(nombre);
		this.setApellidos(apellidos);
		this.setAnyoNac(anyoNac);
		this.setPais(pais);
	}

	/**
	 * Recoge el campo
	 * 
	 * @return
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	/**
	 * Establece el campo
	 * 
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Recoge el campo
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el campo
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Recoge el campo
	 * 
	 * @return
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Establece el campo
	 * 
	 * @param apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Recoge el campo
	 * 
	 * @return
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * Establece el campo
	 * 
	 * @param pais
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * Recoge el campo
	 * 
	 * @return
	 */
	public int getAnyoNac() {
		return anyoNac;
	}

	/**
	 * Establece el campo
	 * 
	 * @param anyoNac
	 */
	public void setAnyoNac(int anyoNac) {
		this.anyoNac = anyoNac;
	}
	
	//@Enumerated(EnumType.STRING)
	
	@Column(insertable = false, updatable = false)
	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	@ManyToMany(mappedBy = "actores", fetch = FetchType.LAZY)
	public List<Pelicula> getActorPeli() {
		return actorPeli;
	}

	public void setActorPeli(List<Pelicula> actorPeli) {
		this.actorPeli = actorPeli;
	}

	@ManyToMany(mappedBy = "directores", fetch = FetchType.LAZY)
	public List<Pelicula> getDirectorPeli() {
		return directorPeli;
	}

	public void setDirectorPeli(List<Pelicula> directorPeli) {
		this.directorPeli = directorPeli;
	}

	@Override
	public int hashCode() {
		return Objects.hash(anyoNac, apellidos, id, nombre, pais, rol);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		return anyoNac == other.anyoNac && Objects.equals(apellidos, other.apellidos) && id == other.id
				&& Objects.equals(nombre, other.nombre) && Objects.equals(pais, other.pais)
				&& Objects.equals(rol, other.rol);
	}

	@Override
	public String toString() {
		return "Equipo [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", anyoNac=" + anyoNac
				+ ", pais=" + pais + ", rol=" + rol + "]";
	}
	
	

}
