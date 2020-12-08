package Visitor;

import Estado.EstadoEfectoTemporal;
import Logica.Alpha;
import Logica.Beta;
import Logica.Infectado;
import Movimiento.MovimientoVerticalCongelado;

public class visitorEfectoTemporal extends Visitor {

	public visitorEfectoTemporal() {
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
	}
	
}
