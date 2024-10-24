package ejercicio10_banco_uso_bloqueoConCondicion;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*clase que crea las cuentas*/
public class Banco {
	private final Double[] cuentas; // array donde se guarda el saldo de cada cuenta
	// creo un atributo para hacer uso del bloqueo de hilo
	private Lock cierreBanco;
	private Condition saldoSuficiente;

	public void transferencia(int cuentaOrigen, int cuentaDestino, Double cantidad) throws InterruptedException {
		// bloquea un trozo de código del programa
		// para que sólo pueda ser ejecutado por un único hilo simultáneamente
		cierreBanco.lock();
		try {
				while (cuentas[cuentaOrigen] < cantidad) {
					//quitamos el return; porque queremos que todas las transferencias.
					//se realicen pone un hilo a la espera y
					//desbloquea el código para que pueda entrar otro hilo.
					saldoSuficiente.await();
				}
			System.out.println(Thread.currentThread());
			cuentas[cuentaOrigen] -= cantidad;
			System.out.printf("%10.2f de %d para %d%n", cantidad, cuentaOrigen, cuentaDestino);
			cuentas[cuentaDestino] += cantidad;
			System.out.printf("Saldo total: %10.2f%n", this.getSaldoTotal());
			//informa a todos los hilos para que despierten los hilos que están a la espera
			saldoSuficiente.signalAll();
		} finally {
			cierreBanco.unlock();
			// desbloquea el código
		}
	}

	public Double getSaldoTotal() {
		Double suma_cuentas = 0.0;

		for (Double a : cuentas) {
			suma_cuentas += a;
		}
		return suma_cuentas;
	}

	public Banco() {
		// inicialmente a cada cuenta se le asignan 2000 euros
		// en el banco hay 100 cuentas
		cuentas = new Double[100];
		for (int i = 0; i < cuentas.length; i++) {
			cuentas[i] = 2000.0;
		}
		cierreBanco = new ReentrantLock();
		saldoSuficiente = cierreBanco.newCondition();
	}

	public Double[] getCuentas() {
		return cuentas;
	}

}
