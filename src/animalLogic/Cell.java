package animalLogic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


import worldLauncher.LaunchWorld;


public class Cell implements Movements{
	
	@SuppressWarnings("serial")
	ArrayList<String> Genetics = new ArrayList<String>() {{
        add("A");
        add("B");
        add("C");
        add("D");
        add("O");
    }};
    
	private String lastFiredSequence = "A";
	private int width = 5;
	private int height = 5;
	private int killcount = 0;
	// current position of the nutrient on the board grid
	private Point pos;
	private BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);

    
	private int id;
    

	public Cell(int x, int y, int id) {
		
		this.id = id;

		//Set Nutrient Colour
		for ( int rc = 0; rc < getHeight(); rc++ ) {
			for ( int cc = 0; cc < getWidth(); cc++ ) {
				// Set the pixel colour of the image n.b. x = cc, y = rc
				img.setRGB(cc, rc, Color.BLACK.getRGB() );
			}
		}
		// initialize the state
		pos = new Point(x, y);
		
	
	
	}
	
	
	
	public String CellGeneticFiring(ArrayList<String> Genetics) {
		
		this.setGenetics(Genetics);
		
		Random ran = new Random();
		
		
		int randomitem = ran.nextInt(Genetics.size());
		String randomElement = Genetics.get(randomitem);
		this.setLastFiredSequence(randomElement);
		return randomElement;
	}

	public void EvolveGenetic(String reinforce) {
		this.Genetics.add(reinforce);
		System.out.println(id + ": Current Kill Count is: " + this.killcount);
		System.out.println(id + "'sGenetic Sequence: " + Genetics);
		System.out.println();
	}
	
	public void DevolveGenetic(String devolve) {
		if(Collections.frequency(this.Genetics, devolve) > 5) {
			this.Genetics.remove(devolve);
			this.Genetics.remove(devolve);
		}
	}
	
	
	
		public void draw(Graphics g, ImageObserver observer) {
		// with the Point class, note that pos.getX() returns a double, but 
		// pos.x reliably returns an int. https://stackoverflow.com/a/30220114/4655368
		// this is also where we translate board grid position into a canvas pixel
		// position by multiplying by the tile size.
		g.drawImage(
				img, 
				pos.x * LaunchWorld.TILE_SIZE, 
				pos.y * LaunchWorld.TILE_SIZE, 
				observer
				);
	}
	
	public Point getPos() {
		return pos;
	}

	public void moveAround() {
		if (pos.x < 0) {
            pos.x = 0;
        } else if (pos.x >= LaunchWorld.COLUMNS) {
            pos.x = pos.x - 2;
        }
        // prevent the player from moving off the edge of the board vertically
        if (pos.y < 0) {
            pos.y = 0;
        } else if (pos.y >= LaunchWorld.ROWS) {
            pos.y = pos.y - 2;
        }
		this.moveUp();
		this.moveLeft();
		this.moveDown();
		this.moveRight();
		
	}
	@Override
	public void moveUp() {
		pos.translate(0, -1);
		if (pos.x < 0) {
            pos.x = 0;
        } else if (pos.x >= LaunchWorld.COLUMNS) {
            pos.x = pos.x - 2;
        }
        // prevent the player from moving off the edge of the board vertically
        if (pos.y < 0) {
            pos.y = 0;
        } else if (pos.y >= LaunchWorld.ROWS) {
            pos.y = pos.y - 2;
        }
    }
		
	@Override
	public void moveDown() {
		pos.translate(0, 1);
		
		if (pos.x < 0) {
            pos.x = 0;
        } else if (pos.x >= LaunchWorld.COLUMNS) {
            pos.x = pos.x - 2;
        }
        // prevent the player from moving off the edge of the board vertically
        if (pos.y < 0) {
            pos.y = 0;
        } else if (pos.y >= LaunchWorld.ROWS) {
            pos.y = pos.y - 2;
        }
    }

	@Override
	public void moveLeft() {
		pos.translate(-1, 0);
		
		if (pos.x < 0) {
            pos.x = 0;
        } else if (pos.x >= LaunchWorld.COLUMNS) {
            pos.x = pos.x - 2;
        }
        // prevent the player from moving off the edge of the board vertically
        if (pos.y < 0) {
            pos.y = 0;
        } else if (pos.y >= LaunchWorld.ROWS) {
            pos.y = pos.y - 2;
        }
    }

	@Override
	public void moveRight() {
		
		pos.translate(1, 0);
		if (pos.x < 0) {
            pos.x = 0;
        } else if (pos.x >= LaunchWorld.COLUMNS) {
            pos.x = pos.x - 2;
        }
        // prevent the player from moving off the edge of the board vertically
        if (pos.y < 0) {
            pos.y = 0;
        } else if (pos.y >= LaunchWorld.ROWS) {
            pos.y = pos.y - 2;
        }
    }
		
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	//Amber add killcount
	public void addkillcount(int i) {
		this.killcount = killcount + i;
				
	}

	public ArrayList<String> getGenetics() {
		return Genetics;
	}

	public void setGenetics(ArrayList<String> genetics) {
		Genetics = genetics;
	}

	public String getLastFiredSequence() {
		return lastFiredSequence;
	}

	public void setLastFiredSequence(String lastFiredSequence) {
		this.lastFiredSequence = lastFiredSequence;
	}



}