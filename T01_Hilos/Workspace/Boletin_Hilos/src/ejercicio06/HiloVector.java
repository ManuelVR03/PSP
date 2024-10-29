package ejercicio06;

public class HiloVector extends Thread{
	
	private int [] vector;
	private int start;
	private int fin;
	private int max;
	
	public HiloVector(int [] vector, int start, int fin) {
		this.vector = vector;
		this.start = start;
		this.fin = fin;
		this.max = 0;
		
	}
	
	public int getMax() {
		return this.max;
	}
	
	public void run() {
		for(int i = start; i < fin; i++)
			if(max < vector[i])
				max = vector[i];
		
	}

}
