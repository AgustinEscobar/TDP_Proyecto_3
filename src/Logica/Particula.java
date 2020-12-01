package Logica;

import Grafico.GraficoParticula;
import Movimiento.Movimiento_vertical;
import Visitor.Visitor;
import Visitor.Visitor_particula;

public class Particula extends Entidad {
	protected Infectado infectado;
	protected int rango;

	public Particula(Juego juego, Infectado infectado) {
		super(juego);
		this.infectado = infectado;
		this.visitor = new Visitor_particula(this);
		this.movimiento = new Movimiento_vertical(this, Movimiento_vertical.ABAJO);
		this.grafico = new GraficoParticula();
		this.grafico.setLocation(infectado.getGrafico().getX() + this.grafico.getAncho() / 2,
				infectado.getGrafico().getY() + this.grafico.getAlto() + 2);
		this.velocidad = 10;
		rango = 100;
	}

	public Infectado getInfectado() {
		return infectado;
	}

	@Override
	public void accionar() {
		if (rango == 0 || this.grafico.getY() >= Mapa.LIMITE_INFERIOR) {
			rango = 100;
			this.eliminar();
		} else {
			rango -= 1;
			movimiento.mover();
			infectado.disparar();
		}
	}

	@Override
	public void aceptar(Visitor v) {
		v.visit_virus(this);

	}
}