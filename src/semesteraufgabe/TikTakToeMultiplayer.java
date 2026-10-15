package semesteraufgabe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class TikTakToeMultiplayer extends JFrame implements ActionListener{

    private static final int GRID_SIZE = 9;
    private char activeSymbol[] = {'X', 'O'};
    private int scoreX = 0;
    private int scoreO = 0;
    private int countMoves = 0;
    private JTextField playerX;
    private JTextField playerO;
    private TicTacToeButton button[] = new TicTacToeButton[GRID_SIZE];
    
    public TikTakToeMultiplayer() {
	super("Tik Tak Toe");
	
	JPanel leftPanel = new JPanel();
	JPanel rightPanel = new JPanel();
	
	leftPanel.setLayout(new GridLayout(3, 3));
	leftPanel.setPreferredSize(new Dimension(300,300));
	rightPanel.setLayout(new GridLayout(3, 0));
	rightPanel.setPreferredSize(new Dimension(150, 300));
	Font font = new Font("Calibri", Font.BOLD, 20);
	
	playerX = new JTextField("Player X: " + scoreX);
	playerX.setFont(font);
	playerX.setEditable(false);
	rightPanel.add(playerX);
	playerO = new JTextField("Player O: " + scoreO);
	playerO.setFont(font);
	playerO.setEditable(false);
	rightPanel.add(playerO);
	JButton newRound = new JButton("New Round");
	newRound.setFont(font);
	rightPanel.add(newRound);
	
	for (int i = 0; i < GRID_SIZE; ++i) {
	    button[i] = new TicTacToeButton();
	    button[i].addActionListener(this);
	    leftPanel.add(button[i]);
	}
	
	
	
	this.add(leftPanel, BorderLayout.WEST);
	this.add(rightPanel, BorderLayout.EAST);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setVisible(true);
	this.pack();
	this.setLocationRelativeTo(null);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
    }
    
    public static void main(String[] args) {
	new TikTakToeMultiplayer();
    }
}
