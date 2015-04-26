//
// Project 4
// Names: Ching-Hao Hu, Tommy Peele, Patrick Stocklin, Xavier Weisenreder
// E-mails: ch931@georgetown.edu, btp11@georgetown.edu, pcs38@georgetown.edu, xmw2@georgetown.edu
// Instructor: Singh
// COSC 150
//
// In accordance with the class policies and Georgetown's Honor Code,
// we certify that, with the exceptions of the lecture notes and those
// items noted below, we have neither given nor received any assistance
// on this project.
//
// Description: A game designed to teach teenagers about the dangers of texting and driving.
//

import java.awt.EventQueue;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Game extends JApplet implements Runnable{

	Screen currentScreen;
	
	private Thread gameThread;
	
	private static final long serialVersionUID = 0;
	
	public void init(){
		try {
			SwingUtilities.invokeAndWait(new Runnable(){
				public void run() {
					createGUI();
				}
			});
		} catch (Exception e){
			System.err.println("createGUI didn't complete successfully");
		}
	}
	
	public void createGUI(){
		currentScreen = new GameScreen(this); //currently set to GameScreen for testing purposes, should start with StartScreen in final version
		
		getContentPane().add(currentScreen);
	}
	
	public void start(){
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run(){
		currentScreen.run();
	}
}
