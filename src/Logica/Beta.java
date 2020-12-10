package Logica;

import java.util.Random;

import Grafico.GraficoBeta;
import Visitor.Visitor;
import Visitor.VisitorBeta;

public class Beta extends Infectado {

	public Beta(Juego juego) {
		super(juego);
		this.visitor = new VisitorBeta(this);
		this.grafico = new GraficoBeta();
		this.danho = 15;
		this.cooldown = 500;
		this.cooldownFinal = cooldown;
		Random ran = new Random();
		int valor;
		valor = ran.nextInt(Mapa.LIMITE_DER_X - this.getGrafico().getAncho());
		this.grafico.setLocation(valor, Mapa.LIMITE_SUPERIOR);
		this.velocidad = 1;
	}

	@Override
	public void recibirDanho(float d) {
		cargaViral -= d * 0.3;
		if (cargaViral <= 0) {
			this.premio = this.premioRandom();
			if (premio != null) {
				this.juego.insertarLuego(premio);
			}
			juego.eliminarInfectado(this);
		}
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitBeta(this);
	}

}
