package Estado;

import Logica.Jugador;
import Logica.Proyectil;
import Logica.ProyectilSanitarioPremio;
import Premio.EfectoTemporal;

public class EstadoEfectoTemporal extends Estado {
	protected int cooldown;

	public EstadoEfectoTemporal(Jugador jugador) {
		super(jugador);
		this.cooldown = EfectoTemporal.MAXDURACION;
	}

	@Override
	public void accionarEstado() {
		this.cooldown-=2;
		if(cooldown <= 0) {
			jugador.setEstado(new EstadoNormal(jugador));
		}
	}
	
	@Override
	public Proyectil getProyectil() {
		return new ProyectilSanitarioPremio(jugador.getJuego(),jugador.getGrafico());
	}

}
