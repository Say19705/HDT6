/**
 * @author Andres Say Agosto 19705
 * @author Cesar Vinicio Rodas Alvarado
 * Extraido de: Duane A Bailey (2007) java structures in java for principled programmer edición raiz 7
 */
import java.util.Collection;
import java.util.Map;
import java.util.Set;
public class Factory {
public Map getType(int op) {
		
		if(op==1) {
			return new hashMap();
		}
		if(op == 2) {
			
			return new TreeMap();
		}
		if(op == 3) {
			
			return new LinkedHashMap();
		}
		else
			return new hashMap();
	}

}
