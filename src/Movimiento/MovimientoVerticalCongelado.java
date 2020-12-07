package Movimiento;

import Logica.Entidad;
import Premio.EfectoTemporal;

public class MovimientoVerticalCongelado extends MovimientoVertical {

	protected int duracion;

	public MovimientoVerticalCongelado(Entidad e, int direccion) {
		super(e, direccion);
		duracion = EfectoTemporal.MAXDURACION;
	}

	public void mover() {
		duracion--;
		if (duracion == 0) {
			this.entidad.setMovimiento();
		}
	}

}
