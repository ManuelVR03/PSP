package ejercicio2;

public class Tabla {

	private char[] tabla;
	private int siguiente;
	private boolean estaVacia;
	private boolean estaLlena;

	public Tabla(int tamanio) {
		this.tabla = new char[tamanio];
		this.siguiente = 0;
		this.estaVacia = true;
		this.estaLlena = false;
	}
	
	

	public char[] getTabla() {
		return tabla;
	}



	public void setTabla(char[] tabla) {
		this.tabla = tabla;
	}



	public int getSiguiente() {
		return siguiente;
	}



	public void setSiguiente(int siguiente) {
		this.siguiente = siguiente;
	}



	public boolean isEstaVacia() {
		return estaVacia;
	}



	public void setEstaVacia(boolean estaVacia) {
		this.estaVacia = estaVacia;
	}



	public boolean isEstaLlena() {
		return estaLlena;
	}



	public void setEstaLlena(boolean estaLlena) {
		this.estaLlena = estaLlena;
	}



	public char leeDeTabla() {
		System.out.println("Valor leído: " + tabla[siguiente]);
		this.estaLlena = false;
		if(siguiente < 0)
			this.siguiente = 0;
		return tabla[siguiente];
	}

	public void annadirATabla(char c) {
		System.out.println("Valor insertado: " + c);
		this.estaLlena = true;
		if(siguiente < 0)
			this.siguiente = 0;
		tabla[siguiente] = c;
	}

}
