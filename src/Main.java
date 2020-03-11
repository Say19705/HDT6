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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
public class Main {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws Exception{
		boolean seguir = true;
		//Map<String,String[]> map = null;
		Map theMap = null; 
		
		Factory factory = new Factory();
		//instanciar la otra clase que aun no esta hecha
		
		System.out.println("-------------------");
		System.out.println("|   Bienvenido    |");
		System.out.println("-------------------");
		
		File archivo_cartas = new File("C:\\Users\\cvrodas\\eclipse-workspace\\HDT6\\src\\cards_desc.txt");
		if(archivo_cartas.exists()) {
			Scanner data = new Scanner(archivo_cartas);
			Scanner teclado1 = new Scanner (System.in);//teclado para int
			Scanner teclado2 = new Scanner (System.in); //teclado para String
			//System.out.println("Aqui quiero ver si mostramos todos lo tipos de cartas para que el usuario elija");
			
			while(seguir) {
				System.out.println("¿Que implementacion desea utilizar? \n1. HashMap \n2.TreeMap \n3.LinkedHashMap ");
				try {
					int op = teclado1.nextInt();
					if(op == 1) {
						theMap = factory.getType(op);
					} else  if(op == 2) {
						theMap = factory.getType(op);
					}else if(op == 3) {
						theMap = factory.getType(op);
					} else {
						throw  new  Exception();
					}
					seguir = false;
				}catch(Exception E) {
					
				}
			}
			//
			while (seguir) {
	            try {
	                Scanner sc = new Scanner(archivo_cartas);//Escanea el archivo
	                String string = "";
	                ArrayList<String> strings = new ArrayList<String>();
	                while (sc.hasNextLine()) {//Lee e archivo
	                    strings.add(sc.nextLine());
	                }
	                for (String dato : strings) {
	                    String[] datos = dato.split("['|']");
	                    theMap.put(datos[0], datos);
	                }
	                seguir = false;
	            } catch (Exception e) {
	                System.out.println("Error al leer el archivo");
	            }
	        }
			
			
		}
		System.out.println("fin");
		
		
		
	}
}
