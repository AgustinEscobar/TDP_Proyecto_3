package Nivel;

import java.util.LinkedList;

import Logica.Infectado;
import Logica.Juego;

public class Nivel1 extends Nivel {

	public Nivel1(Juego j, int cantTandas) {
		super(j, cantTandas);
		this.cantInfectados = 5;

		for (int i = 0; i < cantTandas; i++) {
			this.arregloTandas[i] = new LinkedList<Infectado>();
			this.generarTanda(arregloTandas[i], cantInfectados);
		}
		this.cantInfectados = this.totalInfectados;
	}
}
