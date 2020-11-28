package Visitor;

import Logica.Alpha;
import Logica.Beta;
import Logica.Proyectil;

public class Visitor_proyectil extends Visitor{
	
	protected Proyectil proyectil;
	
	public void visit_beta(Beta beta) {
		proyectil.eliminar();
	}
	public void visit_alpha(Alpha alpha) {
		proyectil.eliminar();		
	}	
}
