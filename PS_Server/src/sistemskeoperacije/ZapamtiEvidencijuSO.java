/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemskeoperacije;

import domen.Evidencija;
import domen.OpstiDomenskiObjekat;
import domen.Zadatak;

/**
 *
 * @author aleksandar
 */
public class ZapamtiEvidencijuSO extends OpstaSistemskaOperacija {

    @Override
    public Object izvrsiSistemskuOperaciju(OpstiDomenskiObjekat domenskiObjekat) throws Exception {
        broker.zapamti(domenskiObjekat);
        porukaMetode = domenskiObjekat.vratiNaziv() + " sacuvana!";
        return null;
    }

    @Override
    public void proveriPredusloveOperacije(OpstiDomenskiObjekat domenskiObjekat) throws Exception {
        Evidencija e = (Evidencija) domenskiObjekat;
        if (e.getId() <= 0) {
            throw new Exception("Preduslovi operacije nisu zadovoljeni! Pokusajte ponovo!");
        }

    }

}
