package Premio;

import Grafico.Grafico;
import Grafico.GraficoPremioSuperArmaSanitaria;
import Grafico.GraficoPremioTemporal;
import Logica.Infectado;
import Logica.Juego;
import Logica.Jugador;
import Visitor.Visitor;
import Visitor.VisitorSuperArmaSanitaria;
import Visitor.visitorEfectoTemporal;

public class PremioSuperArmaSanitaria extends Premio {
	
	
	public PremioSuperArmaSanitaria(Juego juego, Infectado infectado) {
		super(juego);
		this.grafico = new GraficoPremioSuperArmaSanitaria();
		Grafico graficoInfectado = infectado.getGrafico();
		this.grafico.setLocation(graficoInfectado.getX(), graficoInfectado.getY());
		this.visitor = new VisitorSuperArmaSanitaria(this);
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitSuperArmaSanitaria(this);
		
	}
	
}
