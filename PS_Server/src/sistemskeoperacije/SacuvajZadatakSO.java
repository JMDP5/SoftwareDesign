/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemskeoperacije;

import domen.OpstiDomenskiObjekat;
import domen.Zadatak;

/**
 *
 * @author aleksandar
 */
public class SacuvajZadatakSO extends OpstaSistemskaOperacija {

    @Override
    public Object izvrsiSistemskuOperaciju(OpstiDomenskiObjekat domenskiObjekat) throws Exception {
        broker.zapamti(domenskiObjekat);
        porukaMetode = domenskiObjekat.vratiNaziv() + " sacuvan!";
        return null;
    }

    @Override
    public void proveriPredusloveOperacije(OpstiDomenskiObjekat domenskiObjekat) throws Exception {
        Zadatak z = (Zadatak) domenskiObjekat;
        if (z.getId() <= 0 || z.getNaziv() == null || z.getNaziv().isEmpty()
                || z.getStatus() == null || z.getStatus().isEmpty()) {
            throw new Exception("Preduslovi operacije nisu zadovoljeni! Pokusajte ponovo!");
        }
    }

}
