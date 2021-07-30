/**
 * @author Oriol Boix Anfosso <orboan@gmail.com>
 *
 */
package dev.orboan.ita.bej.moduls1a4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

/*
 * M3. Fluxe de dades amb Java
 */
public class Modul3 {

	private static String ciutat1, ciutat2, ciutat3, ciutat4, ciutat5, ciutat6;

	public static void run(String nivell, String fase) {

		switch (nivell) {
		case "nivell1":
			switch (fase) {
			case "fase1":
				level1Fase1();
				break;
			case "fase2":
				level1Fase2();
				break;
			case "fase3":
				level1Fase3();
				break;
			case "fase4":
				level1Fase4();
				break;
			default:
				throw new IllegalArgumentException("Fase invalida: " + fase);
			}
			break;
		case "nivell2":
			level2();
			break;
		case "nivell3":
			level3();
			break;
		default:
			throw new IllegalArgumentException("Nivell invalid: " + nivell);
		}
	}

	private static void level1Fase1() {
		println("---- Nivell 1 - Fase 1 ----\n");

		// berlin, madrid, lisboa, barcelona, roma, napols;
		Scanner in = new Scanner(System.in);
		ciutat1 = getCiutat(in, 1);
		ciutat2 = getCiutat(in, 2);
		ciutat3 = getCiutat(in, 3);
		ciutat4 = getCiutat(in, 4);
		ciutat5 = getCiutat(in, 5);
		ciutat6 = getCiutat(in, 6);
		in.close();

		println(ciutat1 + ", " + ciutat2 + ", " + ciutat3 + ", " + ciutat4 + ", " + ciutat5 + ", " + ciutat6);
	}

	private static void level1Fase2() {
		println("\n\n---- Nivell 1 - Fase 2 ----\n");

		setDefaultValuesForCities();

		String[] arrayCiutats = new String[6];
		arrayCiutats[0] = ciutat1;
		arrayCiutats[1] = ciutat2;
		arrayCiutats[2] = ciutat3;
		arrayCiutats[3] = ciutat4;
		arrayCiutats[4] = ciutat5;
		arrayCiutats[5] = ciutat6;

		bubbleSort(arrayCiutats);

		println("Ciutats per ordre alfabètic:");
		for (String str : arrayCiutats) {
			println(str);
		}

	}

	private static void level1Fase3() {
		println("\n\n---- Nivell 1 - Fase 3 ----\n");
		setDefaultValuesForCities();

		String[] arrayCiutats = new String[6];
		arrayCiutats[0] = ciutat1;
		arrayCiutats[1] = ciutat2;
		arrayCiutats[2] = ciutat3;
		arrayCiutats[3] = ciutat4;
		arrayCiutats[4] = ciutat5;
		arrayCiutats[5] = ciutat6;

		// Fem la transformació usant streams i lambdes
		Stream<String> stream = Arrays.stream(arrayCiutats);
		String[] arrayCiutats4 = stream.map(str -> replaceLetter(str, 'a', '4')).toArray(String[]::new);

		// Ordenem
		bubbleSort(arrayCiutats4);

		// imprimim
		println("Ciutats modificades per ordre alfabètic:");
		for (String str : arrayCiutats4) {
			println(str);
		}
	}

	private static void level1Fase4() {
		println("\n\n---- Nivell 1 - Fase 4 ----\n");
		setDefaultValuesForCities();
		
		//Character enlloc de char per usar en generics
		Character arrCiutat1[] = new Character[ciutat1.length()];
		Character arrCiutat2[] = new Character[ciutat2.length()];
		Character arrCiutat3[] = new Character[ciutat3.length()];
		Character arrCiutat4[] = new Character[ciutat4.length()];
		Character arrCiutat5[] = new Character[ciutat5.length()];
		Character arrCiutat6[] = new Character[ciutat6.length()];
		
		fillCharArray(arrCiutat1, ciutat1);
		fillCharArray(arrCiutat2, ciutat2);
		fillCharArray(arrCiutat3, ciutat3);
		fillCharArray(arrCiutat4, ciutat4);
		fillCharArray(arrCiutat5, ciutat5);
		fillCharArray(arrCiutat6, ciutat6);
		
		println("Ciutats amb els noms invertits:");
		
		printLevel1Fase4(arrCiutat1);
		printLevel1Fase4(arrCiutat2);
		printLevel1Fase4(arrCiutat3);
		printLevel1Fase4(arrCiutat4);
		printLevel1Fase4(arrCiutat5);
		printLevel1Fase4(arrCiutat6);				
	}

	private static void level2() {
		println("\n\n---- Nivell 2 ----\n");

		float[][] notes = new float[5][3];
		
		//Comenta l'opció per a obtenir notes que no vulguis executar
		
		//Notes des del teclat
		//getQualsFromUserInput(notes);
		
		//Random notes
		fillRandomQualifications(notes);
		
		//Calcul mitjana i imprimim per alumne
		println("\nAlumnes aprovats i suspesos amb nota mitjana:");
		int suma;
		float avg;
		String qualStr, nota;
		for(int i = 0; i < 5; i++) {
			suma = 0;
			for(int j = 0; j < 3; j++) {
				suma += notes[i][j];
			}
			avg = (float)suma/3;
			if (avg < 5.0f)
				qualStr = "suspès";
			else
				qualStr = "aprovat";
			nota = String.format("%.2f", avg);
			println("L'alumne " + (i + 1) + " ha " + qualStr + " amb un " + nota);
		}
		
	}

	private static void level3() {
		println("\n\n---- Nivell 3 ----\n");

		int n = 30;
		
		Scanner in = new Scanner(System.in);
		print("Seqüència de Fibonacci fins numero: ");
		n = in.nextInt();
		in.close();
		
		for(int last = 1, prelast = 0, fibo = 0; fibo <= n; last = fibo) {
			fibo = last + prelast;
			if(prelast == 0)
				print(prelast + " " + last + " " + fibo + " ");
			else {
				if(fibo <= n) 
					print(fibo + " ");
			}
			prelast = last;
		}
	}

	/*
	 * Helper methods
	 */
	private static void getQualsFromUserInput(float[][] notes) {
		Scanner in = new Scanner(System.in);
		for(int i = 1; i < 6; i++) {
			println("Notes per a l'alumne " + i + ":");
			for(int j = 1; j < 4; j++) {
				print("Introdueix la nota " + j + " per a l'alumne " + i + ": ");
				notes[i - 1][j - 1] = in.nextFloat();
				println("");
			}
		}
		in.close();
	}
	private static void fillRandomQualifications(float[][] notes) {
		Random r = new Random();
		float min = 0.0f;
		float max = 10.0f;
		for(int i = 0; i < 5; i ++) {
			for(int j = 0; j < 3; j++) {
				notes[i][j] = min + r.nextFloat() * (max - min);
			}
		}
	}
	
	private static void printLevel1Fase4(Character[] arr) {
		printArray(arr);
		print(" - " );
		printArrayInReverse(arr);
	}
	
	private static <T> void printArray(T[] array) {
		for (int i = 0; i <= array.length - 1; i++)
			print(array[i] + "");		
	}

	private static <T> void printArrayInReverse(T[] array) {
		for (int i = array.length - 1; i >= 0; i--)
			print(array[i] + "");
		println("");
	}

	private static void fillCharArray(Character[] arrCiutat, String ciutat) {
		// omplim arrCiutat amb caràcters de l'string un a un
		int index = 0;
		for (char c : ciutat.toCharArray()) { //alternativa: usar charAt(index)
			arrCiutat[index] = c;
			index++;
		}
	}

	private static String replaceLetter(String str, char c1, char c2) {
		// c1 és el caràcter a substituir
		// c2 és el caràcter substitut, el nou caràcter
		char[] array = new char[str.length()];
		int index = 0;
		for (char c : str.toCharArray()) {
			if (c == c1)
				array[index] = c2;
			else
				array[index] = c;
			index++;
		}
		return new String(array);
	}

	private static void bubbleSort(String[] arr) {
		int n = arr.length;
		String aux;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (arr[j - 1].compareToIgnoreCase(arr[j]) > 0) {
					// swap elements
					aux = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = aux;
				}

			}
		}
	}

	private static void setDefaultValuesForCities() {
		ciutat1 = "Berlin";
		ciutat2 = "Madrid";
		ciutat3 = "Lisboa";
		ciutat4 = "Barcelona";
		ciutat5 = "Roma";
		ciutat6 = "Napoles";
	}

	private static String getCiutat(Scanner in, int n) {
		print("Nom de la ciutat " + n + ": ");
		return in.nextLine();
	}

	private static void println(String str) {
		System.out.println(str);
	}

	private static void print(String str) {
		System.out.print(str);
	}
}
