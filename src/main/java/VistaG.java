package main.java;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

public class VistaG extends JFrame implements Observer {

	
	ClaseObservador miObservador;
	int seleccion;
	VistaPrincipal vistaprincipal;

		
		public VistaG(ClaseObservador observador){
			miObservador=observador;
			
			setTitle("Reproductor Musical");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			setVisible(true);
			
			vistaprincipal= new VistaPrincipal(observador);
			observador.addObserver(vistaprincipal);

			miObservador.setPanel(1);
			miObservador.setVista(vistaprincipal.contentPane);
			setContentPane(miObservador.getVista());
		
			setVisible(true);
			
			
		}
	
	
	
	@Override
	public void update(Observable o, Object arg) {
		seleccion=miObservador.getPanelSeleccionado();
		
		if(seleccion == 5 ){
	
			setContentPane(miObservador.getVista());
			miObservador.setVista(miObservador.getVista());
			setVisible(true);
		}
	
}
		
	}


