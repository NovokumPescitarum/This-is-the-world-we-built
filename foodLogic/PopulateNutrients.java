package foodLogic;

import java.util.ArrayList;
import java.util.Random;

import nutrientObjects.Mushroom;

public class PopulateNutrients {
	
	private ArrayList<Nutrient> nuteList = new ArrayList<>();
	
	public PopulateNutrients(int NUM_NUTES, int COLUMNS, int ROWS) {

		
		Random rand = new Random();

		// create the given number of coins in random positions on the board.
		// note that there is not check here to prevent two coins from occupying the same
		// spot, nor to prevent coins from spawning in the same spot as the player
		for (int i = 0; i < NUM_NUTES; i++) {
			int nuteX = rand.nextInt(COLUMNS);
			int nuteY = rand.nextInt(ROWS);
			getNuteList().add(new Mushroom(nuteX, nuteY));
		}

	}
	
	
	public ArrayList<Nutrient> getNuteList() {
		return nuteList;
	}

	public void setNuteList(ArrayList<Nutrient> nuteList) {
		this.nuteList = nuteList;
	}
	
	}

