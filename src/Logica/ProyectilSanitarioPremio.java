package Logica;

import Grafico.Grafico;
import Grafico.GraficoProyectilSanitarioPremio;
import Visitor.Visitor;

public class ProyectilSanitarioPremio extends Proyectil {

	public ProyectilSanitarioPremio(Juego juego, Grafico grafico_jugador) {
		super(juego, grafico_jugador);
		this.grafico = new GraficoProyectilSanitarioPremio();
		this.grafico.setLocation(grafico_jugador.getX() + this.grafico.getAncho() + 11, grafico_jugador.getY() - this.grafico.getY() - 30);
		this.velocidad = 10;
		this.desinfeccion = 40;
	}

	@Override
	public void accionar() {
		movimiento.mover();
	}

	@Override
	public void aceptar(Visitor v) {
		v.visit_proyectil_premio(this);
	}

}