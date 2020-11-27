package Visitor;

import Logica.Alpha;
import Logica.Beta;
import Logica.Proyectil;

public class Visitor_proyectil extends Visitor{
	
	protected Proyectil p;
	
	public void visit_beta(Beta b) {
		b.recibir_danio(30); // Ver si modelar aca o alla jaja
	}
	public void visit_alpha(Alpha a) {
		a.recibir_danio(30);
		
	}
	
}
