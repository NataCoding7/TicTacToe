package semesteraufgabe;

import java.awt.BorderLayout;

import javax.swing.*;

@SuppressWarnings("serial")
public class TicTacToe extends JFrame {
    
    public TicTacToe() {
	super("Tik Tak Toe");
	
	this.setSize(300,100);
	JPanel panelNorth = new JPanel();
	panelNorth.add(new JLabel("Select a mode: "));
	this.add(panelNorth, BorderLayout.NORTH);
	JPanel panelCenter = new JPanel();
	JButton single = new JButton("Singleplayer");
	JButton multi = new JButton("Multiplayer");
	single.addActionListener(e -> new TicTacToeFrameSingleplayer());
	multi.addActionListener(e -> new TicTacToeFrameMultiplayer());
	panelCenter.add(single);
	panelCenter.add(multi);
	this.add(panelCenter, BorderLayout.CENTER);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setVisible(true);
	this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
	new TicTacToe();
    }
    
}
