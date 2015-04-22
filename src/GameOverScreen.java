public class GameOverScreen extends StartScreen
{
	private static final long serialVersionUID = 0;
	private static JLabel scoreBar;
	private static String scoreInfo;
	
	public GameOverScreen(Game game)
	{
		super(game);
		gameOverValues();
	
	}

	public void gameOverValues()
	{
		scoreBar.setBounds(40, 100, 520, 20);
		introText.setLabel("You Life Isn't A Game, Don't Text And Drive");
		scoreInfo = "Final Score: " + String.valueOf(game.getScore());
		scoreBar.setLabel(scoreInfo);	
	}
	
}
