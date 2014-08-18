/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aleksandar
 */
public class Zaduzenje extends OpstiDomenskiObjekat implements Serializable {

    private static final long serialVersionUID = 56L;
    private Radnik radnik;
    private Zadatak zadatak;
    private Date datum;
    private String napomena;

    public Zaduzenje(Radnik radnik, Zadatak zadatak, Date datum, String napomena) {
        this.radnik = radnik;
        this.zadatak = zadatak;
        this.datum = datum;
        this.napomena = napomena;
    }

    public Zaduzenje() {
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    public Zadatak getZadatak() {
        return zadatak;
    }

    public void setZadatak(Zadatak zadatak) {
        this.zadatak = zadatak;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    @Override
    public String vratiNaziv() {
        return "zaduzenje";
    }

    @Override
    public String vratiVrednostiAtributaZaInsert() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return "('" + radnik.getRadnikID() + "','" + zadatak.getId() + "','" + df.format(datum) + "','" + napomena + "')";
    }

    @Override
    public String vratiAtributeZaInsert() {
        return "(radnikid,zadatakid,datumdodele,napomena)";
    }

    @Override
    public String vratiVrednostiZaZapamti() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return "radnikid='" + radnik.getRadnikID() + "',zadatakid='" + zadatak.getId()
                + "',datumdodele='" + df.format(datum) + "',napomena='" + napomena + "'";
    }

    @Override
    public String vratiUslov() {
        return "radnikid=" + radnik.getRadnikID() + " and zadatakid=" + zadatak.getId();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "radnikid";
    }

    @Override
    public String vratiUslovZaSelect() {
        if (radnik != null && radnik.getRadnikID() > 0) {
            return "radnikid=" + radnik.getRadnikID();
        }
        return "1";
    }

    @Override
    public List<OpstiDomenskiObjekat> popuniListuIzBaze(ResultSet rs) {
        List<OpstiDomenskiObjekat> zaduzenja = new ArrayList<>();
        try {
            while (rs.next()) {
                int idrad = rs.getInt("radnikid");
                int idzad = rs.getInt("zadatakid");
                Date datumDodele = rs.getDate("datumdodele");
                String nap = rs.getString("datumdodele");
                Radnik r = new Radnik();
                r.setID(idrad);
                Zadatak z = new Zadatak();
                z.setID(idzad);
                zaduzenja.add(new Zaduzenje(r, z, datumDodele, nap));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return zaduzenja;
    }

    @Override
    public void setID(int id) {
        //Nista ne radi.
    }

    @Override
    public String toString() {
        return "IdRadnika: " + radnik.getRadnikID() + " IdZadatka: " + zadatak.getId();
    }

    @Override
    public int vratiBrojSlabihObjekata() {
        return 0;
    }

    @Override
    public OpstiDomenskiObjekat vratiPovezanObjekat(int i) {
        if (i == 0) {
            Zadatak z = new Zadatak();
            z.setId(this.zadatak.getId());
            return z;
        }
        return null;
    }

    @Override
    public int vratiBrojVeza() {
        return 1;
    }

    @Override
    public void dopuniPovezanAtribut(List<OpstiDomenskiObjekat> lista, int i) {
        if (i == 0) {
            this.zadatak = (Zadatak) lista.get(0);
        }
    }

    @Override
    public OpstiDomenskiObjekat vratiSlabObjekat(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
