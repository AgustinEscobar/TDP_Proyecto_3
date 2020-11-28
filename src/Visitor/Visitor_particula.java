package Visitor;

import Logica.Jugador;
import Logica.Particula;

public class Visitor_particula extends Visitor {
	protected Particula particula;
	
	public Visitor_particula(Particula particula) {
		this.particula = particula;
	}

	public void visit_jugador(Jugador j) {
		particula.eliminar();
	}
}
