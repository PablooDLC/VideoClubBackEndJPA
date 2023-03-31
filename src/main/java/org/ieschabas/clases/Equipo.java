package org.ieschabas.clases;

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
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
public class Equipo {

	private int id;
	private String nombre;
	private String apellidos;
	private int anyoNac;
	private String pais;
	private String rol;

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
	@Column(name = "id")
	public int getId() {
		return id;
	}

	/**
	 * Establece el campo
	 * 
	 * @param id
	 */
	public void setId(int id) {
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
	
	

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public int hashCode() {
		return Objects.hash(anyoNac, apellidos, id, nombre, pais);
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
				&& Objects.equals(nombre, other.nombre) && Objects.equals(pais, other.pais);
	}

	@Override
	public String toString() {
		return "Equipo [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", anyoNac=" + anyoNac
				+ ", pais=" + pais + "]";
	}
	
	

}