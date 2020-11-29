package Logica;

import java.util.Random;

import Grafico.GraficoBeta;
import Premio.Efecto_temporal;
import Premio.Objeto_precioso;
import Visitor.Visitor_beta;

public class Beta extends Infectado {

	public Beta(Juego juego) {
		super(juego);
		this.visitor = new Visitor_beta(this);
		this.grafico = new GraficoBeta();
		this.danio = 15;
		Random ran = new Random();
		int valor;
		valor = ran.nextInt(3);
		if (valor == 0) {
			premio = new Efecto_temporal(juego);
		} else {
			if (valor == 1) {
				premio = new Objeto_precioso(juego);
			} else {
				premio = null;
			}
		}
		valor = ran.nextInt(Mapa.LIMITE_DER_X);
		this.grafico.setLocation(valor, Mapa.LIMITE_SUPERIOR);
		this.velocidad = 2;
		this.letalidad = 10;
	}

	@Override
	public void recibir_danio(float d) {
		carga_viral -= d * 0.15;
		if (carga_viral <= 0) {
//			this.getJuego().getMap().eliminarEntidad_activos(this);
		}
	}

}
