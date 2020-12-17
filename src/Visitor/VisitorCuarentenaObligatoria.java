package Visitor;

import Logica.Alpha;
import Logica.Beta;
import Logica.Infectado;
import Movimiento.MovimientoVerticalCongelado;
import Premio.PremioCuarentenaObligatoria;

public class VisitorCuarentenaObligatoria extends Visitor{
	
	protected PremioCuarentenaObligatoria premio;
	
	
	public VisitorCuarentenaObligatoria(PremioCuarentenaObligatoria p) {
		premio=p;
	}

	@Override
	public void visitAlpha(Alpha a) {
		this.aplicarCuarentena(a);
	}

	@Override
	public void visitBeta(Beta b) {
		this.aplicarCuarentena(b);
	}

	private void aplicarCuarentena(Infectado f) {
	
		f.setMovimiento(new MovimientoVerticalCongelado(f, MovimientoVerticalCongelado.ABAJO));
		premio.eliminar();
	}
}
