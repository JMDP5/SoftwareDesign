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
import view.panel.zadatak.IzmenaBrisanjeZadatakaPanel;

/**
 *
 * @author aleksandar
 */
public class IzmenaBrisanjeKontroler extends OpstiKontroler {

    public IzmenaBrisanjeKontroler() {
    }

    public IzmenaBrisanjeKontroler(IzmenaBrisanjeZadatakaPanel panel) {
        super();
        this.forma = panel;
    }

    public void pretraziZadatke() throws IOException, ClassNotFoundException {
        this.domenskiObjekat = kreirajObjekatIzGUI();
        String operacija = "pretrazi";
        TransferObjekatServer odgovor = pozoviSO(Util.PRONADJI_ZADATAKE);
        prikaziRezultatNaFormi(odgovor);
    }

    public void obrisiZadatak(Zadatak z) throws IOException, ClassNotFoundException {
        domenskiObjekat = new Zadatak();
        this.domenskiObjekat = z;
        TransferObjekatServer odgovor = pozoviSO(Util.OBRISI_ZADATAK);
        prikaziRezultatNaFormi(odgovor);
    }

    public void izmeniZadatak(Zadatak z) throws IOException, ClassNotFoundException {
        //Ovo ne radi, mora new!!
        domenskiObjekat = new Zadatak();
        this.domenskiObjekat = z;
        TransferObjekatServer odgovor = pozoviSO(Util.IZMENI_ZADATAK);
        prikaziRezultatNaFormi(odgovor);
    }

    @Override
    public OpstiDomenskiObjekat kreirajObjekatIzGUI() {
        Zadatak zadatak = new Zadatak();
        IzmenaBrisanjeZadatakaPanel panel = (IzmenaBrisanjeZadatakaPanel) forma;
        zadatak.setNaziv(panel.getNaziv());
        //DODAJ OVDE OSTALE PARAMETRE ZA PRETRAGU!!!
        return zadatak;
    }

    @Override
    public void prikaziRezultatNaFormi(komunikacija.TransferObjekatServer transferObjekat) {
        IzmenaBrisanjeZadatakaPanel panel = (IzmenaBrisanjeZadatakaPanel) forma;
        JOptionPane.showMessageDialog(panel, transferObjekat.getPoruka());
        panel.dodajUTabelu((List<Zadatak>) transferObjekat.getRezultat());
    }

}
