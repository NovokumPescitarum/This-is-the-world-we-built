package worldLogic;

import java.util.ArrayList;
import java.util.Collections;

import animalLogic.Cell;

public class DevolveCell {
	
	public void DevolveGenetic(String devolve, ArrayList<String> Genetics, Cell cell) {
		if(Collections.frequency(Genetics, devolve) > 10) {
			Genetics.remove(devolve);
			Genetics.remove(devolve);
			Genetics.remove(devolve);
			//Whichever state is being devolved is reduced to one gene sequence and its exact opposite is enforced once
			switch(devolve) {
			case("A"):
				cell.moveUp();
				break;
			case("B"):
				cell.moveDown();
				break;
			case("C"):
				cell.moveRight();
				break;
			case("D"):
				cell.moveLeft();
				break;
			case("E"):
				cell.moveDownLeft();
				break;
			case("F"):
				cell.moveDownRight();
				break;
			case("G"):
				cell.moveUpLeft();
				break;
			case("H"):
				cell.moveUpRight();
				break;
			}
		}
	}
}
