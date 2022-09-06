package foodLogic;

import java.util.ArrayList;

import animalLogic.Cell;
import worldLogic.DevolveCell;
import worldLogic.EvolveCell;

public class CollisionLogic {

	public CollisionLogic(ArrayList<Cell> cellList, ArrayList<Nutrient> nuteList){
		ArrayList<Nutrient> collectedNutrients = new ArrayList<>();
		EvolveCell evolutionLogic = new EvolveCell();
		DevolveCell devolutionLogic = new DevolveCell();

		for (Nutrient nute : nuteList)
			for (Cell cell: cellList){
				// if the cell is on the same tile as a nute, collect it
				if (cell.getPos().equals(nute.getPos())) {  				 
					// remove collected nutrients from the board 
					collectedNutrients.add(nute);
					cell.addNutrient(nute.getNutritiousValue());
					cell.setHeight(cell.getHeight() + 1);
					
					evolutionLogic.EvolveGenetic(cell.getLastFiredSequence(), cell.getBaseCellGenetics());
					}
				else {
					devolutionLogic.DevolveGenetic(cell.getLastFiredSequence(), cell.getBaseCellGenetics());
				}

			}nuteList.removeAll(collectedNutrients);


	}

}
