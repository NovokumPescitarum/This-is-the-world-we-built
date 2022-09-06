package worldSpawner;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;
import animalLogic.Cell;
import animalLogic.CellGeneticTranslator;
import animalLogic.PopulateCells;
import foodLogic.CollisionLogic;
import foodLogic.Nutrient;
import foodLogic.PopulateNutrients;
import foodLogic.RanodmizeNutrientSpawn;
import geneSequenceLogic.GeneNeuronFiring;
import worldLauncher.LaunchWorld;


public class SpawnedWorld extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
    private Timer timer;
    //Set up a JPanel to put all this trash into
    private JPanel worldPanel = new JPanel();
  
    //Nutrient and cell List
	private static ArrayList<Nutrient> nuteList = new PopulateNutrients(LaunchWorld.NUM_NUTES,LaunchWorld.COLUMNS,LaunchWorld.ROWS).getNuteList();
	private static ArrayList<Cell> cellList = new PopulateCells(LaunchWorld.NUM_CELLS,LaunchWorld.COLUMNS,LaunchWorld.ROWS).getCellList();
    
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
    	
    	new RanodmizeNutrientSpawn(nuteList);
	    new CollisionLogic(cellList,nuteList);
        repaint();
    }

 
    @Override
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
        
        // draw our nutrients
        for (Nutrient nute : getNuteList()) {
            nute.draw(g, this);
        }
        
        for (Cell cell: getCellList()) {
            cell.draw(g, this);
        }
        
        for (Cell cell: getCellList()) {
           String lastFiredSequence = new GeneNeuronFiring().CellGeneticFiring(cell.getBaseCellGenetics(), cell);
           new CellGeneticTranslator(cell,lastFiredSequence);
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
	public static ArrayList<Nutrient> getNuteList() {
		return nuteList;
	}
	public static ArrayList<Cell> getCellList() {
		return cellList;
	}
}