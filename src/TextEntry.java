import java.awt.Color;
//import java.awt.Dimension;
import java.awt.Font;
//import java.awt.GradientPaint;
//import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
//import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Random;
import java.math.*;

//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//import javax.swing.JLabel;

public class TextEntry{

	private List<String> messages = Arrays.asList("I will be right there", "Hold on, I am on my way",
			"I can not talk right now, I am driving", "Yes, I can go tonight", "No, sorry, I am busy",
			"Yeah, I already bought everything", "Hey d00d, what are you up to rn?", "Nothing, hbu?", "Hi what's up?",
			"Hello", "No, not now", "Just some readings", "Good, thanks", "Really tired actually", "No, not enough time today",
			"Hold on, I'm going to overtake this car");

	private int noOfMessages = messages.size();

	private Random r;

	private boolean visible = false;
	private String messageToType = "Message To Type";
	private String userMessage = "";
	private GameScreen gameScreen;

	private static final String inst = "Please Type The Following Message Exactly:";

	//private int referenceX;
	//private int referenceY = -600;

	public TextEntry(GameScreen gameScreen){
		this.gameScreen = gameScreen;
	}

	public void chooseTextMessage(){
		r = new Random();
		int randomNumber = r.nextInt((noOfMessages - 0));

		messageToType = messages.get(randomNumber);
	}

	public boolean compareUserMessage(){
		int numberOfErrors = 0;
		int i = 0;

		while(i < messageToType.length() && i < userMessage.length())
		{
			if(messageToType.charAt(i) != userMessage.charAt(i))
				numberOfErrors++;

			i++;
		}

		numberOfErrors = numberOfErrors + (messageToType.length() - i);

		if(numberOfErrors > 10)
			return false;
		else
			return true;
	}

	public void resetUserMessage(){
		userMessage = "";
	}

	public void resetMessageToType(){
		chooseTextMessage();
	}

	public boolean isVisible(){
		return visible;
	}

	public void setVisible(boolean visible){
		this.visible = visible;
	}

	public void keyPressed(KeyEvent event){
		if(!visible){
			if(event.getKeyCode() == KeyEvent.VK_DOWN)
			{
				visible = true;
			}
		}
		else{
			switch(event.getKeyCode()){
			case KeyEvent.VK_UP:
				visible = false;
				break;
			case KeyEvent.VK_BACK_SPACE:
				if(userMessage.length() > 0)
					userMessage = userMessage.substring(0, userMessage.length() - 1);
				break;
			case KeyEvent.VK_ENTER:
				if(userMessage.length() > 0){
					if(compareUserMessage())
					{
						System.out.println("Good!");
						resetUserMessage();
						resetMessageToType();
						visible = false;
						gameScreen.timerIncrease();
						gameScreen.newMessageDelay();
						//update Score here
					}
					else
						System.out.println("Bad!");
				}
			default:
				break;
			}
		}
	}

	public void keyTyped(KeyEvent event){
		if(visible){
			char newCharacter = event.getKeyChar();
			if(newCharacter != 8 && newCharacter != 10 && newCharacter != 14) //ASCII code for backspace/*Enter*/Shift - this prevents backspace from incrementing userMessage length
				userMessage = userMessage + newCharacter;
		}
	}

	public void paint(Graphics2D graphics2D){
		graphics2D.setColor(Color.GRAY);
		graphics2D.fillRect(10, 0, 500, 250);

		graphics2D.setColor(Color.BLACK);
		graphics2D.drawLine(10, 170, 510, 170);

		graphics2D.setColor(Color.WHITE);
		graphics2D.fillRect(25, 175, 470, 50);

		graphics2D.setColor(Color.BLACK);
		graphics2D.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		graphics2D.drawString(inst, 30, 40);
		graphics2D.drawString(messageToType, 30, 140);
		graphics2D.drawString(userMessage, 30, 220);
	}

}
