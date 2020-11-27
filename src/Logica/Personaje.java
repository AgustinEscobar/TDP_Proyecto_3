package Logica;

//import java.awt.Point;

import Premio.Premio;

public abstract class Personaje extends Entidad{
	protected float carga_viral;
	protected Premio premio;
	
	public Personaje(Juego juego) {
		super(juego);
	}
	
	public Premio getPremio() {
		return premio;
	}

	public abstract boolean esta_infectado();
	public abstract void recibir_danio(float d);

}