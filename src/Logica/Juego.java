package Logica;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

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

		List<Infectado> lista_infectados = niveles[nivel_actual].get_lista_infectados();
		int cant_inf = niveles[nivel_actual].get_cant_infectados();

		for (Infectado i : lista_infectados) {
			Random r = new Random();
			int ran = r.nextInt(2);
			if (ran != 0) {
				entidadesActivas.add(i);
				mapa.insertarGrafico(i.getGrafico());
			} else {
				entidadesInsertar.add(i);
			}
		}
		// this.mapa.repaint();
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

	public void insertarEntidadActiva(Entidad entidad) {
		this.entidadesActivas.add(entidad);
		this.mapa.insertarGrafico(entidad.getGrafico()); // inserta el grafico de la entidad a la grafica
	}

	public void insertarEntidad_a_Eliminar(Entidad e) {
		this.entidadesEliminar.add(e);
	}

	public void insertarEntidad_a_Insertar(Entidad e) {
		this.entidadesInsertar.add(e);
	}
	
	public void eliminar_infectado(Infectado inf) {
		niveles[nivel_actual].eliminar_infectado(inf);
		this.insertarEntidad_a_Eliminar(inf);
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
		List<Entidad> colision = new LinkedList<Entidad>();
		if (juego_activo) {
			if (ganoJuego()) {
				juego_activo = false;
			}

			if (niveles[nivel_actual].termino_nivel()) {
				this.avanzar_nivel();
				List<Infectado> lista_infectados = niveles[nivel_actual].get_lista_infectados();
				for (Infectado inf : lista_infectados) {
					this.insertarEntidadActiva(inf);
					
				}
			}

			for (Entidad e : entidadesActivas) {
				e.accionar();
				colision = new LinkedList<Entidad>();
				colision = this.detectarColisiones(e);

				for (Entidad colisiona2 : colision) {
					e.aceptar(colisiona2.getVisitor());
				}
			}
			for (Entidad e : entidadesInsertar) {
				entidadesActivas.add(e);
			}

			// mapa.repaint();
		}

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
			try {
				Thread.sleep(5);
			} catch (InterruptedException ex) {

			}
			for (Entidad e : entidadesEliminar) {

				mapa.eliminar_Grafico(e.getGrafico()); // de mapa
				entidadesActivas.remove(e);
			}
			entidadesEliminar = new LinkedList<Entidad>();
			for (Entidad e : entidadesInsertar) {
				this.insertarEntidadActiva(e);
			}
			entidadesInsertar = new LinkedList<Entidad>();
			this.mapa.repaint();

		}

	}

}