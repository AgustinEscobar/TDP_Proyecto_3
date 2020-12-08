package Logica;

import java.util.LinkedList;
import java.util.List;

import GUI.GameGUI;
import Nivel.Nivel;
import Nivel.Nivel1;
import Nivel.Nivel2;

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
		this.niveles[0] = new Nivel1(this, 2);
		this.niveles[1] = new Nivel2(this, 2);
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
//		List<Infectado> lista_infectados = niveles[nivel_actual].getPrimerTanda();
//		for (Infectado i : lista_infectados) {
//			this.insertarEntidad(i);
//		}
		niveles[nivel_actual].accionarNivel();
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

	public void eliminarInfectado(Infectado inf) {
		niveles[nivel_actual].eliminarInfectado(inf);
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
		return nivel_actual + 1;
	}

	public void avanzarNivel() {
		nivel_actual += 1;
	}

//	private boolean esUltimoNivel() {
//		boolean esUltimo = false;
//
//		if (nivel_actual == niveles.length) {
//			esUltimo = niveles[nivel_actual - 1].terminoNivel();
//		}
//		
//		
//		return esUltimo;
//	}

	private boolean ganoJuego() {
		return niveles[niveles.length - 1].terminoNivel();
	}

	public boolean isJuego_activo() {
		return juego_activo;
	}

	public void setJuego_activo(boolean juego_activo) {
		this.juego_activo = juego_activo;
	}

	public void accionar() {
		List<Entidad> colision;
		if (juego_activo) {
			if (ganoJuego()) {
				juego_activo = false;
				System.out.println("termino paper");
			} else {
				// --- 1.0
				// --- 2.0 begin
				if (niveles[nivel_actual].terminoNivel()) {
					this.avanzarNivel();
					this.mapa.cambiarNivel(nivel_actual + 1);
				}
				if (!ganoJuego()) {
					niveles[nivel_actual].accionarNivel();
				}

				// --- 2.0 end
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