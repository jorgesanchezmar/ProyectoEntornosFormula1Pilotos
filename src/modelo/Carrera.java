package modelo;

import java.util.ArrayList;
import java.util.Comparator;

public class Carrera {
	private String nombre;
	private ArrayList<Piloto> pilotos = new ArrayList<>();
	private CalculadorPuntos calculadorPuntos;

	public Carrera(String nombre, CalculadorPuntos calculadorPuntos) {
		this.nombre = nombre;
		this.calculadorPuntos = calculadorPuntos;
	}

	public void añadirPiloto(Piloto p) {
		pilotos.add(p);
	}

    // Asigna puntos a un piloto según su posición y la estrategia seleccionada
	public void asignarPuntos(int id, int posicion) {
		Piloto piloto = buscarPorId(id);
		if (piloto == null)
			System.out.println("Piloto no encontrado");
		else
			piloto.sumarPuntos(calculadorPuntos.calcular(posicion));
	}

	public Piloto buscarPorId(int id) {
		for (Piloto p : pilotos)
			if (p.getId() == id)
				return p;
		return null;
	}

    // Mostrar todos los pilotos
	public void mostrarPilotos() {
		System.out.println("=== Pilotos de la carrera " + nombre + " ===");
		for (Piloto p : pilotos)
			p.mostrarDatos();
	}

	public void mostrarRanking() {
		pilotos.sort(Comparator.comparingInt(Piloto::getPuntos).reversed());
		System.out.println("=== Ranking ===");
		for (Piloto p : pilotos)
			System.out.println(p.getNombre() + " | " + p.getEscuderia() + " | " + p.getPuntos() + " pts");
	}

	public void buscarPorEscuderia(String escuderia) {
		boolean encontrado = false;
		for (Piloto p : pilotos) {
			if (p.getEscuderia().equalsIgnoreCase(escuderia)) {
				p.mostrarDatos();
				encontrado = true;
			}
		}
		if (!encontrado)
			System.out.println("No hay pilotos registrados en " + escuderia);
	}
}
