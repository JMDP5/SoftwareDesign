/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.kontorler.menadzer;

import view.konroler.opstikontorler.OpstiKontroler;
import domen.OpstiDomenskiObjekat;
import domen.Radnik;
import domen.Zadatak;
import domen.Zaduzenje;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.TransferObjekatServer;
import util.Util;
import view.panel.zadatak.DodeljivanjeZadatkaPanel;

/**
 *
 * @author aleksandar
 */
public class ZaduzenjeKontroler extends OpstiKontroler {


    public ZaduzenjeKontroler() {
    }

    public ZaduzenjeKontroler(DodeljivanjeZadatkaPanel panel) {
        super();
        this.forma = panel;

    }

    public List<Radnik> vratiRadnike() throws IOException, ClassNotFoundException {
        List<Radnik> radnici;
        this.domenskiObjekat = new Radnik();
        TransferObjekatServer odgovor = pozoviSO(Util.PRONADJI_RADNIKE);
        radnici = (List<Radnik>) odgovor.getRezultat();

        return radnici;
    }

    public List<Zadatak> vratiZadatke() throws IOException, ClassNotFoundException {
        List<Zadatak> zadaci;
        this.domenskiObjekat = new Zadatak();
        TransferObjekatServer odgovor = pozoviSO(Util.PRONADJI_ZADATAKE);
        zadaci = (List<Zadatak>) odgovor.getRezultat();
        return zadaci;
    }

    public void sacuvajZaduzenje() throws IOException, ClassNotFoundException {
        this.domenskiObjekat = (Zaduzenje) kreirajObjekatIzGUI();
        TransferObjekatServer odgovor = pozoviSO(Util.KREIRAJ_ZADUZENJE);
        prikaziRezultatNaFormi(odgovor);
    }

    @Override
    public OpstiDomenskiObjekat kreirajObjekatIzGUI() {
        DodeljivanjeZadatkaPanel panel = (DodeljivanjeZadatkaPanel) forma;
        Zaduzenje z = new Zaduzenje();
        z.setZadatak((Zadatak) panel.getSelectedZadatak());
        z.setRadnik((Radnik) panel.getSelectedRadnik());
        z.setDatum(panel.getDatum());
        z.setNapomena(panel.getNapomena());
        return z;
    }

    @Override
    public void prikaziRezultatNaFormi(komunikacija.TransferObjekatServer transferObjekat) {
        DodeljivanjeZadatkaPanel panel = (DodeljivanjeZadatkaPanel) forma;
        JOptionPane.showMessageDialog(panel, transferObjekat.getPoruka());
    }

}
