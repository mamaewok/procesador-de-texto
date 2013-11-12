package vista;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import modelo.Listener;

public class View extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea ta;
	private JScrollPane sp;
	
	public View(){
		
		this.setTitle("Editor de textos");
		this.setSize(400, 450);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		this.getContentPane().setLayout(new FlowLayout());
		Listener listener = new Listener(this);
		JMenuBar mb = new JMenuBar();
	
			JMenu m1 = new JMenu("Archivo");
			JMenuItem it = new JMenuItem(listener);
		
				it = new JMenuItem(listener);
				it.setText("Abrir");
				m1.add(it);

				it = new JMenuItem(listener);
				it.setText("Cerrar");
				m1.add(it);
				
				it = new JMenuItem(listener);
				it.setText("Guardar");
				m1.add(it);
				
				it = new JMenuItem(listener);
				it.setText("Salir");
				m1.add(it);
				
			JMenu m2 = new JMenu("Editar");
				m2.add(new JMenuItem("Buscar"));
				m2.addSeparator();
				m2.add("Cortar");
				m2.add("Copiar");
				m2.add("Pegar");
				
			mb.add(m1);
			mb.add(m2);
			
		this.setJMenuBar(mb);
		
		ta = new JTextArea("Archivo...",20,30);
			ta.setLineWrap(true);
			ta.setWrapStyleWord(true);
			this.sp = new JScrollPane(ta);
			ta.setVisible(false);
			this.getContentPane().add(sp);
			this.setVisible(true);
		
	}
	//Acciones
	public void mostrarTexto(String a){
		ta.setText(a);
		ta.setVisible(true);
	}
	
	public void ocultarTexto(){
		System.out.println("Cerrando fichero y ocultando texto");
		ta.setText("");
		sp.setVisible(false);
		this.repaint();
	}
	public String devolverTextArea(){
		return ta.getText();
	}
	public void cerrarPantalla(){
		//this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
	
	//public void 
}
