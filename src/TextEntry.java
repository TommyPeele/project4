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
			"Yeah, I already bought everything");
	
	private int noOfMessages = messages.size();
	
	private Random r;
	
	private boolean visible = false;
	private String messageToType = "Message To Type";
	private String userMessage = "";
	private GameScreen gameScreen;
	
	public TextEntry(GameScreen gameScreen){
		this.gameScreen = gameScreen;
	}
	
	public void chooseTextMessage(){
		r = new Random();
		int randomNumber = r.nextInt((noOfMessages - 0));
		System.out.println(randomNumber);
		
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
		/*for(int i = 0; i < messageToType.length(); i++)
		{
			if(i > messageToType.length() || i > userMessage.length())
				break;
			else if(messageToType.charAt(i) != userMessage.charAt(i))
				numberOfErrors++;
		}*/
	
		System.out.println(userMessage + ":");
		System.out.println(messageToType + ":");
		
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
	
	public void keyPressed(KeyEvent event){
		if(!visible){
			if(event.getKeyCode() == KeyEvent.VK_DOWN)
				visible = true;
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
		//Experimenting with Labels, Ignore
		
		/*String title = "<html><body style='width: 200px; padding: 5px;'>"
                + "<h1>Do U C Me?</h1>"
                + "Here is a long string that will wrap.  "
                + "The effect we want is a multi-line label.";

                JFrame f = new JFrame("Label Render Test");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                BufferedImage image = new BufferedImage(
                    400,
                    300,
                    BufferedImage.TYPE_INT_RGB);
                Graphics2D imageGraphics = image.createGraphics();
                GradientPaint gp = new GradientPaint(
                    20f,
                    20f,
                    Color.red,
                    380f,
                    280f,
                    Color.orange);
                imageGraphics.setPaint(gp);
                imageGraphics.fillRect(0, 0, 400, 300);

                JLabel textLabel = new JLabel(title);
                textLabel.setSize(textLabel.getPreferredSize());

                Dimension d = textLabel.getPreferredSize();
                BufferedImage bi = new BufferedImage(
                    d.width,
                    d.height,
                    BufferedImage.TYPE_INT_ARGB);
                Graphics g = bi.createGraphics();
                g.setColor(new Color(255, 255, 255, 128));
                g.fillRoundRect(
                    0,
                    0,
                    bi.getWidth(f),
                    bi.getHeight(f),
                    15,
                    10);
                g.setColor(Color.black);
                textLabel.paint(g);
                Graphics g2 = image.getGraphics();
                g2.drawImage(bi, 20, 20, f);

                ImageIcon ii = new ImageIcon(image);
                JLabel imageLabel = new JLabel(ii);

                f.getContentPane().add(imageLabel);
                f.pack();
                f.setLocationByPlatform(true);

                f.setVisible(true);*/
		
		graphics2D.setColor(Color.GRAY);
		graphics2D.fillRect(10, 0, 500, 250);
		
		graphics2D.setColor(Color.BLACK);
		graphics2D.drawLine(10, 170, 510, 170);
		
		graphics2D.setColor(Color.WHITE);
		graphics2D.fillRect(25, 175, 470, 50);
		
		graphics2D.setColor(Color.BLACK);
		graphics2D.setFont(new Font("TimesRoman", Font.PLAIN, 24));
		graphics2D.drawString(messageToType, 140, 140);
		graphics2D.drawString(userMessage, 30, 220);
	}

}
