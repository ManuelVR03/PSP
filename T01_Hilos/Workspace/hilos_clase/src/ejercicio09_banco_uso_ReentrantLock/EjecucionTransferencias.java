package ejercicio09_banco_uso_ReentrantLock;

public class EjecucionTransferencias implements Runnable {
    private Banco banco;
    private Integer cuentaOrigen;
    private Double cantidadMaxima;
	
	//la cuenta destino será aleatoria y la cantidad a transferir también
	public EjecucionTransferencias(Banco banco, Integer cuentaOrigen, Double cantidadMaxima) {
		super();
		this.banco = banco;
		this.cuentaOrigen = cuentaOrigen;
		this.cantidadMaxima = cantidadMaxima;
	}

    //método que ejecuta cada hilo
	@Override
	public void run() {
		try {
			while(true) {
				
				//la cuenta destino va a ser aleatoria (entre 0 y 100)
				//La cantidad a mover será aleatoria entre la cantidadMaxima
               
				//el retardo se retarda en 0 y 10 milisegundos
				Integer cuentaDestino=(int)(100*Math.random());
				Double cantidad=cantidadMaxima*Math.random();
				banco.transferencia(cuentaOrigen, cuentaDestino, cantidad);
			
			
				Thread.sleep((int)(Math.random()*10));
			
		}
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

}
