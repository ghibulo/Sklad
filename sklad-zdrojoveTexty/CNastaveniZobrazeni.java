/*
 * CNastaveniZobrazeni.java
 *
 * Created on 17. březen 2008, 14:49
 */

package sklad;

import javax.swing.*;
/**
 *
 * @author  jaih
 */
public class CNastaveniZobrazeni extends javax.swing.JDialog {
	CZobrazeni zobrazeni = null;
	
	/** Creates new form CNastaveniZobrazeni */
	public CNastaveniZobrazeni(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
	}
	
	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                buttonGroup = new javax.swing.ButtonGroup();
                jLabel1 = new javax.swing.JLabel();
                jCheckBoxNazev = new javax.swing.JCheckBox();
                jCheckBoxKod = new javax.swing.JCheckBox();
                jCheckBoxMnozstvi = new javax.swing.JCheckBox();
                jCheckBoxSklad = new javax.swing.JCheckBox();
                jCheckBoxZarazeni = new javax.swing.JCheckBox();
                jCheckBoxPopis = new javax.swing.JCheckBox();
                jCheckBoxTrvanlivost = new javax.swing.JCheckBox();
                jLabel2 = new javax.swing.JLabel();
                jRadioButtonNazev = new javax.swing.JRadioButton();
                jRadioButtonKod = new javax.swing.JRadioButton();
                jRadioButtonSklad = new javax.swing.JRadioButton();
                jRadioButtonZarazeni = new javax.swing.JRadioButton();
                jRadioButtonTrvanlivost = new javax.swing.JRadioButton();
                jToggleButtonZobraz = new javax.swing.JToggleButton();
                jToggleButtonZavrit = new javax.swing.JToggleButton();

                buttonGroup.add(jRadioButtonNazev);
                buttonGroup.add(jRadioButtonKod);
                buttonGroup.add(jRadioButtonSklad);
                buttonGroup.add(jRadioButtonZarazeni);
                buttonGroup.add(jRadioButtonTrvanlivost);

                jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
                jLabel1.setText("Sloupce k zobrazení:");

                jCheckBoxNazev.setSelected(true);
                jCheckBoxNazev.setText("Název typu");

                jCheckBoxKod.setSelected(true);
                jCheckBoxKod.setText("Kod");

                jCheckBoxMnozstvi.setSelected(true);
                jCheckBoxMnozstvi.setText("Množství");

                jCheckBoxSklad.setSelected(true);
                jCheckBoxSklad.setText("Sklad");

                jCheckBoxZarazeni.setSelected(true);
                jCheckBoxZarazeni.setText("Datum zařazení");

                jCheckBoxPopis.setSelected(true);
                jCheckBoxPopis.setText("Popis");

                jCheckBoxTrvanlivost.setSelected(true);
                jCheckBoxTrvanlivost.setText("Trvanlivost");

                jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
                jLabel2.setText("Seřadit dle...");

                jRadioButtonNazev.setSelected(true);
                jRadioButtonNazev.setText("Názvu typu");

                jRadioButtonKod.setText("Kodu");

                jRadioButtonSklad.setText("Skladu");

                jRadioButtonZarazeni.setText("Datumu zařazení");

                jRadioButtonTrvanlivost.setText("Trvanlivosti");

                jToggleButtonZobraz.setText("Zobraz");
                jToggleButtonZobraz.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jToggleButtonZobrazActionPerformed(evt);
                        }
                });

                jToggleButtonZavrit.setText("Zavřít");
                jToggleButtonZavrit.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jToggleButtonZavritActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jCheckBoxPopis)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jCheckBoxNazev)
                                                        .addComponent(jCheckBoxKod)
                                                        .addComponent(jCheckBoxMnozstvi)
                                                        .addComponent(jCheckBoxSklad)
                                                        .addComponent(jCheckBoxZarazeni)
                                                        .addComponent(jCheckBoxTrvanlivost))
                                                .addGap(34, 34, 34)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jToggleButtonZobraz)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jToggleButtonZavrit))
                                                        .addComponent(jRadioButtonTrvanlivost)
                                                        .addComponent(jRadioButtonZarazeni)
                                                        .addComponent(jRadioButtonSklad)
                                                        .addComponent(jRadioButtonKod)
                                                        .addComponent(jRadioButtonNazev)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jCheckBoxNazev)
                                        .addComponent(jRadioButtonNazev))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jCheckBoxKod)
                                        .addComponent(jRadioButtonKod))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jCheckBoxMnozstvi)
                                        .addComponent(jRadioButtonSklad))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jCheckBoxSklad)
                                        .addComponent(jRadioButtonZarazeni))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jCheckBoxZarazeni)
                                        .addComponent(jRadioButtonTrvanlivost))
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBoxPopis)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jCheckBoxTrvanlivost)
                                                .addContainerGap())
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jToggleButtonZobraz)
                                                        .addComponent(jToggleButtonZavrit))
                                                .addGap(22, 22, 22))))
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

	private void jToggleButtonZavritActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonZavritActionPerformed
		// TODO add your handling code here:
		setVisible(false);
	}//GEN-LAST:event_jToggleButtonZavritActionPerformed

	private void jToggleButtonZobrazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonZobrazActionPerformed
		// priprava dat pro CDtModelZobrazeni, cisla jsou poradi v SQLdatabazi
		byte razeni = 0;
		if (jRadioButtonNazev.isSelected()) razeni=1;
		if (jRadioButtonKod.isSelected()) razeni=2;
		if (jRadioButtonSklad.isSelected()) razeni=3;
		if (jRadioButtonTrvanlivost.isSelected()) razeni=8;
		if (jRadioButtonZarazeni.isSelected()) razeni=6;
		int sloupce = 0;
		if (jCheckBoxKod.isSelected()) sloupce|=(int)Math.pow(2,6); //pow(2,5) nastavi 6 bit od konce
		if (jCheckBoxMnozstvi.isSelected()) sloupce|=(int)(Math.pow(2,3)+Math.pow(2,4)); //mnozstvi a jednotka
		if (jCheckBoxNazev.isSelected()) sloupce|=(int)Math.pow(2,7);
		if (jCheckBoxPopis.isSelected()) sloupce|=(int)Math.pow(2,1);
		if (jCheckBoxSklad.isSelected()) sloupce|=(int)Math.pow(2,5);
		if (jCheckBoxTrvanlivost.isSelected()) sloupce|=(int)Math.pow(2,0);
		if (jCheckBoxZarazeni.isSelected()) sloupce|=(int)Math.pow(2,2);
		zobrazeni = new CZobrazeni(new CDtModelZobrazeni(sloupce,razeni));
	}//GEN-LAST:event_jToggleButtonZobrazActionPerformed
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				CNastaveniZobrazeni dialog = new CNastaveniZobrazeni(new javax.swing.JFrame(), true);
				dialog.addWindowListener(new java.awt.event.WindowAdapter() {
					public void windowClosing(java.awt.event.WindowEvent e) {
						//System.exit(0);
		                                e.getComponent().setVisible(false);
					}
				});
				dialog.setVisible(true);
			}
		});
	}
	
        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.ButtonGroup buttonGroup;
        private javax.swing.JCheckBox jCheckBoxKod;
        private javax.swing.JCheckBox jCheckBoxMnozstvi;
        private javax.swing.JCheckBox jCheckBoxNazev;
        private javax.swing.JCheckBox jCheckBoxPopis;
        private javax.swing.JCheckBox jCheckBoxSklad;
        private javax.swing.JCheckBox jCheckBoxTrvanlivost;
        private javax.swing.JCheckBox jCheckBoxZarazeni;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JRadioButton jRadioButtonKod;
        private javax.swing.JRadioButton jRadioButtonNazev;
        private javax.swing.JRadioButton jRadioButtonSklad;
        private javax.swing.JRadioButton jRadioButtonTrvanlivost;
        private javax.swing.JRadioButton jRadioButtonZarazeni;
        private javax.swing.JToggleButton jToggleButtonZavrit;
        private javax.swing.JToggleButton jToggleButtonZobraz;
        // End of variables declaration//GEN-END:variables
	
}
