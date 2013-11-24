package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import vista.Vista;

public class Modelo {

	private String direccion;
	private Vista vista;
	private File fichero;
	private FileReader fr;
	private FileWriter fw;
	private BufferedReader br;
	private String texto = "";

	public Modelo(Vista vista) {
		super();
		this.vista = vista;
	}

	/**
     * Permite abrir un fichero que introducimos por teclado leyendolo
     */
	public void accionAbrir() {
		try {
			setDireccion(vista.devolverTextFieldDir());
			fichero = new File(getDireccion());
			fr = new FileReader(fichero);
			System.out.println("Fichero abierto con éxito");
			int i = 0;
			while ((i = fr.read()) != -1)
				texto += Character.toString((char) i);
			vista.mostrarTexto(texto);
		} catch (FileNotFoundException fnfe) {
			System.out.println("El fichero " + getDireccion() + " no existe ");
			vista.mostrarTexto("El fichero " + getDireccion() + " no existe ");
		} catch (IOException ioe) {
			System.out.println("El disco esta protegido contra escritura");
			vista.mostrarTexto("El disco esta protegido contra escritura");
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				System.out.println("Error");
			}
		}
	}

	/**
     * Permite escribir y guardar el texto que editemos en un fichero
     */
	public void accionEscribirGuardar(String cadena) {
		try {
			setDireccion(vista.devolverTextFieldDir());
			fichero = new File(getDireccion());
			fw = new FileWriter(fichero);
			System.out.println("Fichero encontrado con éxito");
			char[] cad = cadena.toCharArray();
			for (int i = 0; i < cad.length; i++) {
				fw.write(cad[i]);
			}
			System.out.println("Fichero guardado con éxito");

		} catch (FileNotFoundException fnfe) {
			System.out.println("El fichero " + getDireccion() + " no existe ");
			vista.obligarAbrir("Hay que abrir un fichero antes de poder guardarlo");
		} catch (IOException ioe) {
			System.out.println("El disco esta protegido contra escritura");
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				System.out.println("No se ha podido cerrar el fichero");
			} catch (NullPointerException npe) {
				System.out.println("No hay nada que cerrar");
				}
		}
	}

	/**
	 * Oculta el area de texto y vacia la direccion para poder realizar una nueva busqeuda cuando se desee
	 */
	public void accionCerrar() {
		vista.ocultarAbrir();
		vista.ocultarTexto();
		vista.vaciarTextFieldDir();
	}

	/**
	 * Sale del programa cerrando su ejecución dando una advertencia antes
	 */
	public void accionSalir() {
		JFrame f = new JFrame();
        Object[] opciones = {"Aceptar", "Cancelar"};
        int i = JOptionPane.showOptionDialog(f, "¿Seguro que desea Salir?", "Option", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        if (i == 0) {
            System.exit(0); // normal exit  
        }
	}

	/**
	 * Realiza la búsqueda de una palabra imprimiendo las lineas en las que aparece
	 */
	public void accionBuscar() { //TODO
		try {
			setDireccion(vista.devolverTextFieldDir());
			br = new BufferedReader(new FileReader(getDireccion()));
			String linea;
			String palabraABuscar = vista.devolverTextFieldBuscar();
			while ((linea = br.readLine()) != null) {
				if (linea.indexOf(palabraABuscar) != -1){
					vista.mostrarTexto(linea);
				}	
			}
			try {
				br.close();
			} catch (IOException e) {
				System.out
						.println("No se ha podido cerrar la búsqueda del fichero");
			}
		} catch (FileNotFoundException e) {
			vista.obligarAbrir("Hay que abrir un fichero antes de realizar la búsqueda");
			System.out
					.println("Hay que abrir un fichero antes de realizar la búsqueda");
		} catch (IOException ioe) {
			System.out.println("Error");
		}
	}

	/**
	 * Hace accesible la ruta del fichero a través de la variable dirección con la que trabajamos
	 * @return direccion del fichero
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Establece la dirección
	 * @param direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
