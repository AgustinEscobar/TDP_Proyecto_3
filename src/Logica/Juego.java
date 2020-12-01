package Logica;

import java.util.LinkedList;
import java.util.List;

import GUI.GameGUI;
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
	protected GameGUI gui;
	protected Jugador jugador;

	protected Nivel[] niveles;
	protected int nivel_actual;
	// protected HiloGeneral hilo;

	protected List<Entidad> entidadesActivas;
	protected List<Entidad> entidadesInsertar;
	protected List<Entidad> entidadesEliminar;

	protected boolean juego_activo;

	public Juego(GameGUI gui) {
		this.mapa = new Mapa(this);
		this.gui = gui;
		this.jugador = new Jugador(this);
		this.niveles = new Nivel[2];
		this.niveles[0] = new Nivel_1(this);
		this.niveles[1] = new Nivel_2(this);
		this.nivel_actual = 0;
		this.entidadesActivas = new LinkedList<Entidad>();
		this.entidadesInsertar = new LinkedList<Entidad>();
		this.entidadesEliminar = new LinkedList<Entidad>();
		this.juego_activo = true;
		iniciarJuego();
		// this.hilo = new HiloGeneral(this, gui);
	}

	public void iniciarJuego() {
		entidadesActivas.add(jugador);
		mapa.insertarGrafico(jugador.getGrafico());
		List<Infectado> lista_infectados = niveles[nivel_actual].getPrimerTanda();
		for (Infectado i : lista_infectados) {
			this.insertarEntidad(i);
		}
	}

	public List<Entidad> detectarColisiones(Entidad entidad) {
		List<Entidad> list_colisiones = new LinkedList<Entidad>();

		for (Entidad e : entidadesActivas) {
			if (entidad != e) {
				if (e.getGrafico().getRectangle().intersects(entidad.getGrafico().getRectangle())) {
					list_colisiones.add(e);
				}
			}
		}

		return list_colisiones;
	}

	public void insertarEntidad(Entidad entidad) {
		this.entidadesActivas.add(entidad);
		this.mapa.insertarGrafico(entidad.getGrafico()); // inserta el grafico de la entidad a la grafica
	}

	public void eliminarLuego(Entidad e) {
		this.entidadesEliminar.add(e);
	}

	public void insertarLuego(Entidad e) {
		this.entidadesInsertar.add(e);
	}

	public void eliminar_infectado(Infectado inf) {
		niveles[nivel_actual].eliminar_infectado(inf);
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

	public int get_nivel_actual() {
		return nivel_actual+1;
	}

	public void avanzar_nivel() {
		if (nivel_actual < niveles.length) {
			nivel_actual += 1;
		}
	}

	private boolean ganoJuego() {
		return nivel_actual + 1 == niveles.length && niveles[nivel_actual].termino_nivel();
	}

	public boolean isJuego_activo() {
		return juego_activo;
	}

	public void setJuego_activo(boolean juego_activo) {
		this.juego_activo = juego_activo;
	}

	private void insertarInfectados(List<Infectado> lista) {
		for (Infectado inf : lista) {
			this.insertarEntidad(inf);
		}
	}

	public void accionar() {
		List<Entidad> colision;
		List<Infectado> lista_infectados;
		if (juego_activo) {
			if (ganoJuego()) {
				juego_activo = false;
			}
			// mejorar
			if (niveles[nivel_actual].termino_nivel()) {
				this.avanzar_nivel();
				lista_infectados = niveles[nivel_actual].getPrimerTanda();
				if (lista_infectados != null) {
					this.insertarInfectados(lista_infectados);
				}
			} else {
				if (niveles[nivel_actual].terminoPrimerTanda()) {
					lista_infectados = niveles[nivel_actual].getSegundaTanda();
					if (lista_infectados != null) {
						this.insertarInfectados(lista_infectados);
					}
				}
			}
			//
			for (Entidad e : entidadesActivas) {
				e.accionar();
				colision = this.detectarColisiones(e);
				for (Entidad colisiona2 : colision) {
					e.aceptar(colisiona2.getVisitor());
				}
			}
			for (Entidad e : entidadesInsertar) {
				entidadesActivas.add(e);
			}
		}
	}

	public void generarDisparo(Proyectil disparo) {
		this.insertarLuego(disparo);
	}

	@Override
	public void run() {
		try {
			while (juego_activo) {
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
				this.mapa.repaint();
			}
		} catch (InterruptedException ex) {

		}
	}

}