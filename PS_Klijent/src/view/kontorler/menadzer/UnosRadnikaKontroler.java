/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.kontorler.menadzer;

import view.konroler.opstikontorler.OpstiKontroler;
import domen.Radnik;
import domen.Mesto;
import domen.OpstiDomenskiObjekat;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.TransferObjekatServer;
import util.Util;
import view.panel.radnik.UnosRadnikaPanel;

/**
 *
 * @author aleksandar
 */
public class UnosRadnikaKontroler extends OpstiKontroler {

    public UnosRadnikaKontroler() {
    }

    public UnosRadnikaKontroler(UnosRadnikaPanel unosPanel) {
        super();
        this.forma = unosPanel;
    }

    public void kreirajNovogRadnika() throws IOException, ClassNotFoundException {
        Radnik r = new Radnik();
        r.setMesto(new Mesto(1, "Beograd"));
        this.domenskiObjekat = r;
        TransferObjekatServer odgovor = pozoviSO(Util.KREIRAJ_RADNIKA);
        prikaziRezultatNaFormi(odgovor);
    }

    public void zapamtiRadnika() throws IOException, ClassNotFoundException {
        this.domenskiObjekat = kreirajObjekatIzGUI();
        TransferObjekatServer odgovor = pozoviSO(Util.ZAPAMTI_RADNIKA);
        prikaziRezultatNaFormi(odgovor);
        resetujSvaPolja();
    }

    private void resetujSvaPolja() {
        UnosRadnikaPanel panel = (UnosRadnikaPanel) forma;
        panel.resetujSvaPolja();
    }

    @Override
    public OpstiDomenskiObjekat kreirajObjekatIzGUI() {
        UnosRadnikaPanel panel = (UnosRadnikaPanel) forma;
        Radnik radnik = new Radnik();
        radnik.setMesto(panel.getMesto());
        radnik.setID(Integer.parseInt(panel.getId()));
        radnik.setIme(panel.getIme());
        radnik.setPrezime(panel.getPrezime());
        radnik.setKorisnickoIme(panel.getKorisnickoIme());
        radnik.setLozinka(panel.getLozinka());
        return radnik;
    }

    @Override
    public void prikaziRezultatNaFormi(komunikacija.TransferObjekatServer transferObjekat) {
        UnosRadnikaPanel panel = (UnosRadnikaPanel) forma;
        Object rez = transferObjekat.getRezultat();
        if (rez != null) {
            try {
                int r = (int) rez;
                panel.setIdTextField(String.valueOf(r));
                domenskiObjekat.setID(r);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        JOptionPane.showMessageDialog(panel, transferObjekat.getPoruka());
    }

    public List<Mesto> vratiMesta() throws IOException, ClassNotFoundException {
        List<Mesto> mesta = null;
        this.domenskiObjekat = new Mesto();
        TransferObjekatServer odgovor = pozoviSO(Util.PRONADJI_MESTA);
        mesta = (List<Mesto>) odgovor.getRezultat();
        return mesta;
    }

    public boolean daLiJeKorisnickoImeJedinstveno(String text) throws IOException, ClassNotFoundException {
        Radnik r = new Radnik();
        r.setKorisnickoIme(text);
        this.domenskiObjekat = r;
        TransferObjekatServer odg = pozoviSO(Util.PRONADJI_RADNIKE);
        List<Radnik> radnici = (List<Radnik>) odg.getRezultat();
        if (radnici.size() > 0) {
            return false;
        }
        return true;
    }
}
