package sklad;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.*;

public class CustomDialog extends JDialog implements ActionListener {
    private JPanel myPanel = null;
    private JButton yesButton = null;
    private JButton noButton = null;
    private boolean answer = false;
    public boolean getAnswer() { return answer; }

    public CustomDialog(JFrame frame, boolean modal, String myMessage) {
		super(frame, modal);
		myPanel = new JPanel();
		getContentPane().add(myPanel);
		myPanel.add(new JLabel(myMessage));
		myPanel.add(new JLabel("neco zadame"));
		JTextField nazev = new JTextField(10);
		myPanel.add(nazev);
		yesButton = new JButton("Ano");
		yesButton.addActionListener(this);
		myPanel.add(yesButton);	
		noButton = new JButton("Ne");
		noButton.addActionListener(this);
		myPanel.add(noButton);	
		pack();
		setLocationRelativeTo(frame);
		setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
	if(yesButton == e.getSource()) {
	    System.err.println("Uzivatel odpovedel ano");
	    answer = true;
	    setVisible(false);
	}
	else if(noButton == e.getSource()) {
	    System.err.println("Uzivatel odpovedel ne");
	    answer = false;
	    setVisible(false);
	}
    }
    
}
