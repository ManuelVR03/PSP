package ejercicio03_interrumpir_un_hilo;

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.util.ArrayList;

import javax.swing.JPanel;

public class LaminaPelota extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Pelota> pelotas=new ArrayList<Pelota>();
	
	//Añadimos pelota a la lámina
	public void add(Pelota b){
		pelotas.add(b);
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D)g;
		
		for(Pelota b: pelotas){
			
			g2.fill(b.getShape());
		}
		
	}
	
	
}