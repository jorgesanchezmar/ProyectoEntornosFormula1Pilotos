package modelo;

public class Piloto {
	private int id;
	private String nombre;
	private String escuderia;
	private int edad;
	private int puntos;
	private String[] logros = new String[5];
	private int numLogros;

	public Piloto(int id, String nombre, String escuderia, int edad) {
		this.id = id;
		this.nombre = nombre;
		this.escuderia = escuderia;
		this.edad = edad;
		this.puntos = 0;
		this.numLogros = 0;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEscuderia() {
		return escuderia;
	}

	public int getEdad() {
		return edad;
	}

	public int getPuntos() {
		return puntos;
	}

	public void sumarPuntos(int pts) {
		this.puntos += pts;
	}

	public boolean añadirLogro(String logro) {
		if (numLogros < 5) {
			logros[numLogros++] = logro;
			return true;
		}
		return false;
	}

	public void mostrarDatos() {
		System.out.println("ID: " + id + " | " + nombre + " (" + escuderia + ")");
		System.out.println("Edad: " + edad + " | Puntos: " + puntos);
		if (numLogros == 0)
			System.out.println("Logros: Ninguno");
		else {
			System.out.print("Logros: ");
			for (int i = 0; i < numLogros; i++)
				System.out.print(logros[i] + ", ");
			System.out.println();
		}
	}

}
