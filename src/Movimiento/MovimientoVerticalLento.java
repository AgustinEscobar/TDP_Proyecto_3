package Movimiento;

import java.awt.Point;

import Logica.Entidad;

public class MovimientoVerticalLento extends MovimientoVertical {

	public MovimientoVerticalLento(Entidad entidad,int direccion) {
		super(entidad,direccion);
		velocidadExtra = 6;
	}

	@Override
	public void mover() {
		Point p = entidad.getGrafico().getLocation();
		double x = p.getX();
		double y = p.getY() + entidad.getVelocidad() * direccion - velocidadExtra;
		
		if (direccion == MovimientoVertical.ABAJO) {
			this.moverAbajo(p, x, y);		
		}else {
			this.moverArriba(p, x, y);
		}
	}

}