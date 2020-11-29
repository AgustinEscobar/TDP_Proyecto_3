package Logica;

import Estado.Estado;
import Estado.EstadoNormal;
import Grafico.GraficoJugador;
import Premio.Premio;
import Visitor.Visitor;
import Visitor.Visitor_jugador;

public class Jugador extends Personaje {

	protected Arma arma; // conceptual
	protected int limite_izq, limite_der;
	protected Estado estado;

	public Jugador(Juego juego) {
		super(juego);
		this.visitor = new Visitor_jugador(this);
		this.grafico = new GraficoJugador();
		this.carga_viral = 99;
		this.danio = 10;
		this.estado = new EstadoNormal();
		arma = new Arma(new Proyectil_sanitario(juego,this.grafico),this);
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
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public void recibir_danio(float d) {
		carga_viral += d;
		System.out.println("Carga viral del Jugador" + carga_viral);
		if (carga_viral >= 100) {
			this.eliminar();
			this.getJuego().setJuego_activo(false);
		}
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

	@Override
	public void accionar() {
		// ACTUALIZAR DISPARO
		disparar();
	}

	@Override
	public void aceptar(Visitor v) {
		v.visit_jugador(this);
		
	}

}