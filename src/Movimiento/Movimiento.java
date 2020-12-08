package Movimiento;

import java.awt.Point;
import java.util.Random;

import Logica.Entidad;
import Logica.Mapa;

public abstract class Movimiento {
	protected int direccion;
	protected Entidad entidad;
	protected int velocidadExtra;
	protected int duracion;
	protected int limiteY;

	public static final int ARRIBA = -1;
	public static final int ABAJO = 1;

	public Movimiento(Entidad e, int direccion) {
		this.entidad = e;
		this.direccion = direccion;
	}

	public abstract void mover();

	// Movimiento del infectado.
	protected void moverAbajo(Point p, double x, double y) {
		if (y <= Mapa.LIMITE_INFERIOR) {
			p.setLocation(x, y);
			entidad.getGrafico().setLocation(p);
		} else {
			setUbicacionInicial(p);
		}
	}

	// Movimiento del proyectil.
	protected void moverArriba(Point p, double x, double y) {

		if (y > Mapa.LIMITE_SUPERIOR) {
			p.setLocation(x, y);
			entidad.getGrafico().setLocation(p);
		} else {
			entidad.eliminar();
		}
	}

	protected void setUbicacionInicial(Point p) {
		double y = Mapa.LIMITE_SUPERIOR;
		p.setLocation(getXRandom(), y);
		entidad.getGrafico().setLocation(p);
	}

	protected double getXRandom() {
		Random r = new Random();
		double valor = r.nextInt(Mapa.LIMITE_DER_X - entidad.getGrafico().getAncho());
		return valor;
	}

}