package Premio;

import Grafico.Grafico;
import Grafico.GraficoPremioPrecioso;
import Logica.Infectado;
import Logica.Juego;
import Visitor.Visitor;
import Visitor.VisitorPremio;

/**
 * Este tipo de premios le confiere al jugador poderes especiales. Se requiere
 * por lo menos implementar uno de ellos, como puede ser una suerte “poción” que
 * recupere la vida del jugador.
 *
 * 
 */
public class ObjetoPrecioso extends Premio {

	public ObjetoPrecioso(Juego juego, Infectado infectado) {
		super(juego);
		this.grafico = new GraficoPremioPrecioso();
		Grafico graficoInfectado = infectado.getGrafico();
		this.visitor = new VisitorPremio(this);
		this.grafico.setLocation(graficoInfectado.getX(), graficoInfectado.getY());
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitPremioPrecioso(this);
	}
}