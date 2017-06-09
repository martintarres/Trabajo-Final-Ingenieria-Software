package main.java;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JButton;

public class VistaListaReproduccion extends JFrame implements Observer {

	ClaseObservador miObservador;
	//ClaseObservador miObser;
	int seleccion;
	
	JPanel contentPane;
	List ListaAleatoria;
	JButton BotonAleatorio;
	JButton BotonAdelante;
	JSlider BarraVolumen;
	JButton BotonAtras;
	JButton BotonStop;
	JButton BotonPlay;
	JButton BotonPause;
	JButton BotonVolver;
	JButton BotonBorrar;
	
	public VistaListaReproduccion(ClaseObservador observador) {
		miObservador=observador;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ListaAleatoria = new List();
		ListaAleatoria.setBounds(14, 50, 332, 166);
		contentPane.add(ListaAleatoria);
		
		BotonAleatorio = new JButton("Aleatorio");
		BotonAleatorio.setBounds(335, 227, 70, 23);
		contentPane.add(BotonAleatorio);
		
		BotonAdelante = new JButton(">>");
		BotonAdelante.setBounds(252, 227, 70, 23);
		contentPane.add(BotonAdelante);
		
		BarraVolumen = new JSlider();
		BarraVolumen.setMaximum(141);
		BarraVolumen.setOrientation(SwingConstants.VERTICAL);
		BarraVolumen.setBounds(356, 11, 78, 183);
		contentPane.add(BarraVolumen);
		
		
		BotonAtras = new JButton("<<");
		BotonAtras.setBounds(10, 227, 70, 23);
		contentPane.add(BotonAtras);
		
		
		BotonStop = new JButton("Stop");
		BotonStop.setBounds(172, 227, 70, 23);
		contentPane.add(BotonStop);
		
		BotonPlay = new JButton("Play");
		BotonPlay.setBounds(90, 227, 70, 23);
		contentPane.add(BotonPlay);
		
		BotonVolver = new JButton("Volver");
		BotonVolver.setBounds(25, 11, 96, 23);
		contentPane.add(BotonVolver);
		
		BotonBorrar = new JButton("Borrar");
		BotonBorrar.setBounds(157, 11, 89, 23);
		contentPane.add(BotonBorrar);
		
		BotonPause = new JButton("||");
		BotonPause.setBounds(90, 227, 70, 23);
	}

	@Override
	public void update(Observable o, Object arg) {
		seleccion=miObservador.getPanelSeleccionado();
		System.out.println("Notifico en vistasecundaira con" + seleccion);
		
		if(seleccion == 3){
			miObservador.setVista(contentPane);
			miObservador.setPanel(0);
		}

		if(seleccion ==1 ){
			contentPane.remove(BotonPlay);
			contentPane.add(BotonPause);
			miObservador.notifyObservers();
			
		}
		
		if ( seleccion == 2){
			contentPane.remove(BotonPause);
			contentPane.add(BotonPlay);
			miObservador.notifyObservers();
			
		}
		
	}
}
