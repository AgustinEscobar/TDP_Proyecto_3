package Estado;

import Logica.Jugador;
import Logica.Proyectil;
import Logica.ProyectilSanitario;

public class EstadoPremioPrecioso extends Estado {

	public EstadoPremioPrecioso(Jugador jugador) {
		super(jugador);
		jugador.setVidaCompleta();
	}

	@Override
	public Proyectil getProyectil() {	
		return new ProyectilSanitario(jugador.getJuego(),jugador.getGrafico());
	}

}
