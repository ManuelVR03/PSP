package ejercicio07_VR;

public class Test {

	public static void main(String[] args) {
		Hilo hilo0 = new Hilo("Hilo", "/home/usuario/DAM/PSP/T01_Hilos/Workspace/Boletin_Hilos/src/ejercicio07_VR");
		Hilo hilo1 = new Hilo("Palmera", "/home/usuario/DAM/PSP/T01_Hilos/Workspace/Boletin_Hilos/src/ejercicio07_VR");
		
		hilo0.start();
		hilo1.start();
	}

}
