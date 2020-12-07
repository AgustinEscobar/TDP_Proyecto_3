package Logica;

import java.util.Random;

import Grafico.GraficoAlpha;
import Movimiento.MovimientoVertical;
import Movimiento.MovimientoVerticalRapido;
import Visitor.Visitor;
import Visitor.VisitorAlpha;

public class Alpha extends Infectado {

	public Alpha(Juego juego) {
		super(juego);
		this.visitor = new VisitorAlpha(this);
		this.grafico = new GraficoAlpha();
		this.danio = 15;
		Random ran = new Random();
		int valor;
		valor = ran.nextInt(Mapa.LIMITE_DER_X - this.getGrafico().getAncho());
		this.grafico.setLocation(valor, Mapa.LIMITE_SUPERIOR);
		this.velocidad = 1;
		this.letalidad = 25;
	}

	@Override
	public void recibirDanho(float d) {
		this.carga_viral -= d;
		if (carga_viral <= 0) {
			this.premio = this.premioRandom();
			if (this.premio != null) {
				juego.insertarLuego(premio);
			}
			juego.eliminarInfectado(this);
		} else {
			if (carga_viral < 20) {
				this.movimiento = new MovimientoVerticalRapido(this, MovimientoVerticalRapido.ABAJO);
			}
		}
	}

	public void setMovimiento() {
		if (carga_viral < 20) {
			this.movimiento = new MovimientoVerticalRapido(this, MovimientoVerticalRapido.ABAJO);
		} else
			this.movimiento = new MovimientoVertical(this, MovimientoVertical.ABAJO);
	}

	@Override
	public void aceptar(Visitor v) {
		v.visit_alpha(this);
	}

}
