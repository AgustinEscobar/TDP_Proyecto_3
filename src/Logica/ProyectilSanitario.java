package Logica;

import Grafico.Grafico;
import Grafico.GraficoProyectilSanitario;
import Visitor.Visitor;

public class ProyectilSanitario extends Proyectil {

	public ProyectilSanitario(Juego juego,Grafico graficoJugador) {
		super(juego,graficoJugador);
		this.grafico = new GraficoProyectilSanitario();
		this.velocidad = 8;
		this.desinfeccion = 25;
		this.grafico.setLocation(graficoJugador.getX() + this.grafico.getAncho()+11, graficoJugador.getY()-this.grafico.getY()-30);
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitProyectilSanitario(this);
	}

}