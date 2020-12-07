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
		this.danio = 15;
		Random ran = new Random();
		int valor;
		valor = ran.nextInt(Mapa.LIMITE_DER_X - this.getGrafico().getAncho());
		this.grafico.setLocation(valor, Mapa.LIMITE_SUPERIOR);
		this.velocidad = 1;
		this.letalidad = 10;
	}

	@Override
	public void recibirDanho(float d) {
		carga_viral -= d;
		if (carga_viral <= 0) {
			this.premio = this.premioRandom();
			if (premio != null) {
				this.juego.insertarLuego(premio);
			}
			juego.eliminarInfectado(this);
		}
	}
	
	@Override
	public void aceptar(Visitor v) {
		v.visit_beta(this);
	}

}
