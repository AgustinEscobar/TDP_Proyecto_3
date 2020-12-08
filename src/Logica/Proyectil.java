package Logica;

import Grafico.Grafico;
import Movimiento.MovimientoVertical;
import Visitor.VisitorProyectil;

public abstract class Proyectil extends Entidad{
	protected int desinfeccion;
	
	public Proyectil(Juego juego,Grafico graficoJugador) {
		super(juego);
		this.visitor = new VisitorProyectil(this);
		this.movimiento = new MovimientoVertical(this,MovimientoVertical.ARRIBA);
	}
	
	public int getDesinfeccion() {
		return desinfeccion;
	}
	
	@Override
	public void accionar() {
		this.movimiento.mover();
		this.colisiones.detectarColision();
	}
}