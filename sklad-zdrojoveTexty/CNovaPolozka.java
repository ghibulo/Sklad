package sklad;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;




public class CNovaPolozka extends JDialog implements ActionListener {
  private JPanel panel = null;
  private JButton okButton = null;
  private JButton dalsiButton = null;
  private JButton zrusButton = null;
  private JTextArea popis = null;
  private JList typy = null;
  private JList sklady = null;
  private JTextField mnozstvi = null;
  private JComboBox jednotky = null;
  private JTextField kod = null;


    
  public CNovaPolozka(JFrame predchudce) {
    super(predchudce,true);
	 panel = new JPanel();

         getContentPane().add(panel);
         panel.setLayout(new FlowLayout());

	 sklad.CSqlVrstva databaze = new sklad.CSqlVrstva();
	 //vyber typu polozky
	 String[] data =databaze.getPoleTypu();
	 panel.add(new JLabel("Vyber typ položky: "));
	 typy = new JList(data);
         typy.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         typy.setSelectedIndex(0);
         typy.setVisibleRowCount(5);
	 JScrollPane scrollPane = new JScrollPane(typy);
	 panel.add(scrollPane);
	 //kod polozky
	 kod = new JTextField(10);
	 panel.add(new JLabel("Kod položky: "));
	 panel.add(kod);
	 //vyber skladu
	 data =databaze.getPoleSkladu();
	 panel.add(new JLabel("Vyber sklad: "));
	 sklady = new JList(data);
         sklady.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         sklady.setSelectedIndex(0);
         sklady.setVisibleRowCount(5);
	 scrollPane = new JScrollPane(sklady);
	 panel.add(scrollPane);
	 //mnozstvi
	 panel.add(new JLabel("Množství: "));
	 mnozstvi = new JTextField(5);
	 panel.add(mnozstvi);
	 //vyber jednotky
	 data =databaze.getPoleJednotek();
	 jednotky = new JComboBox(data);
         jednotky.setSelectedIndex(0);
	 scrollPane = new JScrollPane(jednotky);
	 panel.add(scrollPane);
	 //popis
	 popis = new JTextArea("Popis",2,18);
	 panel.add(popis);







         //list.addListSelectionListener(this);

	 //popis = new JTextArea("Popis",3,20);
	 //panel.add(popis);

	 okButton = new JButton("Ok");
	 okButton.addActionListener(this);
	 panel.add(okButton);	
	 dalsiButton = new JButton("Další");
	 dalsiButton.addActionListener(this);
	 panel.add(dalsiButton);	
	 zrusButton = new JButton("Zruš");
	 zrusButton.addActionListener(this);
	 panel.add(zrusButton);	

         setSize(600,350);
	 setVisible(true);
  }

    public void actionPerformed(ActionEvent e) {
		if((okButton == e.getSource())||(dalsiButton == e.getSource())) {
			 Calendar cal = Calendar.getInstance();
	                 sklad.CSqlVrstva databaze = new sklad.CSqlVrstva();
                         databaze.pridejPolozku(typy.getSelectedIndex(),
				 Double.parseDouble(mnozstvi.getText()), jednotky.getSelectedIndex(), 
				 sklady.getSelectedIndex(), kod.getText(), cal.getTime()/*zarazeno*/, 
				 cal.getTime()/*vyrazeno*/, popis.getText(), cal.getTime()/*trvanlivost*/ );
			 if (e.getSource()==okButton) setVisible(false); else {
				  popis.setText(""); 
				  mnozstvi.setText(""); 
				  kod.setText(""); 
			 }
			 
		}
		else if(zrusButton == e.getSource()) {
			 setVisible(false);
		}
    }




}

