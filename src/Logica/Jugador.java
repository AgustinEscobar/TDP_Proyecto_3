package Logica;

import GUI.gameGUI;
import Grafico.GraficoJugador;
import Premio.Premio;
import Visitor.Visitor_jugador;

public class Jugador extends Personaje {

	protected Arma arma; // conceptual
	protected int limite_izq, limite_der;

	public Jugador() {
		this.visitor = new Visitor_jugador(this);
		this.grafico = new GraficoJugador();
		this.carga_viral = 0;
		arma = new Arma(new Proyectil_sanitario(this.grafico),this);
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

	@Override
	public void recibir_danio(float d) {
		carga_viral += d;
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

}