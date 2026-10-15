package semesteraufgabe;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings({ "serial", "unused" })
public class TicTacToeFrameSingleplayer extends JFrame{

    
    public TicTacToeFrameSingleplayer() {
	super("Tik Tak Toe");
	
	this.setSize(200, 100);
	
	JLabel label = new JLabel("Choose your opponent");
	label.setHorizontalAlignment(SwingConstants.CENTER);
	
	JPanel panel = new JPanel();
	JButton noob = new JButton("Noob");
	JButton smart = new JButton("Smart");
	
	noob.addActionListener(e -> {
	    new TicTacToeNoob();
	    this.setVisible(false);
	});
	
	smart.addActionListener(e -> {
	    new TicTacToeSmart();
	    this.setVisible(false);
	});
	
	panel.add(noob);
	panel.add(smart);
	
	this.add(label, BorderLayout.NORTH);
	this.add(panel, BorderLayout.CENTER);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);
	this.setVisible(true);
    }
    
    public static void main(String[] args) {
	new TicTacToeFrameSingleplayer();
    }
    
}
