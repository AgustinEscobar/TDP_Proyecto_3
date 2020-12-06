package Logica;

import Grafico.Grafico;
import Movimiento.Movimiento_vertical;
import Visitor.Visitor_proyectil;

public abstract class Proyectil extends Entidad{
	protected int desinfeccion;
	
	public Proyectil(Juego juego,Grafico grafico_jugador) {
		super(juego);
		this.visitor = new Visitor_proyectil(this);
		this.movimiento = new Movimiento_vertical(this,Movimiento_vertical.ARRIBA);
	}
	
	public int getDesinfeccion() {
		return desinfeccion;
	}
}