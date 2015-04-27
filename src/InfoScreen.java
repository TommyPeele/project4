import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JLabel;


public class InfoScreen extends Screen{

	private static final long serialVersionUID = 0;
	
	public InfoScreen(Game game){
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
		
		webQuote.setBounds(200,100,200,50);
		webButton.setBounds(200,160,200,30);
		multiQuote.setBounds(200,200,200,50);
		multiButton.setBounds(200,260,200,30);
		startButton.setBounds(200,320,200,50);
		
		webButton.addActionListener(new WebButtonListener());
		multiButton.addActionListener(new MultiButtonListener());
		startButton.addActionListener(new StartButtonListener());
		
		add(webQuote);
		add(webButton);
		add(multiQuote);
		add(multiButton);
		add(startButton);
	}
	
	class WebButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
        	//URI myUri = URI("http://www.textinganddrivingsafety.com/texting-and-driving-stats/");
        	//open(myUri);
        }
    }
	
	
	class MultiButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
        	//open("http://www.brainfacts.org/sensing-thinking-behaving/awareness-and-attention/articles/2013/the-multitasking-mind/");
        }
     
    }
    
    class StartButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
        	game.getContentPane().removeAll();
        	game.currentScreen = new StartScreen(game);
        	game.getContentPane().add(game.currentScreen);
        	game.getContentPane().validate();
        }
    }

    private static void open(URI uri) {
    	if (Desktop.isDesktopSupported()) {
      		try {
        		Desktop.getDesktop().browse(uri);
      		    } catch (IOException e) { System.out.println("Link Not Found");}
    	} else { System.out.println("Not Supported Desktop"); }
    }
    
}
