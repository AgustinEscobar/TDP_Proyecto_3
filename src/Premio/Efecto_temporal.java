package Premio;

import Grafico.Grafico;
import Grafico.GraficoPremioTemporal;
import Logica.Infectado;
import Logica.Juego;
import Visitor.Visitor;

/**
 * Este tipo de premios otorga efectos temporales al jugador. Uno de los efectos
 * deberá ser una “cuarentena obligatoria” que detenga a todos los infectados
 * por un intervalo de tiempo y una “super arma sanitaria” que otorgue un poder
 * de desinfección multiplicado al arma del jugador por un intervalo de tiempo.
 *
 * 
 */
public class Efecto_temporal extends Premio {

	public Efecto_temporal(Juego juego, Infectado infectado) {
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