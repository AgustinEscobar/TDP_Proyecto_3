package Visitor;

import Logica.Infectado;
import Movimiento.MovimientoVerticalCongelado;

public class visitorCuarentena extends Visitor{
	
	
	public visitorCuarentena() {
		
	}
	
	
	public void visitarInfectados() {
		
	}
	
	
	private void aplicarCuarentena(Infectado f) {
		f.setMovimiento(new MovimientoVerticalCongelado(f,MovimientoVerticalCongelado.ABAJO));
	}
	
}
