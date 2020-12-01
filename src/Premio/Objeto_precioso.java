package Premio;

import Grafico.Grafico;
import Grafico.GraficoPremioPrecioso;
import Logica.Infectado;
import Logica.Juego;
import Visitor.Visitor;

public class Objeto_precioso extends Premio {

	public Objeto_precioso(Juego juego,Infectado infectado) {
		super(juego);
		this.grafico = new GraficoPremioPrecioso();
		Grafico graficoInfectado = infectado.getGrafico();
		this.grafico.setLocation(graficoInfectado.getX(), graficoInfectado.getY());
	}

	@Override
	public void aceptar(Visitor v) {
		v.visit_premio_obj_precioso(this);

	}
}