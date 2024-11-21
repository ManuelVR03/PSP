package ejercicio_tienda_MJ;

public class FormalizarPago extends Thread{

	private Tienda tienda;
	private Cliente carroCliente;
	
	public FormalizarPago(Tienda tienda, Cliente carroCliente) {
		this.tienda = tienda;
		this.carroCliente = carroCliente;
	}
	
	@Override
	public synchronized void run() {
		try {
			Boolean resu = false, salida = false;
			
		}
	}
	
}
