package org.ieschabas.clases;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Cliente")
public class Cliente extends Usuario {

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(String nombre, String apellidos, String direccion, boolean activo, String fechaRegistro) {
		super(nombre, apellidos, direccion, activo, fechaRegistro);
		// TODO Auto-generated constructor stub
	}

	
}
