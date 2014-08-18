/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemskeoperacije;

import domen.OpstiDomenskiObjekat;

/**
 *
 * @author aleksandar
 */
public class PredajZadatakSO extends OpstaSistemskaOperacija {

    @Override
    public Object izvrsiSistemskuOperaciju(OpstiDomenskiObjekat domenskiObjekat) throws Exception {
        broker.zapamti(domenskiObjekat);
        porukaMetode = domenskiObjekat.vratiNaziv() + " sacuvan kao zavrsen!";
        return null;
    }

    @Override
    public void proveriPredusloveOperacije(OpstiDomenskiObjekat domenskiObjekat) throws Exception {

    }

}
