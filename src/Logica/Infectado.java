package Logica;

import java.util.Random;

import Movimiento.Movimiento_vertical;
import Premio.Efecto_temporal;
import Premio.Objeto_precioso;
import Premio.Premio;

public abstract class Infectado extends Personaje {

	protected int letalidad;
	protected Particula particula;
	protected int cooldown; // duracion

	public Infectado(Juego juego) {
		super(juego);
		this.carga_viral = 100;
		this.movimiento = new Movimiento_vertical(this, Movimiento_vertical.ABAJO);
		cooldown = 500;
		this.particula = null;
	}

	public boolean esta_infectado() {
		boolean es = false;
		if (carga_viral > 0) {
			es = true;
		}
		return es;
	}

	public Particula lanzar_particula() {
		return new Particula(juego, this);
	}

	protected Premio premioRandom() {
		Random ran = new Random();
		int valor;
		valor = ran.nextInt(5);
		Premio retorno = null;
		if (valor == 0) {
			retorno = new Efecto_temporal(juego, this);
		} else {
			if (valor == 1) {
				retorno = new Objeto_precioso(juego, this);
			}
		}
		return retorno;
	}

	public void mover() {
		movimiento.mover();
	}

	@Override
	public void accionar() {
		if (carga_viral > 0) {
			this.mover();
			this.disparar();
		}
	}

	public void disparar() {
		Particula p;
		if (this.cooldown == 0) {
			p = lanzar_particula();
			p.insertar_entidad();
			this.cooldown = 500;
		} else {
			this.cooldown -= 1;
		}
	}

	public void setMovimiento(Movimiento_vertical m) {
		this.movimiento = m;
	}

	public void setMovimiento() {
		this.movimiento = new Movimiento_vertical(this, Movimiento_vertical.ABAJO);
	}
}
