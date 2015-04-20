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

public class Game{

	StartScreen startScreen;
	GameScreen gameScreen;
	GameOverScreen gameOverScreen;
	
	public static final int WINDOW_WIDTH = 0;
	public static final int WINDOW_HEIGHT = 0;
	
	public Game(){
		startScreen = new StartScreen();
		gameScreen = new GameScreen();
		gameOverScreen = new GameOverScreen();
	}
	
	public static void main(String[] args){
		return;
	}

}
