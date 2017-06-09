package test.java;

import static org.junit.Assert.*;

import java.awt.*;
import java.io.File;

import org.junit.Before;
import org.junit.Test;

import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import main.java.Modelo;

public class ModeloTest {
	
	BasicPlayer player;
	String path;
	File folder;
	List listapr;
	
	
	@Before
	public void before(){
		player= new BasicPlayer();
		path= "C:\\Users\\marti\\Music\\Coldplay_-_The_Scientist_RB-RcX5DS5A.mp3";
		folder =new File (path);
		try {
			player.open(folder);
		} catch (BasicPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listapr = new List();
	}
	@Test
	public void testIniciarm() {
			
	}

	@Test
	public void testCargar() {


		listapr.add(folder.getName());


		assertEquals(1 , listapr.getItemCount());

	}

	@Test
	public void testPlay()  {
		
		
		
		try {

			player.play();

		} catch (BasicPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		assertEquals(0, player.getStatus());
		


		
		
	}

	@Test
	public void testPause()  {
		try {
			
			player.pause();

		} catch (BasicPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(3, player.getStatus());
	}

	@Test
	public void testStop() {
		try {

			//player.play();
			player.stop();

		} catch (BasicPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(3, player.getStatus());
	}

	@Test
	public void testAdelante() {
		fail("Not yet implemented");
	}

	@Test
	public void testAtras() {
		fail("Not yet implemented");
	}

	@Test
	public void testVolumen() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarcancion() {


	}

	@Test
	public void testSeleccioncarpeta() {
		fail("Not yet implemented");
	}

	@Test
	public void testAgregarLista() {
		fail("Not yet implemented");
	}

	@Test
	public void testBorrar() {

		listapr.add(folder.getName());
		listapr.add(folder.getName());
		listapr.add(folder.getName());
		listapr.remove(folder.getName());

		assertEquals(2, listapr.getItemCount());
	}

	@Test
	public void testAdelanterep() {
		fail("Not yet implemented");
	}

	@Test
	public void testAtrasrep() {
		fail("Not yet implemented");
	}


	
}
