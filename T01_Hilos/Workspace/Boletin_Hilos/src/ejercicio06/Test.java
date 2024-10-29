package ejercicio06;

public class Test {

	public static void main(String[] args) {
		int vector [] = new int [500];
		int max = 0;
		long startTime;
		long endTime;
		
		for(int i = 0; i < vector.length; i++)
			vector[i] = (int) (Math.floor(Math.random()*1000) + 1);

		startTime = System.currentTimeMillis();
		for(int i = 0; i < vector.length; i++)
			if (max < vector[i])
				max = vector[i];
		endTime = System.currentTimeMillis();
		
		System.out.println("El mayor es: " + max);
		System.out.println("Se ha encontrado en: " + (endTime - startTime) + "s");
		
		HiloVector hilo1 = new HiloVector(vector, 0, vector.length/2);
		HiloVector hilo2 = new HiloVector(vector, vector.length/2+1, vector.length);
		
		startTime = System.currentTimeMillis();
		hilo1.start();
		hilo2.start();
		try {
			hilo1.join();
			hilo2.join();
		}catch(InterruptedException e) {
			e.getMessage();
		}
		endTime = System.currentTimeMillis();
		
		if(hilo1.getMax() > hilo2.getMax())
			System.out.println("El mayor está en la primera mitad y es: " + hilo1.getMax());
		else
			System.out.println("El mayor está en la segunda mitad y es: " + hilo2.getMax());
		System.out.println("Se ha tardado con los hilos: " + (endTime-startTime) + "s");
		
			
	}

}
