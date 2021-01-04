package edai.tema7.ejercicio3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		GestionAlumnos GA = new GestionAlumnos();

		Scanner inString = new Scanner(System.in);
		Scanner inDouble = new Scanner(System.in);
		Scanner inInt = new Scanner(System.in);
		String asignatura;
		Double nota;
		GA.leerAlumnos();

		while (true) {
			System.out.println("Gestion de alumnos");
			System.out.println("1 ---> Leer alumnos\n2 ---> Crear un alumno\n3 ---> Salir del programa");
			switch (inString.nextLine()) {
			case "1":
				GA.getAlumnos().stream().forEach(alumno -> {
					System.out.println("Nombre: " + alumno.getNombre());
					System.out.println("Apellido: " + alumno.getApellido());
					alumno.getAsignaturaNota().forEach((k, v) -> {
						System.out.println(k + ": " + v);
					});
					System.out.println("");
				});
				break;
			case "2":
				Alumno a = new Alumno();
				System.out.println("Nombre:");
				a.setNombre(inString.nextLine());
				System.out.println("Apellido:");
				a.setApellido(inString.nextLine());
				System.out.println("Numero de asignaturas:");
				int nAsignaturas = inInt.nextInt();
				for (int i = 0; i < nAsignaturas; i++) {
					System.out.println("Asignatura:");
					asignatura = inString.nextLine();
					System.out.println("Nota:");
					nota = inDouble.nextDouble();
					a.getAsignaturaNota().put(asignatura, nota);
				}
				GA.getAlumnos().add(a);
				GA.guardarAlumnos();
				break;
			case "3":
				System.err.println("Cerrando el sistema...");
				inString.close();
				inInt.close();
				inDouble.close();
				System.exit(0);
			default:
				System.err.println("Select a valid option");
				break;
			}
		}

	}

}
