package worldLauncher;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import worldSpawner.SpawnedWorld;

public class LaunchWorld {

	
	// controls the delay between each tick in ms
    public final static int DELAY = 25;
    // controls the size of the board
    public static final int TILE_SIZE = 5;
    public static final int ROWS = 150;
    public static final int COLUMNS = 250;
    // controls how many nutrients appear on the board
    public static final int NUM_NUTES = 1200;
 // controls how many cell appear on the board
    public static final int NUM_CELLS = 200;
	
	private static void initWindow() {
	// create a window frame and set the title in the toolbar
	JFrame window = new JFrame("This is the world we built");
	// when we close the window, stop the app
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	// create the JPanel to draw on.
	// this also initializes the game loop
	SpawnedWorld World = new SpawnedWorld();
	// add the JPanel to the window
	window.add(World);
	// pass keyboard inputs to the jpanel
	// don't allow the user to resize the window
	window.setResizable(false);
	// fit the window size around the components (just our jpanel).
	// pack() should be called after setResizable() to avoid issues on some platforms
	window.pack();
	// open window in the center of the screen
	window.setLocationRelativeTo(null);
	// display the window
	window.setVisible(true);
	
	
}

public static void main(String[] args) {
	// invokeLater() is used here to prevent our graphics processing from
	// blocking the GUI. 
	// this is a lot of boilerplate code that you shouldn't be too concerned about.
	// just know that when main runs it will call initWindow() once.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				initWindow();
			}
		});
	}
}


