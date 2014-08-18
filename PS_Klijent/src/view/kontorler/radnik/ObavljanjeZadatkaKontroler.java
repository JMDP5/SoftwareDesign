/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.kontorler.radnik;

import domen.OpstiDomenskiObjekat;
import domen.Radnik;
import domen.Zadatak;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.TransferObjekatServer;
import sesija.Sesija;
import util.Util;
import view.konroler.opstikontorler.OpstiKontroler;
import view.panel.radnik.ObavljanjeZadatkaPanel;

/**
 *
 * @author aleksandar
 */
public class ObavljanjeZadatkaKontroler extends OpstiKontroler {

    public ObavljanjeZadatkaKontroler() {
    }

    public ObavljanjeZadatkaKontroler(ObavljanjeZadatkaPanel panel) {
        super();
        this.forma = panel;
    }

    public List<Radnik> ucitajUlogovanogRadnika() throws IOException, ClassNotFoundException {
        this.domenskiObjekat = (OpstiDomenskiObjekat) Sesija.getInstance().getKorisnik();
        TransferObjekatServer odgovor = pozoviSO(Util.PRONADJI_RADNIKE);
        return (List<Radnik>) odgovor.getRezultat();
    }

    @Override
    public OpstiDomenskiObjekat kreirajObjekatIzGUI() {
        ObavljanjeZadatkaPanel panel = (ObavljanjeZadatkaPanel) forma;
        Zadatak z = panel.vratiTrenutniZadatak();
        return z;
    }

    @Override
    public void prikaziRezultatNaFormi(TransferObjekatServer transferObjekat) {
        ObavljanjeZadatkaPanel panel = (ObavljanjeZadatkaPanel) forma;
        JOptionPane.showMessageDialog(panel, transferObjekat.getPoruka());
    }

    public void sacuvajZadatak() throws IOException, ClassNotFoundException {
        this.domenskiObjekat = kreirajObjekatIzGUI();
        TransferObjekatServer odgovor = pozoviSO(Util.SACUVAJ_ZADATAK);
        prikaziRezultatNaFormi(odgovor);
    }
}
