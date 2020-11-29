package Visitor;

import Logica.Alpha;
import Logica.Beta;
import Logica.Proyectil;

public class Visitor_proyectil extends Visitor{
	
	protected Proyectil proyectil;
	
	public Visitor_proyectil(Proyectil p) {
		proyectil= p;
	}
	
	public void visit_beta(Beta beta) {
		proyectil.eliminar();
	}
	
	public void visit_alpha(Alpha alpha) {
		proyectil.eliminar();
	}
	
}
