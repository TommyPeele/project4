
public class BackgroundScreen {
	Image img = new ImageIcon("car-accident.jpg").getImage();
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}
