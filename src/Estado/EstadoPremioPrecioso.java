package Estado;

import Logica.Jugador;
import Logica.Proyectil;
import Logica.Proyectil_sanitario;

public class EstadoPremioPrecioso extends Estado {

	public EstadoPremioPrecioso(Jugador jugador) {
		super(jugador);
		jugador.setVidaCompleta();
	}

	@Override
	public void accionarEstado(Jugador jugador) {
		
	}

	@Override
	public void cambiarEstado() {
		// TODO Auto-generated method stub

	}

	@Override
	public Proyectil getProyectil() {	
		return new Proyectil_sanitario(jugador.getJuego(),jugador.getGrafico());
	}

}
