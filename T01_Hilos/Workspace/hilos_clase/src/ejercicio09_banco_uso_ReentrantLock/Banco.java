package ejercicio09_banco_uso_ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*clase que crea las cuentas*/
public class Banco {
	private final Double[] cuentas; // array donde se guarda el saldo de cada cuenta
	// creo un atributo para hacer uso del bloqueo de hilo
	private Lock cierreBanco;

	public void transferencia(int cuentaOrigen, int cuentaDestino, Double cantidad) {
		// bloquea un trozo de código del programa
		// para que sólo pueda ser ejecutado por un único hilo simultáneamente
		cierreBanco.lock();
		try {
			if (cuentas[cuentaOrigen] < cantidad) {
				System.out.println("cantidad insuficiente:---" + cuentaOrigen + "---Saldo: " + cuentas[cuentaOrigen]
						+ "---" + cantidad);
				return; // no hace nada se sale pero siempre entra en finally
			} else {
				System.out.println("cantidad OK:---" + cuentaOrigen);
			}
			System.out.println(Thread.currentThread());
			cuentas[cuentaOrigen] -= cantidad;
			System.out.printf("%10.2f de %d para %d", cantidad, cuentaOrigen, cuentaDestino);
			cuentas[cuentaDestino] += cantidad;
			System.out.printf("Saldo total: %10.2f%n", this.getSaldoTotal());
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
	}

	public Double[] getCuentas() {
		return cuentas;
	}

}
