package Logica;

import GUI.GameGUI;

public class HiloGeneral extends Thread {
	protected GameGUI game_gui;
	protected Juego juego;

	public HiloGeneral(Juego juego, GameGUI game_gui) {
		/*
		 * por cada iteracion del hilo accionar() para que cada entidad del juego
		 * realice su comportamiento
		 */
		this.game_gui = game_gui;
		this.juego = juego;
		this.start();
	}
	
	public GameGUI getGame_gui() {
		return game_gui;
	}
	
	public Juego getJuego() {
		return juego;
	}

	@Override
	public void run() {
//		// TODO Auto-generated method stub
//		super.run();
		juego.accionar();
	}
}