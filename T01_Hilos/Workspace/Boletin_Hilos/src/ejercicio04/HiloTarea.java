package ejercicio04;

class HiloTarea extends Thread {
	private static Object lock; // Objeto de bloqueo para sincronización
	private static int contador; // Contador de mensajes, comenzamos en 1
	private static String nombreHiloAnterior; // Almacena el mensaje del hilo anterior
	private Mensaje mensaje;

	public HiloTarea() {
		this.mensaje = new Mensaje();
		this.contador = 1;
		this.nombreHiloAnterior = "";
		this.lock = new Object();
	}

	@Override
	public void run() {
		while (contador <= 10) { // Limitar a 10 mensajes
			synchronized (lock) {
				System.out.println(getName() + mensaje.getContenido() + nombreHiloAnterior);
				nombreHiloAnterior = getName() + ": MSG" + contador;

				// Incrementar el contador solo después de que ambos hilos hayan impreso su
				// mensaje
				if (getName().equals("Thread-1")) {
					contador++; // Incrementamos después de que Thread-1 haya enviado su mensaje
				}

				lock.notify(); // Despertamos al otro hilo

				try {
					lock.wait(); // Esperamos nuestro turno
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 

			}

			try {
				Thread.sleep(3000); // Espera de 3 segundos entre mensajes
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}