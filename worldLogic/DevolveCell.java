package worldLogic;

import java.util.ArrayList;
import java.util.Collections;

public class DevolveCell {
	
	public void DevolveGenetic(String devolve, ArrayList<String> Genetics) {
		if(Collections.frequency(Genetics, devolve) > 5) {
			Genetics.remove(devolve);
			Genetics.remove(devolve);
		}
	}
}
