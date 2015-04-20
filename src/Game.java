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

import javax.swing.JFrame;

public class Game extends JFrame implements Runnable{

	StartScreen startScreen;
	GameScreen gameScreen;
	GameOverScreen gameOverScreen;
	
	private static final long serialVersionUID = 0;
	
	public Game(){
		startScreen = new StartScreen(this);
		gameScreen = new GameScreen(this);
		gameOverScreen = new GameOverScreen(this);
		
		add(gameScreen);
		pack();
	}
	
	public void createWindow(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Game");
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	@Override
	public void run(){
		return;
	}
	
	public static void main(String[] args){
		Game game = new Game();
		game.createWindow();
	}

}
