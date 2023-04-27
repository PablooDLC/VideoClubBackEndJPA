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

		List<Equipo> equipo = new ArrayList<Equipo>();

		Equipo actor = new Actor("Pablo", "DeLa", 1414, "esp");
		equipo.add(actor);
		EquipoDao.guardarEquipo(actor);
		Equipo director = new Director("Pepe", "Alonso", 3333, "esp");
		equipo.add(director);
		EquipoDao.guardarEquipo(director);

		Pelicula pelicula = new Pelicula("Pelicula1", "La primera", 2023, "2h", Categoria.CIENCIAFICCION, Formato.FLV,
				Valoracion.CINCO);
		pelicula.setEquipo(equipo);
		PeliculaDao.guardarPelicula(pelicula);
		;

		LOGGER.info("Inicio de la aplicacion");

	}

}
