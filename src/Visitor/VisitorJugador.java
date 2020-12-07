package Visitor;

import Estado.EstadoEfectoTemporal;
import Estado.EstadoPremioPrecioso;
import Logica.Alpha;
import Logica.Beta;
import Logica.Entidad;
import Logica.Jugador;
import Premio.EfectoTemporal;
import Premio.ObjetoPrecioso;

public class VisitorJugador extends Visitor {
	protected Jugador jugador;

	public VisitorJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public void visit_alpha(Alpha alpha) {
		jugador.recibirDanho(alpha.getDanio() / 90);
		alpha.recibirDanho(jugador.getDanio() / 90);
	}

	public void visit_beta(Beta beta) {
		jugador.recibirDanho(beta.getDanio() / 90);
		beta.recibirDanho(jugador.getDanio() / 90);
	}

	/**
	 * vida
	 */
	public void visit_premio_obj_precioso(ObjetoPrecioso premio) {
		jugador.setEstado(new EstadoPremioPrecioso(jugador));
		premio.eliminar();
	}

	/**
	 * bomba
	 */
	public void visit_premio_obj_temporal(EfectoTemporal premio) {
		jugador.setEstado(new EstadoEfectoTemporal(jugador));
		for (Entidad e : jugador.getJuego().entidades()) {
			e.aceptar(premio.getVisitor());
		}
		premio.eliminar();
	}
}
