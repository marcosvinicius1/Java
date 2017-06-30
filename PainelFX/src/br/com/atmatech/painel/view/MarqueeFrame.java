
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;  
import javax.swing.Timer;  
public class MarqueeFrame extends JFrame implements ActionListener {  
    private Timer timer;  
    private MarqueePanel marqueePanel;  
    public void actionPerformed(ActionEvent e) {  
        marqueePanel.moveLabel();  
    }  
    public MarqueeFrame() {  
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setSize(d.width,200);          
        setTitle("Teste Letreiro Digital2");  
        setResizable(false);  
        setUndecorated(false);
        timer = new Timer(10, this); // Velocidade do Timer  
        marqueePanel = new MarqueePanel(timer);  
        add(marqueePanel);  
        timer.start(); // começa a mover o letreiro  
        // timer.stop(); // para de mover o letreiro  
    }  
    public static void main(String[] args) {  
        
        new MarqueeFrame().setVisible(true);  
    }  
}  
class MarqueePanel extends JPanel {  
    private int xLoc, yLoc;  
    private Dimension dimension;  
    private JLabel jLabel1;  
    private Timer timer;  
    public MarqueePanel(final Timer timer) {  
        this.timer = timer;  
        setLayout(null);  
        dimension = Toolkit.getDefaultToolkit().getScreenSize();  
        xLoc = dimension.width;  
        yLoc = 0;  
        jLabel1 = new JLabel("DIGITE O TEXTO AQUI2!!!");  
        jLabel1.setForeground(Color.BLUE);  
        add(jLabel1,BorderLayout.NORTH);  
        moveLabel();  
    }  
    public void moveLabel() {  
        Rectangle r = new Rectangle();  
        r.x = xLoc;  
        r.y = yLoc;  
        Dimension size = jLabel1.getPreferredSize();  
        r.width = size.width;  
        r.height = 100;  
        jLabel1.setBounds(r);  
        xLoc -= 1;  
        if (xLoc < -jLabel1.getWidth() )  
            xLoc = dimension.width;  
    }  
}