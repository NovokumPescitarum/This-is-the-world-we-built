package animalLogic;

import java.util.ArrayList;

public class SparkOfLife {

	ArrayList<String> movements;
	
	public SparkOfLife(Cell cell, String move){
		
		switch(move) {
		case("A"):
			cell.moveDown();
			break;
		case("B"):
			cell.moveUp();
			break;
		case("C"):
			cell.moveLeft();
			break;
		case("D"):
			cell.moveRight();
			break;
		case("O"):
			cell.moveAround();
			break;

	}
		
	}
	
	

	}


		