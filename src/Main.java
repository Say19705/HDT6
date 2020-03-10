/**
 * @author Andres Say Agosto 19705
 * @author Cesar Vinicio Rodas Alvarado
 * Extraido de: Duane A Bailey (2007) java structures in java for principled programmer edición raiz 7
 */
//A
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
public class Main {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws Exception{
		Factory factory = new Factory();
		//instanciar la otra clase que aun no esta hecha
		
		System.out.println("-------------------");
		System.out.println("|   Bienvenido    |");
		System.out.println("-------------------");
		
		File datos = new File("cards_desc.txt");
		if(datos.exists()) {
			Scanner data = new Scanner(datos);
			Scanner teclado1 = new Scanner (System.in);//teclado para int
			Scanner teclado2 = new Scanner (System.in); //teclado para String
			//System.out.println("Aqui quiero ver si mostramos todos lo tipos de cartas para que el usuario elija");
			boolean seguir = true;
			while(seguir) {
				System.out.println("¿Que implementacion desea utilizar? \n1. HashMap \n2.TreeMap \n3.LinkedHashMap ");
				try {
					int op = teclado1.nextInt();
					if(op == 1) {
						Map theMap = factory.getType(op);
						System.out.println("Ingrese que carta desea tomar : ");
						
					}
					if(op == 2) {
						Map theMap = factory.getType(op);
					}
					if(op == 3) {
						Map theMap = factory.getType(op);
					}
				}catch(Exception E) {
					
				}
			}
		}
		
		
		
	}
}
