package Movimiento;

import java.awt.Point;

import Logica.Entidad;

public class Movimiento_vertical_rapido extends Movimiento_vertical {
	

	public Movimiento_vertical_rapido(Entidad entidad, int direccion) {
		super(entidad,direccion);
		this.velocidad_extra = 1;
		duracion = 20;
	}

	public void mover() {
		Point p = entidad.getGrafico().getLocation();
		double x = p.getX();
		double y = p.getY() + entidad.getVelocidad() * direccion + velocidad_extra;
		
		if (direccion == Movimiento_vertical.ABAJO) {
			this.moverAbajo(p, x, y);		
		}else {
			moverArriba(p, x, y);
		}
	}

}