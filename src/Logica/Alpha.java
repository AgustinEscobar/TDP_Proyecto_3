package Logica;

import java.util.Random;

import Grafico.GraficoAlpha;
import Movimiento.Movimiento_vertical_rapido;
import Premio.Efecto_temporal;
import Premio.Objeto_precioso;
import Visitor.Visitor;
import Visitor.Visitor_alpha;

public class Alpha extends Infectado {

	public Alpha(Juego juego) {
		super(juego);
		this.visitor = new Visitor_alpha(this);
		this.grafico = new GraficoAlpha();
		this.danio = 15;
		Random ran = new Random();
		int valor;
//		valor = ran.nextInt(3);
//		if (valor == 0) {
//			premio = new Efecto_temporal(juego, this);
//		} else {
//			if (valor == 1) {
//				premio = new Objeto_precioso(juego, this);
//			} else {
//				premio = null;
//			}
//		}
		valor = ran.nextInt(Mapa.LIMITE_DER_X - this.getGrafico().getAncho());
		this.grafico.setLocation(valor, Mapa.LIMITE_SUPERIOR);
		this.velocidad = 1;
		this.letalidad = 25;
	}

	@Override
	public void recibir_danio(float d) {
		this.carga_viral -= d;
		if (carga_viral <= 0) {
			this.premio = this.premioRandom();
			if (this.premio != null) {
				juego.insertarLuego(premio);
			}
			juego.eliminar_infectado(this);
		} else {
			if (carga_viral < 80) {
				this.movimiento = new Movimiento_vertical_rapido(this, Movimiento_vertical_rapido.ABAJO);
			}
		}
	}

	@Override
	public void aceptar(Visitor v) {
		v.visit_alpha(this);
	}

}
