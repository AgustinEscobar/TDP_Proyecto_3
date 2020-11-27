package Premio;

import Grafico.Grafico;
import Grafico.GraficoPremio;
import Logica.Entidad;
import Movimiento.Movimiento_vertical_rapido;
import Visitor.Visitor_premio;

public abstract class Premio extends Entidad {

	public Premio(Grafico grafico) {
		this.visitor = new Visitor_premio();
		this.grafico = new GraficoPremio();
		this.grafico.setLocation(grafico.getX()/*+ this.grafico.getAncho()/2*/, grafico.getY()/* + this.grafico.getAlto()+2*/); 
		this.movimiento = new Movimiento_vertical_rapido(this,Movimiento_vertical_rapido.ABAJO);
	}

	public abstract Premio getPremio();
}