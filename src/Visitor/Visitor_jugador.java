package Visitor;

import Estado.EstadoEfectoTemporal;
import Estado.EstadoPremioPrecioso;
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

	public void visit_alpha(Alpha alpha) {
		jugador.recibir_danio(alpha.getDanio() / 90);
		alpha.recibir_danio(jugador.getDanio() / 90);
	}

	public void visit_beta(Beta beta) {
		jugador.recibir_danio(beta.getDanio() / 90);
		beta.recibir_danio(jugador.getDanio() / 90);
	}

	public void visit_particula(Particula p) {
		jugador.recibir_danio(p.getInfectado().getDanio());
	}

	public void visit_premio_obj_precioso(Objeto_precioso o) {
		jugador.setEstado(new EstadoPremioPrecioso());
	}

	public void visit_premio_obj_temporal(Efecto_temporal e) {
		jugador.setEstado(new EstadoEfectoTemporal());
	}
}
