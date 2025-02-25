package Logica;

import Grafico.GraficoParticula;
import Movimiento.MovimientoVertical;
import Visitor.Visitor;
import Visitor.VisitorParticula;

public class Particula extends Entidad {
	protected Infectado infectado;
	protected int rango;

	public Particula(Juego juego, Infectado infectado) {
		super(juego);
		this.infectado = infectado;
		this.visitor = new VisitorParticula(this);
		this.movimiento = new MovimientoVertical(this, MovimientoVertical.ABAJO);
		this.grafico = new GraficoParticula();
		this.grafico.setLocation(infectado.getGrafico().getX() + infectado.getGrafico().getAncho() / 2,
		infectado.getGrafico().getY() + infectado.getGrafico().getAlto());
		this.velocidad = 10;
		rango = 100;
	}

	public Infectado getInfectado() {
		return infectado;
	}

	@Override
	public void accionar() {
		if (this.grafico.getLocation().getY() >= Mapa.LIMITE_INFERIOR-10) {
			this.eliminar();
			this.getGrafico().setVisible(false);
		}
		if (rango == 0 ) {
			this.rango = 100;
			this.eliminar();
		} else {
			this.rango -= 1;
			this.movimiento.mover();
			this.colisiones.detectarColision();
		}
	}


	@Override
	public void aceptar(Visitor v) {
		v.visitParticula(this);
	}
}