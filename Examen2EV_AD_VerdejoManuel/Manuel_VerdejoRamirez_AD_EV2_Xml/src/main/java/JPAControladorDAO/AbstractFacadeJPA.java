package JPAControladorDAO;

import jakarta.persistence.EntityManager;

public interface AbstractFacadeJPA<T> {

	Boolean create(T entity);
	
	Boolean update(T entity);
	
	void remove(T entity);
	
	T find(Object id);
	
	EntityManager getEm();
	
}
