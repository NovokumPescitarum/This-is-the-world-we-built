package foodLogic;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import worldLauncher.LaunchWorld;


public class Nutrient{

private int width = 2;
private int height = 2;
private int nutritiousValue = 1;
// current position of the nutrient on the board grid
private Point pos;
private BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);


public Nutrient(int x, int y) {
    //Set Nutrient Colour
	for ( int rc = 0; rc < height; rc++ ) {
		  for ( int cc = 0; cc < width; cc++ ) {
		    // Set the pixel colour of the image n.b. x = cc, y = rc
		    img.setRGB(cc, rc, Color.GREEN.getRGB() );
		  }
		}
    // initialize the state
    pos = new Point(x, y);
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

public int getNutritiousValue() {
	return nutritiousValue;
}

public void setNutritiousValue(int nutritiousValue) {
	this.nutritiousValue = nutritiousValue;
}


}
