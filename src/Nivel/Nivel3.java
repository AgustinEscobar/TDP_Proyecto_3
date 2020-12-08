package Nivel;

import java.util.LinkedList;

import Logica.Infectado;
import Logica.Juego;
import Logica.SuperInfectado;

public class Nivel3 extends Nivel{

	public Nivel3(Juego juego, int cantTandas) {
		super(juego, cantTandas);
		
		for (int i = 0; i < cantTandas; i++) {
			this.arregloTandas[i] = new LinkedList<Infectado>();
			this.arregloTandas[i].add(new SuperInfectado(juego));
			totalInfectados += 1;
		}
		
		
	}

}
