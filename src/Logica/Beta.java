package Logica;

import java.util.Random;

import Grafico.GraficoBeta;
import Visitor.Visitor;
import Visitor.Visitor_beta;

public class Beta extends Infectado {

	public Beta(Juego juego) {
		super(juego);
		this.visitor = new Visitor_beta(this);
		this.grafico = new GraficoBeta();
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
		this.letalidad = 10;
	}

	@Override
	public void recibir_danio(float d) {
		carga_viral -= d;// ACOMODAR
		if (carga_viral <= 0) {
			this.premio = this.premioRandom();
			if (premio != null) {
				this.juego.insertarLuego(premio);
			}
			juego.eliminar_infectado(this);
		}
		// System.out.println("Quite vida a Beta" + carga_viral + "vida restante");

	}

	@Override
	public void aceptar(Visitor v) {
		v.visit_beta(this);
	}

}
