/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.kontorler.menadzer;

import domen.OpstiDomenskiObjekat;
import domen.Zadatak;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import komunikacija.TransferObjekatServer;
import util.Util;
import view.konroler.opstikontorler.OpstiKontroler;
import view.panel.zadatak.UnosZadatkaPanel;

/**
 *
 * @author aleksandar
 */
public class UnosZadatkaKontroler extends OpstiKontroler {

    public UnosZadatkaKontroler() {
    }

    public UnosZadatkaKontroler(UnosZadatkaPanel panel) {
        super();
        this.forma = panel;
    }

    public void kreirajNoviZadatak() throws IOException, ClassNotFoundException {
        this.domenskiObjekat = new Zadatak();
        TransferObjekatServer odgovor = pozoviSO(Util.KREIRAJ_ZADATAK);
        prikaziRezultatNaFormi(odgovor);
    }

    public void sacuvajZadatak() throws IOException, ClassNotFoundException {
        this.domenskiObjekat = kreirajObjekatIzGUI();
        TransferObjekatServer odgovor = pozoviSO(Util.ZAPAMTI_ZADATAK);
        prikaziRezultatNaFormi(odgovor);
    }

    private void resetujSvaPolja() {
        UnosZadatkaPanel panel = (UnosZadatkaPanel) forma;
        panel.resetujSvaPolja();
    }

    @Override
    public OpstiDomenskiObjekat kreirajObjekatIzGUI() {
        UnosZadatkaPanel panel = (UnosZadatkaPanel) forma;
        int id = Integer.parseInt(panel.getIdTextField());
        Zadatak zadatak = new Zadatak();
        zadatak.setID(id);
        zadatak.setNaziv(panel.getNazivZadatka());
        zadatak.setRok(vratiRokDate(panel.getRok()));
        zadatak.setStatus(panel.getStatus());
        zadatak.setOpis(panel.getOpis());
        zadatak.setNoveSlike(panel.getModel().getSlike());
        return zadatak;
    }

    @Override
    public void prikaziRezultatNaFormi(komunikacija.TransferObjekatServer transferObjekat) {
        resetujSvaPolja();
        UnosZadatkaPanel panel = (UnosZadatkaPanel) forma;

        Object rez = transferObjekat.getRezultat();
        if (rez != null) {
            try {
                int r = (int) rez;
                panel.setId(String.valueOf(r));
                domenskiObjekat.setID(r);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        JOptionPane.showMessageDialog(panel, transferObjekat.getPoruka());

    }

    private Date vratiRokDate(String rok) {
        Date d = null;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            d = df.parse(rok);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return d;
    }

}
