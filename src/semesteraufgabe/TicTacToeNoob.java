package semesteraufgabe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TicTacToeNoob extends JFrame implements ActionListener, PropertyChangeListener {


    private static final int GRID_SIZE = 9;
    private int scoreX = 0;
    private int scoreO = 0;
    private int countMoves = 0;
    private JTextField playerX;
    private JTextField playerO;
    private TicTacToeButton button[] = new TicTacToeButton[GRID_SIZE];
    private PropertyChangeSupport changes = new PropertyChangeSupport(this);
    
    public TicTacToeNoob() {
	super("Tik Tak Toe");
	
	changes.addPropertyChangeListener(this);
	
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
	    int scoreXOld = scoreX;
	    scoreX = 0;
	    changes.firePropertyChange("scoreX", scoreXOld, scoreX);
	    int scoreOOld = scoreO;
	    scoreO = 0;
	    changes.firePropertyChange("scoreO", scoreOOld, scoreO);
	    resetGrid();
	});
	newRound.setFont(font);
	
	rightPanel.add(playerX);
	rightPanel.add(playerO);
	rightPanel.add(newRound);
	
	
	
	for (int i = 0; i < GRID_SIZE; ++i) {
	    button[i] = new TicTacToeButton();
	    button[i].addActionListener(this);
	    leftPanel.add(button[i]);
	    button[i].setFont(font);
	}

	
	this.add(leftPanel, BorderLayout.WEST);
	this.add(rightPanel, BorderLayout.EAST);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setVisible(true);
	this.pack();
	this.setLocationRelativeTo(null);
    }
    
    private void checkWin() {
	checkLine();
	checkColumn();
	checkDiagonal();
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
    
    private void checkLine() {
	if (button[0].getText().equals(button[1].getText()) && button[1].getText().equals(button[2].getText())) {
	    if (button[0].getText().equals("X")) {
		JOptionPane.showMessageDialog(this, "Player X won");
		int scoreXOld = this.scoreX;
		++scoreX;
		changes.firePropertyChange("scoreX", scoreXOld, scoreX);
		resetGrid();
	    } else if (button[0].getText().equals("O")){
		JOptionPane.showMessageDialog(this, "Player O won");
		int scoreOOld = this.scoreO;
		++scoreO;
		changes.firePropertyChange("scoreO", scoreOOld, scoreO);
		resetGrid();
	    }
	} else if (button[3].getText().equals(button[4].getText()) && button[4].getText().equals(button[5].getText())) {
	    if (button[3].getText().equals("X")) {
		JOptionPane.showMessageDialog(this, "Player X won");
		int scoreXOld = this.scoreX;
		++scoreX;
		changes.firePropertyChange("scoreX", scoreXOld, scoreX);
		resetGrid();
	    } else if (button[3].getText().equals("O")){
		JOptionPane.showMessageDialog(this, "Player O won");
		int scoreOOld = this.scoreO;
		++scoreO;
		changes.firePropertyChange("scoreO", scoreOOld, scoreO);
		resetGrid();
	    }
	} else if (button[6].getText().equals(button[7].getText()) && button[7].getText().equals(button[8].getText())) {
	    if (button[6].getText().equals("X")) {
		JOptionPane.showMessageDialog(this, "Player X won");
		int scoreXOld = this.scoreX;
		++scoreX;
		changes.firePropertyChange("scoreX", scoreXOld, scoreX);
		resetGrid();
	    } else if (button[6].getText().equals("O")){
		JOptionPane.showMessageDialog(this, "Player O won");
		int scoreOOld = this.scoreO;
		++scoreO;
		changes.firePropertyChange("scoreO", scoreOOld, scoreO);
		resetGrid();
	    }
	}
    }
    
    private void checkColumn() {
	if (button[0].getText().equals(button[3].getText()) && button[3].getText().equals(button[6].getText())) {
	    if (button[0].getText().equals("X")) {
		JOptionPane.showMessageDialog(this, "Player X won");
		int scoreXOld = this.scoreX;
		++scoreX;
		changes.firePropertyChange("scoreX", scoreXOld, scoreX);
		resetGrid();
	    } else if (button[0].getText().equals("O")){
		JOptionPane.showMessageDialog(this, "Player O won");
		int scoreOOld = this.scoreO;
		++scoreO;
		changes.firePropertyChange("scoreO", scoreOOld, scoreO);
		resetGrid();
	    }
	} else if (button[1].getText().equals(button[4].getText()) && button[4].getText().equals(button[7].getText())) {
	    if (button[1].getText().equals("X")) {
		JOptionPane.showMessageDialog(this, "Player X won");
		int scoreXOld = this.scoreX;
		++scoreX;
		changes.firePropertyChange("scoreX", scoreXOld, scoreX);
		resetGrid();
	    } else if (button[1].getText().equals("O")){
		JOptionPane.showMessageDialog(this, "Player O won");
		int scoreOOld = this.scoreO;
		++scoreO;
		changes.firePropertyChange("scoreO", scoreOOld, scoreO);
		resetGrid();
	    }
	} else if (button[2].getText().equals(button[5].getText()) && button[5].getText().equals(button[8].getText())) {
	    if (button[2].getText().equals("X")) {
		JOptionPane.showMessageDialog(this, "Player X won");
		int scoreXOld = this.scoreX;
		++scoreX;
		changes.firePropertyChange("scoreX", scoreXOld, scoreX);
		resetGrid();
	    } else if (button[2].getText().equals("O")){
		JOptionPane.showMessageDialog(this, "Player O won");
		int scoreOOld = this.scoreO;
		++scoreO;
		changes.firePropertyChange("scoreO", scoreOOld, scoreO);
		resetGrid();
	    }
	}
    }
    
    private void checkDiagonal() {
	if (button[0].getText().equals(button[4].getText()) && button[4].getText().equals(button[8].getText())) {
	    if (button[0].getText().equals("X")) {
		JOptionPane.showMessageDialog(this, "Player X won");
		int scoreXOld = this.scoreX;
		++scoreX;
		changes.firePropertyChange("scoreX", scoreXOld, scoreX);
		resetGrid();
	    } else if (button[0].getText().equals("O")){
		JOptionPane.showMessageDialog(this, "Player O won");
		int scoreOOld = this.scoreO;
		++scoreO;
		changes.firePropertyChange("scoreO", scoreOOld, scoreO);
		resetGrid();
	    }
	} else if (button[2].getText().equals(button[4].getText()) && button[4].getText().equals(button[6].getText())) {
	    if (button[2].getText().equals("X")) {
		JOptionPane.showMessageDialog(this, "Player X won");
		int scoreXOld = this.scoreX;
		++scoreX;
		changes.firePropertyChange("scoreX", scoreXOld, scoreX);
		resetGrid();
	    } else if (button[2].getText().equals("O")){
		JOptionPane.showMessageDialog(this, "Player O won");
		int scoreOOld = this.scoreO;
		++scoreO;
		changes.firePropertyChange("scoreO", scoreOOld, scoreO);
		resetGrid();
	    }
	}
    }
    
    private void resetGrid() {
	for (int i = 0; i < GRID_SIZE; ++i) {
		button[i].setIsClicked(false);
		button[i].setText("");
	}
	countMoves = 0;
    }
    
    private void comMove() {
	Random rand = new Random();
	int random = rand.nextInt(9);
	if (countMoves > 0) {
	    if (!checkGridFull() && button[random].getText().isBlank()) {
		button[random].setForeground(Color.red);
		button[random].setText("O");
		button[random].setIsClicked(true);
		countMoves++;
	    } else if (!checkGridFull()) 
		comMove();
	}
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
	for (int i = 0; i < GRID_SIZE; ++i) {
	    if (e.getSource() == button[i] && !button[i].getIsClicked()) {
		button[i].setForeground(Color.blue);
		button[i].setText("X");
		countMoves++;   
		button[i].setIsClicked(true);
		checkWin();
		changes.firePropertyChange("Player Moved", "", "X");
	    }
	}
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
	switch(evt.getPropertyName()) {
	case "scoreX":
	    playerX.setText("Player X: " + scoreX);
	    break;
	case "scoreO":
	    playerO.setText("Player O: " + scoreO);
	    break;
	case "Player Moved":
	    comMove();
	    checkWin();
	    break;
	}
    }
    
    
}
