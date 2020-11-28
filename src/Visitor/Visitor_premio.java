package Visitor;

import Logica.Jugador;
import Premio.Premio;

public class Visitor_premio extends Visitor {
	protected Premio premio;

	public void visit_jugador(Jugador jugador) {
		premio.eliminar();
	}

}
