package Visitor;

import Logica.Alpha;
import Logica.Beta;
import Logica.Jugador;
import Logica.Particula;
import Premio.Efecto_temporal;
import Premio.Objeto_precioso;

public class Visitor_jugador extends Visitor {
	protected Jugador jugador;

	public Visitor_jugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public void visit_alpha(Alpha a) {

	}

	public void visit_beta(Beta b) {

	}

	public void visit_particula(Particula p) {

	}

	public void visit_premio_obj_precioso(Objeto_precioso o) {

	}

	public void visit_premio_obj_temporal(Efecto_temporal e) {

	}
}
