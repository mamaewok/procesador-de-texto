package vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultEditorKit;

import modelo.Modelo;
import modelo.BotonAbrir;
import modelo.BotonBuscar;
import modelo.Listener;
/**
 * Implementa la vista y algunas acciones relacionadas con esta al instanciar la clase vista
 * @author MAMAEWOK
 *
 */
public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextArea ta;
	private JPanel pa;
	private JPanel paDir;
	private JPanel paBuscar;
	private JTextField tfDir = null;
	private JTextField tfBuscar;
	private JLabel jlDir;
	private JLabel jlBuscar;
	private JScrollPane sp;
	private JButton botonBuscar;
	private JButton botonAbrir;
	
	/**
	 * Constructor que establece los elementos gráficos del programa y los enlaza con el las acciones correspondientes
	 */
	public Vista() {

		this.setTitle("Editor de textos");
		this.setSize(400, 450);
		
		Modelo af = new Modelo(this);
		this.setDefaultCloseOperation(Vista.EXIT_ON_CLOSE);

		this.getContentPane().setLayout(new BorderLayout());
		Listener listener = new Listener(this);
		JMenuBar mb = new JMenuBar();

		JMenu m1 = new JMenu("Archivo");
		JMenuItem it = new JMenuItem(listener);

		it = new JMenuItem(listener);
		it.setText("Abrir");
		m1.add(it);

		it = new JMenuItem(listener);
		it.setText("Guardar");
		m1.add(it);

		it = new JMenuItem(listener);
		it.setText("Cerrar");
		m1.add(it);

		it = new JMenuItem(listener);
		it.setText("Salir");
		m1.add(it);

		JMenu m2 = new JMenu("Editar");
		JMenuItem it2 = new JMenuItem(listener);

		it2 = new JMenuItem(listener);
		it2.setText("Buscar");
		m2.add(it2);

		m2.addSeparator();

		it2 = new JMenuItem(new DefaultEditorKit.CutAction());
		it2.setText("Cortar");
		m2.add(it2);

		it2 = new JMenuItem(new DefaultEditorKit.CopyAction());
		it2.setText("Copiar");
		m2.add(it2);

		it2 = new JMenuItem(new DefaultEditorKit.PasteAction());
		it2.setText("Pegar");
		m2.add(it2);

		mb.add(m1);
		mb.add(m2);

		this.setJMenuBar(mb);
		
		ta = new JTextArea(35, 70);
		// ta.setLineWrap(true); Si se pone no se aprecian las barras de scroll horizontales
		ta.setWrapStyleWord(true);
		this.sp = new JScrollPane(ta);
		ta.setVisible(false);
		this.getContentPane().add(sp);

		pa = new JPanel(new GridLayout(2, 1));

		paDir = new JPanel();
		jlDir = new JLabel("Archivo: ");
		tfDir = new JTextField(18); 
		botonAbrir = new BotonAbrir(this, "Abrir"); //Polimorfismo con BotonAbrir
		paDir.add(jlDir);
		paDir.add(tfDir);
		paDir.add(botonAbrir);
		paDir.setVisible(false);

		pa.add(paDir);

		paBuscar = new JPanel();
		jlBuscar = new JLabel("Introduce palabra: ");
		tfBuscar = new JTextField("palabra...", 15);
		botonBuscar = new BotonBuscar(this, "Buscar"); //Polimorfismo con BotonBuscar
		paBuscar.add(jlBuscar);
		paBuscar.add(tfBuscar);
		paBuscar.add(botonBuscar);
		paBuscar.setVisible(false);

		pa.add(paBuscar);

		this.getContentPane().add(pa, BorderLayout.SOUTH);
		this.setVisible(true);

	}//Acaba constructor

	// Acciones que devuelven y vacian cajas de texto, hacen paneles visibles o invisibles y cosas relacionadas con la vista

	/**
	 * Hace visible el panel que contiene los elementos necesario para realizar la apertura del fichero
	 */
	public void mostrarAbrir() {
		paDir.setVisible(true);
		sp.setVisible(true);
	}

	/**
	 * Hace invisible el panel que contiene los elementos necesario para realizar la apertura del fichero
	 */
	public void ocultarAbrir() {
		paDir.setVisible(false);
	}

	/**
	 * Hace visible el area de texto y establece en esta un texto introducido como parámetro
	 * @param text
	 */
	public void mostrarTexto(String text) {
		ta.setText(text);
		ta.setVisible(true);
		sp.setVisible(true);
		this.repaint();
	}
	
	/**
	 * Hace invisible el area de texto y establece en esta un texto introducido como parámetro
	 * @param text
	 */
	public void ocultarTexto() {
		System.out.println("Cerrando fichero y ocultando texto");
		ta.setText("");
		sp.setVisible(false);
		this.repaint();
	}

	/**
	 *  Hace visible el panel que contiene los elementos necesario para realizar la busqeuda en el fichero
	 * @param text
	 */
	public void mostrarBusqueda() {
		paBuscar.setVisible(true);
	}

	/**
	 *  Hace invisible el panel que contiene los elementos necesario para realizar la busqeuda en el fichero
	 * @param text
	 */
	public void ocultarBusqueda() {
		paBuscar.setVisible(false);
	}

	/**
	 * Obliga a realizar la apertura del fichero haciendo visible la apertura del fichero y una advertencia en el area de texto
	 * @param text advertencia que se da al ususario
	 */
	public void obligarAbrir(String advertencia) {
		mostrarAbrir();
		sp.setVisible(true);
		ta.setText(advertencia);
		ta.setVisible(true);
		this.repaint();
	}

	/**
	 * Permite acceder al texto que contenga el area de texto en ese momento
	 * @return texto de ta
	 */
	public String devolverTextArea() {
		return ta.getText();
	}
	
	/**
	 * Permite acceder a la direccion que se introduce en el area de texto de direccion
	 * @return texto de tfDir
	 */
	public String devolverTextFieldDir() {
		return tfDir.getText();
	}

	/**
	 * Permite acceder a la palabra que se introduce en el area de texto de busqeuda
	 * @return texto de tfBuscar
	 */
	public String devolverTextFieldBuscar() {
		return tfBuscar.getText();
	}

	/**
	 * Vacia la dirección del fichero en caso de que sea necesario
	 */
	public void vaciarTextFieldDir() {
		tfDir.setText("");
	}

}
