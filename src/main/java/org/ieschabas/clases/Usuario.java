package org.ieschabas.clases;

import javax.persistence.*;

@Entity
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
public class Usuario {

	private long id;
	private String nombre;
	private String apellidos;
	private String direccion;
	private boolean activo;
	private String fechaRegistro;
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(String nombre, String apellidos, String direccion, boolean activo, String fechaRegistro) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.activo = activo;
		this.fechaRegistro = fechaRegistro;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	public void imprimir() {
		System.out.println("------Usuario------");
		System.out.println("Id:\t\t" + this.id);
		System.out.println("Nombre:\t" + this.nombre);
		System.out.println("Apellidos:\t" + this.apellidos);
		System.out.println("Dirección:\t" + this.direccion);
		System.out.println("Activo:\t" + this.activo);
		System.out.println("Fecha de registro:\t" + this.fechaRegistro);
	}
}
