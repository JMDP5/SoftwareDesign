/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author aleksandar
 */
public class Slika extends OpstiDomenskiObjekat implements Serializable {

    private static final long serialVersionUID = 522139L;
    private Zadatak zadatak;
    private int slikaId;
    private String naziv;
    private transient BufferedImage slika;
    private String putanjaDoSlike;
    private String opis;

    public Slika() {
    }

    public Slika(Zadatak zadatak, int slikaId, String naziv, String putanja, String opis) {
        this.zadatak = zadatak;
        this.slikaId = slikaId;
        this.naziv = naziv;
        this.putanjaDoSlike = putanja;
        this.opis = opis;
    }

    public Zadatak getZadatak() {
        return zadatak;
    }

    public void setZadatak(Zadatak zadatak) {
        this.zadatak = zadatak;
    }

    public int getId() {
        return slikaId;
    }

    public void setId(int id) {
        this.slikaId = id;
    }

    public BufferedImage getSlika() {
        if (slika == null) {
            try {
                slika = ImageIO.read(new File(putanjaDoSlike));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return slika;
    }

    public void setSlika(BufferedImage slika) {
        this.slika = slika;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String vratiNaziv() {
        return "slika";
    }

    @Override
    public String vratiVrednostiAtributaZaInsert() {
        return "('" + zadatak.getId() + "','" + slikaId + "','" + naziv + "','" + putanjaDoSlike + "','" + opis + "')";
    }

    @Override
    public String vratiAtributeZaInsert() {
        return "(zadatakid,slikaid,naziv,slikafajl,opis)";
    }

    @Override
    public String vratiVrednostiZaZapamti() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslov() {
        return "zadatakid=" + zadatak.getId();
    }

    @Override
    public String vratiUslovZaSelect() {
        if (zadatak != null && zadatak.getId() > 0) {
            return "zadatakid=" + zadatak.getId();
        }
        return "1";
    }

    @Override
    public List<OpstiDomenskiObjekat> popuniListuIzBaze(ResultSet rs) {
        List<OpstiDomenskiObjekat> slike = new ArrayList<>();
        try {
            while (rs.next()) {
                int zadatakid = rs.getInt("zadatakid");
                Zadatak z = new Zadatak();
                z.setID(zadatakid);
                int slikaid = rs.getInt("slikaid");
                String n = rs.getString("naziv");
                String putanja = rs.getString("slikafajl");
                String o = rs.getString("opis");
                slike.add(new Slika(z, slikaid, n, putanja, o));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return slike;

    }

    @Override
    public void setID(int id) {
        this.slikaId = id;
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "zadatakid";
    }

    @Override
    public int vratiBrojSlabihObjekata() {
        return 0;
    }

    @Override
    public OpstiDomenskiObjekat vratiPovezanObjekat(int i) {
        return null;
    }

    public int getSlikaId() {
        return slikaId;
    }

    public void setSlikaId(int slikaId) {
        this.slikaId = slikaId;
    }

    @Override
    public String toString() {
        return "Naziv: " + naziv;
    }

    public String getPutanjaDoSlike() {
        return putanjaDoSlike;
    }

    public void setPutanjaDoSlike(String putanjaDoSlike) {
        this.putanjaDoSlike = putanjaDoSlike;
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

}
