package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import vista.Vista;

public class AccionFichero {

	private String direccion;
	private Vista vista;
	private File fichero;
	private FileReader fr;
	private FileWriter fw;
	private BufferedReader br;
	private String texto = "";

	public AccionFichero(Vista vista) {
		super();
		this.vista = vista;
	}

	/**
     * 
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
		} catch (IOException ioe) {
			System.out.println("El disco esta protegido contra escritura");
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				System.out.println("Error");
			}
		}
	}

	/**
     * 
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
		} catch (IOException ioe) {
			System.out.println("El disco esta protegido contra escritura");
		} catch (Exception e) {
			System.out.println("Error desconocido");
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				System.out.println("No se ha podido cerrar el fichero");
			}
		}
	}

	/**
	 * 
	 */
	public void accionCerrar() {
		vista.ocultarAbrir();
		vista.ocultarTexto();
	}

	/**
	 * 
	 */
	public void accionSalir() {
		vista.cerrarPantalla();
	}

	/**
	 * 
	 */
	public void accionBuscar() {
		try {
			setDireccion(vista.devolverTextFieldDir());
			br = new BufferedReader(new FileReader(getDireccion()));
			String linea;

			while ((linea = br.readLine()) != null) {
				if (linea.indexOf(vista.devolverTextFieldBuscar()) != -1)
					vista.mostrarTexto(linea);
			}
			try {
				br.close();
			} catch (IOException e) {
				System.out
						.println("No se ha podido cerrar la búsqueda del fichero");
			}
		} catch (FileNotFoundException e) {
			System.out
					.println("Hay que abrir un fichero antes de realizar la búsqueda");
			vista.obligarAbrir();
		} catch (IOException ioe) {
			System.out.println("Error");
		}
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
