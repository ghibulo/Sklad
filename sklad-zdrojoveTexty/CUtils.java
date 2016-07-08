/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sklad;

import java.util.*;
import java.text.*;
/**
 *
 * @author jaih
 */
public class CUtils {

public static String now(String dateFormat) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(cal.getTime());
}

public static String ftos(double cislo) {
    DecimalFormatSymbols s = new DecimalFormatSymbols();
    s.setDecimalSeparator('.');
    DecimalFormat f = new DecimalFormat("####0.0#",s);
    return f.format(cislo);
}








}
