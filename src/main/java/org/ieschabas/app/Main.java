package org.ieschabas.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.text.DateFormatter;

import org.ieschabas.clases.Actor;
import org.ieschabas.clases.Alquiler;
import org.ieschabas.clases.Cliente;
import org.ieschabas.clases.Director;
import org.ieschabas.clases.Equipo;
import org.ieschabas.clases.Pelicula;
import org.ieschabas.clases.Usuario;
import org.ieschabas.daos.AlquilerDao;
import org.ieschabas.daos.EquipoDao;
import org.ieschabas.daos.PeliculaDao;
import org.ieschabas.daos.UsuariosDao;
import org.jboss.logging.Logger;

public class Main {

	private static final Logger LOGGER = Logger.getLogger(Main.class);

	public static void main(String[] args) {

		Pelicula pelicula1 = new Pelicula("HOLA", "dddd", 2023, "2h", null, null, null);
		PeliculaDao.guardarPelicula(pelicula1);
		
		Equipo actor1 = new Actor("EEE", "La", 2033, "esp");
		EquipoDao.guardarEquipo(actor1);
		Equipo director1 = new Director("RR", "Cerv", 2222, "eng");
		EquipoDao.guardarEquipo(director1);
		
		Usuario cliente1 = new Cliente("asdas", "De", "Calle calle", true, "12-12-12");
		UsuariosDao.guardarUsuario(cliente1);
		

		
		//Alquiler alquiler1 = new Alquiler(pelicula1, cliente1, new Date(24-24-24), new Date(23-23-23));
		//AlquilerDao.guardarAlquiler(alquiler1);
	
		
		LOGGER.info("Inicio de la aplicacion");

		
	}

}
