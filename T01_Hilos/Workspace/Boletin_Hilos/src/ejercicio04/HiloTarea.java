package ejercicio04;

class HiloTarea extends Thread {
    private static final Object lock = new Object(); // Objeto de bloqueo para sincronización
    private static int contador = 1; // Contador de mensajes
    private String nombreHilo;

    public HiloTarea(String nombreHilo) {
        this.nombreHilo = nombreHilo;
    }

    private void enviarMensaje(String mensaje) {
        System.out.println(nombreHilo + " enterado del mensaje de: " + mensaje);
    }

    @Override
    public void run() {
        while (contador <= 10) {
            synchronized (lock) {
                if (contador <= 10) {
                    Mensaje msg = new Mensaje("MSG" + contador);
                    enviarMensaje(Thread.currentThread().getName() + ": " + msg.getContenido());

                    contador++; // Incrementamos el contador para el siguiente mensaje
                    lock.notify(); // Despertamos al otro hilo

                    try {
                        if (contador <= 10) {
                            lock.wait(); // Esperamos nuestro turno
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
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
