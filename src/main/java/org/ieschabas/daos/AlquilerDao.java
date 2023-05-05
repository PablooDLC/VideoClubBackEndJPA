package org.ieschabas.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.ieschabas.clases.Alquiler;
import org.ieschabas.clases.Pelicula;
import org.jboss.logging.Logger;

public class AlquilerDao {

	private static final Logger LOGGER = Logger.getLogger(PeliculaDao.class);
	private static EntityManager em;
	private static EntityManagerFactory emf;
	private static final String SQL_BUSQUEDA_ALQUILER = "Select a FROM Alquiler a";
	
	private static void setUp() {
		emf = Persistence.createEntityManagerFactory("videoClub");
		em = emf.createEntityManager();
		em.getTransaction().begin();
	}
	
	private static void close() {
		em.getTransaction().commit();
		em.close();
	}
	
	public static void guardarAlquiler(Alquiler alquiler) {
		
		setUp();
		
		if(alquiler.getIdCompuesta() != null) {
			alquiler = em.merge(alquiler);
		}
		em.persist(alquiler);
		
		close();
	}
	
	public static void eliminarAlquiler(Alquiler alquiler) {
		
		setUp();
		
		alquiler = em.merge(alquiler);
		em.remove(alquiler);
		
		close();
	}
	
	public static List<Alquiler> obtenerAlquiler() {
		
		setUp();
		
		List<Alquiler> alquileres = em.createQuery(SQL_BUSQUEDA_ALQUILER, Alquiler.class).getResultList();

		if (alquileres.isEmpty()) {
			LOGGER.info("No hay datos en la tabla alquiler");
		} else {
			for (Alquiler alquiler : alquileres) {
				LOGGER.info(alquiler.getIdCompuesta() + "--" + alquiler.getIdAlquiler() + "--" + alquiler.getFechaRetorno());
			}
		}
		
		close();
		
		return alquileres;
	}
	
	public static void modificarPelicula(Alquiler alquiler) {
		
		setUp();
		
		alquiler = em.find(Alquiler.class, alquiler.getIdCompuesta());
		
		if(alquiler.getIdCompuesta() != null) {
			alquiler = em.merge(alquiler);
		}
		em.persist(alquiler);
		
		close();
	}
}
