package vista;

import java.awt.BorderLayout;
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

import modelo.BotonAbrir;
import modelo.BotonBuscar;
import modelo.Listener;

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
	
	public Vista() {

		this.setTitle("Editor de textos");
		this.setSize(400, 450);
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

		it2 = new JMenuItem(listener);
		it2.setText("Cortar");
		m2.add(it2);

		it2 = new JMenuItem(listener);
		it2.setText("Copiar");
		m2.add(it2);

		it2 = new JMenuItem(listener);
		it2.setText("Pegar");
		m2.add(it2);

		mb.add(m1);
		mb.add(m2);

		this.setJMenuBar(mb);

		ta = new JTextArea(35, 70);
//		ta.setLineWrap(true);  Si se pone no se aprecian las barras de scroll horizontales
		ta.setWrapStyleWord(true);
		this.sp = new JScrollPane(ta);
		ta.setVisible(false);
		this.getContentPane().add(sp);

		pa = new JPanel(new GridLayout(2, 1));

		paDir = new JPanel();
		jlDir = new JLabel("Archivo: ");
		tfDir = new JTextField(18); //C:\Users\MAMAEWOK\Documents\algo.txt
		botonAbrir = new BotonAbrir(this, "Abrir");
		paDir.add(jlDir);
		paDir.add(tfDir);
		paDir.add(botonAbrir);
		paDir.setVisible(false);

		pa.add(paDir);

		paBuscar = new JPanel();
		jlBuscar = new JLabel("Introduce palabra: ");
		tfBuscar = new JTextField("palabra...", 15);
		botonBuscar = new BotonBuscar(this,"Buscar");
		paBuscar.add(jlBuscar);
		paBuscar.add(tfBuscar);
		paBuscar.add(botonBuscar);
		paBuscar.setVisible(false);

		pa.add(paBuscar);

		this.getContentPane().add(pa, BorderLayout.SOUTH);
		this.setVisible(true);

	}

	// Acciones

	public void mostrarAbrir() {
		paDir.setVisible(true);
	}
	
	public void ocultarAbrir() {
		paDir.setVisible(false);
	}

	public void mostrarTexto(String a) {
		ta.setText(a);
		ta.setVisible(true);
		sp.setVisible(true);
		this.repaint();
	}

	public void mostrarBusqueda() {
		paBuscar.setVisible(true);
	}
	
	public void ocultarBusqueda(){
		paBuscar.setVisible(false);
	}
	public void obligarAbrir(){
		mostrarAbrir();
		ta.setText("Primero tienes que abrir un Archivo");
		ta.setVisible(true);
	}

	public void ocultarTexto() {
		System.out.println("Cerrando fichero y ocultando texto");
		ta.setText("");
		sp.setVisible(false);
		this.repaint();
	}

	public String devolverTextArea() {
		return ta.getText();
	}

	public void cerrarPantalla() {
		System.exit(0);
	}

	public String devolverTextFieldDir() {
		return tfDir.getText();
	}
	public void vaciarTextFieldDir(){
		tfDir.setText("");
	}

	public String devolverTextFieldBuscar() {
		return tfBuscar.getText();
	}

}
