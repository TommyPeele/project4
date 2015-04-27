import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class GameOverScreen extends Screen{

	private static final long serialVersionUID = 0;
	private static final int gameOverCollision = 0;
	private static final int gameOverDetection = 1;
	private String warning;
	
	public GameOverScreen(Game game, int state, int playerScore){
		super(game);
		
		initGUI(state, playerScore);
	}
	
	public void initGUI(int state, int playerScore){
		if (state == gameOverCollision) {
			warning = "You are caught texting by the police!";
		}
		else {
			warning = "You just had an accident";
		}
		String msg = "<html>" + warning + "<br>Your score is: " + String.valueOf(playerScore) + "</html>";
		JLabel message = new JLabel(msg);
		
		JButton startButton = new JButton("Start Game");
		JButton infoButton = new JButton("Learn More");
		JButton exitButton = new JButton("Exit");
		
		setLayout(null);
		
		message.setBounds(100,50,400,120);
		startButton.setBounds(200,200,200,50);
		infoButton.setBounds(200,270,200,50);
		exitButton.setBounds(200,340,200,50);
		
		startButton.addActionListener(new StartButtonListener());
		infoButton.addActionListener(new InfoButtonListener());
		exitButton.addActionListener(new ExitButtonListener());
		
		add(message);
		add(startButton);
		add(infoButton);
		add(exitButton);
	}
	
	class StartButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
        	game.getContentPane().removeAll();
        	game.currentScreen = new GameScreen(game);
        	game.getContentPane().add(game.currentScreen);
        	game.getContentPane().validate();
        	game.start();
        	game.currentScreen.requestFocusInWindow();
        }
    }
	
	class InfoButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
        	game.getContentPane().removeAll();
        	game.currentScreen = new InfoScreen(game);
        	game.getContentPane().add(game.currentScreen);
        	game.getContentPane().validate();
        }
    }
	
	class ExitButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
        	System.exit(ABORT);
        }
    }

}
