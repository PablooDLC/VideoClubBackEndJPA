package org.ieschabas.daos;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.PropertyConfigurator;
import org.ieschabas.clases.Equipo;
import org.ieschabas.clases.Pelicula;
import org.ieschabas.enums.Categoria;
import org.ieschabas.enums.Formato;
import org.ieschabas.enums.Valoracion;
import org.jboss.logging.Logger;

public class PeliculaDao {

	private static final Logger LOGGER = Logger.getLogger(PeliculaDao.class);
	private static EntityManager em;
	private static EntityManagerFactory emf;
	private static final String SQL_BUSQUEDA_PELICULA = "SELECT p FROM Pelicula p";
	private static final String SQL_BUSQUEDA_PELICULA_TITULO = "SELECT p FROM Pelicula p where titulo = : titulo";

	private static void setUp() {
		emf = Persistence.createEntityManagerFactory("videoClub");
		em = emf.createEntityManager();
		em.getTransaction().begin();

		// Indicamos al logger el fichero propiedades

		//PropertyConfigurator.configure("src/main/resources/log4.properties");
	}

	private static void close() {
		em.getTransaction().commit();
		em.close();
	}

	public static void guardarPelicula(Pelicula pelicula) {

		setUp();

		if (pelicula.getId() != 0) {
			pelicula = em.merge(pelicula);
		}
		em.persist(pelicula);

		close();

	}

	public static void eliminarPelicula(Pelicula pelicula) {
		setUp();

		pelicula = em.merge(pelicula);
		em.remove(pelicula);

		close();
	}

	public static List<Pelicula> obtenerPelicula() {
		setUp();

		List<Pelicula> peliculas = em.createQuery(SQL_BUSQUEDA_PELICULA, Pelicula.class).getResultList();

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

	public static Pelicula obtenerPeliculaPorTitulo(String titulo) {
		setUp();

		Pelicula pelicula = em.createQuery(SQL_BUSQUEDA_PELICULA_TITULO, Pelicula.class).setParameter("titulo", titulo).getSingleResult();

		close();
		return pelicula;
	}

	public static List<Equipo> obtenerActorPorPelicula(Pelicula pelicula) {

		setUp();
		List<Equipo> actores = em.createQuery("SELECT a FROM Equipo a JOIN a.titulo p WHERE p = :titulo", Equipo.class).setParameter("pelicula", pelicula).getResultList();
		close();
		return actores;
	}

	public static void modificarPelicula(Pelicula pelicula) {

		setUp();

		pelicula = em.merge(pelicula);
		em.persist(pelicula);

		close();
	}
}
