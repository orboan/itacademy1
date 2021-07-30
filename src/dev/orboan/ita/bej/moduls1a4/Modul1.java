/**
 * @author Oriol Boix Anfosso <orboan@gmail.com>
 *
 */
package dev.orboan.ita.bej.moduls1a4;

import java.util.Arrays;

/*
 * M1. Els conceptes bàsics de Java
 */
public class Modul1 {

	private static String fraseAnyTraspas;
	
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
		String nom = "Jean-Luc";
		String cognom1 = "Picard";
		String cognom2 = "Gessard";
		int dia = 13;
		int mes = 7;
		int any = 2305;

		println(nom + " " + cognom1 + " " + cognom2);
		println(dia + "/" + mes + "/" + any);

		// Especifiquem el número de xifres (afegint 0 davant si cal)
		String fdia = String.format("%02d", dia);
		String fmes = String.format("%02d", mes);
		String fany = String.format("%04d", any);

		println(fdia + "/" + fmes + "/" + fany);
	}

	private static void level1Fase2() {
		println("\n\n---- Nivell 1 - Fase 2 ----\n");

		int anytraspas = 1948;
		int anynaixement = 1987;
		int counter = 0;

		println("Anys de traspas des de " + anytraspas + " fins a " + anynaixement + ": ");
		for (int i = anytraspas; i <= anynaixement; i++)
			if (isAnyTraspas(i)) {
				print(i + " ");
				counter++;
			}
		print("\nNombre d'anys de traspas des de " + anytraspas + " fins a " + anynaixement + ": ");
		println(counter + "");
	}

	private static void level1Fase3() {
		println("\n\n---- Nivell 1 - Fase 3 ----\n");
		
		int any = 1948;
		boolean esAnyDeTraspas = isAnyTraspas(any);
		fraseAnyTraspas = creaFraseTraspas(esAnyDeTraspas, any);
		println(fraseAnyTraspas);
		
		any = 1987;
		esAnyDeTraspas = isAnyTraspas(any);
		fraseAnyTraspas = creaFraseTraspas(esAnyDeTraspas, any);
		println(fraseAnyTraspas);

	}

	private static void level1Fase4() {
		println("\n\n---- Nivell 1 - Fase 4 ----\n");
		
		String nom = "Jean-Luc";
		String cognom1 = "Picard";
		String cognom2 = "Gessard";
		int dia = 13;
		int mes = 7;
		int any = 2305;
		boolean esAnyDeTraspas = isAnyTraspas(any);
		fraseAnyTraspas = creaFraseTraspas(esAnyDeTraspas, any);
		
		println("El meu nom és " + nom + " " + cognom1 + " " + cognom2);
		println("Vaig néixer el " + dia + "/" + mes+ "/" + any);
		println(fraseAnyTraspas);		
	}

	private static void level2() {
		println("\n\n---- Nivell 2 ----\n");
		
		double pi = 3.1416;
		int ipi = (int)pi;
		float fpi = (float)pi;
		String spi = String.valueOf(pi);
		
		println(pi + " double");
		println(ipi + " int");
		println(fpi + " float");
		println(spi + " String");
		//Totes les variables numèriques primitives són convertides
		//a String en ser concatenades amb un String
	}

	private static void level3() {
		println("\n\n---- Nivell 3 ----\n");
		
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		println(Arrays.toString(array));
		
		//Rotació de l'array:
		int longitud = array.length;
		int aux;
		for(int i = 0; i <= longitud / 2; i++) {
			aux = array[longitud - 1 - i];
			array[longitud - 1 - i] = array[i];
			array[i] = aux;			
		}
		println(Arrays.toString(array));
	}

	
	/* 
	 * Helper methods
	 */
	private static boolean isAnyTraspas(int any) {
		if(any % 4 != 0)
			return false;
		else if(any % 100 != 0)
			return true;
		else if(any % 400 != 0)
			return false;
		return true;
	}
	
	private static String creaFraseTraspas(boolean esAnyDeTraspas, int any) {
		if(esAnyDeTraspas) 
			return "L'any " + any + " sí és de traspàs.";
		else
			return "L'any " + any + " no és de traspàs.";
		
	}

	private static void println(String str) {
		System.out.println(str);
	}

	private static void print(String str) {
		System.out.print(str);
	}

}
