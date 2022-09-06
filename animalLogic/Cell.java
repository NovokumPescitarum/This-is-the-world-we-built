package animalLogic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import geneSequenceLogic.BaseCellGenetics;
import worldLauncher.LaunchWorld;


public abstract class Cell implements Movements{
	

	private String lastFiredSequence = "A";
	private int width = 5;
	private int height = 5;
	private int nutritientsInSystem = 0;
	// current position of the nutrient on the board grid
	private Point pos;
	private BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
	private BufferedImage image;
	private ArrayList<String> baseCellGenetics = new BaseCellGenetics().getGenetics();
        

	public Cell(int x, int y, int id, String imagePath) {
		loadImage(imagePath);
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
	
    private void loadImage(String imagePath) {
        try {
            // you can use just the filename if the image file is in your
            // project folder, otherwise you need to provide the file path.
            image = ImageIO.read(new File(imagePath));
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }
	
	public void draw(Graphics g, ImageObserver observer) {
		// with the Point class, note that pos.getX() returns a double, but 
		// pos.x reliably returns an int. 
		// this is also where we translate board grid position into a canvas pixel
		// position by multiplying by the tile size.
		g.drawImage(image,14,14,observer);
		g.drawImage(
				image, 
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

	public void addNutrient(int i) {
		this.nutritientsInSystem = nutritientsInSystem + i;
				
	}

	public String getLastFiredSequence() {
		return lastFiredSequence;
	}

	public void setLastFiredSequence(String lastFiredSequence) {
		this.lastFiredSequence = lastFiredSequence;
	}



	public ArrayList<String> getBaseCellGenetics() {
		return baseCellGenetics;
	}



	public void setBaseCellGenetics(ArrayList<String> baseCellGenetics) {
		this.baseCellGenetics = baseCellGenetics;
	}



}