package org.ieschabas.clases;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Admin")
public class Administrador extends Usuario{

	public Administrador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrador(String nombre, String apellidos, String direccion, boolean activo, String fechaRegistro) {
		super(nombre, apellidos, direccion, activo, fechaRegistro);
		// TODO Auto-generated constructor stub
	}

	
}
