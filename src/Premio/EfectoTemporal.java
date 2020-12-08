package Premio;

import Grafico.Grafico;
import Grafico.GraficoPremioTemporal;
import Logica.Infectado;
import Logica.Juego;
import Visitor.Visitor;
import Visitor.visitorEfectoTemporal;

/**
 * Este tipo de premios otorga efectos temporales al jugador. Uno de los efectos
 * deberá ser una “cuarentena obligatoria” que detenga a todos los infectados
 * por un intervalo de tiempo y una “super arma sanitaria” que otorgue un poder
 * de desinfección multiplicado al arma del jugador por un intervalo de tiempo.
 *
 * 
 */
public class EfectoTemporal extends Premio {
	public static final int MAXDURACION = 1000;
	
	public EfectoTemporal(Juego juego, Infectado infectado) {
		super(juego);
		this.grafico = new GraficoPremioTemporal();
		Grafico graficoInfectado = infectado.getGrafico();
		this.grafico.setLocation(graficoInfectado.getX(), graficoInfectado.getY());
		this.visitor = new visitorEfectoTemporal();
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitPremioTemporal(this);
	}

}