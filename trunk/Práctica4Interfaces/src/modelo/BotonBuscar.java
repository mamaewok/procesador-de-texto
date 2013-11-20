package modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vista.Vista;

public class BotonBuscar extends JButton implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Vista vista;

	public BotonBuscar(Vista vista, String nombre) {
		super();
		this.vista = vista;
		this.setText(nombre);
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AccionFichero accionFichero = new AccionFichero(vista);
		accionFichero.accionBuscar();
		vista.ocultarBusqueda();

	}
}
