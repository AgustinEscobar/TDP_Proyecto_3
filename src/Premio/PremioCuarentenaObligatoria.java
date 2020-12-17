package Premio;

import Grafico.Grafico;
import Grafico.GraficoPremioTemporal;
import Logica.Infectado;
import Logica.Juego;
import Visitor.Visitor;
import Visitor.VisitorCuarentenaObligatoria;
import Visitor.visitorEfectoTemporal;

public class PremioCuarentenaObligatoria extends Premio {

	public static final int MAXDURACION = 1000;

	public PremioCuarentenaObligatoria(Juego juego, Infectado infectado) {
		super(juego);
		this.grafico = new GraficoPremioTemporal();
		Grafico graficoInfectado = infectado.getGrafico();
		this.grafico.setLocation(graficoInfectado.getX(), graficoInfectado.getY());
		this.visitor = new VisitorCuarentenaObligatoria(this);
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitCuarentenaObligatoria(this);

	}
}
