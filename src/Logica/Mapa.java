package Logica;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Grafico.Grafico;

public class Mapa extends JPanel {

	public static final int LIMITE_IZQ_X = 0;
	public static final int LIMITE_DER_X = 591;
	public static final int LIMITE_INFERIOR = 571;
	public static final int LIMITE_SUPERIOR = 0;

	protected int cantidadEnemigos;
	protected JLabel background;
	protected Juego juego;

	public Mapa(Juego juego) {
		this.setLayout(null);
		this.juego = juego;

		Dimension dim = new Dimension(591, 571);
		setMinimumSize(dim);
		setMaximumSize(dim);
		setPreferredSize(dim);
		setSize(dim);

		this.background = new JLabel();
		this.background.setBounds(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		cambiarNivel(1);
		this.add(background);
		this.setComponentZOrder(this.background, 0);
	}

	public void cambiarNivel(int nivel) {
		this.background.setIcon(new ImageIcon(this.getClass().getResource("/Texturas/nivel" + nivel + ".jpg")));
	}
	
	public void gameOver() {
		for(Entidad entidad : juego.entidades()) {
			entidad.getGrafico().setVisible(false);
		}
		this.background.setIcon(new ImageIcon(this.getClass().getResource("/Texturas/juegoTerminado.jpg")));
	}
	
	public void gameWin() {
		for(Entidad entidad : juego.entidades()) {
			entidad.getGrafico().setVisible(false);
		}
		this.background.setIcon(new ImageIcon(this.getClass().getResource("/Texturas/juegoGanado.jpg")));
	}

	public synchronized void insertarGrafico(Grafico g) {
		this.add(g);
		this.setComponentZOrder(g, 0);
	}

	public synchronized void eliminar_Grafico(Grafico g) {
		this.remove(g);
		this.repaint();
	}
}