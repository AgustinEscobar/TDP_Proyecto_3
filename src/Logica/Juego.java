package Logica;

import java.util.LinkedList;
import java.util.List;

import GUI.gameGUI;
import Nivel.Nivel;
import Nivel.Nivel_1;
import Nivel.Nivel_2;

/*
 * -que el mapa se encargue de la grafica
 * 
 * 
 */
public class Juego implements Runnable {
	protected Mapa mapa;
	protected gameGUI gui;
	protected Jugador jugador;

	protected Nivel[] niveles;
	protected int nivel_actual;
	// protected HiloGeneral hilo;

	protected List<Entidad> entidadesActivas;
	protected List<Entidad> entidadesInsertar;
	protected List<Entidad> entidadesEliminar;

	protected boolean juego_activo;

	public Juego(gameGUI gui) {
		this.mapa = new Mapa(this);
		this.gui = gui;
		this.jugador = new Jugador(this);
		this.niveles = new Nivel[2];
		this.niveles[0] = new Nivel_1();
		this.niveles[1] = new Nivel_2();
		this.nivel_actual = 0;
		this.entidadesActivas = new LinkedList<Entidad>();
		this.entidadesInsertar = new LinkedList<Entidad>();
		this.entidadesEliminar = new LinkedList<Entidad>();
		this.juego_activo = true;
		iniciarJuego();
		// this.hilo = new HiloGeneral(this, gui);
	}

	public void insertarEntidadActiva(Entidad entidad) {
		this.entidadesActivas.add(entidad);
		this.mapa.insertarGrafico(entidad.getGrafico()); // inserta el grafico de la entidad a la grafica
	}

	public void iniciarJuego() {
		entidadesActivas.add(jugador);
		mapa.insertarGrafico(jugador.getGrafico());

		List<Infectado> lista_infectados = niveles[nivel_actual].get_lista_infectados();
		int cant_inf = niveles[nivel_actual].get_cant_infectados();

		for (Infectado i : lista_infectados) {
			entidadesActivas.add(i);
			mapa.insertarGrafico(i.getGrafico());
		}
		this.mapa.repaint();
	}

	public void insertarEntidad_a_Eliminar(Entidad e) {
		this.entidadesEliminar.add(e);
	}

	public void insertarEntidad_a_Insertar(Entidad e) {
		this.entidadesInsertar.add(e);
	}

	public Jugador getPlayer() {
		return jugador;
	}

	public gameGUI getGui() {
		return gui;
	}

	public Mapa getMap() {
		return mapa;
	}

	public Nivel get_nivel_actual() {
		return niveles[nivel_actual];
	}

	public void avanzar_nivel() {
		if (nivel_actual < niveles.length) {
			nivel_actual += 1;
		}
	}

	public boolean isJuego_activo() {
		return juego_activo;
	}

	public void setJuego_activo(boolean juego_activo) {
		this.juego_activo = juego_activo;
	}

	public void accionar() {

		if (juego_activo) {
			if (ganoJuego()) {
				juego_activo = false;
			}

			for (Entidad e : entidadesActivas) {
				e.accionar();
			}
		}
		mapa.repaint();
	}

	public void generarDisparo(Proyectil disparo) {
		this.insertarEntidadActiva(disparo);
	}

	private boolean ganoJuego() {
		// TODO cuando eliminamos todos los enemigos, ganar el nivel, si el nivel es el
		// ultimo, ganar juego.

		return false;
	}

	@Override
	public void run() {
		while (juego_activo) {
			this.accionar();
			for (Entidad e : entidadesEliminar) {
				mapa.eliminar_Grafico(e.getGrafico()); // de mapa
				entidadesActivas.remove(e);
			}
			entidadesEliminar = new LinkedList<Entidad>();
			for (Entidad e : entidadesInsertar) {
				entidadesActivas.add(e);
			}
			entidadesInsertar = new LinkedList<Entidad>();
			this.mapa.repaint();
			try {
				Thread.sleep(5);
			} catch (InterruptedException ex) {

			}
		}
	
	}

}