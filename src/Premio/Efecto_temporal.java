package Premio;

import Grafico.Grafico;
import Grafico.GraficoPremio;
import Logica.Juego;

public class Efecto_temporal extends Premio {

	public Efecto_temporal(Juego juego,Grafico grafico) {
		super(juego, grafico);
		this.grafico = new GraficoPremio();
		this.velocidad = 10;
	}

	@Override
	public Premio getPremio() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void accionar() {
		// TODO Auto-generated method stub
		
	}

}