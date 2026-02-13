package modelo;

public class PuntosRapidos extends CalculadorPuntos {
	
    @Override

	public int calcular(int posicion) {
		return Math.max(0, 10 - (posicion - 1));
	}
}
