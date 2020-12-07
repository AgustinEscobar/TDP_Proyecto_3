package Movimiento;

import java.awt.Point;

import Logica.Entidad;

// relentiza los oponentes
public class MovimientoVerticalLento extends MovimientoVertical {

	public MovimientoVerticalLento(Entidad entidad,int direccion) {
		super(entidad,direccion);
		velocidad_extra = 6;
	}

	@Override
	public void mover() {
		Point p = entidad.getGrafico().getLocation();
		double x = p.getX();
		double y = p.getY() + entidad.getVelocidad() * direccion - velocidad_extra;
		//this.mover_aux(p, x, y);
		
		// !!
		if (direccion == MovimientoVertical.ABAJO) {
			this.moverAbajo(p, x, y);		
		}else {
			this.moverArriba(p, x, y);
		}
		
//		p.setLocation(x, y);
//		entidad.getGrafico().setLocation(p);
	}

}