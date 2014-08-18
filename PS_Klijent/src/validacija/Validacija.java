/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validacija;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author aleksandar
 */
public class Validacija {

    public static boolean daLiSuSvaPopunjena(String... strings) {
        for (String st : strings) {
            if (st == null || st.equals("")) {
                return false;
            }

        }
        return true;
    }

    public static boolean datumFormatOk(String sDate) {
        Date d = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            d = df.parse(sDate);
        } catch (ParseException ex) {
            return false;
        }
        return true;

    }

    public static boolean datumVeciOdDanas(String sDate) {
        Date danas = new Date();
        Date d = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            d = df.parse(sDate);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return !d.before(danas);
    }

    public static boolean datumVeciOdDanas(Date d) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return datumVeciOdDanas(df.format(d));

    }

    public static boolean formatBrojaOK(String ocena) {
        try {
            int a = Integer.parseInt(ocena);
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
        return true;
    }
}
