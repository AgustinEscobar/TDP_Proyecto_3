package Estado;

import Logica.Jugador;
import Logica.Personaje;
/**
 * El jugador no se puede mover
 */
public class EstadoCongelado extends Estado{

	public EstadoCongelado(Jugador jugador) {
		super(jugador);
	}

//	@Override
//	public void accionarEstado(Jugador jugador) {
//		
//	}

	@Override
	public void cambiarEstado() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void accionarEstado(Personaje jugador) {
		// TODO Auto-generated method stub
		
	}

}
