package Visitor;

import Logica.Jugador;
import Logica.Particula;

public class VisitorParticula extends Visitor {
	protected Particula particula;

	public VisitorParticula(Particula particula) {
		this.particula = particula;
	}

	public void visitJugador(Jugador jugador) {
		jugador.recibirDanho(particula.getInfectado().getDanho());
		particula.eliminar();
	}
}
