package GUI;

import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import Grafico.Grafico;
import Logica.Juego;
import Logica.Jugador;
import Logica.Mapa;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JLabel;

public class GameGUI extends JFrame {

	private Juego juego;
	private JPanel contentPane;
	private Mapa panelMapa;

	/*
	 * Create the frame.
	 */
	public GameGUI() {
		juego = new Juego(this);

		Random random = new Random();

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// PASAR A MAPA
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// ---------------- BARRA LATERAL DONDE VAN LAS OPCIONES ----------------
		JPanel barra_opciones = new JPanel();
		barra_opciones.setBounds(590, 0, 206, 571);

		contentPane.add(juego.getMap());

		contentPane.add(barra_opciones);
		barra_opciones.setLayout(null);
		
		JLabel nivelActual = new JLabel("Nivel actual: "+juego.get_nivel_actual());
		nivelActual.setBounds(0, 5, 206, 38);
		barra_opciones.add(nivelActual);
		
//		panelMapa = new Mapa();
//		panelMapa.setBounds(0, 0, 591, 571);
//		contentPane.add(panelMapa);
//		panelMapa.setLayout(null);

		Jugador jugador = juego.getPlayer();
		Grafico grafico_jugador = jugador.getGrafico();
		grafico_jugador.setBounds(jugador.get_x(), jugador.get_y(), grafico_jugador.getAncho(),
				grafico_jugador.getAlto());

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				Point posJugador = juego.getPlayer().getPosicion();
				if (juego.isJuego_activo()) {
					int codigoTeclado = e.getKeyCode();
	
					if (codigoTeclado == KeyEvent.VK_LEFT || codigoTeclado == KeyEvent.VK_A) {
						juego.getPlayer().moverAIzquierda();
					}
					if (codigoTeclado == KeyEvent.VK_RIGHT || codigoTeclado == KeyEvent.VK_D) {
						juego.getPlayer().moverADerecha();
					}
					posJugador.setLocation(juego.getPlayer().get_x(), juego.getPlayer().get_y());
					grafico_jugador.setLocation(posJugador);
				}
			}

			public void keyReleased(KeyEvent e) {
				nivelActual.setText("Nivel actual: "+juego.get_nivel_actual());
				int codigoTecla = e.getKeyCode();
				if (juego.isJuego_activo()) {
					if (codigoTecla == KeyEvent.VK_SPACE) {
							juego.generarDisparo(jugador.disparar());
					}
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {

				switch (e.getKeyCode()) {
//				case KeyEvent.VK_SPACE: {
//					System.out.println("keo");
//					juego.getPlayer().disparar();
//					//disparar de jugador tiene que retornar proyectil
//                    juego.generarDisparo(jugador.disparar());
//                    System.out.print("booludaso");
//					break;
//				}
				}
			}
		});
		this.setVisible(true);
	}

	public Juego getJuego() {
		return juego;
	}

	public int get_alto() {
		return panelMapa.getHeight();
	}

	public Mapa getPanelMapa() {
		return panelMapa;
	}

	public int get_ancho() {
		return panelMapa.getWidth();
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				GameGUI g = new GameGUI();
				Thread t = new Thread(g.getJuego());
				t.start();
			}
		});
	}

}
