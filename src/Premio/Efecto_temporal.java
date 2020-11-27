package Premio;

import Grafico.Grafico;
import Grafico.GraficoPremio;

public class Efecto_temporal extends Premio {

	public Efecto_temporal(Grafico grafico) {
		super(grafico);
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