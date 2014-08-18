/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemskeoperacije;

import domen.OpstiDomenskiObjekat;
import domen.Radnik;

/**
 *
 * @author aleksandar
 */
public class ZapamtiRadnikaSO extends OpstaSistemskaOperacija {

    @Override
    public Object izvrsiSistemskuOperaciju(OpstiDomenskiObjekat domenskiObjekat) throws Exception {
        broker.zapamti(domenskiObjekat);
        porukaMetode = domenskiObjekat.vratiNaziv() + " sacuvan!";
        return null;
    }

    @Override
    public void proveriPredusloveOperacije(OpstiDomenskiObjekat domenskiObjekat) throws Exception {
        Radnik r = (Radnik) domenskiObjekat;
        if (r.getRadnikID() <= 0 || r.getKorisnickoIme() == null || r.getKorisnickoIme().isEmpty()
                || r.getLozinka() == null || r.getLozinka().isEmpty()) {
            throw new Exception("Preduslovi operacije nisu zadovoljeni! Pokusajte ponovo!");
        }

    }

}
