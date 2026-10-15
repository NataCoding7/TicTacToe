package semesteraufgabe;

import javax.swing.*;

@SuppressWarnings("serial")
public class TicTacToeButton extends JButton{

    private boolean isClicked = false;
    
    public boolean getIsClicked() {
	return this.isClicked;
    }
    
    public void setIsClicked(boolean b) {
	this.isClicked = b;
    }
    
}
