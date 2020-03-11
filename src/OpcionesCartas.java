/**
 * @author Andres Say Agosto 19705
 * @author Cesar Vinicio Rodas Alvarado 16776
 */
import java.util.ArrayList;
import java.util.Map;

public class OpcionesCartas {
	
	//Muestra la carta seleccionada
	public String mostrarCarta(Map<String,String[]> mapa, String[] carta){
		String[] c = mapa.get(carta[0]);
        if (c==null) return "Nombre incorrecto, intente de nuevo";
        else return "La carta-> "+ c[0] + "es de tipo-> " + c[1];
    }
	
	//muestra todas las cartas
	public String mostrarCartas(ArrayList<String[]> aux, ArrayList<String[]> al){
        String result = "";
        int i = 0;
        for (String[] card: aux) {
            for (String[] carta: al ) {
                if (card.equals(carta)) i++;
            }
            result = result + "Nombre-> "+ card[0] + " tipo-> " + card[1] + " cantidad-> " + i + " cartas en total.\n";
            i=0;
        }
        return result;
    }
	
	//Ordena las cartas
	public ArrayList<String[]> sort_selecction(ArrayList<String[]> cartas){
        int n = cartas.size();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++){
                String[] ob1 = cartas.get(j);
                String[] ob2 = cartas.get(j+1);
                if (ob1[1].compareTo(ob2[1])>1){
                	cartas.set(j,ob2);
                    cartas.set(j+1,ob1);
                }
            }
        return cartas;
    }
	
	//variantes de las cartas
	public String variantes(ArrayList<String[]> cartas) {
        String result ="";
        for (String[] carta: cartas) {
            result+="Nombre-> " + carta[0] + " Tipo-> " + carta[1] + "\n";
        }
        return result;
    }
	
	//obtener los elementos del Map
	public ArrayList<String[]> elementosMap (Map<String,String[]> map){
        ArrayList<String[]> elementos = new ArrayList<String[]>();
        map.forEach((K,V)->elementos.add(V));
        return elementos;
    }
}
