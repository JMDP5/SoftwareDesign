/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.kontroler.logovanje;

import domen.Korisnik;
import domen.OpstiDomenskiObjekat;
import domen.Radnik;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.TransferObjekatServer;
import sesija.Sesija;
import util.Util;
import view.FLogovanje;
import view.FMenadzer;
import view.FRadnik;
import view.konroler.opstikontorler.OpstiKontroler;
import view.panel.opstaekranskaforma.OpstaEkranskaForma;

/**
 *
 * @author aleksandar
 */
public class LogovanjeKontroler extends OpstiKontroler {

    public LogovanjeKontroler() {
    }

    public LogovanjeKontroler(FLogovanje forma) {
        super();
        this.forma = (OpstaEkranskaForma) forma;
    }

    @Override
    public OpstiDomenskiObjekat kreirajObjekatIzGUI() {
        FLogovanje f = (FLogovanje) this.forma;
        return f.vratiTipPrijave();
    }

    @Override
    public void prikaziRezultatNaFormi(TransferObjekatServer transferObjekat) {
        FLogovanje panel = (FLogovanje) forma;
        String poruka = (String) transferObjekat.getPoruka();
        if (poruka != null && poruka.startsWith("Nije")) {
            JOptionPane.showMessageDialog(panel, transferObjekat.getPoruka());
        }
        if (transferObjekat.getRezultat() != null) {
            List<OpstiDomenskiObjekat> rez = (List<OpstiDomenskiObjekat>) transferObjekat.getRezultat();
            Korisnik k = (Korisnik) rez.get(0);
            Sesija.getInstance().setKorisnik(k);
            if (k instanceof Radnik) {
                new FRadnik().setVisible(true);
                JOptionPane.showMessageDialog(panel, "Uspesno ste se prijavili");
            } else {
                new FMenadzer().setVisible(true);
            }
            panel.dispose();
        }
    }

    public void prijaviKorisnika() throws IOException, ClassNotFoundException {
        this.domenskiObjekat = kreirajObjekatIzGUI();
        TransferObjekatServer odgovor = pozoviSO(Util.PRIJAVI_SE);
//        Sesija.getInstance().setKorisnik((Korisnik) odgovor.getRezultat());
        prikaziRezultatNaFormi(odgovor);
    }

}
