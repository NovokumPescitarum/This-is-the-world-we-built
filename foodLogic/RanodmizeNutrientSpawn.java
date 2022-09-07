package foodLogic;

import java.util.ArrayList;
import java.util.Random;
import nutrientObjects.Mushroom;
import worldLauncher.LaunchWorld;

public class RanodmizeNutrientSpawn {

	 //Randomizer Which Creates Nutrients(Can be other objects)
		public RanodmizeNutrientSpawn(ArrayList<Nutrient> nuteList) {
	    // Amber additions spawn nutrients randomly
		Random rand = new Random();

		int nuteX = rand.nextInt(LaunchWorld.COLUMNS);
		int nuteY = rand.nextInt(LaunchWorld.ROWS);
		
	    if (rand.nextInt(10000) < 1000) {
			nuteList.add(new Mushroom(nuteX, nuteY));}
		}
		
}
