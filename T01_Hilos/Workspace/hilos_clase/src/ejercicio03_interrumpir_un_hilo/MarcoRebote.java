package ejercicio03_interrumpir_un_hilo;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//Marco con lámina y botones
public class MarcoRebote extends JFrame {

	private static final long serialVersionUID = 1L;
	private LaminaPelota lamina;
	private Thread t;

	public MarcoRebote() {

		setBounds(600, 300, 400, 350);

		setTitle("Rebotes");

		lamina = new LaminaPelota();

		add(lamina, BorderLayout.CENTER);

		JPanel laminaBotones = new JPanel();

		ponerBoton(laminaBotones, "Dale!", new ActionListener() {

			public void actionPerformed(ActionEvent evento) {

				comienza_el_juego();
			}

		});

		ponerBoton(laminaBotones, "Salir", new ActionListener() {

			public void actionPerformed(ActionEvent evento) {

				System.exit(0);

			}

		});
		
		ponerBoton(laminaBotones, "Detener", new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				detener();
			}
		});
		

		add(laminaBotones, BorderLayout.SOUTH);
	}

	// Ponemos botones

	public void ponerBoton(Container c, String titulo, ActionListener oyente) {

		JButton boton = new JButton(titulo);

		c.add(boton);

		boton.addActionListener(oyente);

	}

	/**************************************************************************/
	// Añade pelota y la bota 3000 veces

	public void comienza_el_juego() {

		Pelota pelota = new Pelota();
		lamina.add(pelota);

		Runnable r = new PelotaHilos(pelota, lamina);
		t = new Thread(r);
		t.start();

	}
	
	public void detener() {
		t.interrupt();
	}

}
