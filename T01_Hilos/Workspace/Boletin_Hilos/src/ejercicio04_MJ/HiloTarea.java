package ejercicio04_MJ;

public class HiloTarea extends Thread{

	private Mensaje mensaje;
	
	public HiloTarea(Mensaje m) {
		this.mensaje=m;
	}
	
	public void run() {
		for(int i = 1; i <= 10; i++) {
			synchronized (this.mensaje) {
				System.out.println(this.getName() + " enterado del mensaje de: " + this.mensaje.getMensaje());
				this.mensaje.setMensaje(this.getName() + ": MSG" + i);
			}
			try {
				sleep(3000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
