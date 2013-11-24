package modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vista.Vista;
/**
 * Clase que implementa la accion que realiza el boton de búsqeuda
 * @author MAMAEWOK
 *
 */
public class BotonBuscar extends JButton implements ActionListener {

	private static final long serialVersionUID = 1L;
	Vista vista;

	/**
	 * Crea el objeto de tipo BotonBuscar incluyendo la vista en la que se encuentra y el nombre que tendrá dicho botón
	 * @param vista
	 * @param nombre
	 */
	public BotonBuscar(Vista vista, String nombre) {
		super();
		this.vista = vista;
		this.setText(nombre);
		this.addActionListener(this);
	}

	/**
	 * Indica la acción que realiza nuestro boton buscar
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		AccionFichero accionFichero = new AccionFichero(vista);
		accionFichero.accionBuscar();
		vista.ocultarBusqueda();

	}
}
