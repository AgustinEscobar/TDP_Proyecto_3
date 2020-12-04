package Logica;

import Comportamiento.Comportamiento;
import Premio.Premio;

public abstract class Personaje extends Entidad{
	protected float carga_viral;
	protected Premio premio;
	protected Comportamiento comportamiento;
	protected float danio;
	
	public Personaje(Juego juego) {
		super(juego);
	}
	
	public void setDanho(float d) {
		this.danio = d;
	}
	
	public Premio getPremio() {
		return premio;
	}
	
	public float getDanio() {
		return danio;
	}
	
	public abstract boolean esta_infectado();
	public abstract void recibir_danio(float d);

}