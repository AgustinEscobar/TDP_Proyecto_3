package Visitor;

import Logica.Jugador;
import Logica.Particula;

public class VisitorParticula extends Visitor {
	protected Particula particula;

	public VisitorParticula(Particula particula) {
		this.particula = particula;
	}

	public void visit_jugador(Jugador jugador) {
		jugador.recibirDanho(particula.getInfectado().getDanio());
		particula.eliminar();
	}
}
