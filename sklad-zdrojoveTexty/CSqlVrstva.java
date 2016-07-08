package sklad;
import java.sql.*;
import java.util.*;
import java.util.*;
import java.text.SimpleDateFormat;

//objekt zajistuje veskerou SQL komunikaci s databazi. Predpoklada zalozenou databazi sklad.
public class CSqlVrstva {
   Connection con = null;
   Statement  stmt = null;
   ResultSet  polePolozek = null; // vysledek dotazu na polozky, ktery bude slouzit jako zdroj simulace pole


   public CSqlVrstva() {
     int        count;
     try {
       Class.forName("com.mysql.jdbc.Driver").newInstance();
       con = DriverManager.getConnection("jdbc:mysql://localhost/sklad?useUnicode=true&characterEncoding=UTF-8", "jaih", "lingvo");
       stmt = con.createStatement();

     } catch(Exception e) {
         System.err.println("Vyjimka: " + e.getMessage());
       } 
   }

   public void vytvorTabulky() {
     int        count;
     try {
	     //pridelat omezeni primklice a unique

       count = stmt.executeUpdate ("DROP TABLE IF EXISTS typyPolozek");
       count = stmt.executeUpdate ("CREATE TABLE typyPolozek (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, nazev VARCHAR(20) NOT NULL UNIQUE, popis VARCHAR(50)) TYPE = MYISAM CHARACTER SET utf8;");

       count = stmt.executeUpdate ("DROP TABLE IF EXISTS polozky");
       count = stmt.executeUpdate ("CREATE TABLE polozky (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, idTypu INT, mnozstvi DECIMAL(5,2), idJednotky INT, idSkladu INT, kod CHAR(10), zarazeno DATETIME, vyrazeno DATETIME, popis varchar(50), trvanlivost DATETIME) TYPE = MYISAM CHARACTER SET utf8;");

       count = stmt.executeUpdate ("DROP TABLE IF EXISTS historie");
       count = stmt.executeUpdate ("CREATE TABLE historie (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, idPolozky INT, mnozstvi DECIMAL(5,2), idJednotky INT, datum DATETIME, operace CHAR(10), umisteni INT, poznamka VARCHAR(30));");

       count = stmt.executeUpdate ("DROP TABLE IF EXISTS jednotky");
       count = stmt.executeUpdate ("CREATE TABLE jednotky(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, nazev CHAR(8) NOT NULL UNIQUE) TYPE = MYISAM CHARACTER SET utf8;");

       count = stmt.executeUpdate ("DROP TABLE IF EXISTS osoby");
       count = stmt.executeUpdate ("CREATE TABLE osoby(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, nick VARCHAR(20) NOT NULL UNIQUE, heslo VARCHAR(20)) TYPE = MYISAM CHARACTER SET utf8;");

       count = stmt.executeUpdate ("DROP TABLE IF EXISTS sklady");
       count = stmt.executeUpdate ("CREATE TABLE sklady(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, nazev VARCHAR(20) NOT NULL UNIQUE, popis VARCHAR(20)) TYPE = MYISAM CHARACTER SET utf8;");

       count = stmt.executeUpdate ("DROP TABLE IF EXISTS zodpovednost");
       count = stmt.executeUpdate ("CREATE TABLE zodpovednost(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, idOsoby INT, idSkladu INT, prava INT) TYPE = MYISAM CHARACTER SET utf8;");

       count = stmt.executeUpdate ("DROP VIEW IF EXISTS polozkyView");
       count = stmt.executeUpdate ("create view polozkyView (JMENO_TYPU, KOD, SKLAD, MNOZSTVI, JEDNOTKA, ZARAZENO, POPIS, TRVANLIVOST) as select typyPolozek.nazev, polozky.kod, sklady.nazev, polozky.mnozstvi, jednotky.nazev, polozky.zarazeno, polozky.popis, polozky.trvanlivost from typyPolozek, polozky, jednotky,sklady where typyPolozek.id=polozky.idTypu and jednotky.id=polozky.idJednotky and sklady.id=polozky.idSkladu;");

/*práva: 
 * přijímat na sklad 		.... 1
 * vydávat ze skladu 		.... 2
 * koukat			.... 4
 * vydat do jiného skladu	.... 8
 */
       } catch(Exception e) {
           System.err.println("Vyjimka: " + e.getMessage());
         } 
                                                                                                              
   }

/* OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY OSOBY */

   public boolean pridejOsobu(String nick, String heslo) {
     int  count;

     if (existujeOsoba(nick)) {
       return false;
     } else {
         try {                                                                                                
           count = stmt.executeUpdate("INSERT INTO osoby (nick, heslo) VALUES('"+nick+"','"+heslo+"');");
         } catch(Exception e) {
               System.err.println("Vyjimka: " + e.getMessage());
           }                                                                                               
	 return true;
       }
      
   }

   public String hesloOsoby(String nick) {
     ResultSet  rs = null;
     String heslo=new String();
     try {
       rs = stmt.executeQuery("SELECT heslo FROM osoby WHERE nick='"+nick+"'");
       if (rs.next()) {
         heslo= rs.getString(1);
       } else {
         heslo="";
       }
     } catch(Exception e) {
         System.err.println("Vyjimka: " + e.getMessage());
       } 
     return heslo;
   }

   public boolean existujeOsoba(String nick) {
     ResultSet  rs = null;
     String heslo=new String();
     boolean existuje;
     try {
       rs = stmt.executeQuery("SELECT nick FROM osoby WHERE nick='"+nick+"'");
       existuje=rs.next(); 
     } catch(Exception e) {
         System.err.println("Vyjimka: " + e.getMessage());
	 existuje=false;
       } 
     return existuje;
   }

   public int setHeslo(String nick, String heslo) {
   int pocet = 0;
     try {
       pocet = stmt.executeUpdate("UPDATE osoby SET heslo='"+heslo+"' WHERE nick='"+nick+"'");
     } catch(Exception e) {
         System.err.println("Vyjimka: " + e.getMessage());
       } 
     return pocet;
   }
   
   public int vymazOsobu(String nick) {
   int pocet = 0;
     try {
       pocet = stmt.executeUpdate("DELETE FROM osoby WHERE nick='"+nick+"'");
     } catch(Exception e) {
         System.err.println("Vyjimka: " + e.getMessage());
       } 
     return pocet;
   }


/* SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLADY SKLAD*/


   public boolean pridejSklad(String nazev, String popis) {
     int  count;
     if (existujeSklad(nazev)) {
       return false;
     } else {
         try {                                                                                                
           count = stmt.executeUpdate("INSERT INTO sklady (nazev, popis) VALUES('"+nazev+"','"+popis+"');");
         } catch(Exception e) {
               System.err.println("Vyjimka: " + e.getMessage());
           }                                                                                               
	 return true;
       }
      
   }

   public String popisSkladu(String nazev) {
     ResultSet  rs = null;
     String popis=new String();
     try {
       rs = stmt.executeQuery("SELECT popis FROM sklady WHERE nazev='"+nazev+"'");
       if (rs.next()) {
         popis= rs.getString(1);
       } else {
         popis="";
       }
     } catch(Exception e) {
         System.err.println("Vyjimka: " + e.getMessage());
       } 
     return popis;
   }

   public boolean existujeSklad(String nazev) {
     ResultSet  rs = null;
     String popis=new String();
     boolean existuje;
     try {
       rs = stmt.executeQuery("SELECT nazev FROM sklady WHERE nazev='"+nazev+"'");
       existuje=rs.next(); 
     } catch(Exception e) {
         System.err.println("Vyjimka: " + e.getMessage());
	 existuje=false;
       } 
     return existuje;
   }

   public int setPopisSkladu(String nazev, String popis) {
   int pocet = 0;
     try {
       pocet = stmt.executeUpdate("UPDATE sklady SET popis='"+popis+"' WHERE nazev='"+nazev+"'");
     } catch(Exception e) {
         System.err.println("Vyjimka: " + e.getMessage());
       } 
     return pocet;
   }
   
   public int vymazSklad(String nazev) {
   int pocet = 0;
     try {
       pocet = stmt.executeUpdate("DELETE FROM sklady WHERE nazev='"+nazev+"'");
     } catch(Exception e) {
         System.err.println("Vyjimka: " + e.getMessage());
       } 
     return pocet;
   }

   public String[] getPoleSkladu() {
     ResultSet  rs = null;
     ArrayList pole = new ArrayList();
     try {
       rs = stmt.executeQuery("SELECT nazev FROM sklady ORDER BY id");

       while (rs.next()) {
          pole.add(rs.getString(1));
       }

     } catch(Exception e) {
         System.err.println("Vyjimka: " + e.getMessage());
       } 
     String[] poles=new String[pole.size()];
     for (int j=0;j<pole.size();j++) poles[j]=(String)pole.get(j);
     return poles;
   }

/* ZODPOVEDNOST ZODPOVEDNOST ZODPOVEDNOST ZODPOVEDNOST ZODPOVEDNOST ZODPOVEDNOST ZODPOVEDNOST ZODPOVEDNOST ZODPOVEDNOST ZODPOVEDNOST ZODPOVEDNOST ZODPOVEDNOST ZODPOVEDNOST ZODPOVEDNOST ZODPOVEDNOST ZODPOVEDNOST ZODPOVEDNOST ZODPOVEDNOST ZODPOVEDNOST ZODPOVEDNOST ZODPOVEDNOST ZODPOVEDNOST ZODPOVEDNOST ZODPOVPOVEDNOST ZODPOVEDNOST ZODPOVEDNOST ZODPOVEDNOST ZODPOVEDNOST ZODPOVEDNOST ZODPOVEDNOST ZODPOVEDNOST ZODPOVEDNOST ZODPOVEDNOST ZODPOVEDNOST ZODPOVEDNOST ZODPOVEDNOST ZODPOVEDNOST ZODPOVEDNOST ZODPOVEDNOST ZODPOVEDNOST ZODPOVEDNOST */

   public boolean pridejZodpovednost(String osoba, String sklad) {
     int  count;
     if (existujeZodpovednost(osoba,sklad)) {
       return false;
     } else {
         try {                                                                                                
           count = stmt.executeUpdate("INSERT INTO zodpovednost (idOsoby, idSkladu) value(select o.id, s.id from osoby o, sklady s where o.nick='"+osoba+"' AND s.nazev='"+sklad+"');");
         } catch(Exception e) {
               System.err.println("Vyjimka(pridejZodpovednost): " + e.getMessage());
	       return false;
           }                                                                                               
	 return (count==1);
       }
      
   }

	public int getPrava(String osoba, String sklad) {
	  int  			prava=0;
     ResultSet  	rs = null;
     try {
       rs = stmt.executeQuery("SELECT zodpovednost.prava from osoby JOIN zodpovednost ON osoby.id=zodpovednost.idOsoby JOIN sklady on sklady.id=zodpovednost.idSkladu WHERE osoby.nick='"+osoba+"' AND sklady.nazev='"+sklad+"'");
		 if (rs.next()) {prava = rs.getInt(1);} else {prava = 0;}
     } catch(Exception e) {
         System.err.println("Vyjimka(getPrava): " + e.getMessage());
       } 
	  return prava;
	}

	public boolean setPrava(String osoba, String sklad, int prava) {
	  int[] trojice= getTrojice(osoba,sklad);
	  int count, pocet;
	  System.out.println(" "+trojice[0]+trojice[1]+trojice[2]);
     try {
		 if (trojice[0]==-1) {
		   pridejZodpovednost(osoba,sklad);
	    } 
       pocet = stmt.executeUpdate("UPDATE zodpovednost SET prava="+prava+" WHERE idOsoby="+trojice[0]+";");
     } catch(Exception e) {
         System.err.println("Vyjimka(setPrava): " + e.getMessage());
			return false;
       } 
	  return true;
	}



   public boolean existujeZodpovednost(String osoba, String sklad) {
     ResultSet  rs = null;
     boolean existuje;
     try {
       rs = stmt.executeQuery("SELECT osoby.nick, sklady.nazev from osoby join zodpovednost on osoby.id=zodpovednost.idOsoby join sklady on sklady.id=zodpovednost.idSkladu WHERE osoby.nick='"+osoba+"' AND sklady.nazev='"+sklad+"'");
       existuje=rs.next(); 
     } catch(Exception e) {
         System.err.println("Vyjimka(existujeZodpovednost): " + e.getMessage());
	 existuje=false;
       } 
     return existuje;
   }

   
   public int vymazZodpovednost(String osoba, String sklad) {
   int pocet = 0;
     try {
       pocet = stmt.executeUpdate("DELETE FROM zodpovednost WHERE zodpovednost.idOsoby=(select id from osoby where nick='"+osoba+"') AND zodpovednost.idSkladu=(select id from sklady where nazev='"+sklad+"')");
     } catch(Exception e) {
         System.err.println("Vyjimka(vymazZodpovednost): " + e.getMessage());
       } 
     return pocet;
   }

	private int[] getTrojice(String osoba, String sklad) {
     ResultSet  rs = null;
	  int[] vysledek = {-1,-1,-1};
	    System.out.println("getTrojice");
	    System.out.println("vysl "+vysledek[0]);
     try {
       rs = stmt.executeQuery("SELECT zodpovednost.idOsoby,zodpovednost.idSkladu, zodpovednost.prava from osoby join zodpovednost on osoby.id=zodpovednost.idOsoby join sklady on sklady.id=zodpovednost.idSkladu WHERE osoby.nick='"+osoba+"' AND sklady.nazev='"+sklad+"'");
       if (rs.next()) {
		   for(int i=0;i<3;i++) {vysledek[i]=rs.getInt(i+1);}
		 } 
     } catch(Exception e) {
         System.err.println("Vyjimka(getTrojice): " + e.getMessage());
       } 
     return vysledek;
   }
	  
/*typyPolozek typyPolozek typyPolozek typyPolozek typyPolozek typyPolozek typyPolozek typyPolozek typyPolozek typyPolozek typyPolozek typyPolozek typyPolozek typyPolozek typyPolozek typyPolozek typyPolozek typyPolozek typyPolozek typyPolozek typyPolozek typyPolozek typyPolozek typyPolozek typyPolozek typyPolozek typyPolozek typyPolozek typyPolozek typyPolozek typyPolozek typyPolozek*/ 


   public boolean pridejTypPolozky(String nazev, String popis) {
     int  count;
	  System.err.println(nazev+", "+popis);
     if (existujeTypPolozky(nazev)) {
       return false;
     } else {
         try {                                                                                                
           count = stmt.executeUpdate("INSERT INTO typyPolozek (nazev, popis) VALUES('"+nazev+"','"+popis+"');");
         } catch(Exception e) {
               System.err.println("Vyjimka: " + e.getMessage());
           }                                                                                               
	 return true;
       }
      
   }

   public String popisTypuPolozky(String nazev) {
     ResultSet  rs = null;
     String popis=new String();
     try {
       rs = stmt.executeQuery("SELECT popis FROM typyPolozek WHERE nazev='"+nazev+"'");
       if (rs.next()) {
         popis= rs.getString(1);
       } else {
         popis="";
       }
     } catch(Exception e) {
         System.err.println("Vyjimka: " + e.getMessage());
       } 
     return popis;
   }


   public String[] getPoleTypu() {
     ResultSet  rs = null;
     ArrayList pole = new ArrayList();
     try {
       rs = stmt.executeQuery("SELECT nazev FROM typyPolozek ORDER BY id");

       System.err.println("typy položek do arrayu: ");
       while (rs.next()) {
          pole.add(rs.getString(1));
          System.err.println(rs.getString(1));
       }

     } catch(Exception e) {
         System.err.println("Vyjimka: " + e.getMessage());
       } 
     String[] poles=new String[pole.size()];
     System.err.println("TypPoložek do listboxu:");
     for (int j=0;j<pole.size();j++) {
	     poles[j]=(String)pole.get(j);
	     System.err.println(poles[j]);

     }
     return poles;
   }

   public boolean existujeTypPolozky(String nazev) {
     ResultSet  rs = null;
     String popis=new String();
     boolean existuje;
     try {
       rs = stmt.executeQuery("SELECT nazev FROM typyPolozek WHERE nazev='"+nazev+"'");
       existuje=rs.next(); 
     } catch(Exception e) {
         System.err.println("Vyjimka: " + e.getMessage());
	 existuje=false;
       } 
     return existuje;
   }

   public int setPopisTypuPolozky(String nazev, String popis) {
   int pocet = 0;
     try {
       pocet = stmt.executeUpdate("UPDATE typyPolozek SET popis='"+popis+"' WHERE nazev='"+nazev+"'");
     } catch(Exception e) {
         System.err.println("Vyjimka: " + e.getMessage());
       } 
     return pocet;
   }
   
   public int vymazTypPolozky(String nazev) {
   int pocet = 0;
     try {
       pocet = stmt.executeUpdate("DELETE FROM typyPolozek WHERE nazev='"+nazev+"'");
     } catch(Exception e) {
         System.err.println("Vyjimka: " + e.getMessage());
       } 
     return pocet;
   }

/*jednotky jednotky jednotky jednotky jednotky jednotky jednotky jednotky jednotky jednotky jednotky jednotky jednotky jednotky jednotky jednotky jednotky jednotky jednotky jednotky jednotky jednotky jednotky jednotky jednotky jednotky jednotky jednotky jednotky jednotky jednotky jednotky jednotky jednotky jednotky jednotky jednotky jednotky jednotky jednotky */

   public boolean pridejJednotku(String nazev) {
     int  count;
     if (existujeJednotka(nazev)) {
       return false;
     } else {
         try {                                                                                                
           count = stmt.executeUpdate("INSERT INTO jednotky (nazev) VALUES('"+nazev+"');");
         } catch(Exception e) {
               System.err.println("Vyjimka: " + e.getMessage());
           }                                                                                               
	 return true;
       }
      
   }


   public boolean existujeJednotka(String nazev) {
     ResultSet  rs = null;
     String popis=new String();
     boolean existuje;
     try {
       rs = stmt.executeQuery("SELECT nazev FROM jednotky WHERE nazev='"+nazev+"'");
       existuje=rs.next(); 
     } catch(Exception e) {
         System.err.println("Vyjimka: " + e.getMessage());
	 existuje=false;
       } 
     return existuje;
   }

   
   public int vymazJednotku(String nazev) {
   int pocet = 0;
     try {
       pocet = stmt.executeUpdate("DELETE FROM jednotky WHERE nazev='"+nazev+"'");
     } catch(Exception e) {
         System.err.println("Vyjimka: " + e.getMessage());
       } 
     return pocet;
   }

   public String[] getPoleJednotek() {
     ResultSet  rs = null;
     ArrayList pole = new ArrayList();
     try {
       rs = stmt.executeQuery("SELECT nazev FROM jednotky ORDER BY id");

       while (rs.next()) {
          pole.add(rs.getString(1));
       }

     } catch(Exception e) {
         System.err.println("Vyjimka: " + e.getMessage());
       } 
     String[] poles=new String[pole.size()];
     for (int j=0;j<pole.size();j++) poles[j]=(String)pole.get(j);
     return poles;
   }


/*polozky polozky polozky polozky polozky polozky polozky polozky polozky polozky polozky polozky polozky polozky polozky polozky polozky polozky polozky polozky polozky polozky polozky polozky polozky polozky polozky polozky polozky polozky polozky polozky polozky polozky polozky polozky polozky polozky polozky polozky polozky polozky polozky polozky */


   public void initPolePolozek(byte razenySloupec) {
     try {
       polePolozek = stmt.executeQuery("SELECT * FROM polozkyView ORDER BY "+razenySloupec);
     } catch(Exception e) {
         System.err.println("Vyjimka: (existujePolozka) " + e.getMessage());
       } 
   }

   public String polePolozekAt(int radek, int sloupec) {
     try {
	     polePolozek.absolute(radek);
	     return polePolozek.getString(sloupec);
     } catch(Exception e) {
         System.err.println("Vyjimka: (polePolozekAt) " + e.getMessage());
	 return "";
       } 
   }

   public int polePolozekLength() {
	try { 
	   polePolozek.last();
	   return polePolozek.getRow();
        } catch(Exception e) {
         System.err.println("Vyjimka: (polePolozekLength) " + e.getMessage());
	 return -1;
       } 
   }


   public boolean pridejPolozku(int idTypu, double mnozstvi, int idJednotky, int idSkladu, String kod, java.util.Date zarazeno, java.util.Date vyrazeno, String popis, java.util.Date trvanlivost ) {
     int  count;
         try {
            SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
           String prikaz = new String("INSERT INTO polozky (idTypu, mnozstvi, idJednotky, idSkladu, kod, zarazeno, vyrazeno, popis, trvanlivost) ");
	   prikaz = prikaz+ String.format("VALUES(%d , %s , %d , %d ,'%s' , '%s' , '%s' , '%s' , '%s' );",
		   idTypu+1, CUtils.ftos(mnozstvi), idJednotky+1, idSkladu+1, kod, sdf.format(zarazeno), 
		   sdf.format(vyrazeno), popis, sdf.format(trvanlivost));
	   System.err.println(prikaz);
           count = stmt.executeUpdate(prikaz);
	   //alternativa
          // count = stmt.executeUpdate("INSERT INTO polozky (idTypu, mnozstvi, idJednotky, idSkladu, kod, zarazeno, vyrazeno, popis, trvanlivost) VALUES("+idTypu+", "+mnozstvi+", "+idJednotky+", "+idSkladu+", '"+kod+"', '"+zarazeno.toString()+"', '"+vyrazeno.toString()+"', '"+popis+"', '"+trvanlivost.toString()+"'+);");
         } catch(Exception e) {
               System.err.println("Vyjimka: " + e.getMessage());
           }                                                                                               
	 return true;
   }


   public boolean existujePolozka(int idTypu) {
     ResultSet  rs = null;
     boolean existuje;
     try {
       rs = stmt.executeQuery("SELECT idTypu FROM polozky WHERE idTypu='"+idTypu+"'");
       existuje=rs.next(); 
     } catch(Exception e) {
         System.err.println("Vyjimka: (existujePolozka) " + e.getMessage());
	 existuje=false;
       } 
     return existuje;
   }

   public int setSkladuPolozky(int kterou, int idSkladu) {
   int pocet = 0;
   ResultSet  rs = null;
     try {
       rs = stmt.executeQuery("SELECT idTypu, mnozstvi, idJednotky, idSkladu, kod, zarazeno, vyrazeno, popis, trvanlivost  FROM polozky WHERE idTypu='"+kterou+"'");
		 //aktualizovat historii
       pocet = stmt.executeUpdate("UPDATE polozky SET idSkladu='"+idSkladu+"' WHERE id='"+kterou+"'");
     } catch(Exception e) {
         System.err.println("Vyjimka: " + e.getMessage());
       } 
     return pocet;
   }
  /* 
   public int vymazSklad(String nazev) {
   int pocet = 0;
     try {
       pocet = stmt.executeUpdate("DELETE FROM sklady WHERE nazev='"+nazev+"'");
     } catch(Exception e) {
         System.err.println("Vyjimka: " + e.getMessage());
       } 
     return pocet;
   }
	*/



   protected void finalize() throws Throwable {
     if(con != null) con.close();
   }



}
