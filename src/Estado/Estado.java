package Estado;

import Logica.Jugador;
import Logica.Proyectil;

public abstract class Estado {
	protected Jugador jugador;

	public Estado(Jugador jugador) {
		this.jugador = jugador;
	}


	
	public abstract Proyectil getProyectil();
	
	public void accionarEstado() {}
	
}
