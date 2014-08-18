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
public class Mesto extends OpstiDomenskiObjekat implements Serializable {

    private static final long serialVersionUID = 29L;
    private int pttBroj;
    private String nazivMesta;

    public Mesto(int ptt, String naziv) {
        this.pttBroj = ptt;
        this.nazivMesta = naziv;
    }

    public Mesto(int pttBroj) {
        this.pttBroj = pttBroj;
    }

    public Mesto() {
    }

    public int getPttBroj() {
        return pttBroj;
    }

    public void setPttBroj(int pttBroj) {
        this.pttBroj = pttBroj;
    }

    public String getNazivMesta() {
        return nazivMesta;
    }

    public void setNazivMesta(String nazivMesta) {
        this.nazivMesta = nazivMesta;
    }

    @Override
    public String vratiNaziv() {
        return "mesto";
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
        return "pttbroj=" + pttBroj;

    }

    @Override
    public String vratiUslovZaSelect() {
        if (pttBroj > 0) {
            return "pttbroj=" + pttBroj;
        }
        return "1";
    }

    @Override
    public List<OpstiDomenskiObjekat> popuniListuIzBaze(ResultSet rs) {
        List<OpstiDomenskiObjekat> mesta = new ArrayList<>();
        try {
            while (rs.next()) {
                int ptt = rs.getInt("pttbroj");
                String naziv = rs.getString("nazivmesta");
                mesta.add(new Mesto(ptt, naziv));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return mesta;
    }

    @Override
    public void setID(int id) {
        this.pttBroj = id;
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "pttbroj";
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
    public String toString() {
        return pttBroj + " - " + nazivMesta;
    }

    @Override
    public int vratiBrojVeza() {
        return 0;
    }

    @Override
    public void dopuniPovezanAtribut(List<OpstiDomenskiObjekat> lista2, int i) {
        //Nema povezanih atributa.
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OpstiDomenskiObjekat vratiSlabObjekat(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
