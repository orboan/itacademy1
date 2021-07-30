/**
 * @author Oriol Boix Anfosso <orboan@gmail.com>
 *
 */
package dev.orboan.ita.bej.moduls1a4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import dev.orboan.ita.bej.exceptions.IncorrectPlatTypeException;
import dev.orboan.ita.bej.exceptions.platIdOutOfMenuException;

/*
 * M4. Excepcions i control d'errors
 */
public class Modul4 {
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

		// variables per a monedes i bitllets
		int un = 1, dos = 2, cinc = 5, deu = 10, vint = 20, cinquanta = 50, cent = 100, doscents = 200, cinccents = 500;

		// variable per al preu total de l'àpat
		int preuTotal = 0;

		// arrays per a guardar els plats del menú i els seus preus
		String[] plats = new String[10];
		int[] preus = new int[10];

	}

	private static void level1Fase2() {
		println("\n\n---- Nivell 1 - Fase 2 ----\n");

		int m1, m2, b5, b10, b20, b50, b100, b200, b500;

		int preuTotal = 0;

		String[] plats = new String[10];
		int[] preus = new int[10];
		loadMenu(plats, preus);

		// Llista de comanda
		// (cada plat té un codi numèric igual a l'índex a l'array de plats més 1)
		List<Integer> comanda = new ArrayList<>();
		// processOrder(comanda, plats, preus);

	}

	private static void level1Fase3() {
		println("\n\n---- Nivell 1 - Fase 3 ----\n");

		int preuTotal = 0;

		String[] plats = new String[10];
		int[] preus = new int[10];
		loadMenu(plats, preus);

		// Llista de comanda
		// (cada plat té un codi numèric igual a l'índex a l'array de plats més 1)
		List<Integer> comanda = new ArrayList<>();
		processOrder(comanda, plats, preus);
		if (checkOrder(comanda, plats)) {
			printComanda(comanda, plats, preus);
			preuTotal = getPreuTotalComanda(comanda, preus);
			println("Preu total de la comanda: " + preuTotal + "€");
			printBitllets(preuTotal);
		}

	}

	private static void level2() {
		println("\n\n---- Nivell 2 ----\n");

		int preuTotal = 0;

		String[] plats = new String[10];
		int[] preus = new int[10];
		loadMenu(plats, preus);

		// Llista de comanda
		// (cada plat té un codi numèric igual a l'índex a l'array de plats més 1)
		List<Integer> comanda = new ArrayList<>();

		// Processem la comanda, que ara llença una excepció si
		// el plat és desconegut, però segueix demanant plats
		processOrderWithExceptions(comanda, plats, preus);

		printComanda(comanda, plats, preus);
		preuTotal = getPreuTotalComanda(comanda, preus);
		println("Preu total de la comanda: " + preuTotal + "€");
		printBitllets(preuTotal);

	}

	private static void level3() {
		println("\n\n---- Nivell 3 ----\n");
		int preuTotal = 0;

		String[] plats = new String[10];
		int[] preus = new int[10];
		loadMenu(plats, preus);

		// Llista de comanda
		// (cada plat té un codi numèric igual a l'índex a l'array de plats més 1)
		List<Integer> comanda = new ArrayList<>();

		// Processem la comanda, que ara llença excepcions
		// personalitzades
		processOrderWithCustomExceptions(comanda, plats, preus);

		printComanda(comanda, plats, preus);
		preuTotal = getPreuTotalComanda(comanda, preus);
		println("Preu total de la comanda: " + preuTotal + "€");
		printBitllets(preuTotal);
	}

	/*
	 * Helper methods
	 */

	private static void printBitllets(int total) {
		total = printBitllets(total, 500);
		total = printBitllets(total, 200);
		total = printBitllets(total, 100);
		total = printBitllets(total, 50);
		total = printBitllets(total, 20);
		total = printBitllets(total, 10);
		total = printBitllets(total, 5);
		total = printBitllets(total, 2);
		printBitllets(total, 1);
	}

	private static int printBitllets(int total, int amountBitllet) {
		int numBitllets = total / amountBitllet;
		String tipus = "bitllets";
		if (amountBitllet < 5)
			tipus = "monedes";
		if (numBitllets != 0)
			println(numBitllets + " " + tipus + " de " + amountBitllet + "€");
		return total % amountBitllet;
	}

	private static int getPreuTotalComanda(List<Integer> comanda, int[] preus) {
		int total = 0;
		for (int i : comanda) {
			total += preus[i - 1];
		}
		return total;
	}

	private static void printComanda(List<Integer> comanda, String[] plats, int[] preus) {
		println("Plats demanats: ");
		List<Integer> platsComptats = new ArrayList<>();
		for (int i : comanda) {
			if (!platsComptats.contains(i)) {
				int f = Collections.frequency(comanda, i);
				println(String.format("%-15s - %-2s unitats - Preu: %3d €", plats[i - 1], f, preus[i - 1] * f));
				platsComptats.add(i);
			}
		}
		println("");
	}

	private static boolean checkOrder(List<Integer> comanda, String[] plats) {
		// Comprovem que no s'ha entrat un plat amb codi desconegut
		for (int i : comanda) {
			if (i < 1 || i > plats.length) {
				println("Has demanat un plat desconegut (codi: " + i + ")");
				return false;
			}
		}
		return true;
	}

	private static void loadMenu(String[] plats, int[] preus) {

		// Map amb les dades precarregades
		Map<String, Integer> preuPlat = new HashMap<>();
		preuPlat.put("Bufalina ", 12);
		preuPlat.put("4 formaggi", 12);
		preuPlat.put("Pino Daniele", 18);
		preuPlat.put("Margherita", 9);
		preuPlat.put("Prosciutto", 10);
		preuPlat.put("Parmiggiana", 11);
		preuPlat.put("Al tonno ", 13);
		preuPlat.put("Carbonara", 11);
		preuPlat.put("Massimo Troise", 17);
		preuPlat.put("Ortolana ", 12);

		// Omplenem els arrays des del map
		int counter = 0;
		for (Map.Entry<String, Integer> entry : preuPlat.entrySet()) {
			plats[counter] = entry.getKey();
			preus[counter] = entry.getValue();
			counter++;
		}
	}

	private static void processOrderWithCustomExceptions(List<Integer> comanda, String[] plats, int[] preus) {
		if (!checkMenu(plats, preus))
			return;
		printMenu(plats, preus);

		Scanner in = new Scanner(System.in);
		boolean notEmptyOrder = false;
		boolean end = false;
		while (!end) {
			print("Quin plat vols demanar [1 - 10] [q per acabar]: ");
			String input = "q";
			if (in.hasNextLine())
				input = in.nextLine();
			if (input.equals("q"))
				end = true;
			else {
				try {
					int platId = 0;
					//Llençarà una excepció expecífica si no s'ha introduit
					//un número enter
					try {
						platId = Integer.parseInt(input);
					} catch (final NumberFormatException nfe) {
						throw new IncorrectPlatTypeException(nfe.getMessage());
					}

					// Llencem una nova excepció general si el
					// plat és desconegut
					if (platId < 1 || platId > plats.length)
						throw new platIdOutOfMenuException("Plat desconegut (codi: " + platId + ")");
					comanda.add(platId);
					println("Plat '" + plats[platId - 1] + "' afegit a la comanda.");
				} catch (final IncorrectPlatTypeException ipte) {
					println(ipte.getMessage() + "\n - Pots seguir demanant o prémer 'q' per acabar.");
				} catch (final platIdOutOfMenuException e) {
					println(e.getMessage() + "\n - Pots seguir demanant o prémer 'q' per acabar.");
				}
			}
			// feedback bàsic
			if (comanda.isEmpty())
				println("\nLa comanda està buida. No has demanat cap plat encara! ");
			else
				notEmptyOrder = true;

		}
		if (notEmptyOrder)
			println("Gràcies per fer la comanda! ");
		in.close();
	}
	
	
	private static void processOrderWithExceptions(List<Integer> comanda, String[] plats, int[] preus) {
		if (!checkMenu(plats, preus))
			return;
		printMenu(plats, preus);

		Scanner in = new Scanner(System.in);
		boolean notEmptyOrder = false;
		boolean end = false;
		while (!end) {
			print("Quin plat vols demanar [1 - 10] [q per acabar]: ");
			String input = "q";
			if (in.hasNextLine())
				input = in.nextLine();
			if (input.equals("q"))
				end = true;
			else {
				try {
					//Llençarà una excepció expecífica si no s'ha introduit
					//un número enter
					int platId = Integer.parseInt(input);

					// Llencem una nova excepció general si el
					// plat és desconegut
					if (platId < 1 || platId > plats.length)
						throw new Exception("Error: Plat desconegut (codi: " + platId + ")");
					comanda.add(platId);
					println("Plat '" + plats[platId - 1] + "' afegit a la comanda.");
				} catch (final NumberFormatException nfe) {
					println("Error" + nfe.getMessage() + " - Pots seguir demanant o prémer 'q' per acabar.");
				} catch (final Exception e) {
					println(e.getMessage());
				}
			}
			// feedback bàsic
			if (comanda.isEmpty())
				println("\nLa comanda està buida. No has demanat cap plat encara! ");
			else
				notEmptyOrder = true;

		}
		if (notEmptyOrder)
			println("Gràcies per fer la comanda! ");
		in.close();
	}

	private static void processOrder(List<Integer> comanda, String[] plats, int[] preus) {

		if (!checkMenu(plats, preus))
			return;
		printMenu(plats, preus);

		Scanner in = new Scanner(System.in);
		boolean notEmptyOrder = false;
		boolean end = false;
		while (!end) {
			print("Quin plat vols demanar [1 - 10] [q per acabar]: ");
			String input = "q";
			if (in.hasNextLine())
				input = in.nextLine();
			if (input.equals("q"))
				end = true;
			else {
				try {
					int plat = Integer.parseInt(input);
					comanda.add(plat);
					println("Plat '" + plats[plat - 1] + "' afegit a la comanda.");
				} catch (final NumberFormatException e) {
					println("Error: has d'introduir un número de plat !");
				}
			}
			// feedback bàsic
			if (comanda.isEmpty())
				println("\nLa comanda està buida. No has demanat cap plat encara! ");
			else
				notEmptyOrder = true;

		}
		if (notEmptyOrder)
			println("Gràcies per fer la comanda! ");
		in.close();
	}

	private static boolean checkMenu(String[] plats, int[] preus) {
		// Controlem que els arrays entrats siguin plens i de la mateixa mida:
		if (plats.length == 0 || preus.length == 0 || plats.length != preus.length)
			return false;
		return true;
	}

	private static void printMenu(String[] plats, int[] preus) {
		// Mostrem els plats disponibles i els seus preus
		println("#### Plats disponibles i els seus preus: ####");
		for (int i = 0; i < plats.length; i++) {
			println((i + 1) + " - " + plats[i] + " - \t" + preus[i] + "€");
		}
	}

	private static void println(String str) {
		System.out.println(str);
	}

	private static void print(String str) {
		System.out.print(str);
	}
}
