package Logica;

import java.util.Random;

import Movimiento.MovimientoVertical;
import Premio.EfectoTemporal;
import Premio.ObjetoPrecioso;
import Premio.Premio;

public abstract class Infectado extends Personaje {
	protected Particula particula;
	protected int cooldown; // duracion

	public Infectado(Juego juego) {
		super(juego);
		this.cargaViral = 100;
		this.movimiento = new MovimientoVertical(this, MovimientoVertical.ABAJO);
		this.cooldown = 500;
		this.particula = null;
	}

	public boolean estaInfectado() {
		boolean es = false;
		if (cargaViral > 0) {
			es = true;
		}
		return es;
	}

	public Particula lanzarParticula() {
		return new Particula(juego, this);
	}

	protected Premio premioRandom() {
		Random ran = new Random();
		int valor;
		valor = ran.nextInt(5);
		Premio retorno = null;
		if (valor == 0) {
			retorno = new EfectoTemporal(juego, this);
		} else {
			if (valor == 1) {
				retorno = new ObjetoPrecioso(juego, this);
			}
		}
		return retorno;
	}

	public void mover() {
		movimiento.mover();
	}

	@Override
	public void accionar() {
		if (cargaViral > 0) {
			this.mover();
			this.disparar();
			this.colisiones.detectarColision();
		}
	}

	public void disparar() {
		Particula particula;
		if (this.cooldown == 0) {
			particula = lanzarParticula();
			particula.insertar_entidad();
			this.cooldown = 500;
		} else {
			this.cooldown -= 1;
		}
	}

	public void setMovimiento(MovimientoVertical m) {
		this.movimiento = m;
	}

	public void setMovimiento() {
		this.movimiento = new MovimientoVertical(this, MovimientoVertical.ABAJO);
	}
}
