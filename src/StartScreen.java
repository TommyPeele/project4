import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class StartScreen extends Screen{

	private static final long serialVersionUID = 0;
	
	public StartScreen(Game game){
		super(game);
		initGUI();
	}
	
	public void initGUI(){
		JLabel instruction = new JLabel();
		JButton startButton = new JButton("Start Game");
		JButton infoButton = new JButton("Learn More");
		JButton exitButton = new JButton("Exit");
		
		setLayout(null);
		
		instruction.setBounds(100,150,300,50);
		startButton.setBounds(200,200,200,50);
		infoButton.setBounds(200,270,200,50);
		exitButton.setBounds(200,340,200,50);
		
		instruction.setText("Use the left and right arrows to move the car between lanes.\n"
		+ "Use the down arrow to pull down the text screen\n" 
		+ "Use the up arrow to pull up the text screen\n"
		+ "Type the text and press Enter to send the text\n"
		+ "Avoid texting with a police car on the road\n"
		+ "Avoid accidents with other cars")
		
		startButton.addActionListener(new StartButtonListener());
		infoButton.addActionListener(new InfoButtonListener());
		exitButton.addActionListener(new ExitButtonListener());
		
		add(instruction);
		add(startButton);
		add(infoButton);
		add(exitButton);
	}
	
	class StartButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
        	System.out.println("Start");
        	game.getContentPane().removeAll();
        	game.currentScreen = new GameScreen(game);
        	game.getContentPane().add(game.currentScreen);
        	game.getContentPane().revalidate();
        	//requestFocusInWindow();
        	game.start();
        	game.currentScreen.requestFocusInWindow();
        }
    }
	
	class InfoButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
        	game.getContentPane().removeAll();
        	game.currentScreen = new InfoScreen(game);
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
