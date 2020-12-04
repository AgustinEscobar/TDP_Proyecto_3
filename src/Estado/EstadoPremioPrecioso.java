package Estado;

import Logica.Jugador;
import Logica.Personaje;

public class EstadoPremioPrecioso extends Estado{

	public EstadoPremioPrecioso(Jugador jugador) {
		super(jugador);
		jugador.setVidaCompleta();
	}

	@Override
	public void accionarEstado(Personaje jugador) {
	}

	@Override
	public void cambiarEstado() {
		// TODO Auto-generated method stub
		
	}

}
