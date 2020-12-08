package Logica;

import Grafico.Grafico;
import Grafico.GraficoProyectilSanitarioPremio;
import Visitor.Visitor;

public class ProyectilSanitarioPremio extends Proyectil {

	public ProyectilSanitarioPremio(Juego juego, Grafico graficoJugador) {
		super(juego, graficoJugador);
		this.grafico = new GraficoProyectilSanitarioPremio();
		this.grafico.setLocation(graficoJugador.getX() + this.grafico.getAncho() + 11, graficoJugador.getY() - this.grafico.getY() - 30);
		this.velocidad = 10;
		this.desinfeccion = 40;
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitProyectilPremio(this);
	}

}