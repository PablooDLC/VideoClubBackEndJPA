package org.ieschabas.app;

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

		Pelicula pelicula = new Pelicula("Hola", "adiossssss", 2000, "2h", Categoria.ACCION, Formato.DIVX, Valoracion.CINCO);
        PeliculaDao.guardarPelicula(pelicula);;
        
        Equipo actor = new Actor("Pablo", "DeLa", 3333, "esp");
        Equipo director = new Director("Fernando", "Alonso", 1433, "esp");
        EquipoDao.guardarEquipo(actor);
        EquipoDao.guardarEquipo(director);

        LOGGER.info("Inicio de la aplicacion");

	}

}
