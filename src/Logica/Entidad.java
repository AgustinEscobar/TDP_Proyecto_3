package Logica;

import java.awt.Point;

import Grafico.Grafico;
import Movimiento.Movimiento;
import Visitor.Visitor;

public abstract class Entidad {
	protected Juego juego;
	protected Visitor visitor;
	protected Grafico grafico;
	protected Movimiento movimiento;
	protected int velocidad;

	protected Entidad(Juego juego) {
		this.juego = juego;
	}
	
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	public void setImagen(Grafico img) {
		grafico = img;
	}

	public abstract void aceptar(Visitor v);
		
	
	
	public Visitor getVisitor() {
		return visitor;
	}
	
	public void eliminar() {
		juego.eliminarLuego(this);
	}
	
	public void insertar_entidad() {
		juego.insertarLuego(this);
	}
	
	public Grafico getGrafico() {
		return grafico;
	}

	public int get_x() {
		return this.grafico.getX();
	}

	public int get_y() {
		return this.grafico.getY();
	}

	public int getVelocidad() {
		return velocidad;
	}

	public Movimiento getMovimiento() {
		return movimiento;
	}

	public Point getPosicion() {
		return this.grafico.getLocation();
	}

	public abstract void accionar();

	/**
	 * Permite obtener la velocidad de movimiento de una Entidad.
	 * 
	 * @return la velocidad de una entidad.
	 */
	public Juego getJuego() {
		return juego;
	}

}