package Estado;

import Logica.Jugador;
import Logica.Proyectil;
import Logica.ProyectilSanitario;

public class EstadoNormal extends Estado {
	
	public EstadoNormal(Jugador jugador) {
		super(jugador);
		this.velocidadJugador = 6;
	}

//	@Override
//	public void cambiarEstado() {
//		jugador.setVelocidad(jugador.getVelocidad()); //
//	}
//	
//	@Override
//	public void accionarEstado(Jugador jugador) {
//	}

	@Override
	public Proyectil getProyectil() {
		return new ProyectilSanitario(jugador.getJuego(),jugador.getGrafico());
	}
	
}
