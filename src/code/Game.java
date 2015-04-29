package code;
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

import javax.swing.JApplet;
import javax.swing.SwingUtilities;

public class Game extends JApplet implements Runnable{

	private Screen currentScreen;
	private Thread gameThread;

	private static final long serialVersionUID = 0;

	@Override
	public void init(){
		try{
			SwingUtilities.invokeAndWait(new Runnable(){
				public void run(){
					createGUI();
				}
			});
		} catch (Exception e){
			System.err.println("CreateGUI was not sucessfully completed.");
		}
	}

	public Screen getCurrentScreen(){
		return currentScreen;
	}

	public void setCurrentScreen(Screen screen){
		currentScreen = screen;
	}

	public void createGUI(){
		currentScreen = new StartScreen(this);
		getContentPane().add(currentScreen);
	}

	@Override
	public void start(){
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run(){
		currentScreen.run();
	}

}
