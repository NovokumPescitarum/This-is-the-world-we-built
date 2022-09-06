package geneSequenceLogic;

import java.util.ArrayList;
import java.util.Random;
import animalLogic.Cell;

public class GeneNeuronFiring {
	
	public String CellGeneticFiring(ArrayList<String> Genetics, Cell cell) {
		
		cell.setBaseCellGenetics(Genetics);
		
		Random ran = new Random();
		int randomitem = ran.nextInt(Genetics.size());
		String randomElement = Genetics.get(randomitem);
		cell.setLastFiredSequence(randomElement);
		return randomElement;
	}
}
