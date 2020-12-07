package Movimiento;

import java.awt.Point;

import Logica.Entidad;

public class MovimientoVerticalRapido extends MovimientoVertical {
	

	public MovimientoVerticalRapido(Entidad entidad, int direccion) {
		super(entidad,direccion);
		this.velocidad_extra = 1;
		duracion = 20;
	}

	public void mover() {
		Point p = entidad.getGrafico().getLocation();
		double x = p.getX();
		double y = p.getY() + entidad.getVelocidad() * direccion + velocidad_extra;
		
		if (direccion == MovimientoVertical.ABAJO) {
			this.moverAbajo(p, x, y);		
		}else {
			moverArriba(p, x, y);
		}
	}

}