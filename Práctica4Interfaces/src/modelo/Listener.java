package modelo;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JMenuItem;

import vista.Vista;

public class Listener extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private Vista vista;
	private AccionFichero accionFichero;

	// Constructor
	/**
	 * 
	 * @param vista
	 */
	public Listener(Vista vista) {
		super();
		this.vista = vista;
	}
	
	// Acciones
	@Override
	/**
	 * 
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
		
		else if ((menu.getText().equals("Buscar")))
			vista.mostrarBusqueda();

	}

}
