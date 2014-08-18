/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.kontorler.radnik;

import domen.OpstiDomenskiObjekat;
import domen.Radnik;
import domen.Slika;
import domen.Zadatak;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.TransferObjekatServer;
import sesija.Sesija;
import util.Util;
import validacija.Validacija;
import view.konroler.opstikontorler.OpstiKontroler;
import view.panel.radnik.PredavanjeZadatkaPanel;

/**
 *
 * @author aleksandar
 */
public class PredavanjeZadatkaKontroler extends OpstiKontroler {

    public PredavanjeZadatkaKontroler() {
    }

    public PredavanjeZadatkaKontroler(PredavanjeZadatkaPanel panel) {
        super();
        this.forma = panel;
    }

    @Override
    public OpstiDomenskiObjekat kreirajObjekatIzGUI() {
        PredavanjeZadatkaPanel p = (PredavanjeZadatkaPanel) forma;
        Zadatak z = (Zadatak) p.vratiTrenutniZadatak();
        if (!Validacija.datumVeciOdDanas(z.getRok())) {
            z.setStatus("zavrsen - Sa zakasnjenjem");
        } else {
            z.setStatus("zavrsen - Na vreme");
        }

        // ****** Izbrisi ovo kasnije kad proradi!
        z.setNoveSlike(new ArrayList<Slika>());
        System.out.println("Nove slike size: " + z.getNoveSlike().size());
        return z;
    }

    @Override
    public void prikaziRezultatNaFormi(TransferObjekatServer transferObjekat) {
        PredavanjeZadatkaPanel p = (PredavanjeZadatkaPanel) forma;
        JOptionPane.showMessageDialog(p, transferObjekat.getPoruka());
    }

    public List<Radnik> ucitajUlogovanogRadnika() throws IOException, ClassNotFoundException {
        this.domenskiObjekat = (OpstiDomenskiObjekat) Sesija.getInstance().getKorisnik();
        TransferObjekatServer odgovor = pozoviSO(Util.PRONADJI_RADNIKE);
        return (List<Radnik>) odgovor.getRezultat();
    }

    public void predajZadatak() throws IOException, ClassNotFoundException {
        this.domenskiObjekat = kreirajObjekatIzGUI();
        TransferObjekatServer odgovor = pozoviSO(Util.PREDAJ_ZADATAK);
        prikaziRezultatNaFormi(odgovor);
    }

}
