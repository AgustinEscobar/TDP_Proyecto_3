package Movimiento;

import Logica.Entidad;

public class MovimientoVerticalCongelado extends Movimiento_vertical {
	
	protected static final int MAXDURACION= 1000;
	protected int duracion;
	
	public MovimientoVerticalCongelado(Entidad e, int direccion) {
		super(e, direccion);
		duracion= MAXDURACION;
	}
	
	public void mover() {
		duracion--;
		if (duracion==0) {
			this.entidad.setMovimiento();
		}
	}
	
}
