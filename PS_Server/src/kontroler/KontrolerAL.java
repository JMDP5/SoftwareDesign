/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import komunikacija.TransferObjekatKlijent;
import komunikacija.TransferObjekatServer;
import sistemskeoperacije.IzmeniZadatakSO;
import sistemskeoperacije.KreirajNoviZadatakSO;
import sistemskeoperacije.KreirajNovoZaduzenjeSO;
import sistemskeoperacije.KreirajNovogRadnikaSO;
import sistemskeoperacije.KreirajNovuEvidencijuSO;
import sistemskeoperacije.ObrisiZadatakSO;
import sistemskeoperacije.OpstaSistemskaOperacija;
import sistemskeoperacije.PredajZadatakSO;
import sistemskeoperacije.PrijaviSeSO;
import sistemskeoperacije.PronadjiMestaSO;
import sistemskeoperacije.PronadjiRadnikeSO;
import sistemskeoperacije.PronadjiZadatkeSO;
import sistemskeoperacije.SacuvajZadatakSO;
import sistemskeoperacije.ZapamtiEvidencijuSO;
import sistemskeoperacije.ZapamtiRadnikaSO;
import sistemskeoperacije.ZapamtiZadatakSO;

/**
 *
 * @author aleksandar
 */
public class KontrolerAL {

    private static KontrolerAL instance;
    private OpstaSistemskaOperacija sistemskaOperacija;

    private KontrolerAL() {

    }

    public static KontrolerAL getInstance() {
        if (instance == null) {
            instance = new KontrolerAL();
        }
        return instance;
    }

    public TransferObjekatServer kreirajNovogRadnika(TransferObjekatKlijent primljenObjekat) {
        sistemskaOperacija = new KreirajNovogRadnikaSO();
        return sistemskaOperacija.izvrsiOpstuSistemskuOperaciju(primljenObjekat);
    }

    public TransferObjekatServer zapamtiRadnika(TransferObjekatKlijent primljenObjekat) {
        sistemskaOperacija = new ZapamtiRadnikaSO();
        return sistemskaOperacija.izvrsiOpstuSistemskuOperaciju(primljenObjekat);
    }

    public TransferObjekatServer kreirajZadatak(TransferObjekatKlijent primljenObjekat) {
        sistemskaOperacija = new KreirajNoviZadatakSO();
        return sistemskaOperacija.izvrsiOpstuSistemskuOperaciju(primljenObjekat);
    }

    public TransferObjekatServer zapamtiZadatak(TransferObjekatKlijent primljenObjekat) {
        sistemskaOperacija = new ZapamtiZadatakSO();
        return sistemskaOperacija.izvrsiOpstuSistemskuOperaciju(primljenObjekat);
    }

    public TransferObjekatServer izmeniZadatak(TransferObjekatKlijent primljenObjekat) {
        sistemskaOperacija = new IzmeniZadatakSO();
        return sistemskaOperacija.izvrsiOpstuSistemskuOperaciju(primljenObjekat);
    }

    public TransferObjekatServer obrisiZadatak(TransferObjekatKlijent primljenObjekat) {
        sistemskaOperacija = new ObrisiZadatakSO();
        return sistemskaOperacija.izvrsiOpstuSistemskuOperaciju(primljenObjekat);
    }

    public TransferObjekatServer sacuvajZadatak(TransferObjekatKlijent primljenObjekat) {
        sistemskaOperacija = new SacuvajZadatakSO();
        return sistemskaOperacija.izvrsiOpstuSistemskuOperaciju(primljenObjekat);
    }

    public TransferObjekatServer predajZadatak(TransferObjekatKlijent primljenObjekat) {
        sistemskaOperacija = new PredajZadatakSO();
        return sistemskaOperacija.izvrsiOpstuSistemskuOperaciju(primljenObjekat);
    }

    public TransferObjekatServer kreirajEvidenciju(TransferObjekatKlijent primljenObjekat) {
        sistemskaOperacija = new KreirajNovuEvidencijuSO();
        return sistemskaOperacija.izvrsiOpstuSistemskuOperaciju(primljenObjekat);
    }

    public TransferObjekatServer zapamtiEvidenciju(TransferObjekatKlijent primljenObjekat) {
        sistemskaOperacija = new ZapamtiEvidencijuSO();
        return sistemskaOperacija.izvrsiOpstuSistemskuOperaciju(primljenObjekat);
    }

    public TransferObjekatServer kreirajZaduzenje(TransferObjekatKlijent primljenObjekat) {
        sistemskaOperacija = new KreirajNovoZaduzenjeSO();
        return sistemskaOperacija.izvrsiOpstuSistemskuOperaciju(primljenObjekat);
    }

    public TransferObjekatServer pronadjiMesta(TransferObjekatKlijent primljenObjekat) {
        sistemskaOperacija = new PronadjiMestaSO();
        return sistemskaOperacija.izvrsiOpstuSistemskuOperaciju(primljenObjekat);
    }

    public TransferObjekatServer pronadjiZadatke(TransferObjekatKlijent primljenObjekat) {
        sistemskaOperacija = new PronadjiZadatkeSO();
        return sistemskaOperacija.izvrsiOpstuSistemskuOperaciju(primljenObjekat);
    }

    public TransferObjekatServer pronadjiRadnike(TransferObjekatKlijent primljenObjekat) {
        sistemskaOperacija = new PronadjiRadnikeSO();
        return sistemskaOperacija.izvrsiOpstuSistemskuOperaciju(primljenObjekat);
    }

    public TransferObjekatServer prijaviSe(TransferObjekatKlijent primljenObjekat) {
        sistemskaOperacija = new PrijaviSeSO();
        return sistemskaOperacija.izvrsiOpstuSistemskuOperaciju(primljenObjekat);
    }

}
