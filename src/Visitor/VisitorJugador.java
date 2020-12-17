package Visitor;

import Estado.EstadoEfectoTemporal;
import Estado.EstadoPremioPrecioso;
import Estado.EstadoSuperArmaSanitaria;
import Logica.Alpha;
import Logica.Beta;
import Logica.Entidad;
import Logica.Jugador;
import Logica.SuperInfectado;
import Premio.EfectoTemporal;
import Premio.ObjetoPrecioso;
import Premio.PremioCuarentenaObligatoria;
import Premio.PremioSuperArmaSanitaria;

public class VisitorJugador extends Visitor {
	protected Jugador jugador;

	public VisitorJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public void visitAlpha(Alpha alpha) {
		jugador.recibirDanho(alpha.getDanho() / 90);
		alpha.recibirDanho(jugador.getDanho() / 90);
	}

	public void visitBeta(Beta beta) {
		jugador.recibirDanho(beta.getDanho() / 90);
		beta.recibirDanho(jugador.getDanho() / 90);
	}

	@Override
	public void visitSuperInfectado(SuperInfectado infectado) {
		jugador.recibirDanho(infectado.getDanho() / 90);
		infectado.recibirDanho(jugador.getDanho() / 90);
	}
	
	/**
	 * vida
	 */
	public void visitPremioPrecioso(ObjetoPrecioso premio) {
		jugador.setEstado(new EstadoPremioPrecioso(jugador));
		premio.eliminar();
	}


	
	public void visitCuarentenaObligatoria(PremioCuarentenaObligatoria premio) {
		for (Entidad e : jugador.getJuego().entidades()) {
			e.aceptar(premio.getVisitor());
		}
		premio.eliminar();
	}
}
