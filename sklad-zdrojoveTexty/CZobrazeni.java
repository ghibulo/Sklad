/*
 * CZobrazeni.java
 *
 * Created on 18. březen 2008, 0:36
 */

package sklad;
import javax.swing.table.AbstractTableModel;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author  jaih
 */
public class CZobrazeni extends /*javax.swing.JInternalFrame*/ JDialog {
	
         private JPanel panel = null;
	 private JTable tabulka = null;
	/** Creates new form CZobrazeni */
	public CZobrazeni() {
		initComponents();
	}
	public CZobrazeni(AbstractTableModel data) {
	 super((JFrame)null,true);
	 panel = new JPanel();
         panel.setLayout(new BorderLayout());
         getContentPane().add(panel);
	 tabulka = new JTable(data);
	 tabulka.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
	 JScrollPane scroll = new JScrollPane(tabulka);
	 panel.add(scroll,BorderLayout.CENTER);


         setSize(600,350);
	 setVisible(true);
	}
	
	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 917, Short.MAX_VALUE)
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 298, Short.MAX_VALUE)
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents
	
	
        // Variables declaration - do not modify//GEN-BEGIN:variables
        // End of variables declaration//GEN-END:variables
	
}
