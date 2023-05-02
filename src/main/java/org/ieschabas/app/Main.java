package org.ieschabas.app;

import java.util.ArrayList;
import java.util.List;

import org.ieschabas.clases.Actor;
import org.ieschabas.clases.Alquiler;
import org.ieschabas.clases.Cliente;
import org.ieschabas.clases.Director;
import org.ieschabas.clases.Equipo;
import org.ieschabas.clases.Pelicula;
import org.ieschabas.clases.Usuario;
import org.ieschabas.daos.EquipoDao;
import org.ieschabas.daos.PeliculaDao;
import org.ieschabas.daos.UsuariosDao;
import org.ieschabas.enums.Categoria;
import org.ieschabas.enums.Formato;
import org.ieschabas.enums.Valoracion;
import org.jboss.logging.Logger;

public class Main {

	private static final Logger LOGGER = Logger.getLogger(Main.class);

	public static void main(String[] args) {

		Pelicula pelicula1 = new Pelicula("Pelicula1", "EEEEE", 2023, "2h", null, null, null);
		PeliculaDao.guardarPelicula(pelicula1);
		
		Equipo actor1 = new Actor("Pablo", "La", 2033, "esp");
		EquipoDao.guardarEquipo(actor1);
		Equipo director1 = new Director("Javi", "Cerv", 2222, "eng");
		EquipoDao.guardarEquipo(director1);
		
		Alquiler alquiler1 = new Alquiler("02-05-23", "04-05-23");
		
		Usuario cliente1 = new Cliente("Pepe", "De", "Calle calle", true, "12-12-12");
		UsuariosDao.guardarUsuario(cliente1);
		
		LOGGER.info("Inicio de la aplicacion");

	}

}
