package semesteraufgabe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class TicTacToeFrameMultiplayer extends JFrame implements ActionListener{
    
    private static final int GRID_SIZE = 9;
    private char activeSymbol[] = {'X', 'O'};
    private int scoreX = 0;
    private int scoreO = 0;
    private int countMoves = 0;
    private JTextField playerX;
    private JTextField playerO;
    private TicTacToeButton button[] = new TicTacToeButton[GRID_SIZE];
    
    public TicTacToeFrameMultiplayer() {
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
	playerO = new JTextField("Player O: " + scoreO);
	playerO.setFont(font);
	playerO.setEditable(false);
	JButton newRound = new JButton("New Round");
	newRound.addActionListener(e -> {
	    scoreX = 0;
	    scoreO = 0;
	    resetGrid();
	});
	newRound.setFont(font);
	
	rightPanel.add(playerX);
	rightPanel.add(playerO);
	rightPanel.add(newRound);
	
	
	
	for (int i = 0; i < GRID_SIZE; ++i) {
	    button[i] = new TicTacToeButton();
	    button[i].addActionListener(this);
	    button[i].setFont(font);
	    leftPanel.add(button[i]);
	}

	
	this.add(leftPanel, BorderLayout.WEST);
	this.add(rightPanel, BorderLayout.EAST);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setVisible(true);
	this.pack();
	this.setLocationRelativeTo(null);
	JOptionPane.showMessageDialog(null, "Player X starts", "Information", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void checkWin() {
	if (checkLine() || checkColumn() || checkDiagonal()) {
	    resetGrid();
	    return;
	}
	if (checkGridFull()) {
		JOptionPane.showMessageDialog(this, "No one won");
		resetGrid();
	    }
    }
    
    private boolean checkGridFull() {
	for (int i = 0; i < GRID_SIZE; ++i) {
	    if (button[i].getText().isBlank()) return false;
	}
	return true;
    }
    
    private boolean checkLine() {
	if (button[0].getText().equals(button[1].getText()) && button[1].getText().equals(button[2].getText())) {
	    if (button[0].getText().equals("X")) {
		JOptionPane.showMessageDialog(this, "Player X won");
		++scoreX;
		playerX.setText("Player X: " + scoreX);
		return true;
	    } else if (button[0].getText().equals("O")){
		JOptionPane.showMessageDialog(this, "Player O won");
		++scoreO;
		playerO.setText("Player O: " + scoreO);
		return true;
	    }
	} else if (button[3].getText().equals(button[4].getText()) && button[4].getText().equals(button[5].getText())) {
	    if (button[3].getText().equals("X")) {
		JOptionPane.showMessageDialog(this, "Player X won");
		++scoreX;
		playerX.setText("Player X: " + scoreX);
		return true;
	    } else if (button[3].getText().equals("O")){
		JOptionPane.showMessageDialog(this, "Player O won");
		++scoreO;
		playerO.setText("Player O: " + scoreO);
		return true;
	    }
	} else if (button[6].getText().equals(button[7].getText()) && button[7].getText().equals(button[8].getText())) {
	    if (button[6].getText().equals("X")) {
		JOptionPane.showMessageDialog(this, "Player X won");
		++scoreX;
		playerX.setText("Player X: " + scoreX);
		return true;
	    } else if (button[6].getText().equals("O")){
		JOptionPane.showMessageDialog(this, "Player O won");
		++scoreO;
		playerO.setText("Player O: " + scoreO);
		return true;
	    }
	}
	return false;
    }
    
    private boolean checkColumn() {
	if (button[0].getText().equals(button[3].getText()) && button[3].getText().equals(button[6].getText())) {
	    if (button[0].getText().equals("X")) {
		JOptionPane.showMessageDialog(this, "Player X won");
		++scoreX;
		playerX.setText("Player X: " + scoreX);
		return true;
	    } else if (button[0].getText().equals("O")){
		JOptionPane.showMessageDialog(this, "Player O won");
		++scoreO;
		playerO.setText("Player O: " + scoreO);
		return true;
	    }
	} else if (button[1].getText().equals(button[4].getText()) && button[4].getText().equals(button[7].getText())) {
	    if (button[1].getText().equals("X")) {
		JOptionPane.showMessageDialog(this, "Player X won");
		++scoreX;
		playerX.setText("Player X: " + scoreX);
		return true;
	    } else if (button[1].getText().equals("O")){
		JOptionPane.showMessageDialog(this, "Player O won");
		++scoreO;
		playerO.setText("Player O: " + scoreO);
		return true;
	    }
	} else if (button[2].getText().equals(button[5].getText()) && button[5].getText().equals(button[8].getText())) {
	    if (button[2].getText().equals("X")) {
		JOptionPane.showMessageDialog(this, "Player X won");
		++scoreX;
		playerX.setText("Player X: " + scoreX);
		return true;
	    } else if (button[2].getText().equals("O")){
		JOptionPane.showMessageDialog(this, "Player O won");
		++scoreO;
		playerO.setText("Player O: " + scoreO);
		return true;
	    }
	}
	return false;
    }
    
    private boolean checkDiagonal() {
	if (button[0].getText().equals(button[4].getText()) && button[4].getText().equals(button[8].getText())) {
	    if (button[0].getText().equals("X")) {
		JOptionPane.showMessageDialog(this, "Player X won");
		++scoreX;
		playerX.setText("Player X: " + scoreX);
		return true;
	    } else if (button[0].getText().equals("O")){
		JOptionPane.showMessageDialog(this, "Player O won");
		++scoreO;
		playerO.setText("Player O: " + scoreO);
		return true;
	    }
	} else if (button[2].getText().equals(button[4].getText()) && button[4].getText().equals(button[6].getText())) {
	    if (button[2].getText().equals("X")) {
		JOptionPane.showMessageDialog(this, "Player X won");
		++scoreX;
		playerX.setText("Player X: " + scoreX);
		return true;
	    } else if (button[2].getText().equals("O")){
		JOptionPane.showMessageDialog(this, "Player O won");
		++scoreO;
		playerO.setText("Player O: " + scoreO);
		return true;
	    }
	}
	return false;
    }
    
    private void resetGrid() {
	for (int i = 0; i < GRID_SIZE; ++i) {
		button[i].setIsClicked(false);
		button[i].setText("");
	}
	countMoves = 0;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
	int index = countMoves % 2;
	for (int i = 0; i < GRID_SIZE; ++i) {
	    if (e.getSource().equals(button[i]) && !button[i].getIsClicked()) {
		if (index == 0)
		    button[i].setForeground(Color.blue);
		else 
		    button[i].setForeground(Color.red);
		button[i].setText(String.valueOf(activeSymbol[index]));
		countMoves++;   
		button[i].setIsClicked(true);
		checkWin();
		break;
	    }
	}
    }
    
    public static void main(String[] args) {
	new TicTacToeFrameMultiplayer();
    }
}
