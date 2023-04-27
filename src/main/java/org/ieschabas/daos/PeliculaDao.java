package org.ieschabas.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.PropertyConfigurator;
import org.ieschabas.clases.Pelicula;
import org.jboss.logging.Logger;

public class PeliculaDao {

	private static final Logger LOGGER = Logger.getLogger(PeliculaDao.class);
	private static EntityManager em;
	private static EntityManagerFactory emf;
	private static final String SQL_BUSQUEDA_EVENTO = "SELECT e FROM videoClub e";

	private static void setUp() {
		emf = Persistence.createEntityManagerFactory("videoClub");
		em = emf.createEntityManager();
		em.getTransaction().begin();

		// Indicamos al logger el fichero propiedades

		PropertyConfigurator.configure("src/main/resources/log4.properties");
	}

	private static void close() {
		em.getTransaction().commit();
		em.close();
	}

	public static void guardarPelicula(Pelicula pelicula) {

		setUp();

		if(pelicula.getId() != 0) {
			pelicula = em.merge(pelicula);
		}
		em.persist(pelicula);

		// LOGGER.info("Identificador de la pelicula: " + pelicula.getId());

		close();

	}

	public static void eliminarPelicula(Pelicula pelicula) {
		setUp();

		pelicula = em.merge(pelicula);
		em.remove(pelicula);

		close();
	}

	public static List<Pelicula> ObtenerPelicula() {
		setUp();

		List<Pelicula> peliculas = em.createQuery(SQL_BUSQUEDA_EVENTO, Pelicula.class).getResultList();

		if (peliculas.isEmpty()) {
			LOGGER.info("No hay datos en la tabla equipo");
		} else {
			for (Pelicula pelicula : peliculas) {
				LOGGER.info(pelicula.getId() + "--" + pelicula.getTitulo() + "--" + pelicula.getDescripcion() + "--"
						+ pelicula.getDuracion() + "--" + pelicula.getAñopublicacion() + pelicula.getCategoria() + "--"
						+ pelicula.getFormato() + "--" + pelicula.getValoracion());
			}
		}

		close();

		return peliculas;

	}
}
