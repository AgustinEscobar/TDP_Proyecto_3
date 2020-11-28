package Premio;

import Grafico.GraficoPremio;
import Logica.Juego;

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

}