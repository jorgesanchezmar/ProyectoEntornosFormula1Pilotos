package modelo;

public class PuntosF1 extends CalculadorPuntos {
	public int calcular(int posicion) {

		// Distribución de puntos oficial de F1
		switch (posicion) {
		case 1:
			return 25;
		case 2:
			return 18;
		case 3:
			return 15;
		case 4:
			return 12;
		case 5:
			return 10;
		default:
			return 0;
		}
	}
}
