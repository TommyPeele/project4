import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class InfoScreen extends Screen{

	private static final long serialVersionUID = 0;
	
	public InfoScreen(Game game){
		super(game);
		initGUI();
	}
	
	public void initGUI(){
		JButton startButton = new JButton("Start Game");
		JButton exitButton = new JButton("Exit");
		
		setLayout(null);
		
		startButton.setBounds(200,270,200,50);
		exitButton.setBounds(200,340,200,50);
		
		startButton.addActionListener(new StartButtonListener());
		exitButton.addActionListener(new ExitButtonListener());
		
		add(startButton);
		add(exitButton);
	}
	
	class StartButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
        	game.getContentPane().removeAll();
        	game.currentScreen = new GameScreen(game);
        	game.getContentPane().add(game.currentScreen);
        	game.getContentPane().revalidate();
        }
    }
	
	class ExitButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
        	System.exit(ABORT);
        }
    }

}