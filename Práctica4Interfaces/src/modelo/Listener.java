package modelo;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JMenuItem;

import vista.Vista;
/**
 * Clase que contiene las opciones de las acciones que realizará nuestro programa
 * @author MAMAEWOK
 *
 */
public class Listener extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private Vista vista;
	private AccionFichero accionFichero;

	// Constructor
	/**
	 * Incluye la vista en la instanciación del objeto Listener
	 * @param vista donde se encuentra nuestro objeto
	 */
	public Listener(Vista vista) {
		super();
		this.vista = vista;
	}
	
	// Acciones
	@Override
	/**
	 * Implementa las funciones básicas de los botones del menu de nuestro programa
	 */
	public void actionPerformed(ActionEvent e) {
		JMenuItem menu = (JMenuItem) e.getSource();
		
		System.out.println(
		 "el menu que genera el evento es:"+ menu.getText());
		
		 accionFichero = new AccionFichero(vista);
		if ((menu.getText().equals("Abrir")))
			vista.mostrarAbrir();

		else if ((menu.getText().equals("Guardar")))
			accionFichero.accionEscribirGuardar(vista.devolverTextArea());

		else if ((menu.getText().equals("Cerrar")))
			accionFichero.accionCerrar();

		else if ((menu.getText().equals("Salir")))
			accionFichero.accionSalir();
		
		else if ((menu.getText().equals("Buscar"))){
			accionFichero.accionBuscar();
			vista.mostrarBusqueda();
		}
		

	}

}
