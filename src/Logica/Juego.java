package Logica;

import java.util.LinkedList;
import java.util.List;

import GUI.GameGUI;
import Nivel.Nivel;
import Nivel.Nivel1;
import Nivel.Nivel2;
import Nivel.Nivel3;

public class Juego implements Runnable {
	protected Mapa mapa;
	protected GameGUI gui;
	protected Jugador jugador;
	protected Nivel[] niveles;
	protected int nivelActual;

	protected List<Entidad> entidadesActivas;
	protected List<Entidad> entidadesInsertar;
	protected List<Entidad> entidadesEliminar;

	protected boolean juegoActivo;

	public Juego(GameGUI gui) {
		this.mapa = new Mapa(this);
		this.gui = gui;
		this.jugador = new Jugador(this);
		this.niveles = new Nivel[3];
		this.niveles[0] = new Nivel1(this, 2);
		this.niveles[1] = new Nivel2(this, 2);
		this.niveles[2] = new Nivel3(this, 1);
		this.nivelActual = 0;

		this.entidadesActivas = new LinkedList<Entidad>();
		this.entidadesInsertar = new LinkedList<Entidad>();
		this.entidadesEliminar = new LinkedList<Entidad>();
		this.juegoActivo = true;
		iniciarJuego();
	}

	private void iniciarJuego() {
		entidadesActivas.add(jugador);
		mapa.insertarGrafico(jugador.getGrafico());
		niveles[nivelActual].accionarNivel();
	}

	public void insertarEntidad(Entidad entidad) {
		this.entidadesActivas.add(entidad);
		this.mapa.insertarGrafico(entidad.getGrafico());
	}

	public void eliminarLuego(Entidad e) {
		this.entidadesEliminar.add(e);
	}

	public void insertarLuego(Entidad e) {
		this.entidadesInsertar.add(e);
	}

	public void eliminarInfectado(Infectado inf) {
		niveles[nivelActual].eliminarInfectado(inf);
		this.eliminarLuego(inf);
	}

	public Jugador getPlayer() {
		return jugador;
	}

	public GameGUI getGui() {
		return gui;
	}

	public Mapa getMap() {
		return mapa;
	}

	public int getNivelActual() {
		return nivelActual + 1;
	}

	private void avanzarNivel() {
		nivelActual += 1;
	}

	private boolean ganoJuego() {
		return niveles[niveles.length - 1].terminoNivel();
	}

	public boolean isJuegoActivo() {
		return juegoActivo;
	}

	public void setJuegoActivo(boolean juegoActivo) {
		this.juegoActivo = juegoActivo;
	}

	public void accionar() {
		if (juegoActivo) {
			if (ganoJuego()) {
				juegoActivo = false;
				this.terminoJuego(true);
			} else {
				if (niveles[nivelActual].terminoNivel()) {
					this.avanzarNivel();
					this.mapa.cambiarNivel(nivelActual + 1);
				}
				niveles[nivelActual].accionarNivel();
				for (Entidad entidad : entidadesActivas) {
					entidad.accionar();
				}

				for (Entidad e : entidadesInsertar) {
					entidadesActivas.add(e);
				}
			}
		}
	}

	public void generarDisparo(Proyectil disparo) {
		this.insertarLuego(disparo);
	}

	public List<Entidad> entidades() {
		return entidadesActivas;
	}

	public void terminoJuego(boolean termino) {
		this.gui.terminoJuego(termino);
	}

	@Override
	public void run() {
		try {
			while (juegoActivo) {
				this.accionar();
				Thread.sleep(5);
				for (Entidad e : entidadesEliminar) {
					mapa.eliminar_Grafico(e.getGrafico());
					entidadesActivas.remove(e);
				}
				entidadesEliminar = new LinkedList<Entidad>();
				for (Entidad e : entidadesInsertar) {
					this.insertarEntidad(e);
				}
				entidadesInsertar = new LinkedList<Entidad>();
				this.gui.actualizarNivel();
				this.gui.actualizarVidaJugador(jugador);
				this.mapa.repaint();
			}
		} catch (InterruptedException ex) {

		}
	}

}