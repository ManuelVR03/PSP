package JPAControladorDAO;

import java.util.List;

import entidades.Producto;

public interface ProductoFacade extends AbstractFacadeJPA<Producto>{
	public List<Producto> mostrarTodos();

}
