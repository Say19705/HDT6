/**
 * @author Andres Say Agosto 19705
 * @author Cesar Vinicio Rodas Alvarado 16776
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
        ArrayList<String[]> cartasTmp =  new ArrayList<String[]>(); 
		
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
				String opciones = ":\n1. Agregar una carta a la colección del usuario" + 
								   "\n2. Mostrar un tipo de carta especifica" +
								   "\n3. Mostrar el nombre, tipo y la cantidad de carta que tiene el usuario en su coleccion" + 
								   "\n4. Mostrar el nombre, tipo y la cantidad de carta que tiene el usuario en su coleccion ordenada por tipo" +
								   "\n5. Mostrar el nombre y el tipo de todas las cartas existentes" +
								   "\n6. Mostrar el nombre y el tipo de todas las cartas existentes, ordenadas por tipo" +
								   "\n7. Salir del programa\n";

				System.out.println("\n¿Que desea realizar con las cartas?" + opciones);
				try {
					int op = teclado1.nextInt();
	                switch (op){
	                    case 1:{
	                        System.out.println("Nombre de la carta");
	                        Scanner sc = new Scanner(System.in);
	                        String carta = sc.nextLine();
	                        
	                        String[] tmp = carta.split("['|']");
	                        
	                        
	                        String[] tomarcarta = theMap.get(tmp[0]);
	                        
	                        if (tomarcarta.length == 0)
	                        	System.out.println("Carta invalida");
	                        else {
	                            cartas.add(tmp);
	                            if (!cartasTmp.contains(tmp)){
	                            	cartasTmp.add(tmp);
	                            }
	                            System.out.println("\nListo! Carta agregada.");
	                        }
	                    }break;
	                    case 2:{
	                        System.out.println("Ingrese el nombre de la carta a mostrar");
	                        String carta = teclado2.nextLine();
	                        String[] tmp = carta.split("['|']");
	                        System.out.println(ops.mostrarCarta(theMap,tmp));
	                    }break;
	                    case 3:{
	                    	String totalCartas = ops.mostrarCartas(cartasTmp,cartas); 
	                        System.out.println(totalCartas);
	                    }break;
	                    case 4:{
	                    	ArrayList<String[]> cartasOrdenadas = ops.sort_selecction(cartasTmp);
	                    	String lista = ops.mostrarCartas(cartasOrdenadas,cartas);
	                        System.out.println(lista);
	                    }break;
	                    case 5:{
	                    	 ArrayList<String[]> el = ops.elementosMap(theMap);
	                    	 String lista = ops.variantes(el);
	                         System.out.println(lista);
	                    }break;
	                    case 6:{
	                    	ArrayList<String[]> el = ops.elementosMap(theMap);
	                    	ArrayList<String[]> cartasOrdenadas = ops.sort_selecction(el);
	                    	String lista = ops.variantes(cartasOrdenadas);
	                    	System.out.println(lista);
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
