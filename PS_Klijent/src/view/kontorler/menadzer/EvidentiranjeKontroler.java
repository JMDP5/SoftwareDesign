 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.kontorler.menadzer;

import domen.Evidencija;
import domen.Menadzer;
import domen.OpstiDomenskiObjekat;
import domen.Zadatak;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.TransferObjekatServer;
import sesija.Sesija;
import util.Util;
import view.konroler.opstikontorler.OpstiKontroler;
import view.panel.zadatak.EvidentiranjePanel;

/**
 *
 * @author aleksandar
 */
public class EvidentiranjeKontroler extends OpstiKontroler {

    public EvidentiranjeKontroler() {
    }

    public EvidentiranjeKontroler(EvidentiranjePanel panel) {
        super();
        forma = panel;
    }

    public List<Zadatak> vratiZadatke() throws IOException, ClassNotFoundException {
        List<Zadatak> zadaci;
        Zadatak z = new Zadatak();
        this.domenskiObjekat = z;
        TransferObjekatServer odgovor = pozoviSO(Util.PRONADJI_ZADATAKE);
        zadaci = vratiZavrsene((List<Zadatak>) odgovor.getRezultat());
        return zadaci;
    }

    public void kreirajNovuEvidenciju() throws IOException, ClassNotFoundException {
        Evidencija evidencija = new Evidencija();
        this.domenskiObjekat = evidencija;
        TransferObjekatServer odgovor = pozoviSO(Util.KREIRAJ_EVIDENCIJU);
        prikaziRezultatNaFormi(odgovor);
    }

    public void sacuvajEvidenciju() throws IOException, ClassNotFoundException {
        this.domenskiObjekat = kreirajObjekatIzGUI();
        TransferObjekatServer odgovor = pozoviSO(Util.ZAPAMTI_EVIDENCIJU);
        prikaziRezultatNaFormi(odgovor);
    }

    @Override
    public OpstiDomenskiObjekat kreirajObjekatIzGUI() {
        EvidentiranjePanel panel = (EvidentiranjePanel) forma;
        Evidencija evidencija = new Evidencija();
        evidencija.setId(Integer.parseInt(panel.getID()));
        evidencija.setZadatak((Zadatak) panel.getSelectedZadatak());
        evidencija.setMenadzer((Menadzer) Sesija.getInstance().getKorisnik());
        evidencija.setDatumKreiranja(panel.getDatum());
        evidencija.setKomentar(panel.getKomentar());
        evidencija.setOcena(Integer.parseInt(panel.getOcena()));
        return evidencija;
    }

    @Override
    public void prikaziRezultatNaFormi(komunikacija.TransferObjekatServer transferObjekat) {
        EvidentiranjePanel panel = (EvidentiranjePanel) forma;

        Object rez = transferObjekat.getRezultat();
        if (rez != null) {
            try {
                panel.setID(String.valueOf((int) transferObjekat.getRezultat()));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        JOptionPane.showMessageDialog(panel, transferObjekat.getPoruka());

    }

    private List<Zadatak> vratiZavrsene(List<Zadatak> list) {
        List<Zadatak> zavrseni = new ArrayList<>();
        for (Zadatak zadatak : list) {
            if (zadatak.getStatus().startsWith("z")) {
                zavrseni.add(zadatak);
            }
        }
        return zavrseni;
    }

}
