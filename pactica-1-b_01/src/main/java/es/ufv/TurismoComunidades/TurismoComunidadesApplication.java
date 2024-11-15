package es.ufv.TurismoComunidades;


import es.ufv.TurismoComunidades.utils.Utilidades;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class TurismoComunidadesApplication {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		

		int option;
		do {
			System.out.println("\n----- Menú Principal -----");
			System.out.println("1. Convertir CSV a JSON");
			System.out.println("2. Agrupar por comunidad de destino");
			System.out.println("3. Resultados por período");
			System.out.println("4. Resultados origen");
			System.out.println("5. Salir");
			System.out.print("Seleccione una opción: ");
			option = scanner.nextInt();
			scanner.nextLine();  // Limpiar el salto de línea
			switch (option) {
				case 1:
					ArrayList<TurismoData> listaCsv = Utilidades.leerCsv("src/main/resources/TurismoComunidades.csv");
					Utilidades.guardarjsonTurismo(listaCsv,"TurismoComunidades.json");
					System.out.println(Utilidades.leerJson("TurismoComunidades.json"));
					break;
				case 2:

					break;
				case 3:


					break;
				case 4:

					break;
				case 5:
					System.out.println("Saliendo del programa...");
					break;
				default:
					System.out.println("Opción no válida, por favor intente de nuevo.");
					break;
			}
		} while (option != 5);

		scanner.close();
	}


}