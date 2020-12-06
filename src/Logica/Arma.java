package Logica;

public class Arma {
	protected Proyectil proyectil;
	protected Jugador jugador;
	
	public Arma(Proyectil p,Jugador jugador) {
		this.proyectil = p;
		this.jugador = jugador;
	}
	
	public Proyectil disparar() {
//		// crear un nuevo proyectil y ubicarlo en el mapa
//		proyectil = new Proyectil_sanitario(jugador.getJuego(),jugador.getGrafico());
//		return proyectil;
		return jugador.getEstado().getProyectil();
	}

	public void setProyectil(Proyectil p) {
		this.proyectil = p;
	}
}