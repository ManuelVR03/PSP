package ejercicio2;

public class Test {

	/*
	 * Crear un programa en Java en consola con dos hilos de ejecución tal que lean
	 * datos del mismo fichero ejercicio2.txt. Los datos se tienen que leer línea a
	 * línea. Se impone la restricción de que solo un hilo puede estar haciendo una
	 * lectura del fichero a la vez, por lo que hay bloquear sólo ese código. El
	 * primer hilo muestre los datos de la línea que lee en mayúsculas y el segundo
	 * muestre los datos de la línea que lee en minúsculas .
	 */

	public static void main(String[] args) {
		HiloLectura mayuscula = new HiloLectura();
		HiloLectura minuscula = new HiloLectura();
		mayuscula.setName("hiloMY");
		
		mayuscula.start();
		minuscula.start();

	}

}
