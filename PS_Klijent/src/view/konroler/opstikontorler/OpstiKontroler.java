/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.konroler.opstikontorler;

import domen.OpstiDomenskiObjekat;
import java.io.IOException;
import komunikacija.Komunikacija;
import komunikacija.TransferObjekatKlijent;
import komunikacija.TransferObjekatServer;
import view.panel.opstaekranskaforma.OpstaEkranskaForma;

/**
 *
 * @author aleksandar
 */
public abstract class OpstiKontroler {

    protected OpstiDomenskiObjekat domenskiObjekat;
    protected OpstaEkranskaForma forma;

    public OpstiKontroler() {
    }

    protected TransferObjekatServer pozoviSO(int operacija) throws IOException, ClassNotFoundException {
        TransferObjekatKlijent transfer = new TransferObjekatKlijent(operacija, domenskiObjekat);
        Komunikacija.getInstance().posalji(transfer);
        TransferObjekatServer odgovor = Komunikacija.getInstance().primi();
        return odgovor;

    }

    public OpstiDomenskiObjekat vratiOpstiDomenskiObjekat() {
        return domenskiObjekat;
    }

    public abstract OpstiDomenskiObjekat kreirajObjekatIzGUI();

    public abstract void prikaziRezultatNaFormi(TransferObjekatServer transferObjekat);
}
