/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemskeoperacije;

import domen.OpstiDomenskiObjekat;
import java.util.List;
import static sistemskeoperacije.OpstaSistemskaOperacija.broker;

/**
 *
 * @author aleksandar
 */
public class PronadjiRadnikeSO extends OpstaSistemskaOperacija {

    @Override
    public Object izvrsiSistemskuOperaciju(OpstiDomenskiObjekat domenskiObjekat) throws Exception {
        List<OpstiDomenskiObjekat> lista = broker.pretrazi(domenskiObjekat);
        if (lista.size() >= 1) {
            porukaMetode = "Pretraga uspesna!";
        } else {
            porukaMetode = "Nije nadjen " + domenskiObjekat.vratiNaziv() + " po unetim kriterijumima!";
        }
        return (Object) lista;
    }

    @Override
    public void proveriPredusloveOperacije(OpstiDomenskiObjekat domenskiObjekat) throws Exception {

    }

 
}
