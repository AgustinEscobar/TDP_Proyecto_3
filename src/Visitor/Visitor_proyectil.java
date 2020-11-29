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
		beta.recibir_danio(proyectil.getJuego().getPlayer().getDanio());
		proyectil.eliminar();
	}
	
	public void visit_alpha(Alpha alpha) {
		alpha.recibir_danio(proyectil.getJuego().getPlayer().getDanio());
		proyectil.eliminar();
	}
	
}
