package ejercicio2;

public class HiloTabla extends Thread {

	private Tabla tabla;
	private int siguiente;

	public HiloTabla(Tabla tabla) {
		this.tabla = tabla;
		this.siguiente = tabla.getSiguiente();
	}

	@Override
	public void run() {
		while (siguiente < tabla.getTabla().length) {
			if (tabla.isEstaLlena()) {
				leer();
			} else {
				tabla.annadirATabla((char) ((int) (Math.random() * 255 + 1)));
				siguiente = tabla.getSiguiente();
				tabla.setSiguiente(siguiente--);
				try {
					sleep((int) (Math.random() * 6000 + 4000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public synchronized void leer() {
		tabla.leeDeTabla();
		try {
			sleep((int) (Math.random() * 6000 + 4000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		siguiente = tabla.getSiguiente();
		tabla.setSiguiente(siguiente++);

	}
}
