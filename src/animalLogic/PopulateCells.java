package animalLogic;

import java.util.ArrayList;
import java.util.Random;


public class PopulateCells {
	
	private ArrayList<Cell> cellList = new ArrayList<>();
	
	public PopulateCells(int NUM_CELLS, int COLUMNS, int ROWS) {

		
		Random rand = new Random();

		// create the given number of coins in random positions on the board.
		// note that there is not check here to prevent two coins from occupying the same
		// spot, nor to prevent coins from spawning in the same spot as the player
		for (int i = 0; i < NUM_CELLS; i++) {
			int nuteX = rand.nextInt(COLUMNS);
			int nuteY = rand.nextInt(ROWS);
			cellList.add(new Cell(nuteX, nuteY, i));
		}

	}

	public ArrayList<Cell> getCellList() {
		return cellList;
	}

	//public void getCellList(ArrayList<Nutrient> nuteList) {
		//this.cellList = cellList;
	public void getCellList(ArrayList<Cell> cellList) {
		this.cellList = cellList;
	}
}
