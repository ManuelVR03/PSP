package JPAControladorDAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.UtilJPA;

public abstract class AbstractFacadeJPAImpl<T> implements AbstractFacadeJPA<T>{

	private Class<T> entityClass;
	private EntityManager em;
	
	public AbstractFacadeJPAImpl(Class<T> entityClass) {
		this.entityClass = entityClass;
		em = UtilJPA.getEntityManager();
	}
	
	@Override
	public Boolean create(T entity) {
		em.getTransaction().begin();
		try {
			em.persist(entity);
			em.getTransaction().commit();
			return true;
		}catch(Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ha ocurrido un error al GUARDAR, clave duplicada");
			return false;
		}
		
	}
	
	@Override
	public Boolean update(T entity) {
		em.getTransaction().begin();
		try {
			em.merge(entity);
			em.getTransaction().commit();
			System.out.println(entity + " Actualización exitosa");
			return true;
		}catch(Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ha ocurrido un error al actualizar");
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public void remove(T entity) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(entity));
		tx.commit();
	}
	
	@Override
	public T find(Object id) {
		return em.find(entityClass, id);
	}

	@Override
	public EntityManager getEm() {
		return em;
	}
}


