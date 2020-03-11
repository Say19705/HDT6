/**
 * @author Andres Say Agosto 19705
 * @author Cesar Vinicio Rodas Alvarado 16776
 * Extraido de: Duane A Bailey (2007) java structures in java for principled programmer edición raiz 7
 */
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Factory<K,V> {
	public Map<K,V> getType(int op) {
		
		if(op==1) {
			return new HashMap<K,V>();
		}
		if(op == 2) {
			
			return new TreeMap<K,V>();
		}
		if(op == 3) {
			
			return new LinkedHashMap<K,V>();
		}
		else
			return new HashMap<K,V>();
	}

}
