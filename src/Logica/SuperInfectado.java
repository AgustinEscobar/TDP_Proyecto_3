package Logica;

import java.util.Random;

import Grafico.GraficoSuperEnemigo;
import Visitor.Visitor;
import Visitor.VisitorSuperInfectado;

public class SuperInfectado extends Infectado {

	public SuperInfectado(Juego juego) {
		super(juego);
		this.visitor = new VisitorSuperInfectado(this);
		this.grafico = new GraficoSuperEnemigo();
		this.danho = 10;
		Random ran = new Random();
		int valor;
		valor = ran.nextInt(Mapa.LIMITE_DER_X - this.getGrafico().getAncho());
		this.grafico.setLocation(valor, Mapa.LIMITE_SUPERIOR);
		this.velocidad = 1;
	}

	@Override
	public void recibirDanho(float d) {
		cargaViral -= d * 0.2;
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
		v.visitSuperInfectado(this);
	}
}
