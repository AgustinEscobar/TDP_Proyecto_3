package Premio;

import Grafico.GraficoPremio;
import Logica.Juego;
import Visitor.Visitor;

public class Efecto_temporal extends Premio {

	public Efecto_temporal(Juego juego) {
		super(juego);
		this.grafico = new GraficoPremio();
		this.velocidad = 10;
	}

	@Override
	public void accionar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aceptar(Visitor v) {
		v.visit_premio_obj_temporal(this);
		
	}

}