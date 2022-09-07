package foodLogic;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import worldLauncher.LaunchWorld;


public abstract class Nutrient{

private int width = 2;
private int height = 2;
private int nutritiousValue = 1;
// current position of the nutrient on the board grid
private Point pos;
private BufferedImage image;

public Nutrient(int x, int y, String imagePath) {
    loadImage(imagePath);
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
    // pos.x reliably returns an int. https://stackoverflow.com/a/30220114/4655368
    // this is also where we translate board grid position into a canvas pixel
    // position by multiplying by the tile size.
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

public int getNutritiousValue() {
	return nutritiousValue;
}

public void setNutritiousValue(int nutritiousValue) {
	this.nutritiousValue = nutritiousValue;
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


}
