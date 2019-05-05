package giaodien;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Work extends JPanel{
	
public void paint(Graphics g){
        
//        g.fillRect(100, 100, 400, 400);
//        for(int i = 100; i <= 400; i+=100){
//            for(int j = 100; j <= 400; j+=100){
//                g.clearRect(i, j, 50, 50);
//            }
//        }
//        
//        for(int i = 150; i <= 450; i+=100){
//            for(int j = 150; j <= 450; j+=100){
//                g.clearRect(i, j, 50, 50);
//            }
//        }
	// TODO : test
		  g.setColor(Color.BLACK);
		  g.drawRect(25, 25, 600, 400);
		  for (int i = 25 ; i <= 600 ; i+= 50) {
			  for (int j = 25 ; j <= 400 ; j+= 50) {
				  g.drawRect(i, j, 25, 25);
			  }
		  }
		  for (int i = 50 ; i <= 600 ; i+= 50) {
			  for (int j = 50 ; j <= 400 ; j+= 50) {
				  g.drawRect(i, j, 25, 25);
			  }
		  }
		  
		  for (int i = 37 ; i <= 600+12 ; i+=25) {
			  for (int j = 37 ; j <= 400+12 ; j+=25) {
				  g.drawString("-1", i, j);
			  }
		  }
		  
    }

    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setSize(700,500);
        frame.getContentPane().add(new Work());
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
