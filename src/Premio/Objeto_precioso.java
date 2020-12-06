package Premio;

import Grafico.Grafico;
import Grafico.GraficoPremioPrecioso;
import Logica.Infectado;
import Logica.Juego;
import Visitor.Visitor;
import Visitor.Visitor_premio;

/**
 * Este tipo de premios le confiere al jugador poderes especiales. Se requiere
 * por lo menos implementar uno de ellos, como puede ser una suerte �poci�n� que
 * recupere la vida del jugador.
 *
 * 
 */
public class Objeto_precioso extends Premio {

	public Objeto_precioso(Juego juego, Infectado infectado) {
		super(juego);
		this.grafico = new GraficoPremioPrecioso();
		Grafico graficoInfectado = infectado.getGrafico();
		this.visitor = new Visitor_premio(this);
		this.grafico.setLocation(graficoInfectado.getX(), graficoInfectado.getY());
	}

	@Override
	public void aceptar(Visitor v) {
		v.visit_premio_obj_precioso(this);
	}
}