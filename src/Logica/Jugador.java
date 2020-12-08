package Logica;

import Estado.Estado;
import Estado.EstadoNormal;
import Grafico.GraficoJugador;
import Premio.Premio;
import Visitor.Visitor;
import Visitor.VisitorJugador;

public class Jugador extends Personaje {

	protected Arma arma; // conceptual
	protected int limite_izq, limite_der;
	protected Estado estado;

	public Jugador(Juego juego) {
		super(juego);
		this.visitor = new VisitorJugador(this);
		this.grafico = new GraficoJugador();
		this.carga_viral = 0;
		this.danio = 100;
		this.estado = new EstadoNormal(this);
		arma = new Arma(new ProyectilSanitario(juego, this.grafico), this);
		limite_der = Mapa.LIMITE_DER_X - this.grafico.getAncho();
		limite_izq = Mapa.LIMITE_IZQ_X;
		this.grafico.setLocation(limite_der / 2, Mapa.LIMITE_INFERIOR - grafico.getAlto() - 10);
		premio = null;
	}

	@Override
	public boolean esta_infectado() {
		boolean esta_inf = false;
		if (carga_viral >= 100) {
			esta_inf = true;
		}
		return esta_inf;
	}

	public void setPremio(Premio m) {
		this.premio = m;
	}

	public void setVidaCompleta() {
		this.carga_viral = 0;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public void recibirDanho(float d) {
		carga_viral += d;
		if (carga_viral >= 100) {
			System.out.println("jugador muerrto");
			this.eliminar();
			this.getJuego().setJuego_activo(false);
		}
	}
	
	public Estado getEstado() {
		return estado;
	}
	
	public Arma getArma() {
		return arma;
	}

	public Proyectil disparar() {
		return arma.disparar();
	}

	public void moverADerecha() {
		if (grafico.getX() < limite_der) {
			grafico.setLocation(grafico.getX() + 6, grafico.getY());
		}
	}

	public void moverAIzquierda() {
		if (grafico.getX() > limite_izq) {
			grafico.setLocation(grafico.getX() - 6, grafico.getY());
		}
	}

	public void accionarJugador() {
		this.estado.accionarEstado(this);
	}

	@Override
	public void accionar() {
		this.colisiones.detectarColision();
	}

	@Override
	public void aceptar(Visitor v) {
		v.visit_jugador(this);
	}

}