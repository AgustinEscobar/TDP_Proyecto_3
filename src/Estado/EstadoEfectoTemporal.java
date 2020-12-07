package Estado;

import Logica.Jugador;
import Logica.Proyectil;
import Logica.ProyectilSanitarioPremio;
import Premio.EfectoTemporal;

public class EstadoEfectoTemporal extends Estado {
	protected int cooldown;

	public EstadoEfectoTemporal(Jugador jugador) {
		super(jugador);
		jugador.getArma().setProyectil(new ProyectilSanitarioPremio(jugador.getJuego(), jugador.getGrafico()));
		this.cooldown = EfectoTemporal.MAXDURACION;
	}

	@Override
	public void cambiarEstado() {

	}

	@Override
	public void accionarEstado(Jugador jugador) {
		
	}

	@Override
	public void accionarEstado() {
		this.cooldown-=1;
		if(cooldown == 0) {
			jugador.setEstado(new EstadoNormal(jugador));
		}
	}
	
	@Override
	public Proyectil getProyectil() {
		return new ProyectilSanitarioPremio(jugador.getJuego(),jugador.getGrafico());
	}

}
