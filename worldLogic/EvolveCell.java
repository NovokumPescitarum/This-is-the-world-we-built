package worldLogic;
import java.util.ArrayList;

import animalLogic.Cell;

public class EvolveCell {

	
	public void EvolveNutrientGene(String reinforce, ArrayList<String> Genetics,Cell cell) {
		Genetics.add(reinforce);
		Genetics.add(reinforce);
		Genetics.add(reinforce);
		Genetics.add(reinforce);
		Genetics.add(reinforce);
		
		cell.setHeight(cell.getHeight() + 1);
		cell.setWidth(cell.getWidth() + 1);
	}
	
	
	public void EvolvePredatorGene(String reinforce, ArrayList<String> Genetics,Cell cell) {
		Genetics.add(reinforce);
		Genetics.add(reinforce);
		Genetics.add(reinforce);
		Genetics.add(reinforce);
		Genetics.add(reinforce);
		Genetics.add(reinforce);
		Genetics.add(reinforce);
		Genetics.add(reinforce);
		Genetics.add(reinforce);
		Genetics.add(reinforce);
		Genetics.add(reinforce);
		Genetics.add(reinforce);
		Genetics.add(reinforce);
		Genetics.add(reinforce);
		Genetics.add(reinforce);
		cell.setHeight(cell.getHeight() + 3);
		cell.setWidth(cell.getWidth() + 3);
		
		System.out.println("ID: " + cell.getId());
		System.out.println("Genetic Sequence: " + cell.getBaseCellGenetics());
		System.out.println("Using Movement: " + cell.getLastFiredSequence());
		System.out.println("Kill count: " + cell.getKillCount());
		System.out.println("Height: " + cell.getHeight());
		System.out.println("Width: " + cell.getWidth());
		System.out.println("Location: " + cell.getPos());
		System.out.println();
		

		cell.setHeight(cell.getHeight() + 1);
		cell.setWidth(cell.getWidth() + 1);
	}

}
