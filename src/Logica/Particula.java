package Logica;


import Grafico.Grafico;
import Grafico.GraficoParticula;
import Movimiento.Movimiento_vertical;
import Visitor.Visitor_particula;
/*
 * debax : yo creo que esta clase no deberia tener un
 * lanzar particulam, sino el infectado llame a lanzar particula,
 * cosa de poder ubicar la particula en el mapa, creo que seria
 * lo mismo para el premio
 */
public class Particula extends Entidad{
	protected int rango;
	
	public Particula(Juego juego, Grafico grafico) {
		super(juego);
		// hola
		this.visitor = new Visitor_particula(this);
		this.movimiento = new Movimiento_vertical(this,Movimiento_vertical.ARRIBA);
		this.grafico = new GraficoParticula();
		this.grafico.setLocation(grafico.getX()+ this.grafico.getAncho()/2, grafico.getY() + this.grafico.getAlto()+2);
		this.velocidad = 10;
		rango = 5;
	}

	@Override
	public void accionar() {
		// TODO Auto-generated method stub
		
	}
}