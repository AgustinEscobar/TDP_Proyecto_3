package Logica;

import java.util.Random;

import Movimiento.MovimientoVertical;
import Premio.EfectoTemporal;
import Premio.ObjetoPrecioso;
import Premio.Premio;

public abstract class Infectado extends Personaje {

	protected int letalidad;
	protected Particula particula;
	protected int cooldown; // duracion

	public Infectado(Juego juego) {
		super(juego);
		this.carga_viral = 100;
		this.movimiento = new MovimientoVertical(this, MovimientoVertical.ABAJO);
		this.cooldown = 500;
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
		if (carga_viral > 0) {
			this.mover();
			this.disparar();
			this.colisiones.detectarColision();
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

	public void setMovimiento(MovimientoVertical m) {
		this.movimiento = m;
	}

	public void setMovimiento() {
		this.movimiento = new MovimientoVertical(this, MovimientoVertical.ABAJO);
	}
}
