package Nivel;

import java.util.LinkedList;
import java.util.Random;

import Logica.Alpha;
import Logica.Beta;
import Logica.Infectado;
import Logica.Juego;

public class Nivel_1 extends Nivel {

	public Nivel_1(Juego j) {
		super(j);
		Random random;
		int valor;
		this.cant_infectados = 5;
		this.lista_infectados = new LinkedList<Infectado>();

		for (int i = 0; i < cant_infectados; i++) {
			random = new Random();
			valor = random.nextInt(3);
			if (valor == 1) {
				lista_infectados.add(new Beta(juego));
			} else {
				lista_infectados.add(new Alpha(juego));
			}
		}
	}
}
