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
public class KreirajNovuEvidencijuSO extends OpstaSistemskaOperacija {

    @Override
    public Object izvrsiSistemskuOperaciju(OpstiDomenskiObjekat domenskiObjekat) throws Exception {
        int id = broker.ubaciSlog(domenskiObjekat);
        porukaMetode = domenskiObjekat.vratiNaziv() + " uspesno kreirana!";
        return id;
    }

    @Override
    public void proveriPredusloveOperacije(OpstiDomenskiObjekat domenskiObjekat) throws Exception{

    }

}
