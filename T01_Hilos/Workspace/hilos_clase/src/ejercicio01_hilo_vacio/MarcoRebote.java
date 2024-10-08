package ejercicio01_hilo_vacio;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


//Marco con lámina y botones
public class MarcoRebote extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private LaminaPelota lamina;
		
		public MarcoRebote(){
			
			setBounds(600,300,400,350);
			
			setTitle ("Rebotes");
			
			lamina=new LaminaPelota();
			
			add(lamina, BorderLayout.CENTER);
			
			JPanel laminaBotones=new JPanel();
			
			ponerBoton(laminaBotones, "Dale!", new ActionListener(){
				
				public void actionPerformed(ActionEvent evento){
					
					comienza_el_juego();
				}
				
			});
			
			
			ponerBoton(laminaBotones, "Salir", new ActionListener(){
				
				public void actionPerformed(ActionEvent evento){
					
					System.exit(0);
					
				}
				
			});
			
			add(laminaBotones, BorderLayout.SOUTH);
		}
		
		
		//Ponemos botones
		
		public void ponerBoton(Container c, String titulo, ActionListener oyente){
			
			JButton boton=new JButton(titulo);
			
			c.add(boton);
			
			boton.addActionListener(oyente);
			
		}
		/**************************************************************************/
		//Añade pelota y la bota 3000 veces
		
		public void comienza_el_juego (){
									
				Pelota pelota=new Pelota();
				lamina.add(pelota);
				
				for (int i=1; i<=3000; i++){
					
					pelota.mueve_pelota(lamina.getBounds());
					
					lamina.paint(lamina.getGraphics());
					
					try {
						Thread.sleep(4);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
			
			
		}
		
		
		
		
	}

