/**
 * @author Oriol Boix Anfosso <orboan@gmail.com>
 *
 */
package dev.orboan.ita.bej.main;

import dev.orboan.ita.bej.moduls1a4.Modul1;
import dev.orboan.ita.bej.moduls1a4.Modul2;
import dev.orboan.ita.bej.moduls1a4.Modul3;
import dev.orboan.ita.bej.moduls1a4.Modul4;

public class Main {

	public static void main(String[] args) {
		
		//Comenta / descomenta segons el que vulguis executar
		
		//runModul1();
		//runModul2();
		//runModul3();
		runModul4();

	}

	private static void runModul1() {
		printHeader(1);
		
		//Comenta / descomenta segons el que vulguis executar
		
		Modul1.run("nivell1", "fase1");
		Modul1.run("nivell1", "fase2");
		Modul1.run("nivell1", "fase3");
		Modul1.run("nivell1", "fase4");
		Modul1.run("nivell2", "");
		Modul1.run("nivell3", "");
	}

	private static void runModul2() {
		printHeader(2);
		
		//Comenta / descomenta segons el que vulguis executar
		
		Modul2.run("nivell1", "fase1");
		Modul2.run("nivell1", "fase2");
		Modul2.run("nivell1", "fase3");
		Modul2.run("nivell1", "fase4");
		Modul2.run("nivell2", "");
		Modul2.run("nivell3", "");
	}
	
	private static void runModul3() {
		printHeader(3);
		
		//Comenta / descomenta segons el que vulguis executar
		
		//Modul3.run("nivell1", "fase1");
		Modul3.run("nivell1", "fase2");
		Modul3.run("nivell1", "fase3");
		Modul3.run("nivell1", "fase4");
		Modul3.run("nivell2", "");
		Modul3.run("nivell3", "");
	}
	
	private static void runModul4() {
		printHeader(4);
		
		//Comenta / descomenta segons el que vulguis executar
		
		//Modul3.run("nivell1", "fase1");
		//Modul4.run("nivell1", "fase2");
		//Modul4.run("nivell1", "fase3");
		//Modul4.run("nivell2", "");
		Modul4.run("nivell3", "");
	}

	private static void printHeader(int module) {
		System.out.println("\n");
		System.out.println("###########################");
		System.out.println("#### Exercicis Mòdul " + module + " ####");
		System.out.println("###########################\n");
	}
}
