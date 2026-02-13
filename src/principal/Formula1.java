package principal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import modelo.*;

public class Formula1 {
	static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Piloto> pilotos = new ArrayList<>();
		Carrera gpMonaco = new Carrera("GP Mónaco", new PuntosF1());

		boolean salir = false;
		do {
			System.out.println("\n=== MENÚ FÓRMULA 1 ===");
			System.out.println("1. Registrar piloto");
			System.out.println("2. Mostrar pilotos");
			System.out.println("3. Asignar puntos");
			System.out.println("4. Buscar por escudería");
			System.out.println("5. Mostrar ranking");
			System.out.println("6. Añadir logro a piloto");
			System.out.println("7. Salir");
			System.out.print("Opción: ");

			int opcion = Integer.parseInt(leer.readLine());
			switch (opcion) {
			case 1:
				Piloto p = registrarPiloto(pilotos);
				gpMonaco.añadirPiloto(p);
				break;
			case 2:
				gpMonaco.mostrarPilotos();
				break;
			case 3:
				asignarPuntos(gpMonaco);
				break;
			case 4:
				buscarPorEscuderia(gpMonaco);
				break;
			case 5:
				gpMonaco.mostrarRanking();
				break;
			case 6:
				añadirLogro(gpMonaco);
				break;
			case 7:
				salir = true;
				break;
			default:
				System.out.println("Opción no válida");
			}
		} while (!salir);
	}

	private static Piloto registrarPiloto(ArrayList<Piloto> pilotos) throws IOException {
		System.out.print("Nombre: ");
		String nombre = leer.readLine();
		System.out.print("Escudería: ");
		String escuderia = leer.readLine();
		System.out.print("Edad: ");
		int edad = Integer.parseInt(leer.readLine());
		int id = pilotos.size() + 1;
		return new Piloto(id, nombre, escuderia, edad);
	}

	private static void asignarPuntos(Carrera carrera) throws IOException {
		System.out.print("ID piloto: ");
		int id = Integer.parseInt(leer.readLine());
		System.out.print("Posición llegada: ");
		int pos = Integer.parseInt(leer.readLine());
		carrera.asignarPuntos(id, pos);
	}

	private static void buscarPorEscuderia(Carrera carrera) throws IOException {
		System.out.print("Escudería: ");
		String escuderia = leer.readLine();
		carrera.buscarPorEscuderia(escuderia);
	}

	private static void añadirLogro(Carrera carrera) throws IOException {
		System.out.print("ID piloto: ");
		int id = Integer.parseInt(leer.readLine());
		System.out.print("Nombre logro: ");
		String logro = leer.readLine();
		Piloto p = carrera.buscarPorId(id);
		if (p != null) {
			if (p.añadirLogro(logro))
				System.out.println("Logro añadido");
			else
				System.out.println("El piloto ya tiene 5 logros");
		} else
			System.out.println("Piloto no encontrado");
	}
}
