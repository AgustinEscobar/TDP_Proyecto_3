package Nivel;

import java.util.List;

import Logica.Infectado;
import Logica.Juego;

public abstract class Nivel {
	protected Juego juego;
	protected int cant_infectados;
	protected List<Infectado> lista_infectados;
	
	public Nivel(Juego juego) {
		this.juego=juego;
	}
	
	public List<Infectado> get_lista_infectados(){
		return lista_infectados;
	}
	
	public  int get_cant_infectados() {
		return cant_infectados;
	}
}
