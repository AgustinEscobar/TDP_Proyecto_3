package Logica;

import java.awt.Point;

import Grafico.Grafico;
import Grafico.GraficoProyectilSanitarioPremio;
import Visitor.Visitor;

public class Proyectil_sanitario_premio extends Proyectil{
	
	//relentiza tambien
	public Proyectil_sanitario_premio(Juego juego, Grafico grafico) {
		super(juego, grafico);
		this.grafico = new GraficoProyectilSanitarioPremio();
		this.velocidad = 10;
		this.cap_desinfeccion= 40;	
		
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