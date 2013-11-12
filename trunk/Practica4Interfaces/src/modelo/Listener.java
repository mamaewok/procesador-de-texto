package modelo;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JMenuItem;

import vista.View;

/**
 * Clase que implementa las acciones de gestionar ficheros
 * 
 * @author Ainhoa
 */
public class Listener extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private String direccion = "C:\\algo.txt";
	private View vista;
	private File fichero;
	private FileReader fr;
	private FileWriter fw;
	private String texto;
	
	//Constructor
	/**
	 * 
	 * @param vista
	 */
	public Listener(View vista) {
		super();
		this.vista = vista;
	}

	/**
	 * 
	 */
	public void accionAbrir() {
		try {
			fichero = new File(direccion); //meter getDireccion cuando implemente abrir
			fr = new FileReader(fichero);
			System.out.println(
					"Fichero abierto con éxito");
			int i;
			while ((i = fr.read()) != -1)
				texto+=Character.toString((char)i);
			vista.mostrarTexto(texto);
		} catch (FileNotFoundException fnfe) {
			System.out.println(
					"El fichero " + direccion + " no existe ");
		} catch (IOException ioe) {
			System.out.println(
					"El disco esta protegido contra escritura");
		}
	}
	/**
	 * 
	 */
	public void accionEscribir(String cadena) {
		try {
			fichero = new File(direccion);
			setK(new FileWriter(fichero));
			// System.out.println("Fichero encontrado con éxito");
			char[]cad = cadena.toCharArray();
			for(int i = 0; i < cad.length; i++){
				getFw().write(cad[i]);
				}
			
		} catch (FileNotFoundException fnfe) {
			System.out.println(
					"El fichero " + direccion + " no existe ");
		} catch (IOException ioe) {
			System.out.println(
					"El disco esta protegido contra escritura");
		}
	}
	
	
	public void accionCerrar(){
		try {
			fr.close();
			vista.ocultarTexto();
		} catch (IOException e1) {
			System.out.println(
					"No se pudo cerrar el fichero");
			}
	}
	
	public void accionSalir(){
		vista.cerrarPantalla();
	}
	
	//Acciones
	@Override
	/**
	 * 
	 */
	public void actionPerformed(ActionEvent e) {
		JMenuItem menu = (JMenuItem) e.getSource();
		//System.out.println(
				//"el menu que genera el evento es:"+ menu.getText());
		if((menu.getText().equals("Abrir")))
			accionAbrir();
			
		if((menu.getText().equals("Editar")))
			accionEscribir(vista.devolverTextArea());
		
		if((menu.getText().equals("Cerrar")))
			accionCerrar();
			

		if((menu.getText().equals("Salir")))
			accionSalir();
			
			
	}


	//G&S

	public FileWriter getFw() {
		return fw;
	}

	public void setK(FileWriter fw) {
		this.fw = fw;
	}

	public FileReader getF() {
		return fr;
	}

	public void setF(FileReader f) {
		this.fr = f;
	}
}
