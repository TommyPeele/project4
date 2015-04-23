import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class GameOverScreen extends Screen{

	private static final long serialVersionUID = 0;
	private static JLabel scoreBar;
    private static JLabel endMessage;
	private static JButton learnButton;
    private static JButton playAgain;
    private static JButton exitButton;
	private static String scoreInfo;
	
	public GameOverScreen(Game game){
		super(game);
		initGUI();
	}
    
	public void initGUI(){
		//getScore needs to be implemented
		//scoreInfo = "Final Score: " + String.valueOf(game.getScore());
		setBounds();
		setLabels();
		setListeners();
		setAdd();
	}

	public void setBounds()
	{
        endMessage.setBounds(200, 20, 200, 80);
		scoreBar.setBounds(200, 120, 200, 20);
        learnButton.setBounds(200, 150, 200, 50);
        playAgain.setBounds(200, 220, 200, 50);
        exitButton.setBounds(200, 290, 200, 50);
	}
    
    public void setLabels()
   	{
    		//SetLabels not working
       	//endMessage.setLabel("You Life Isn't A Game, Don't Text And Drive");
       	//scoreBar.setLabel(scoreInfo);
       	//learnButton.setLabel("Learn More");
       	//playAgain.setLabel("Play Again");
       	//exitButton.setLabel("Exit");
   	}
    
   	public void setListeners()
   	{ 
   		learnButton.addActionListener(new learnButtonListener());
       	playAgain.addActionListener(new playButtonListener());
       	exitButton.addActionListener(new exitButtonListener());
    }
    
    public void setAdd()
   	{
       	add(endMessage);
       	add(scoreBar);
       	add(learnButton);
       	add(playAgain);
       	add(exitButton);
   	}

   	class learnButtonListener implements ActionListener
    {
       	public void actionPerformed(ActionEvent e)
       	{
           		System.out.println("Over 80% of children die by texting and driving");
       	}
    }
    
    class playButtonListener implements ActionListener
   	{
       	public void actionPerformed(ActionEvent e)
       	{
         		System.out.println();
       	}
    }
    
    class exitButtonListener implements ActionListener
    	{
        public void actionPerformed(ActionEvent e)
       	{
           		System.exit(0);
       	}
	}
    
}
