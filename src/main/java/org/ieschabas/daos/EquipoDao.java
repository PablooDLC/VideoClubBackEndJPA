package org.ieschabas.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.PropertyConfigurator;
import org.ieschabas.clases.Equipo;
import org.jboss.logging.Logger;

public class EquipoDao {

	private static final Logger LOGGER = Logger.getLogger(EquipoDao.class);
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

	public static void guardarEquipo(Equipo equipo) {

		setUp();
		
		if(equipo.getId() != 0) {
			equipo = em.merge(equipo);
		}
		em.persist(equipo);

		close();

	}

	public static void eliminarEquipo(Equipo equipo) {
		setUp();

		equipo = em.merge(equipo);
		em.remove(equipo);

		close();
	}

	public static List<Equipo> ObtenerEquipo() {
		setUp();

		List<Equipo> equipos = em.createQuery(SQL_BUSQUEDA_EVENTO, Equipo.class).getResultList();

		if (equipos.isEmpty()) {
			LOGGER.info("No hay datos en la tabla equipo");
		} else {
			for (Equipo equipo : equipos) {
				LOGGER.info(equipo.getId() + "--" + equipo.getNombre() + "--" + equipo.getApellidos() + "--"
						+ equipo.getAnyoNac() + "--" + equipo.getPais() + "--" + equipo.getRol());
			}
		}

		close();

		return equipos;

	}
	
	public static void modificarEquipo(Equipo equipo) {
		
		setUp();
		
		eliminarEquipo(equipo);
		
		if(equipo.getId() != 0) {
			equipo = em.merge(equipo);
		}
		em.persist(equipo);
		
		close();
		
	}
}
