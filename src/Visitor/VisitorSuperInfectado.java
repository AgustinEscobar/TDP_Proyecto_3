package Visitor;

import Logica.SuperInfectado;

public class VisitorSuperInfectado extends Visitor{
	protected SuperInfectado enemigo;
	
	public VisitorSuperInfectado(SuperInfectado enemigo) {
		this.enemigo = enemigo;
	}
}