package Estado;

import Logica.Jugador;
import Logica.Proyectil;
import Logica.ProyectilSanitario;

public class EstadoNormal extends Estado {
	
	public EstadoNormal(Jugador jugador) {
		super(jugador);

	}



	@Override
	public Proyectil getProyectil() {
		return new ProyectilSanitario(jugador.getJuego(),jugador.getGrafico());
	}
	
}
