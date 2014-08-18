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
import java.util.List;

/**
 *
 * @author aleksandar
 */
public class Menadzer extends OpstiDomenskiObjekat implements Serializable, Korisnik {

    private static final long serialVersionUID = 71L;
    private int id;
    private String ime;
    private String prezime;
    private String obrazovanje;
    private int brojPodredjenih;
    private String korisnickoIme;
    private String lozinka;

    public Menadzer() {
    }

    public Menadzer(int id, String ime, String prezime, String obrazovanje, int brojPodredjenih, String korisnickoIme, String lozinka) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.obrazovanje = obrazovanje;
        this.brojPodredjenih = brojPodredjenih;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getObrazovanje() {
        return obrazovanje;
    }

    public void setObrazovanje(String obrazovanje) {
        this.obrazovanje = obrazovanje;
    }

    public int getBrojPodredjenih() {
        return brojPodredjenih;
    }

    public void setBrojPodredjenih(int brojPodredjenih) {
        this.brojPodredjenih = brojPodredjenih;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    @Override
    public String vratiNaziv() {
        return "menadzer";
    }

    @Override
    public String vratiVrednostiAtributaZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiAtributeZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiZaZapamti() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslov() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiPrimarniKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaSelect() {
        String uslov = "";
        if (id > 0) {
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

    @Override
    public List<OpstiDomenskiObjekat> popuniListuIzBaze(ResultSet rs) {
        List<OpstiDomenskiObjekat> menadzeri = new ArrayList<>();
        try {
            while (rs.next()) {
                int id = rs.getInt("menadzerid");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                String obrazovanje = rs.getString("obrazovanje");
                int brojPodredjenih = rs.getInt("brojpodredjenih");
                String korisnickoIme = rs.getString("korisnickoime");
                String lozinka = rs.getString("lozinka");

                menadzeri.add(new Menadzer(id, ime, prezime, obrazovanje, brojPodredjenih, korisnickoIme, lozinka));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return menadzeri;
    }

    @Override
    public void setID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int vratiBrojSlabihObjekata() {
        return 0;
    }

    @Override
    public OpstiDomenskiObjekat vratiPovezanObjekat(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int vratiBrojVeza() {
        return 0;
    }

    @Override
    public void dopuniPovezanAtribut(List<OpstiDomenskiObjekat> lista, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OpstiDomenskiObjekat vratiSlabObjekat(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int vratiIdKorisnika() {
        return getId();
    }

    @Override
    public String vratiImePrezimeKorisnika() {
        return getIme() + " " + getPrezime();
    }
}
