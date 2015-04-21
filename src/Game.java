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

import javax.swing.JFrame;

public class Game extends JFrame implements Runnable{

	Screen currentScreen;
	
	private Thread gameThread;
	
	private static final long serialVersionUID = 0;
	
	public Game(){
		currentScreen = new GameScreen(this); //currently set to GameScreen for testing purposes, should start with StartScreen in final version
		
		add(currentScreen);
		pack();
	}
	
	public void createWindow(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Game");
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void start(){
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run(){
		currentScreen.run();
	}
	
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run(){
				Game game = new Game();
				game.createWindow();
				game.start();
			}
		});
	}

}
