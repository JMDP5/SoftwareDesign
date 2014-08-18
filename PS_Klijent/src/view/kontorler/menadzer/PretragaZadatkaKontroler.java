/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.kontorler.menadzer;

import view.konroler.opstikontorler.OpstiKontroler;
import domen.OpstiDomenskiObjekat;
import domen.Zadatak;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.TransferObjekatServer;
import util.Util;
import view.panel.zadatak.PretragaZadatakaPanel;

/**
 *
 * @author aleksandar
 */
public class PretragaZadatkaKontroler extends OpstiKontroler {

    public PretragaZadatkaKontroler() {
    }

    public PretragaZadatkaKontroler(PretragaZadatakaPanel panel) {
        super();
        this.forma = panel;
    }

    public void pretraziZadatke() throws IOException, ClassNotFoundException {
        this.domenskiObjekat = kreirajObjekatIzGUI();
        TransferObjekatServer odgovor = pozoviSO(Util.PRONADJI_ZADATAKE);
        prikaziRezultatNaFormi(odgovor);
    }

    @Override
    public OpstiDomenskiObjekat kreirajObjekatIzGUI() {
        Zadatak zadatak = new Zadatak();
        PretragaZadatakaPanel panel = (PretragaZadatakaPanel) this.forma;
        zadatak.setId(Integer.parseInt(panel.getID()));
        zadatak.setNaziv(panel.getNaziv());
        zadatak.setRok(panel.getRok());
        zadatak.setStatus(panel.getStatus());
        return zadatak;
    }

    @Override
    public void prikaziRezultatNaFormi(komunikacija.TransferObjekatServer transferObjekat) {
        PretragaZadatakaPanel panel = (PretragaZadatakaPanel) forma;
        JOptionPane.showMessageDialog(panel, transferObjekat.getPoruka());
        panel.dodajUTabelu((List<Zadatak>) transferObjekat.getRezultat());
    }

}
