package modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vista.Vista;
/**
 * Clase que implementa la accion que realiza el boton de apertura de fichero
 * @author MAMAEWOK
 *
 */
public class BotonAbrir extends JButton implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private Vista vista;
	/**
	 *  Crea el objeto de tipo BotonAbrir incluyendo la vista en la que se encuentra y el nombre que tendrá dicho botón
	 * @param vista
	 * @param nombre
	 */
	public BotonAbrir(Vista vista, String nombre){
		super();
		this.vista = vista;
		this.setText(nombre);
		this.addActionListener(this);
	}

	/**
	 * Indica la acción que realiza nuestro boton de apertura de fichero
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Modelo accionFichero = new Modelo(vista);
		accionFichero.accionAbrir();
	}

	
}
