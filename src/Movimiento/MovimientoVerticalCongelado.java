package Movimiento;

import Logica.Entidad;
import Premio.Efecto_temporal;

public class MovimientoVerticalCongelado extends Movimiento_vertical {

	protected int duracion;

	public MovimientoVerticalCongelado(Entidad e, int direccion) {
		super(e, direccion);
		duracion = Efecto_temporal.MAXDURACION;
	}

	public void mover() {
		duracion--;
		if (duracion == 0) {
			this.entidad.setMovimiento();
		}
	}

}
