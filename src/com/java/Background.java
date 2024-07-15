import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Background extends JPanel {
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Vẽ một màu đen với độ mờ là 50%
        g.setColor(new Color(0, 0, 0, 128));
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
