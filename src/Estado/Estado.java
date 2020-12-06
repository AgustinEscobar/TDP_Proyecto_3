package Estado;

import Logica.Jugador;
import Logica.Proyectil;

public abstract class Estado {
	protected Jugador jugador;
	protected int velocidadJugador;

	public Estado(Jugador jugador) {
		this.jugador = jugador;
	}

	public int getVelocidadJugador() {
		return velocidadJugador;
	}
	
	public abstract Proyectil getProyectil();
	
	public void accionarEstado() {}
	
	public abstract void accionarEstado(Jugador jugador);

	public abstract void cambiarEstado();
}
