package Estado;

import Logica.Jugador;
import Logica.Personaje;

public class EstadoNormal extends Estado {
	
	public EstadoNormal(Jugador jugador) {
		super(jugador);
	}

	@Override
	public void cambiarEstado() {
		personaje.setVelocidad(personaje.getVelocidad()); //
	}

	@Override
	public void accionarEstado(Personaje jugador) {
		// TODO Auto-generated method stub
		
	}

}
