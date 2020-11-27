package Visitor;

import Logica.Alpha;
import Logica.Beta;
import Logica.Jugador;
import Logica.Proyectil;

public class Visitor_alpha extends Visitor{
	
	protected Alpha a;
	
	public Visitor_alpha(Alpha a) {
		this.a = a;
	}
	
	public void visit_jugador(Jugador j) {
		
	}
	
	public void visit_beta(Beta b) {
		
	}
	
	public void visit_proyectil(Proyectil p) {
		
	}
}
