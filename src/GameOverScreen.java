public class GameOverScreen extends Screen
{

	private static final long serialVersionUID = 0;
	private static JLabel scoreBar;
    	private static JLabel endMessage;
	private static JButton learnButton;
    	private static JButton playAgain;
    	private static JButton exitButton;
	private static String scoreInfo;
	
	public GameOverScreen(Game game)
	{
		super(game);
        	initGUI();
	}
    
	public intitGUI()
    	{
		scoreInfo = "Final Score: " + String.valueOf(game.getScore());
		setBounds();
        	setLabels();
        	setListeners();
        	setAdd();
    	}

	public void setBounds()
	{
        	endMessage.setBounds(40, 20, 520, 80);
		scoreBar.setBounds(40, 120, 520, 20);
        	learnButton.setBounds(40, 150, 520, 50);
        	playAgain.setBounds(40, 220, 520, 50);
        	exitButton.setBounds(40, 290, 520, 50);
	}
    
    	public void setLabels()
    	{
        	endMessage.setLabel("You Life Isn't A Game, Don't Text And Drive");
        	scoreBar.setLabel(scoreInfo);
        	learnButton.setLabel("Learn More");
        	playAgain.setLabel("Play Again");
        	exitButton.setLabel("Exit");
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
    
    	class learnButtonListener implements ActionListener
    	{
        	public void actionPerformed(ActionEvent e)
        	{
            		System.exit(0);
        	}
	}
    
}
