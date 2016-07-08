import sklad.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class CSklad implements ActionListener {
    JFrame mujFrejm = null;
    JButton mTlacitko = null;
    JMenuItem itemP1 = null;
    JMenuItem itemP2 = null;
    JMenuItem itemP3 = null;
    JMenuItem itemO1 = null;
    JMenuItem itemO2 = null;
    JMenuItem itemO3 = null;
    JMenuItem itemO4 = null;

    public CSklad() {
        mujFrejm = new JFrame("Sklad - test verze");
        mujFrejm.setSize(600,270);
        mujFrejm.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e) {System.exit(0);}
            });

	 JMenuBar menuBar = new JMenuBar();
	 mujFrejm.setJMenuBar(menuBar);

	 JMenu menuP = new JMenu("Položky");
	 itemP1 = new JMenuItem("Nový typ položky");
	 itemP1.addActionListener(this);
	 menuP.add(itemP1);
	 itemP2 = new JMenuItem("Nová položka");
	 itemP2.addActionListener(this);
	 menuP.add(itemP2);
	 itemP3 = new JMenuItem("Přehled položek");
	 itemP3.addActionListener(this);
	 menuP.add(itemP3);
	 menuBar.add(menuP);

	 JMenu menuO = new JMenu("Ostatní");
	 itemO1 = new JMenuItem("Nová osoba");
	 itemO1.addActionListener(this);
	 menuO.add(itemO1);
	 itemO2 = new JMenuItem("Nový sklad");
	 itemO2.addActionListener(this);
	 menuO.add(itemO2);
	 itemO3 = new JMenuItem("Nová jednotka");
	 itemO3.addActionListener(this);
	 menuO.add(itemO3);
	 itemO4 = new JMenuItem("Vše vymazat");
	 itemO4.addActionListener(this);
	 menuO.add(itemO4);
	 menuBar.add(menuO);

	ImageIcon icon =  new ImageIcon("logo.png", "logo");
	JLabel lab = new JLabel(icon);
	//mTlacitko = new JButton("Test the dialog!");
	//mTlacitko.addActionListener(this);
//	mujFrejm.setLocationRelativeTo(null);
	mujFrejm.getContentPane().add(lab);
//	mujFrejm.pack();
	mujFrejm.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
	if(itemO4 == e.getSource()) {
	sklad.CSqlVrstva databaze = new sklad.CSqlVrstva();
	databaze.vytvorTabulky();
	}
	if(itemO3 == e.getSource()) {
        sklad.CNovaJednotka dialog = new sklad.CNovaJednotka(null);
	}
	if(itemO2 == e.getSource()) {
        sklad.CNovySklad dialog = new sklad.CNovySklad(null);
	}

	if(itemO1 == e.getSource()) {
        sklad.CNovaOsoba dialog = new sklad.CNovaOsoba(null);
	}
	if(itemP1 == e.getSource()) {
        sklad.CNovyTyp dialog = new sklad.CNovyTyp(null);
	}
	if(itemP2 == e.getSource()) {
        sklad.CNovaPolozka dialog = new sklad.CNovaPolozka(null);
	}
	if(itemP3 == e.getSource()) {
		CNastaveniZobrazeni dialog = new CNastaveniZobrazeni(new javax.swing.JFrame(), true);
		dialog.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
		          //System.exit(0);
				e.getComponent().setVisible(false);
			}
		});
		dialog.setVisible(true);
	}
	if(mTlacitko == e.getSource()) {
	    System.err.println("Oteviram dialog");
	    sklad.CustomDialog mDialog = new sklad.CustomDialog(mujFrejm, true, "Nejaka otazka");
	    System.err.println("Po otevreni dialogu");
	    if(mDialog.getAnswer()) {
		System.err.println("odpoved z dialogu 'true' (ano tlacitko.)");
	    }
	    else {
		System.err.println("odpoved z dialogu 'false' (ne tlacitko)");
	    }
	}
    }

    public static void main(String argv[]) {

	     CSklad test = new CSklad();

    }
}
