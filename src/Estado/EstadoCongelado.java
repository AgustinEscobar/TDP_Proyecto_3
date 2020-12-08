package Estado;

import Logica.Jugador;
import Logica.Proyectil;
import Logica.ProyectilSanitario;

/**
 * El jugador no se puede mover
 */
public class EstadoCongelado extends Estado{

	public EstadoCongelado(Jugador jugador) {
		super(jugador);
	}

	@Override
	public Proyectil getProyectil() {
		return new ProyectilSanitario(jugador.getJuego(),jugador.getGrafico());
	}

}
