package org.ieschabas.clases;

import java.net.PasswordAuthentication;
import java.util.Objects;

import javax.persistence.*;
import javax.swing.JPasswordField;

@Entity
@DiscriminatorColumn(name = "rol", discriminatorType = DiscriminatorType.STRING)
public class Usuario {

	private long id;
	private String nombre;
	private String apellidos;
	private String email;
	private String password;
	private boolean activo;
	private String fechaRegistro;
	@Transient
	private transient String rol;
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(String nombre, String apellidos, String email, String password, boolean activo, String fechaRegistro) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	
	@Column(insertable = false, updatable = false)
	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public void imprimir() {
		System.out.println("------Usuario------");
		System.out.println("Id:\t\t" + this.id);
		System.out.println("Nombre:\t" + this.nombre);
		System.out.println("Apellidos:\t" + this.apellidos);
		System.out.println("Dirección:\t" + this.email);
		System.out.println("Activo:\t" + this.activo);
		System.out.println("Fecha de registro:\t" + this.fechaRegistro);
	}

	@Override
	public int hashCode() {
		return Objects.hash(activo, apellidos, email, fechaRegistro, id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return activo == other.activo && Objects.equals(apellidos, other.apellidos)
				&& Objects.equals(email, other.email) && Objects.equals(fechaRegistro, other.fechaRegistro)
				&& id == other.id && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email
				+ ", password= "+ password + ", activo=" + activo + ", fechaRegistro=" + fechaRegistro + "]";
	}	
	
}
