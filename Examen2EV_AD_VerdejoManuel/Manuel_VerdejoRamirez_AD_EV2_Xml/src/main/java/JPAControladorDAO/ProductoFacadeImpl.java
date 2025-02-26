package JPAControladorDAO;

import java.util.List;

import entidades.Producto;
import jakarta.persistence.TypedQuery;

public class ProductoFacadeImpl extends AbstractFacadeJPAImpl<Producto> implements ProductoFacade{
	public ProductoFacadeImpl() {
		super(Producto.class);
	}
	
	@Override
	public List<Producto> mostrarTodos(){
		TypedQuery<Producto> q = getEm().createQuery("SELECT p FROM Producto AS p", Producto.class);
		return q.getResultList();
	}

}
