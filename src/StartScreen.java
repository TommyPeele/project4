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
		JLabel background = new JLabel(new ImageIcon("/res/car-accident.jpg"));
		JLabel instruction = new JLabel();
		JButton startButton = new JButton("Start Game");
		JButton infoButton = new JButton("Learn More");
		JButton exitButton = new JButton("Exit");
		
		setLayout(null);
		
		background.setBounds(0,0,600,400);
		instruction.setBounds(50,50,500,150);
		startButton.setBounds(200,200,200,50);
		infoButton.setBounds(200,270,200,50);
		exitButton.setBounds(200,340,200,50);

		instruction.setText("<html>Use the left and right arrows to move the car between lanes.<br>"
		+ "A red circle in the upper left corner will flash when you have a new text message!<br>"
		+ "Use the down arrow to pull down the text screen<br>" 
		+ "Use the up arrow to pull up the text screen<br>"
		+ "Type the text and press Enter to send the text<br>"
		+ "Avoid texting with a police car on the road<br>"
		+ "Avoid accidents with other cars</html>");
		
		instruction.setHorizontalAlignment(SwingConstants.CENTER);

		startButton.addActionListener(new StartButtonListener());
		infoButton.addActionListener(new InfoButtonListener());
		exitButton.addActionListener(new ExitButtonListener());
		
		background.setOpaque(false);
		
		add(background);
		add(instruction);
		add(startButton);
		add(infoButton);
		add(exitButton);
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
	
	class InfoButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
        	game.getContentPane().removeAll();
        	game.currentScreen = new InfoScreen(game);
        	game.getContentPane().add(game.currentScreen);
        	game.getContentPane().validate();
        }
    }
	
	class ExitButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
        	System.exit(ABORT);
        }
    }

}
