/**
 * @author Oriol Boix Anfosso <orboan@gmail.com>
 *
 */
package dev.orboan.ita.bej.moduls1a4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


/*
 * M2. Estructura de dades, bucles i condicionals
 */
public class Modul2 {
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
			try {
				level3();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			throw new IllegalArgumentException("Nivell invalid: " + nivell);
		}
	}

	private static void level1Fase1() {
		println("---- Nivell 1 - Fase 1 ----\n");

		char[] fullName = { 'O', 'r', 'i', 'o', 'l', ' ', 'B', 'o', 'i', 'x' };
		for (char i : fullName) {
			print(i);
		}
		println("");
	}

	private static void level1Fase2() {
		println("\n\n---- Nivell 1 - Fase 2 ----\n");

		Character[] fullName = { 'O', 'r', 'i', 'o', 'l', ' ', 'B', 'o', 'i', 'x' };
		List<Character> nameListOfChars = Arrays.asList(fullName);

		for (Character c : nameListOfChars) {
			if (Character.isDigit(c)) {
				println("Els noms de persones no contenen números!");
				break;
			}
			char ch = Character.toLowerCase(c);
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
				println(c + " VOCAL");
			else if (!Character.isWhitespace(c))
				println(c + " CONSONANT");
			else
				println("");
		}

	}

	private static void level1Fase3() {
		println("\n\n---- Nivell 1 - Fase 3 ----\n");

		char[] fullName = { 'O', 'r', 'i', 'o', 'l', ' ', 'B', 'o', 'i', 'x' };
		for (char c : fullName) {
			print(c);
		}
		println("");
		Map<Character, Integer> parelles = new HashMap<>();

		int numberOfRepetitions;

		// Omplir el map
		for (char c : fullName) {
			numberOfRepetitions = countRepetitions(c, fullName);
			parelles.put(c, numberOfRepetitions);
		}

		// Imprimir el map
		for (Map.Entry<Character, Integer> entry : parelles.entrySet()) {
			println("clau='" + entry.getKey() + "', valor=" + entry.getValue());
		}

	}

	private static void level1Fase4() {
		println("\n\n---- Nivell 1 - Fase 4 ----\n");

		Character[] name = { 'O', 'r', 'i', 'o', 'l' };
		List<Character> nameList = Arrays.asList(name);

		// Aquí ho faig d'una manera diferent:
		char[] surname = { 'B', 'o', 'i', 'x' };
		List<Character> surnameList = new ArrayList<>();
		for (char c : surname)
			surnameList.add(c);

		// Concatenem les dues llistes:
		List<Character> fullName = new ArrayList<>();
		fullName.addAll(nameList);
		fullName.add(' ');
		fullName.addAll(surnameList);

		// Imprimim la llista final:
		println(fullName.toString());

	}

	private static void level2() {
		println("\n\n---- Nivell 2 ----\n");

		print("Introdueix l'alçada: ");
		Scanner in = new Scanner(System.in);
		
		int alcada = in.nextInt();
		in.close();
		
		// Pila de numeros:
		for (int i = 0; i < alcada; i++) {
			for (int j = 0; j <= i; j++)
				print(j + 1 + "");
			println("");
		}

		println("");
		
		// Piramide invertida asteriscs:
		for (int i = alcada; i > 0; i--) {
			for (int k = 0; k < alcada - i; k++)
				print(" ");
			for (int j = 0; j < i * 2 - 1; j++)
				print("*");
			println("");
		}

	}

	private static void level3() throws InterruptedException {
		println("\n\n---- Nivell 3 ----\n");

		int hour = 0, minutes = 0, seconds = 0;
		while(true) {
			println(buildTimeStr(hour,minutes,seconds));
			Thread.sleep(1000);
			seconds++;
			if(seconds == 60) {
				minutes++;
				seconds = 0;
			}
			if(minutes == 60) {
				hour++;
				minutes = 0;
			}
		}
	}

	/*
	 * Helper methods
	 */

	private static int countRepetitions(char c, char[] array) {
		int counter = 0;
		for (char ch : array) {
			if (ch == c)
				counter++;
		}
		return counter;
	}

	private static String buildTimeStr(int hour, int minutes, int seconds) {
		String fhour = String.format("%02d", hour);
		String fminutes = String.format("%02d", minutes);
		String fseconds = String.format("%02d", seconds);
		return fhour + ":" + fminutes + ":" + fseconds;
	}
	
	private static void println(String str) {
		System.out.println(str);
	}

	private static void print(String str) {
		System.out.print(str);
	}

	private static void print(char c) {
		System.out.print(c);
	}
}
