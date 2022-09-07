package animalLogic;

import java.util.ArrayList;
import worldLogic.EvolveCell;

public class AttackLogic {

	public AttackLogic(ArrayList<Cell> cellList){
		ArrayList<Cell> deadCells = new ArrayList<>();
		EvolveCell evolutionLogic = new EvolveCell();
		
		for (Cell cell2 : cellList)
			for (Cell cell: cellList){
				// if the cell is on the same tile as a nute, collect it
				if (cell.getPos().equals(cell2.getPos()) && cell.getNutrientsInSystem() > cell2.getNutrientsInSystem()) {  				 
					cell.setKillCount(cell.getKillCount() + 4);
					cell.addNutrient(3);
					evolutionLogic.EvolvePredatorGene(cell.getLastFiredSequence(), cell.getBaseCellGenetics(), cell);
					deadCells.add(cell2);
					
				}
				else if(cell.getPos().equals(cell2.getPos()) && cell.getNutrientsInSystem() < cell2.getNutrientsInSystem()){
					cell2.setKillCount(cell.getKillCount() + 4);
					cell.addNutrient(3);
					evolutionLogic.EvolvePredatorGene(cell2.getLastFiredSequence(), cell2.getBaseCellGenetics(), cell2);
					deadCells.add(cell);
				}

			}cellList.removeAll(deadCells);


	}

}


