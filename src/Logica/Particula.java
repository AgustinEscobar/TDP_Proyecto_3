package Logica;

import Grafico.GraficoParticula;
import Movimiento.Movimiento_vertical;
import Visitor.Visitor;
import Visitor.Visitor_particula;
/*
 * debax : yo creo que esta clase no deberia tener un
 * lanzar particulam, sino el infectado llame a lanzar particula,
 * cosa de poder ubicar la particula en el mapa, creo que seria
 * lo mismo para el premio
 */
public class Particula extends Entidad{
	protected Infectado infectado;
	protected int rango;
	
	public Particula(Juego juego, Infectado infectado) {
		super(juego);
		// hola
		this.infectado = infectado;
		this.visitor = new Visitor_particula(this);
		this.movimiento = new Movimiento_vertical(this,Movimiento_vertical.ABAJO);
		this.grafico = new GraficoParticula();
		this.grafico.setLocation(infectado.getGrafico().getX()+ this.grafico.getAncho()/2, infectado.getGrafico().getY() + this.grafico.getAlto()+2);
		this.velocidad = 10;
		rango = 5;
	}
	
	public Infectado getInfectado() {
		return infectado;
	}

	@Override
	public void accionar() {
		infectado.disparar();
		movimiento.mover();
	}

	@Override
	public void aceptar(Visitor v) {
		v.visit_virus(this);
		
	}
}