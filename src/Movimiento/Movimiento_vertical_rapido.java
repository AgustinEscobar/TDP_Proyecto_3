package Movimiento;

import java.awt.Point;

import Logica.Entidad;

public class Movimiento_vertical_rapido extends Movimiento_vertical {
	

	public Movimiento_vertical_rapido(Entidad entidad, int direccion) {
		super(entidad,direccion);
		this.velocidad_extra = 6;
		duracion = 20;
	}

	public void mover() {
		Point p = entidad.getGrafico().getLocation();
		double x = p.getX();
		double y = p.getY() + entidad.getVelocidad() * direccion + velocidad_extra;
		
		//this.mover_aux(p, x, y);
		// !!
		if (direccion == Movimiento_vertical.ABAJO) {
			this.mover_aux_abajo(p, x, y);		
		}else {
			mover_aux_arriba(p, x, y);
		}
//		p.setLocation(x, y);
//		entidad.getGrafico().setLocation(p);
	}

}