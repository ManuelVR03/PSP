package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class UtilJPA {

	private static final EntityManager em;

	static {
		try {
			em = Persistence.createEntityManagerFactory("Persistencia").createEntityManager();
		} catch (Throwable t) {
			System.out.println("Error al inicializar el Entity Manager " + t);
			t.printStackTrace();
			throw new ExceptionInInitializerError();
		}
	}

	public static EntityManager getEntityManager() {
		return em;
	}

}
