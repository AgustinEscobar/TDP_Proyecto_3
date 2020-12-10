package Logica;

import Estado.Estado;
import Estado.EstadoNormal;
import Grafico.GraficoJugador;
import Premio.Premio;
import Visitor.Visitor;
import Visitor.VisitorJugador;

public class Jugador extends Personaje {
	protected int limiteIzq, limiteDer;
	protected Estado estado;

	public Jugador(Juego juego) {
		super(juego);
		this.visitor = new VisitorJugador(this);
		this.grafico = new GraficoJugador();
		this.cargaViral = 0;
		this.velocidad = 8;
		this.danho = 20;
		this.estado = new EstadoNormal(this);
		limiteDer = Mapa.LIMITE_DER_X - this.grafico.getAncho();
		limiteIzq = Mapa.LIMITE_IZQ_X;
		this.grafico.setLocation(limiteDer / 2, Mapa.LIMITE_INFERIOR - grafico.getAlto() - 10);
		premio = null;
	}

	@Override
	public boolean estaInfectado() {
		boolean esta_inf = false;
		if (cargaViral >= 100) {
			esta_inf = true;
		}
		return esta_inf;
	}

	public void setPremio(Premio m) {
		this.premio = m;
	}

	public void setVidaCompleta() {
		this.cargaViral = 0;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public void recibirDanho(float d) {
		cargaViral += d;
		if (cargaViral >= 100) {
			this.juego.terminoJuego(false);
			this.getJuego().setJuegoActivo(false);
		}
	}

	public Estado getEstado() {
		return estado;
	}

	public void disparar() {
		Proyectil newProyectil = estado.getProyectil();
		juego.insertarLuego(newProyectil);
	}

	public void moverADerecha() {
		if (grafico.getX() < limiteDer) {
			grafico.setLocation(grafico.getX() + velocidad, grafico.getY());
		}
	}

	public void moverAIzquierda() {
		if (grafico.getX() > limiteIzq) {
			grafico.setLocation(grafico.getX() - velocidad, grafico.getY());
		}
	}

	@Override
	public void accionar() {
		this.colisiones.detectarColision();
		this.estado.accionarEstado();
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitJugador(this);
	}

}