package Visitor;

import Logica.Beta;
import Logica.Jugador;
import Logica.Proyectil;

public class Visitor_beta extends Visitor{
	protected Beta beta;
	
	public Visitor_beta(Beta beta) {
		this.beta = beta;
	}
	
//	public void visit_jugador(Jugador jugador) {
//		beta.recibir_danio(jugador.getDanio());
//	}
//	
//	public void visit_proyectil(Proyectil proyectil) {
//		beta.recibir_danio(proyectil.getJuego().getPlayer().getDanio());
//		if (!beta.esta_infectado()) {
////			if (beta.getPremio() != null) {
////				beta.getJuego().insertarEntidad_a_Insertar(beta.getPremio());
////			}
//			beta.eliminar();
//		}
//	}
}
