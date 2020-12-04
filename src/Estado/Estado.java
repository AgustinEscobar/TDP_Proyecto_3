package Estado;

import Logica.Personaje;

/*
 * - atributo personaje
 * - dependiendo el tipo de efecto, vamos a castear
 * de personaje a infectado o jugador segun corresponda (ej: en estado premio precioso vamos
 * a castear a jugador y modificar el comportamiento de jugador, ya que en premio precioso
 * solo va a afectar al jugador)
 */
public abstract class Estado {
	protected Personaje personaje;

	public Estado(Personaje personaje) {
		this.personaje = personaje;
	}

	public abstract void accionarEstado(Personaje jugador);

	public abstract void cambiarEstado();
}
