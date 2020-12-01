package Premio;

import Grafico.Grafico;
import Grafico.GraficoPremioTemporal;
import Logica.Infectado;
import Logica.Juego;
import Visitor.Visitor;

public class Efecto_temporal extends Premio {

	public Efecto_temporal(Juego juego,Infectado infectado) {
		super(juego);
		this.grafico = new GraficoPremioTemporal();
		Grafico graficoInfectado = infectado.getGrafico();
		this.grafico.setLocation(graficoInfectado.getX(), graficoInfectado.getY());
	}

	@Override
	public void aceptar(Visitor v) {
		v.visit_premio_obj_temporal(this);
		
	}

}