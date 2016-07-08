package sklad;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class CNovySklad extends JDialog implements ActionListener {
  private JPanel panel = null;
  private JButton okButton = null;
  private JButton dalsiButton = null;
  private JButton zrusButton = null;
  private JTextField nazev = null;
  private JTextArea popis = null;


    
  public CNovySklad(JFrame predchudce) {
    super(predchudce,true);
	 panel = new JPanel();

    getContentPane().add(panel);
    panel.setLayout(new FlowLayout());

	 panel.add(new JLabel("Zadej název: "));
	 nazev = new JTextField(20);
	 panel.add(nazev);
	 popis = new JTextArea("Popis",3,20);
	 panel.add(popis);

	 okButton = new JButton("Ok");
	 okButton.addActionListener(this);
	 panel.add(okButton);	
	 dalsiButton = new JButton("Další");
	 dalsiButton.addActionListener(this);
	 panel.add(dalsiButton);	
	 zrusButton = new JButton("Zruš");
	 zrusButton.addActionListener(this);
	 panel.add(zrusButton);	

    setSize(300,150);
	 setVisible(true);
  }

    public void actionPerformed(ActionEvent e) {
		if(okButton == e.getSource()) {
			 System.err.println("Uzivatel odpovedel ano"+nazev.getText());
			 sklad.CSqlVrstva databaze = new sklad.CSqlVrstva();
			 databaze.pridejSklad(nazev.getText(),popis.getText());
			 
			 //answer = true;
			 setVisible(false);
		}
		else if(dalsiButton == e.getSource()) {
			 System.err.println("Uzivatel odpovedel dalsi");
			 sklad.CSqlVrstva databaze = new sklad.CSqlVrstva();
			 databaze.pridejSklad(nazev.getText(),popis.getText());
			 //answer = false;
			 nazev.setText("");
			 popis.setText("");
			 //setVisible(false);
		}
		else if(zrusButton == e.getSource()) {
			 System.err.println("Uzivatel odpovedel zrus");
			 //answer = false;
			 setVisible(false);
		}
    }




}

