package Visitor;

import Premio.PremioSuperArmaSanitaria;
import Logica.Alpha;
import Logica.Beta;
import Logica.Jugador;
import Logica.Particula;
import Logica.ProyectilSanitario;
import Logica.ProyectilSanitarioPremio;
import Logica.SuperInfectado;
import Premio.EfectoTemporal;
import Premio.ObjetoPrecioso;
import Premio.PremioCuarentenaObligatoria;

public abstract class Visitor {
	public void visitAlpha(Alpha a) {}
	public void visitBeta(Beta b) {}
	public void visitJugador(Jugador j) {}
	public void visitProyectilSanitario(ProyectilSanitario p) {}
	public void visitProyectilPremio(ProyectilSanitarioPremio p) {}
	public void visitParticula(Particula p) {}
	public void visitPremioPrecioso(ObjetoPrecioso o) {}
	public void visitPremioTemporal(EfectoTemporal e) {}
	public void visitSuperInfectado(SuperInfectado i) {}
	public void visitSuperArmaSanitaria(PremioSuperArmaSanitaria a) {}
	public void visitCuarentenaObligatoria(PremioCuarentenaObligatoria p) {}
}
