package Logica;

import Grafico.Grafico;
import Grafico.GraficoProyectilSanitario;
import Movimiento.Movimiento_vertical;
import Visitor.Visitor_proyectil;

public abstract class Proyectil extends Entidad{
	
	protected int cap_desinfeccion;
	
	public Proyectil(Juego juego,Grafico grafico) {
		super(juego);
		this.visitor = new Visitor_proyectil(this);
		this.grafico = new GraficoProyectilSanitario();
		this.grafico.setLocation(grafico.getX(), grafico.getY());
		this.movimiento = new Movimiento_vertical(this,Movimiento_vertical.ARRIBA);
	}
}