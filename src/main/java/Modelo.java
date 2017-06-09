package main.java;



import java.awt.Component;
import java.awt.List;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JSlider;

import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

public class Modelo {
		
	String path;
	File files = null ;
	static BasicPlayer player;
	List listapr;
	String unir;
	File [] listFiles;
	File folder;
	File archivo;
	List listarep;
	
	public void iniciarm(){
		player= new BasicPlayer();
		path= "C:\\Users\\marti\\Music";
		folder =new File (path);
	}
	
	public void cargar(List listapr){
		
		
		this.listapr=listapr;
		 
		 
		 listFiles = folder.listFiles();
		 
			for(int i=0; i<listFiles.length;i++){
				if(listFiles[i].isFile()){
					files=listFiles[i].getAbsoluteFile();
					if(files.getName().endsWith("mp3") || files.getName().endsWith("wav") || files.getName().endsWith("mp4")){
					System.out.println(files);
			//		System.out.println(listFiles[i]);
					listapr.add(files.getName());
					
					}
				}
			}
	}
	

	
	public void play(){
				unir= path.concat("\\" + listapr.getSelectedItem());
				
				archivo = new File ( unir);
				
				System.out.println("soy archivo1 " + archivo);
				
				if(player.getStatus()==-1 ||player.getStatus()== 2){
					
					try {
				player.open(archivo);
				player.play();
			} catch (BasicPlayerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				}
			
		
		
			if(player.getStatus()==0 ){
		try {
			player.open(new File(unir));
			
			player.play();
			System.out.println("Soy status play " + player.getStatus());
		} catch (BasicPlayerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}
		
		
		if(player.getStatus()==1){
			
				try {
					player.resume();
					System.out.println("Soy status resume " + player.getStatus());
				} catch (BasicPlayerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				
		
		}
	}
			}
	
	
	public void pause(){
		try {
			player.pause();
			System.out.println("soy status pausa " + player.getStatus());
		} catch (BasicPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void stop(){
		try {
			player.stop();
			//System.out.println("Soy status stop " + player.getStatus());
		} catch (BasicPlayerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void adelante(){
		listapr.select((listapr.getSelectedIndex()+1));
		unir = "C:\\Users\\marti\\Music\\" + listapr.getSelectedItem();
		try {
			player.stop();
			player.open(new File(unir));
			player.play();
		} catch (BasicPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void atras(){
		
		listapr.select((listapr.getSelectedIndex()-1));
		unir = "C:\\Users\\marti\\Music\\" + listapr.getSelectedItem();
		try {
			player.stop();
			player.open(new File(unir));
			player.play();
		} catch (BasicPlayerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void volumen(JSlider source){
		
		source.setMaximum(141);
		try {
			player.setGain(source.getValue()*0.01); // Aca lo multiplico porque el volumen 
														//	solo puede ir entre 0 y 1.4 								
		} catch (BasicPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void buscarcancion(String s){
		
		listapr.removeAll();
		
		for(int i=0; i<listFiles.length;i++){
			if(listFiles[i].isFile()){
				files=listFiles[i].getAbsoluteFile();
				if(files.getName().endsWith("mp3") || files.getName().endsWith("wav") || files.getName().endsWith("mp4")){
					
					
					if(files.toString().toLowerCase().contains(s)){
						//System.out.println(files.toString());
						listapr.add(files.getName());
						
					}
					
					}
			
		}
		}
	}
	
	public void seleccioncarpeta(List lista){
		JFileChooser fc=new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		Component contentPane = null;
		int ventanaseleccionada = fc.showOpenDialog(contentPane);
		
		if(ventanaseleccionada== JFileChooser.APPROVE_OPTION){
				folder=fc.getSelectedFile();
				path= folder.getAbsolutePath();
			
				//path= path.concat("\\");
				listapr.removeAll();
				cargar(lista);
		}
	}
	
	public void agregarLista(String string, List listarep){
			String archi;
			archi=string;
			this.listarep=listarep;
			
			listarep.add(archi);
			
	}
	
	public void borrar(String archivo){
		listarep.remove(archivo);
	}
	
	public void adelanterep(){
		listarep.select((listarep.getSelectedIndex()+1));
		unir = "C:\\Users\\marti\\Music\\" + listarep.getSelectedItem();
		try {
			player.stop();
			player.open(new File(unir));
			player.play();
		} catch (BasicPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void atrasrep(){
		
		listarep.select((listarep.getSelectedIndex()-1));
		unir = "C:\\Users\\marti\\Music\\" + listarep.getSelectedItem();
		try {
			player.stop();
			player.open(new File(unir));
			player.play();
		} catch (BasicPlayerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	

}
