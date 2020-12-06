package Visitor;

import Estado.EstadoEfectoTemporal;
import Logica.Alpha;
import Logica.Beta;
import Logica.Infectado;
import Logica.Jugador;
import Movimiento.MovimientoVerticalCongelado;

public class visitorCuarentena extends Visitor {

	public visitorCuarentena() {
	}

	@Override
	public void visit_alpha(Alpha a) {
		this.aplicarCuarentena(a);
	}

	@Override
	public void visit_beta(Beta b) {
		this.aplicarCuarentena(b);
	}
	
	@Override
	public void visit_jugador(Jugador j) {
		j.setEstado(new EstadoEfectoTemporal(j));
	}

	private void aplicarCuarentena(Infectado f) {
		f.setMovimiento(new MovimientoVerticalCongelado(f, MovimientoVerticalCongelado.ABAJO));
	}
	
}
