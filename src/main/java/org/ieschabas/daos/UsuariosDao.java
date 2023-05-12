package org.ieschabas.daos;

import org.ieschabas.clases.Usuario;
import org.jboss.logging.Logger;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UsuariosDao {

	private static final Logger LOGGER = Logger.getLogger(UsuariosDao.class);
	private static EntityManager em;
	private static EntityManagerFactory emf;
	private static final String QUERY_BUSQUEDA_USUARIO = "SELECT u FROM Usuario u";

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

	public static void guardarUsuario(Usuario usuario) {

		setUp();

		if (usuario.getId() != 0) {
			usuario = em.merge(usuario);
		}
		em.persist(usuario);

		close();

	}

	public static void eliminarUsuario(Usuario usuario) {
		setUp();

		if (usuario.getId() != 0) {
			usuario = em.merge(usuario);
		}
		em.remove(usuario);

		close();
	}

	public static List<Usuario> obtenerUsuario() {
		setUp();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios = em.createQuery(QUERY_BUSQUEDA_USUARIO, Usuario.class).getResultList();

		if (usuarios.isEmpty()) {
			LOGGER.info("No hay datos en la tabla usuarios");
		} else {
			for (Usuario usuario : usuarios) {
				LOGGER.info(usuario.getId() + "--");
			}
		}

		close();

		return usuarios;

	}
	
	public static Usuario recuperarUsuario(long id) {
		
		setUp();
		
		Usuario usuario = em.find(Usuario.class, id);
		
		close();
		
		return usuario;
	}
}
