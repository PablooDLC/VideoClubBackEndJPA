package org.ieschabas.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.ieschabas.clases.Equipo;

public class EquipoDao {

	private static final Logger LOGGER = Logger.getLogger(EquipoDao.class);
	private static EntityManager em;
	private static EntityManagerFactory emf;
	private static final String SQL_BUSQUEDA_EQUIPO = "SELECT e FROM Equipo e";
	private static final String SQL_BUSQUEDA_ACTOR = "SELECT e FROM Equipo e where rol =  : Actor";
	private static final String SQL_BUSQUEDA_DIRECTOR = "SELECT e FROM Equipo e where  rol = : Director";

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

	public static List<Equipo> obtenerActor(String rol) {
		setUp();

		List<Equipo> actores = em.createQuery(SQL_BUSQUEDA_ACTOR, Equipo.class).setParameter("Actor", rol).getResultList();

		if (actores.isEmpty()) {
			LOGGER.info("No hay datos en la tabla equipo");
		} else {
			for (Equipo equipo : actores) {
				LOGGER.info(equipo.getId() + "--" + equipo.getNombre() + "--" + equipo.getApellidos() + "--"
						+ equipo.getAnyoNac() + "--" + equipo.getPais() + "--" + equipo.getRol());
			}
		}

		close();

		return actores;

	}
	
	public static List<Equipo> obtenerDirector(String rol) {
		setUp();

		List<Equipo> directores = em.createQuery(SQL_BUSQUEDA_DIRECTOR, Equipo.class).setParameter("Director", rol).getResultList();

		if (directores.isEmpty()) {
			LOGGER.info("No hay datos en la tabla equipo");
		} else {
			for (Equipo equipo : directores) {
				LOGGER.info(equipo.getId() + "--" + equipo.getNombre() + "--" + equipo.getApellidos() + "--"
						+ equipo.getAnyoNac() + "--" + equipo.getPais() + "--" + equipo.getRol());
			}
		}

		close();

		return directores;

	}
	
	public static List<Equipo> obtenerEquipo() {
		setUp();

		List<Equipo> equipos = em.createQuery(SQL_BUSQUEDA_EQUIPO, Equipo.class).getResultList();

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

		equipo = em.merge(equipo);
		em.persist(equipo);
		
		close();
		
	}
}
