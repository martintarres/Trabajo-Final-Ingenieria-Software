package main.java;

import java.awt.List;
import java.awt.TextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

import javax.swing.JList;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Controlador implements ActionListener {

	Modelo modelo;
	Vista vista;
	List listapr;
	ClaseObservador miObservador;

	
	List listarep;
	
	public Controlador(Modelo modelo, Vista vista){
		
		miObservador= vista.miObservador;
		
		
		this.modelo=modelo;
		this.vista=vista;
		
		vista.vistaprincipal.list.addActionListener(this);
		vista.vistaprincipal.BuscarCancion.addTextListener(new MyTextListener());
		vista.vistaprincipal.BotonAdelante.addActionListener(this);
		vista.vistaprincipal.BarraVolumen.addChangeListener(new SliderListener());
		vista.vistaprincipal.BotonAtras.addActionListener(this);
		vista.vistaprincipal.BotonStop.addActionListener(this);
		vista.vistaprincipal.BotonPlay.addActionListener(this);
		vista.vistaprincipal.BotonPause.addActionListener(this);
		vista.vistaprincipal.SeleccionCarpeta.addActionListener(this);
		vista.vistaprincipal.ListaReproduccion.addActionListener(this);
		vista.vistaprincipal.AgregarListaReproduccion.addActionListener(this);
		vista.vistaprincipal.list.addMouseListener(ml);
		
		
		
		
		vista.vistalistareproduccion.BotonVolver.addActionListener(this);
		vista.vistalistareproduccion.BotonPlay.addActionListener(this);
		vista.vistalistareproduccion.BotonPause.addActionListener(this);
		vista.vistalistareproduccion.BotonBorrar.addActionListener(this);
		vista.vistalistareproduccion.BotonStop.addActionListener(this);
		vista.vistalistareproduccion.BotonAdelante.addActionListener(this);
		vista.vistalistareproduccion.BotonAtras.addActionListener(this);
		
		
		
		
	}
	

	
	public void iniciar(){
		modelo.iniciarm();
		
		listapr = vista.vistaprincipal.list;
		modelo.cargar(listapr);
		
		listarep = vista.vistalistareproduccion.ListaAleatoria;
	}
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
			if(vista.vistaprincipal.BotonPlay == e.getSource()){
				miObservador.setPanel(1);
				modelo.play();
				
				
				
		}
			if(vista.vistaprincipal.BotonPause== e.getSource()){
				miObservador.setPanel(2);
				modelo.pause();
				
				}
			if(vista.vistaprincipal.BotonStop == e.getSource()){
				miObservador.setPanel(2);
				modelo.stop();
			}
			if(vista.vistaprincipal.BotonAdelante== e.getSource()){
				miObservador.setPanel(1);
				modelo.adelante();
			}
			if(vista.vistaprincipal.BotonAtras == e.getSource()){
				modelo.atras();
				miObservador.setPanel(1);
			}
			
			if(vista.vistaprincipal.list == e.getSource()){
				miObservador.setPanel(2);
				modelo.stop();
				miObservador.setPanel(1);
				
				modelo.play();
			}
			
			if(vista.vistaprincipal.SeleccionCarpeta == e.getSource()){
				modelo.stop();
				miObservador.setPanel(2);
				modelo.seleccioncarpeta(listapr);
			}
			
			if(vista.vistaprincipal.ListaReproduccion == e.getSource()){
				System.out.println("Toque ir a lista reprodiccuion");
				miObservador.setPanel(3);
			}
			
			if(vista.vistaprincipal.AgregarListaReproduccion == e.getSource()){
				modelo.agregarLista(listapr.getSelectedItem(), listarep);
			}
			
			
			
			
			if(vista.vistalistareproduccion.BotonVolver == e.getSource()){
				miObservador.setPanel(4);
			}
			
			if(vista.vistalistareproduccion.BotonPlay == e.getSource()){
				miObservador.setPanel(1);
				modelo.play();
			}
			
			if(vista.vistalistareproduccion.BotonPause == e.getSource()){
				miObservador.setPanel(2);
				modelo.pause();
			}
			
			if(vista.vistalistareproduccion.BotonBorrar == e.getSource()){
				modelo.borrar(listarep.getSelectedItem());
			}
			
			if(vista.vistalistareproduccion.BotonStop == e.getSource()){
				miObservador.setPanel(2);
				modelo.stop();
			}
			
			if(vista.vistalistareproduccion.BotonAdelante == e.getSource()){
				miObservador.setPanel(1);
				modelo.adelanterep();
			}
			
			if(vista.vistalistareproduccion.BotonAtras == e.getSource()){
				modelo.atrasrep();
				miObservador.setPanel(1);
			}
	}
	
	class SliderListener implements ChangeListener {

		public void stateChanged(ChangeEvent e) {
			JSlider source = (JSlider)e.getSource();
			if (!source.getValueIsAdjusting()) {
				modelo.volumen(source);
			}
			
		}
		
	}
	
	 class MyTextListener implements TextListener {

		public void textValueChanged(TextEvent e) {
			 TextComponent tc = (TextComponent)e.getSource();
			 String s = tc.getText();
			 modelo.buscarcancion(s);
		}
		 
	 }


	 MouseListener ml=new MouseAdapter() {
		   
		   @Override
		   public void mouseReleased(MouseEvent arg0) {
			  
		   }
		   
		   @Override
		   public void mousePressed(MouseEvent arg0) {
			   
		   }
		   
		   @Override
		   public void mouseExited(MouseEvent arg0) {
			   
		   }
		   
		   @Override
		   public void mouseEntered(MouseEvent arg0) {
			   
		   }
		   
		   @Override
		   public void mouseClicked(MouseEvent arg0) {
			
		    
		   }
		};
	
	
	
	
}
