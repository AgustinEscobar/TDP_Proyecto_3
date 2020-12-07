package Visitor;

import Logica.Alpha;
import Logica.Beta;
import Logica.Proyectil;

public class VisitorProyectil extends Visitor{
	protected Proyectil proyectil;
	
	public VisitorProyectil(Proyectil p) {
		proyectil= p;
	}
	
	public void visit_beta(Beta beta) {
		beta.recibirDanho(proyectil.getDesinfeccion());
		proyectil.eliminar();
	}
	
	public void visit_alpha(Alpha alpha) {
		alpha.recibirDanho(proyectil.getDesinfeccion());
		proyectil.eliminar();
	}
	
}
