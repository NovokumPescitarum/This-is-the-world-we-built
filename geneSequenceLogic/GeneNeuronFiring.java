package geneSequenceLogic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import animalLogic.Cell;

public class GeneNeuronFiring {
	
	public String CellGeneticFiring(ArrayList<String> Genetics, Cell cell) {
		
		cell.setBaseCellGenetics(Genetics);
		Collections.shuffle(Genetics, new Random(5));
		Random ran = new Random();
		int randomitem = ran.nextInt(Genetics.size());
		String randomElement = Genetics.get(randomitem);
		cell.setLastFiredSequence(randomElement);
		return randomElement;
	}
}
