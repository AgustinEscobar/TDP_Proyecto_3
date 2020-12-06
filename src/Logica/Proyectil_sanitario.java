package Logica;

import Grafico.Grafico;
import Grafico.GraficoProyectilSanitario;
import Visitor.Visitor;

public class Proyectil_sanitario extends Proyectil {

	public Proyectil_sanitario(Juego juego,Grafico grafico_jugador) {
		super(juego,grafico_jugador);
		this.grafico = new GraficoProyectilSanitario();
		this.velocidad = 8;
		this.desinfeccion = 25;
		this.grafico.setLocation(grafico_jugador.getX() + this.grafico.getAncho()+11, grafico_jugador.getY()-this.grafico.getY()-30);
	}

	@Override
	public void accionar() {
		movimiento.mover();
	}

	@Override
	public void aceptar(Visitor v) {
		v.visit_proyectil_sanitario(this);
	}

}