package ejercicio08_bancoSinSincronizar;

/*clase que crea las cuentas*/
public class Banco {
	private final Double[] cuentas;  //array donde se guarda el saldo de cada cuenta

	public void transferencia(int cuentaOrigen, int cuentaDestino, Double cantidad) {
		if (cuentas[cuentaOrigen]<cantidad) {
			return; // si el saldo de la cuenta es inferior a la cuenta a transferir 
					//no hace nada se sale
		}
		System.out.println(Thread.currentThread());
		cuentas[cuentaOrigen]-=cantidad;
		System.out.printf("Cantidad transferida: %10.2f de Cuenta origen %d para cuenta destino %d", cantidad,cuentaOrigen,cuentaDestino);
		cuentas[cuentaDestino]+=cantidad;
		System.out.printf("\n Saldo total: %10.2f%n",this.getSaldoTotal());
	}
	
	public Double getSaldoTotal() {
		Double suma_cuentas=0.0;
		
		for(Double a:cuentas) {
			suma_cuentas+=a;
		}
		return suma_cuentas;
	}
	
	public Banco() {
		//inicialmente  a cada cuenta se le asignan 2000 euros
		// en el banco hay 100 cuentas
		cuentas=new Double[100];
		for(int i=0;i<cuentas.length;i++) {
			cuentas[i]=2000.0;
		}
	}

	

	public Double[] getCuentas() {
		return cuentas;
	}
	
	
	
}
