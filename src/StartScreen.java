import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class StartScreen extends Screen{

	private static final long serialVersionUID = 0;
	
	public StartScreen(Game game){
		super(game);
		initGUI();
	}
	
	public void initGUI(){
		JLabel background = new JLabel(new ImageIcon("car-accident.jpg"));
		JButton startButton = new JButton("Start Game");
		JButton instructionButton = new JButton("Instructions to the Game");
		JButton infoButton = new JButton("Learn More");
		JButton exitButton = new JButton("Exit");
		
		setLayout(null);
		
		background.setBounds(0,0,600,400);
		instructionButton.setBounds(200,200,200,40);
		startButton.setBounds(200,250,200,40);
		infoButton.setBounds(200,300,200,40);
		exitButton.setBounds(200,350,200,40);

		startButton.addActionListener(new StartButtonListener());
		instructionButton.addActionListener(new InstructionButtonListener());
		infoButton.addActionListener(new InfoButtonListener());
		exitButton.addActionListener(new ExitButtonListener());
		
		background.setOpaque(false);
		
		add(background);
		background.add(startButton);
		background.add(instructionButton);
		background.add(infoButton);
		background.add(exitButton);
	}
	
	class StartButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
        	game.getContentPane().removeAll();
        	game.currentScreen = new GameScreen(game);
        	game.getContentPane().add(game.currentScreen);
        	game.getContentPane().validate();
        	//requestFocusInWindow();
        	game.start();
        	game.currentScreen.requestFocusInWindow();
        }
    }
    
    	class InstructionButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
        	game.getContentPane().removeAll();
        	game.currentScreen = new InstructionScreen(game);
        	game.getContentPane().add(game.currentScreen);
        	game.getContentPane().validate();
        	game.currentScreen.requestFocusInWindow();
        }
    }
	
	class InfoButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
        	game.getContentPane().removeAll();
        	game.currentScreen = new InfoScreen(game);
        	game.getContentPane().add(game.currentScreen);
        	game.getContentPane().validate();
        	game.currentScreen.requestFocusInWindow();
        }
    }
	
	class ExitButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
        	System.exit(ABORT);
        }
    }

}
