package Premio;

import Logica.Entidad;
import Logica.Juego;
import Logica.Mapa;
import Movimiento.Movimiento_vertical;
import Visitor.Visitor_premio;

public abstract class Premio extends Entidad {

	public Premio(Juego juego) {
		super(juego);
//		this.visitor = new Visitor_premio(this);
		this.movimiento = new Movimiento_vertical(this, Movimiento_vertical.ABAJO);
		this.velocidad = 1;
	}

	@Override
	public void accionar() {
		if (this.grafico.getLocation().getY() < Mapa.LIMITE_INFERIOR) {
			this.movimiento.mover();
		}else {
			this.eliminar();
		}
			
	}

	public Premio getPremio() {
		return this;
	}
}