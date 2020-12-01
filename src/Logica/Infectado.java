package Logica;

import Movimiento.Movimiento_vertical;

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

	// si al recibir daño, se desinfecta y además tiene premio, dropeamos premio en
	// la pos posactual
	public boolean esta_infectado() {
		boolean es = false;
		if (carga_viral > 0) {
			es = true;
		}
		return es;
	}

	public void mover() {
		movimiento.mover();
	}

	public Particula lanzar_particula() {
		return new Particula(juego, this);
	}

	@Override
	public void accionar() {
		// lanzar particula
		// moverse
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
			// TERMINAR
			this.cooldown = 500;
		} else {
			this.cooldown -= 1;
		}
	}
}
