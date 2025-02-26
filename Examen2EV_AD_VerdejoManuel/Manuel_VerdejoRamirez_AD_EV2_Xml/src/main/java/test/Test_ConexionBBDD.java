package test;

import java.io.File;

import JPAControladorDAO.ProductoFacadeImpl;
import entidades.Producto;
import entidades.ProductoD;
import entidades.ProductoN;
import entidades.ProductosDiciembre;
import entidades.ProductosNoviembre;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

public class Test_ConexionBBDD {

	public static void main(String[] args) throws JAXBException {
		ProductoFacadeImpl pf = new ProductoFacadeImpl();
		JAXBContext context = JAXBContext.newInstance(ProductosNoviembre.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		ProductosNoviembre productosN = (ProductosNoviembre) unmarshaller.unmarshal(new File("./Fuentes/datos_noviembre.xml"));
		for (ProductoN n: productosN.getProductosN()) {
			Producto p = new Producto();
			p.setIdRef(n.getIdref());
			p.setCategoria(null);
			p.setMarca(null);
			p.setNombre(n.getNombre());
			p.setPais(n.getPais());
			p.setProveedor(n.getProveedor());
			pf.create(p);
		}
		context = JAXBContext.newInstance(ProductosDiciembre.class);
		unmarshaller = context.createUnmarshaller();
		ProductosDiciembre productosD = (ProductosDiciembre) unmarshaller.unmarshal(new File("./Fuentes/datos_diciembre.xml"));
		for (ProductoD d: productosD.getProductosD()) {
			Producto p = new Producto();
			p.setIdRef(d.getIdref());
			p.setCategoria(d.getCategoria());
			p.setMarca(d.getMarca());
			p.setNombre(d.getNombre());
			p.setPais(null);
			p.setProveedor(null);
			pf.create(p);
		}
		for (Producto p: pf.mostrarTodos()) {
			System.out.println(p.toString());
		}
	}

}
