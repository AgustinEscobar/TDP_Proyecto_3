package Movimiento;

import java.awt.Point;

import Logica.Entidad;

public class MovimientoVertical extends Movimiento {

	public MovimientoVertical(Entidad e, int direccion) {
		super(e, direccion);
		this.duracion = 5;
	}

	public void mover() {
		if (duracion != 0) {
			duracion--;
		} else {
			Point p = entidad.getGrafico().getLocation();
			double x = p.getX();
			double y = p.getY() + entidad.getVelocidad() * direccion;
			
			// !!
			if (direccion == MovimientoVertical.ABAJO) {
				this.moverAbajo(p, x, y);		
			}else {
				this.moverArriba(p, x, y);
			}
			
			duracion = 5;
		}
	}
}