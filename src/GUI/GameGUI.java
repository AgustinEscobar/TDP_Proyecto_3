package GUI;

import java.awt.Point;

import javax.swing.ImageIcon;
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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameGUI extends JFrame {

	private Juego juego;
	private JPanel contentPane;
	private Mapa panelMapa;
	private JPanel panelOpciones;
	private JLabel nivelActual;
	private JProgressBar progressBar;
	private JButton botonReiniciar;

	/*
	 * Create the frame.
	 */
	public GameGUI() {
		juego = new Juego(this);
		panelMapa = juego.getMap();

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 669);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		contentPane.add(juego.getMap());

		panelOpciones = new JPanel();
		panelOpciones.setBounds(0, 572, 599, 58);
		contentPane.add(panelOpciones);
		panelOpciones.setLayout(null);
		panelOpciones.setBackground(Color.DARK_GRAY);

		JLabel vidaJugador = new JLabel("Carga viral:");
		vidaJugador.setForeground(Color.WHITE);
		vidaJugador.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 15));
		vidaJugador.setBounds(10, 3, 144, 23);
		panelOpciones.add(vidaJugador);

		nivelActual = new JLabel("Nivel actual:");
		nivelActual.setForeground(Color.WHITE);
		nivelActual.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 15));
		nivelActual.setBounds(228, 11, 144, 36);
		panelOpciones.add(nivelActual);

		progressBar = new JProgressBar(0, 100);
		progressBar.setBounds(10, 24, 157, 23);
		progressBar.setValue(0);
		progressBar.setBackground(Color.GREEN);
		panelOpciones.add(progressBar);

		botonReiniciar = new JButton("Jugar de nuevo");
		botonReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (botonReiniciar.isEnabled()) {
					dispose();
					GameGUI g = new GameGUI();
					g.setLocationRelativeTo(null);
					Thread t = new Thread(g.getJuego());
					t.start();
				}
			}
		});

		botonReiniciar.setForeground(Color.BLACK);
		botonReiniciar.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		botonReiniciar.setBounds(409, 11, 157, 36);
		botonReiniciar.setBackground(Color.LIGHT_GRAY);
		botonReiniciar.setEnabled(false);
		botonReiniciar.setVisible(false);
		panelOpciones.add(botonReiniciar);

		Jugador jugador = juego.getPlayer();
		Grafico grafico_jugador = jugador.getGrafico();
		grafico_jugador.setBounds(jugador.getX(), jugador.getY(), grafico_jugador.getAncho(),
				grafico_jugador.getAlto());

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (juego.isJuegoActivo()) {
					int codigoTeclado = e.getKeyCode();

					if (codigoTeclado == KeyEvent.VK_LEFT || codigoTeclado == KeyEvent.VK_A) {
						juego.getPlayer().moverAIzquierda();
					}
					if (codigoTeclado == KeyEvent.VK_RIGHT || codigoTeclado == KeyEvent.VK_D) {
						juego.getPlayer().moverADerecha();
					}
				}
			}

			public void keyReleased(KeyEvent e) {
				int codigoTecla = e.getKeyCode();
				if (juego.isJuegoActivo()) {
					if (codigoTecla == KeyEvent.VK_SPACE) {
						juego.getPlayer().disparar();
					}
				}
			}
		});
		
		addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				juego.getPlayer().disparar();
			}
		});
		this.setVisible(true);
	}
	
	

	public Juego getJuego() {
		return juego;
	}

	public int getAlto() {
		return panelMapa.getHeight();
	}

	public Mapa getPanelMapa() {
		return panelMapa;
	}

	public int getAncho() {
		return panelMapa.getWidth();
	}

	public void actualizarNivel() {
		nivelActual.setText("Nivel actual: " + juego.getNivelActual());
	}

	public void actualizarVidaJugador(Jugador jugador) {
		int vida = (int) jugador.getVida();
		if (progressBar.getValue() > 70) {
			progressBar.setBackground(Color.RED);
		} else {
			progressBar.setBackground(Color.GREEN);
		}
		progressBar.setValue(vida);
		progressBar.repaint();
	}

	public void terminoJuego(boolean termino) {
		if (termino) { // gano
			panelMapa.gameWin();
			JOptionPane.showMessageDialog(null, "Muy bien 10 felicitado", "¡Ganaste!", JOptionPane.INFORMATION_MESSAGE);
		} else { // perdio
			panelMapa.gameOver();
			JOptionPane.showMessageDialog(null, "Que bajonaso", "¡Perdiste!",
					JOptionPane.INFORMATION_MESSAGE);
		}
		botonReiniciar.setEnabled(true);
		botonReiniciar.setVisible(true);
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				GameGUI g = new GameGUI();
				g.setLocationRelativeTo(null);
				Thread t = new Thread(g.getJuego());
				t.start();
			}
		});
	}
}
