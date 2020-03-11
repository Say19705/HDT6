import java.util.ArrayList;
import java.util.Map;

public class OpcionesCartas {
	
	public String mostrarCarta(Map<String,String[]> mapa, String[] carta){
		String[] c = mapa.get(carta[0]);
        if (c==null) return "Nombre incorrecto, intente de nuevo";
        else return "La carta-> "+ c[0] + "es de tipo->" + c[1];
    }
	
	public String mostrarCartas(ArrayList<String[]> aux, ArrayList<String[]> al){
        String result = "";
        int i = 0;
        for (String[] card: aux) {
            for (String[] carta: al ) {
                if (card.equals(carta)) i++;
            }
            result = "Nombre-> "+ card[0] + " tipo-> " + card[1] + " hay " + i + " cartas en total.\n";
            i=0;
        }
        return result;
    }
}
