package Visitor;

import Logica.Alpha;
import Logica.Beta;
import Logica.Jugador;
import Logica.Proyectil;

public class Visitor_alpha extends Visitor{
	
	protected Alpha alpha;
	
	public Visitor_alpha(Alpha alpha) {
		this.alpha = alpha;
	}
	
//	public void visit_jugador(Jugador jugador) {
//		alpha.recibir_danio(jugador.getDanio());
//	}

//	public void visit_proyectil(Proyectil proyectil) {
//		alpha.recibir_danio(proyectil.getJuego().getPlayer().getDanio());
//	}
}
