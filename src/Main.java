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
import java.io.BufferedReader;
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
		Map<String,String[]> theMap = null; 
        OpcionesCartas ops = new OpcionesCartas();
		ArrayList<String[]> cartas =new ArrayList<String[]>();
        ArrayList<String[]> cartasaux =  new ArrayList<String[]>(); 
		
		Factory factory = new Factory();
		//instanciar la otra clase que aun no esta hecha
		
		System.out.println("-------------------");
		System.out.println("|   Bienvenido    |");
		System.out.println("-------------------");
		
		System.out.println(System.getProperty("user.dir") + "\\cards_desc.txt");
		
		File archivo_cartas = new File(System.getProperty("user.dir") + "\\cards_desc.txt");
		if(archivo_cartas.exists()) {
			//Scanner data = new Scanner(archivo_cartas);
			Scanner teclado1 = new Scanner (System.in);//teclado para int
			Scanner teclado2 = new Scanner (System.in); //teclado para String
			
			//Selección de implementación
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
			
			//carga de cartas
			seguir = true;
			while (seguir) {
	            try {
	            	
	            	FileReader fr = new FileReader(archivo_cartas);
	    			BufferedReader br = new BufferedReader(fr);
	    			
	    			String linea = "";
	    			ArrayList<String> strings = new ArrayList<String>();
	    			
	    	        while((linea = br.readLine()) != null ) {
	    				strings.add(linea);
	    			}
	    			
	    			br.close();
	    			fr.close();
	            	
	            	for (String dato : strings) {
	                    String[] datos = dato.split("['|']");
	                    theMap.put(datos[0], datos);
	                }
	            	
	                System.out.println("Se ingresaron: " + theMap.size());
	                seguir = false;
	            } catch (Exception e) {
	                System.out.println("Error al leer el archivo");
	            }
	        }
			//Opciones con las cartas
			seguir = true;
			while(seguir) {
				String opciones = ":\n1. Agregar carta" + 
								   "\n2. Mostrar el tipo de carta deseada" +
								   "\n3. Mostrar las cartas" + 
								   "\n4. Mostrar las cartas ordenadas" +
								   "\n5. Mostrar todas las variantes de cartas" +
								   "\n6. Mostrar todas las variantes de cartas ordenadas" +
								   "\n7. Salir del programa\n";

				System.out.println("\n¿Que desea realizar con las cartas?" + opciones);
				try {
					int op = teclado1.nextInt();
	                switch (op){
	                    case 1:{
	                        System.out.println("Nombre de la carta\n");
	                        Scanner sc = new Scanner(System.in);
	                        String carta = sc.nextLine();
	                        
	                        String[] tmp = carta.split("['|']");
	                        
	                        
	                        String[] tomarcarta = theMap.get(tmp[0]);
	                        
	                        if (tomarcarta==null)
	                        	System.out.println("\nCarta invalida");
	                        else {
	                            cartas.add(tmp);
	                            if (!cartasaux.contains(tmp)){
	                                cartasaux.add(tmp);
	                            }
	                            System.out.println("\nListo! Carta agregada.");
	                        }
	                    }break;
	                    case 2:{
	                        System.out.println("\nIngrese el nombre de la carta a mostrar");
	                        String carta = teclado2.nextLine();
	                        String[] tmp = carta.split("['|']");
	                        System.out.println(ops.mostrarCarta(theMap,tmp));
	                    }break;
	                    case 3:{
	                        System.out.println(ops.mostrarCartas(cartasaux,cartas));
	                    }break;
	                    case 4:{
	                        //TODO
	                    }break;
	                    case 5:{
	                        //TODO
	                    }break;
	                    case 6:{
	                        //TODO
	                    }break;
	                    case 7:{
	                        System.out.println("Fin, hasta luego.");
	                        seguir= false;
	                    }break;
	                    default: throw  new  Exception();
	                }
	            } catch (Exception e){
	                System.out.println("Opción incorrecta");
	            }
			}
		}		
	}
}
