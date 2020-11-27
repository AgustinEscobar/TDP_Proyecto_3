package Visitor;

import Logica.Beta;
import Logica.Jugador;
import Logica.Proyectil;

public class Visitor_beta extends Visitor{
	protected Beta b;
	
	public Visitor_beta(Beta b) {
		this.b = b;
	}
	
	public void visit_jugador(Jugador j) {
		
	}
	
	public void visit_beta(Beta b) {
		
	}
	
	public void visit_proyectil(Proyectil p) {
		
	}
}
