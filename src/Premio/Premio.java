package Premio;

import Logica.Entidad;
import Logica.Juego;
import Logica.Mapa;
import Movimiento.MovimientoVertical;

public abstract class Premio extends Entidad {

	public Premio(Juego juego) {
		super(juego);
		this.movimiento = new MovimientoVertical(this, MovimientoVertical.ABAJO);
		this.velocidad = 3;
	}

	@Override
	public void accionar() {
		if (this.grafico.getLocation().getY() >= Mapa.LIMITE_INFERIOR-10) {
			this.eliminar();
		}
		else {
			if (this.grafico.getLocation().getY() < Mapa.LIMITE_INFERIOR) {
				this.movimiento.mover();
				this.colisiones.detectarColision();
			}
		}
			
	}

	public Premio getPremio() {
		return this;
	}
}