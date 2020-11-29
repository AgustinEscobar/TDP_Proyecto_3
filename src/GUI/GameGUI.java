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

				int codigoTeclado = e.getKeyCode();

				if (codigoTeclado == KeyEvent.VK_LEFT || codigoTeclado == KeyEvent.VK_A) {
					juego.getPlayer().moverAIzquierda();
				}
				if (codigoTeclado == KeyEvent.VK_RIGHT || codigoTeclado == KeyEvent.VK_D) {
					juego.getPlayer().moverADerecha();
				}

//				if (codigoTeclado == KeyEvent.VK_SPACE) {
//					System.out.println("ahi va la bala, cabeceala");
//					//disparar de jugador tiene que retornar proyectil
//                    juego.generarDisparo(jugador.disparar());
//				}
				posJugador.setLocation(juego.getPlayer().get_x(), juego.getPlayer().get_y());
				grafico_jugador.setLocation(posJugador);
			}

			public void keyReleased(KeyEvent e) {
				int codigoTecla = e.getKeyCode();

				if (codigoTecla == KeyEvent.VK_SPACE) {
					juego.generarDisparo(jugador.disparar());
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

//		int valor = random.nextInt(LIMITE_DER_X);
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

	/**
	 * Launch the application. //
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
////					SplashScreen splash = new SplashScreen(300);
////					splash.showSplash();
//					gameGUI frame = new gameGUI();
//					
//					//gameGUI g = new gameGUI();
//					Thread t = new Thread();
//					t.start();
//					
////					hilo = new HiloGeneral();
////					game = hilo.getJuego();
////					gameGUI frame = hilo.getGame_gui();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

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
