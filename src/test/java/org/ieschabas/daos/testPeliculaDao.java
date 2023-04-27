package org.ieschabas.daos;

import static org.junit.jupiter.api.Assertions.*;

import org.ieschabas.clases.Pelicula;
import org.ieschabas.enums.Categoria;
import org.ieschabas.enums.Formato;
import org.ieschabas.enums.Valoracion;
import org.junit.Test;

import junit.framework.Assert;

class testPeliculaDao {

	@Test
	void testGuardarPelicula() {
		
		Pelicula pelicula1 = new Pelicula("Peliceeela1", "La asdad", 2023, "2h", Categoria.CIENCIAFICCION, Formato.FLV,
				Valoracion.CINCO);
		Pelicula pelicula2 = new Pelicula("asass", "La wwww", 222, "2h", Categoria.CIENCIAFICCION, Formato.FLV,
				Valoracion.CINCO);
		
		assertEquals("asass", pelicula2.getTitulo());
		
	}
	
	@Test
	void buscarTest() {
	//	Pelicula pelicula = PeliculaDao.ObtenerPelicula();
	}

}
