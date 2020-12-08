package Visitor;

import Logica.Alpha;
import Logica.Beta;
import Logica.Proyectil;
import Logica.SuperInfectado;

public class VisitorProyectil extends Visitor{
	protected Proyectil proyectil;
	
	public VisitorProyectil(Proyectil p) {
		proyectil= p;
	}
	
	public void visitBeta(Beta beta) {
		beta.recibirDanho(proyectil.getDesinfeccion());
		proyectil.eliminar();
	}
	
	public void visitAlpha(Alpha alpha) {
		alpha.recibirDanho(proyectil.getDesinfeccion());
		proyectil.eliminar();
	}
	
	@Override
	public void visitSuperInfectado(SuperInfectado infectado) {
		infectado.recibirDanho(proyectil.getDesinfeccion());
		proyectil.eliminar();
	}
}
