/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aleksandar
 */
public class Radnik extends OpstiDomenskiObjekat implements Serializable, Korisnik {

    private static final long serialVersionUID = 752L;
    private int radnikID;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String lozinka;
    private Mesto mesto;
    private List<Zaduzenje> zaduzenja;

    public Radnik() {
        this.zaduzenja = new ArrayList<>();
    }

    public Radnik(int radnikID, String ime, String prezime, String korisnickoIme, String lozinka, Mesto mesto, List<Zaduzenje> zaduzenje) {
        this.radnikID = radnikID;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.mesto = mesto;
        this.zaduzenja = zaduzenje;
    }

    public int getRadnikID() {
        return radnikID;
    }

    public void setRadnikID(int radnikID) {
        this.radnikID = radnikID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public List<Zaduzenje> getZaduzenje() {
        return zaduzenja;
    }

    public void setZaduzenje(List<Zaduzenje> zaduzenje) {
        this.zaduzenja = zaduzenje;
    }

    @Override
    public String vratiNaziv() {
        return "radnik";
    }

    @Override
    public String vratiVrednostiAtributaZaInsert() {
        return "('" + ime + "','" + prezime + "','" + korisnickoIme + "','" + lozinka + "','" + mesto.getPttBroj() + "')";
    }

    @Override
    public String vratiAtributeZaInsert() {
        return "(ime,prezime,korisnickoime,lozinka,pttbroj)";
    }

    @Override
    public String vratiVrednostiZaZapamti() {
        return "ime='" + ime + "',prezime='" + prezime
                + "',korisnickoime='" + korisnickoIme + "',lozinka='" + lozinka + "',pttbroj='" + mesto.getPttBroj() + "'";
    }

    @Override
    public String vratiUslov() {
        return "radnikid=" + radnikID;
    }

    @Override
    public String vratiUslovZaSelect() {
        String uslov = "";
        if (radnikID > 0) {
            uslov += vratiUslov();
        }
        if (ime != null && !ime.isEmpty()) {
            if (!uslov.isEmpty()) {
                uslov += " AND ";
            }
            uslov += "ime='" + ime + "'";
        }
        if (korisnickoIme != null && !korisnickoIme.isEmpty()) {
            if (!uslov.isEmpty()) {
                uslov += " AND ";
            }
            uslov += "korisnickoime='" + korisnickoIme + "'";
        }

        if (lozinka != null && !lozinka.isEmpty()) {
            if (!uslov.isEmpty()) {
                uslov += " AND ";
            }
            uslov += "lozinka='" + lozinka + "'";
        }
        if (uslov.isEmpty()) {
            uslov = "1";
        }
        return uslov;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    @Override
    public List<OpstiDomenskiObjekat> popuniListuIzBaze(ResultSet rs) {
        List<OpstiDomenskiObjekat> radnici = new ArrayList<>();
        try {
            while (rs.next()) {
                int id = rs.getInt("radnikid");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                String korisnickoIme = rs.getString("korisnickoime");
                String lozinka = rs.getString("lozinka");

                int pttBroj = rs.getInt("pttbroj");

                radnici.add(new Radnik(id, ime, prezime, korisnickoIme, lozinka, new Mesto(pttBroj), new ArrayList<Zaduzenje>()));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return radnici;
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "radnikid";
    }

    @Override
    public void setID(int id) {
        this.radnikID = id;
    }

    @Override
    public String toString() {
        return "ID: " + radnikID + " Ime: " + ime + " Prezime: " + prezime;
    }

    @Override
    public int vratiBrojSlabihObjekata() {
        return 0;
    }

    @Override
    public OpstiDomenskiObjekat vratiPovezanObjekat(int i) {
        switch (i) {
            case 0:
                Mesto m = new Mesto();
                m.setPttBroj(mesto.getPttBroj());
                return m;

            case 1:
                Zaduzenje z = new Zaduzenje();
                z.setRadnik(this);
                return z;
        }

        return null;
    }

    @Override
    public int vratiBrojVeza() {
        return 2;
    }

    @Override
    public void dopuniPovezanAtribut(List<OpstiDomenskiObjekat> lista, int i) {
        if (i == 0) {
            mesto = (Mesto) lista.get(0);
        } else if (i == 1) {
            for (OpstiDomenskiObjekat opstiDomenskiObjekat : lista) {
                zaduzenja.add((Zaduzenje) opstiDomenskiObjekat);
            }
        }
    }

    @Override
    public OpstiDomenskiObjekat vratiSlabObjekat(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int vratiIdKorisnika() {
        return getRadnikID();
    }

    @Override
    public String vratiImePrezimeKorisnika() {
        return getIme() + " " + getPrezime();
    }

}
