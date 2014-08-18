
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
public class Zadatak extends OpstiDomenskiObjekat implements Serializable {

    private static final long serialVersionUID = 74725271747L;
    private int id;
    private String naziv;
    private Date rok;
    private String status;
    private String opis;
    private List<Slika> slikeUBazi;
    private List<Slika> noveSlike;
    List<Zaduzenje> zaduzenje;

    public Zadatak() {
        this.slikeUBazi = new ArrayList<>();
        this.noveSlike = new ArrayList<>();
        this.zaduzenje = new ArrayList<>();
        rok = new Date();
    }

    public Zadatak(int id, String naziv, Date rok, String status, String opis, List<Slika> slikeUBazi, List<Slika> noveSlike, List<Zaduzenje> zaduzenje) {
        this.id = id;
        this.naziv = naziv;
        this.rok = rok;
        this.status = status;
        this.opis = opis;
        this.slikeUBazi = slikeUBazi;
        this.noveSlike = noveSlike;
        this.zaduzenje = zaduzenje;
    }

    public List<Zaduzenje> getZaduzenje() {
        return zaduzenje;
    }

    public void setZaduzenje(List<Zaduzenje> zaduzenje) {
        this.zaduzenje = zaduzenje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Date getRok() {
        return rok;
    }

    public void setRok(Date rok) {
        this.rok = rok;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public List<Slika> getSlikeUBazi() {
        return slikeUBazi;
    }

    public void setSlikeUBazi(List<Slika> slikeUBazi) {
        this.slikeUBazi = slikeUBazi;
    }

    public List<Slika> getNoveSlike() {
        return noveSlike;
    }

    public void setNoveSlike(List<Slika> noveSlike) {
        this.noveSlike = noveSlike;
    }

    @Override
    public String vratiNaziv() {
        return "zadatak";
    }

    @Override
    public String vratiVrednostiAtributaZaInsert() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return "('" + naziv + "','" + df.format(rok) + "','" + status + "','" + opis + "')";
    }

    @Override
    public String vratiAtributeZaInsert() {
        return "(nazivzadatka,rokzaizvrsenje,status,opis)";
    }

    @Override
    public String vratiVrednostiZaZapamti() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return "nazivzadatka='" + naziv + "',rokzaizvrsenje='" + df.format(this.rok)
                + "',status='" + status + "',opis='" + opis + "'";
    }

    @Override
    public String vratiUslov() {
        return "zadatakid=" + id;
    }

    @Override
    public String vratiUslovZaSelect() {

        String uslov = "";
        if (id > 0) {
            uslov += vratiUslov();
        }
        if (naziv != null && !naziv.isEmpty()) {
            if (!uslov.isEmpty()) {
                uslov += " AND ";
            }
            uslov += "nazivzadatka='" + naziv + "'";
        }
        if (this.status != null && !this.status.isEmpty()) {
            if (!uslov.isEmpty()) {
                uslov += " AND ";
            }
            uslov += "status='" + status + "'";
        }
        if (uslov.isEmpty()) {
            uslov = "1";
        }
        return uslov;
    }

    @Override
    public List<OpstiDomenskiObjekat> popuniListuIzBaze(ResultSet rs) {
        List<OpstiDomenskiObjekat> zadaci = new ArrayList<>();
        try {
            while (rs.next()) {
                int id = rs.getInt("zadatakid");
                String naziv = rs.getString("nazivzadatka");
                Date rok = rs.getDate("rokzaizvrsenje");
                String status = rs.getString("status");
                String opis = rs.getString("opis");
                zadaci.add(new Zadatak(id, naziv, rok, status, opis, new ArrayList<Slika>(), new ArrayList<Slika>(), new ArrayList<Zaduzenje>()));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return zadaci;
    }

    @Override
    public void setID(int id) {
        this.id = id;
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "zadatakid";
    }

    @Override
    public String toString() {
        return "ID: " + id + " Naziv:" + naziv;
    }

    @Override
    public int vratiBrojSlabihObjekata() {
        return noveSlike.size();
    }

    @Override
    public OpstiDomenskiObjekat vratiPovezanObjekat(int i) {
        if (i == 0) {
            Slika s = new Slika();
            s.setZadatak(this);
            return s;
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
            for (OpstiDomenskiObjekat opstiDomenskiObjekat : lista) {
                slikeUBazi.add((Slika) opstiDomenskiObjekat);
            }
        }

    }

    @Override
    public OpstiDomenskiObjekat vratiSlabObjekat(int i) {
        return noveSlike.get(i);
    }
    
    public int vratiKljucZaSliku() {
        return slikeUBazi.size() + noveSlike.size() + 1;
    }

}
