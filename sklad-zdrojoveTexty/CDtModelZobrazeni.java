/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sklad;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author jaih
 */
public class CDtModelZobrazeni extends AbstractTableModel{

sklad.CSqlVrstva databaze = null;
final byte nazev = 1;
final byte kod = 2;
final byte mnozstvi = 4;
final byte sklad = 8;
final byte datum = 16;
final byte popis = 32;
final byte trvanlivost = 64;
byte[] sloupce; //sloupce ktere figuruji v tabulce
byte razeno = 0;

//poradi nazvu v poli musi kopirovat poradi polozek v SQLbázi (polozkyView)
private final static String[] nazevSloupcu = {"Název typu", "Kód",  "Sklad", "Množství", "Jednotka",
"Zařazeno", "Popis", "Trvanlivost"};

	
	public CDtModelZobrazeni(int sloupce, byte razeno) {
		//pocet sloupcu
		int slp = sloupce;
		int pocet = slp & 1;
		for(int i=1;i<32;i++) {
			slp = slp >>> 1;
			pocet += slp&1;
		}
		this.sloupce = new byte[pocet];
		//naplneni pole sloupce[]
		int k=1;
		for(byte i=0,p=0;i<32;i++) {
			if ((sloupce & k)==k) this.sloupce[p++]=i;
			k*=2;
		}
		this.razeno=razeno;
		databaze = new sklad.CSqlVrstva();
		databaze.initPolePolozek(razeno);
	}

	public int getRowCount() {
		return databaze.polePolozekLength();
	}
	public int getColumnCount() {
		return sloupce.length;

	}
	public Object getValueAt(int row, int column){
		return databaze.polePolozekAt(row+1, sloupce[column]+1);
	}
	public String getColumnName(int sl) {
		return (nazevSloupcu[sloupce[sl]]);
	}


}
