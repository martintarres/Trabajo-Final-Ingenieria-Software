package main.java;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

public class Vista extends JFrame implements Observer {

	
	ClaseObservador miObservador;
	
	int seleccion;
	VistaPrincipal vistaprincipal;
	VistaListaReproduccion vistalistareproduccion;
		
		public Vista(ClaseObservador observador){
			miObservador=observador;
		
			
			setTitle("Reproductor Musical");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			setVisible(true);
			
			vistaprincipal= new VistaPrincipal(miObservador);
			miObservador.addObserver(vistaprincipal);
			
			vistalistareproduccion = new VistaListaReproduccion(miObservador);
			miObservador.addObserver(vistalistareproduccion);
			
			miObservador.setVista(vistaprincipal.contentPane);
			setContentPane(miObservador.getVista());
		
			setVisible(true);
			
			
		}
	
	
	
	@Override
	public void update(Observable o, Object arg) {
		/*seleccion=miObservador.getPanelSeleccionado();
	//	seleccion=miObser.getPanelSeleccionado();
		System.out.println("en vista me llego " +seleccion  );*/
		if(seleccion == 0 ){
	
			setContentPane(miObservador.getVista());
			miObservador.setVista(miObservador.getVista());
			setVisible(true);
		}
		
		setContentPane(miObservador.getVista());

		}
	
}
		
	


