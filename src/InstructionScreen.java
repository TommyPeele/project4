
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JLabel;


public class InstructionScreen extends Screen{

	private static final long serialVersionUID = 0;
	
	public InstructionScreen(Game game){
		super(game);
		initGUI();
	}
	
	public void initGUI(){
		JButton webButton = new JButton("Learn More Statistics Here");
		JButton multiButton = new JButton("Learn More About The Dangers of Multitasking Here");
		
		JLabel webQuote = new JLabel("13% of Drivers aged 18-20 involved in car wrecks admitted to talking or texting on the time of their crash.");
		JLabel multiQuote = new JLabel("Multitasking doesn’t just slow you down and increase the number of mistakes you make; it temporarily changes the way your brain works.");
		
		JButton startButton = new JButton("Return to Main Screen");
		
		setLayout(null);
		
		startButton.setBounds(200,320,200,50);

		add(startButton);
	}
	
    
}
