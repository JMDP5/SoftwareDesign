/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemskeoperacije;

import domen.OpstiDomenskiObjekat;
import domen.Zaduzenje;

/**
 *
 * @author aleksandar
 */
public class KreirajNovoZaduzenjeSO extends OpstaSistemskaOperacija {

    @Override
    public Object izvrsiSistemskuOperaciju(OpstiDomenskiObjekat domenskiObjekat) throws Exception {
        int id = broker.ubaciSlog(domenskiObjekat);
        porukaMetode = domenskiObjekat.vratiNaziv() + " uspesno kreirano!";
        return id;
    }

    @Override
    public void proveriPredusloveOperacije(OpstiDomenskiObjekat domenskiObjekat) throws Exception {
        Zaduzenje z = (Zaduzenje) domenskiObjekat;
        if (z.getRadnik().getRadnikID() <= 0 || z.getZadatak().getId() <= 0) {
            throw new Exception("Preduslovi operacije nisu zadovoljeni! Pokusajte ponovo!");
        }

    }

}
