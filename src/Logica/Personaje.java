package Logica;

import Premio.Premio;

public abstract class Personaje extends Entidad {
	protected float cargaViral;
	protected Premio premio;
	protected float danho;

	public Personaje(Juego juego) {
		super(juego);
	}

	public void setDanho(float d) {
		this.danho = d;
	}

	public Premio getPremio() {
		return premio;
	}

	public float getDanho() {
		return danho;
	}

	public abstract boolean estaInfectado();

	public abstract void recibirDanho(float d);

}