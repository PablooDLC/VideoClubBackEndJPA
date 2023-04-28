package org.ieschabas.app;

import java.util.ArrayList;
import java.util.List;

import org.ieschabas.clases.Actor;
import org.ieschabas.clases.Director;
import org.ieschabas.clases.Equipo;
import org.ieschabas.clases.Pelicula;
import org.ieschabas.daos.EquipoDao;
import org.ieschabas.daos.PeliculaDao;
import org.ieschabas.enums.Categoria;
import org.ieschabas.enums.Formato;
import org.ieschabas.enums.Valoracion;
import org.jboss.logging.Logger;

public class Main {

	private static final Logger LOGGER = Logger.getLogger(Main.class);

	public static void main(String[] args) {

		Pelicula pelicula1 = new Pelicula("Pelicula1", "EEEEE", 2023, "2h", null, null, null);
		PeliculaDao.guardarPelicula(pelicula1);
		
		LOGGER.info("Inicio de la aplicacion");

	}

}
