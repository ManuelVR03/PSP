package ejercicio11_banco_uso_bloqueoConObject;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*clase que crea las cuentas*/
public class Banco {
	private final Double[] cuentas;

	public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, Double cantidad)
			throws InterruptedException {

		while (cuentas[cuentaOrigen] < cantidad) {
			wait();
		}
		System.out.println(Thread.currentThread());
		cuentas[cuentaOrigen] -= cantidad;
		System.out.printf("%10.2f de %d para %d%n", cantidad, cuentaOrigen, cuentaDestino);
		cuentas[cuentaDestino] += cantidad;
		System.out.printf("Saldo total: %10.2f%n", this.getSaldoTotal());
		notifyAll();

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
	}

	public Double[] getCuentas() {
		return cuentas;
	}

}
