package worldSpawner;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;
import animalLogic.Cell;
import animalLogic.PopulateCells;
import animalLogic.SparkOfLife;
import foodLogic.Nutrient;
import foodLogic.PopulateNutrients;
import worldLauncher.LaunchWorld;


public class SpawnedWorld extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
    private Timer timer;
    //Set up a JPanel to put all this trash into
    private JPanel worldPanel = new JPanel();
  
    //Nutrient and cell List
	private ArrayList<Nutrient> nuteList = new PopulateNutrients(LaunchWorld.NUM_NUTES,LaunchWorld.COLUMNS,LaunchWorld.ROWS).getNuteList();
	private ArrayList<Cell> cellList = new PopulateCells(LaunchWorld.NUM_CELLS,LaunchWorld.COLUMNS,LaunchWorld.ROWS).getCellList();
    
    public SpawnedWorld() {
        // set the game board size
    	this.setPreferredSize(new Dimension(LaunchWorld.TILE_SIZE * LaunchWorld.COLUMNS, LaunchWorld.TILE_SIZE * LaunchWorld.ROWS));
        // set the game board background color
    	this.setBackground(new Color(232, 232, 232));
    	
        // this timer will call the actionPerformed() method every DELAY ms
        timer = new Timer(LaunchWorld.DELAY, this);
        timer.start();

       
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	randomizeNuteSpawn();
	    NutrientCollision();
        repaint();
    }

    private void drawBackground(Graphics g) {
        // draw a checkered background
        g.setColor(new Color(214, 214, 214));
        for (int row = 0; row < LaunchWorld.ROWS; row++) {
            for (int col = 0; col < LaunchWorld.COLUMNS; col++) {
                // only color every other tile
                if ((row + col) % 2 == 1) {
                    // draw a square tile at the current row/column position
                    g.fillRect(
                        col * LaunchWorld.TILE_SIZE, 
                        row * LaunchWorld.TILE_SIZE, 
                        LaunchWorld.TILE_SIZE, 
                        LaunchWorld.TILE_SIZE
                    );
                }
            }    
        }
    }
    
    
    //Randomizer Which Creates Nutrients(Can be other objects)
	private void randomizeNuteSpawn() {
    // Amber additions spawn nutrients randomly
	Random rand = new Random();

	int nuteX = rand.nextInt(LaunchWorld.COLUMNS);
	int nuteY = rand.nextInt(LaunchWorld.ROWS);
	
    if (rand.nextInt(10000) < 1000) {
		nuteList.add(new Nutrient(nuteX, nuteY));}
	}
	
	
	//So the cell can pick up nutrients
    private void NutrientCollision() {
    	 ArrayList<Nutrient> collectedNutrients = new ArrayList<>();

    	 for (Nutrient nute : nuteList)
    		 for (Cell cell: getCellList()){
         // if the cell is on the same tile as a nute, collect it
    			 if (cell.getPos().equals(nute.getPos())) {  				 
        // remove collected nutrients from the board 
    				 collectedNutrients.add(nute);
    				 cell.addkillcount(1);
    				 cell.setHeight(cell.getHeight() +1);
    				 cell.setWidth(cell.getWidth() +1);
    				 cell.EvolveGenetic(cell.getLastFiredSequence());}
    			 else {
    				 cell.DevolveGenetic(cell.getLastFiredSequence());
    			 }
    		 }nuteList.removeAll(collectedNutrients);
    			 
    		 
    }
  
    @Override
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);

        // draw our graphics.
        drawBackground(g);
        
        // draw our nutrients
        for (Nutrient nute : nuteList) {
            nute.draw(g, this);
        }
        
        for (Cell cell: getCellList()) {
            cell.draw(g, this);
        }
        
        for (Cell cell: getCellList()) {
           String firedSequence = cell.CellGeneticFiring(cell.getGenetics());
        	new SparkOfLife(cell,firedSequence);
        }
        
        

        // this smooths out animations on some systems
        Toolkit.getDefaultToolkit().sync();
    }


	public JPanel getWorldPanel() {
		return worldPanel;
	}

	public void setWorldPanel(JPanel worldPanel) {
		this.worldPanel = worldPanel;
	}


	public ArrayList<Cell> getCellList() {
		return cellList;
	}

	public void setCellList(ArrayList<Cell> cellList) {
		this.cellList = cellList;
	}
}