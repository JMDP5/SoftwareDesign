    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aleksandar
 */
public class Evidencija extends OpstiDomenskiObjekat implements Serializable {

    private static final long serialVersionUID = 2L;
    int id;
    Date datumKreiranja;
    String komentar;
    int ocena;
    Zadatak zadatak;
    Menadzer menadzer;

    public Evidencija(int id, Date datumKreiranja, String komentar, int ocena, Zadatak zadatak, Menadzer menadzer) {
        this.id = id;
        this.datumKreiranja = datumKreiranja;
        this.komentar = komentar;
        this.ocena = ocena;
        this.zadatak = zadatak;
        this.menadzer = menadzer;
    }

    public Evidencija() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Date datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public Zadatak getZadatak() {
        return zadatak;
    }

    public void setZadatak(Zadatak zadatak) {
        this.zadatak = zadatak;
    }

    public Menadzer getMenadzer() {
        return menadzer;
    }

    public void setMenadzer(Menadzer menadzer) {
        this.menadzer = menadzer;
    }

    @Override
    public String vratiNaziv() {
        return "evidencija";
    }

    @Override
    public String vratiVrednostiAtributaZaInsert() {
        return "('2014-06-06','" + komentar + "','" + ocena + "',null,null)";
    }

    @Override
    public String vratiAtributeZaInsert() {
        return "(datumkreiranja,komentar,ocena,zadatakid,menadzerid)";
    }

    @Override
    public String vratiVrednostiZaZapamti() {
         SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return "datumkreiranja='" + df.format(datumKreiranja) + "',komentar='" + komentar
                + "',ocena='" + ocena + "',zadatakid='" + zadatak.getId() + "',menadzerid='" + menadzer.getId() + "'";
    }

    @Override
    public String vratiUslov() {
        return "evidencijaid=" + id;
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "evidencijaid";
    }

    @Override
    public String vratiUslovZaSelect() {
        return "1";
    }

    @Override
    public List<OpstiDomenskiObjekat> popuniListuIzBaze(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setID(int id) {
        this.id = id;
    }

    @Override
    public int vratiBrojSlabihObjekata() {
        return 0;
    }

    @Override
    public OpstiDomenskiObjekat vratiPovezanObjekat(int i) {
        return null;
    }

    @Override
    public int vratiBrojVeza() {
        return 2;
    }

    @Override
    public void dopuniPovezanAtribut(List<OpstiDomenskiObjekat> lista2, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OpstiDomenskiObjekat vratiSlabObjekat(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
