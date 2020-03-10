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
