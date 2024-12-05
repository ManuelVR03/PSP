package ejercicio2;

public class Test {

	public static void main(String[] args) {
		
		Tabla tabla = new Tabla(10);
		HiloTabla hilo1 = new HiloTabla(tabla);
		HiloTabla hilo2 = new HiloTabla(tabla);
		hilo1.start();
		hilo2.start();

	}

}
