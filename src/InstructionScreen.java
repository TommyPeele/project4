
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

//import StartScreen.StartButtonListener;


public class InstructionScreen extends Screen{

	private static final long serialVersionUID = 0;
	
	public InstructionScreen(Game game){
		super(game);
		
		initGUI();
		
	}
	
	public void initGUI(){
		
		setBackground(Color.CYAN);
		JLabel instruction = new JLabel();
		JButton startButton = new JButton("Return to Main Screen");
		
		instruction.setText("<html>Use the left and right arrows to move the car between lanes.<br>"
		+ "A red circle in the upper left corner will flash when you have a new text message!<br>"
		+ "Use the down arrow to pull down the text screen<br>" 
		+ "Use the up arrow to pull up the text screen<br>"
		+ "Type the text and press Enter to send the text<br>"
		+ "Avoid texting with a police car on the road<br>"
		+ "Avoid accidents with other cars</html>");
		
		instruction.setHorizontalAlignment(SwingConstants.CENTER);
		setLayout(null);
		
		startButton.addActionListener(new StartButtonListener());
		
		instruction.setBounds(50,100,500,150);
		startButton.setBounds(200,320,200,50);

		add(instruction);
		add(startButton);
		
	}
	
	
	class StartButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
        	game.getContentPane().removeAll();
        	game.currentScreen = new StartScreen(game);
        	game.getContentPane().add(game.currentScreen);
        	game.getContentPane().validate();
        }
    }
}
