package Premio;

import Comportamiento.Comportamiento;
import Grafico.Grafico;
import Grafico.GraficoPremio;
import Logica.Juego;

public class Objeto_precioso extends Premio{

	public Objeto_precioso(Juego juego) {
		super(juego);
		this.grafico = new GraficoPremio();
		this.velocidad = 30;
	}

	@Override
	public void accionar() {
		// TODO Auto-generated method stub
		
	}
}