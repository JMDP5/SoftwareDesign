/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sever.komunikacija;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import komunikacija.TransferObjekatKlijent;
import komunikacija.TransferObjekatServer;
import kontroler.KontrolerAL;
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
import util.Util;

/**
 *
 * @author aleksandar
 */
class KlijentNit extends Thread {

    ObjectInputStream input;
    ObjectOutputStream output;

    public KlijentNit(Socket s) {
        try {
            input = new ObjectInputStream(s.getInputStream());
            output = new ObjectOutputStream(s.getOutputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        start();
    }

    @Override
    public void run() {

        while (true) {
            TransferObjekatKlijent primljenObjekat = null;
            TransferObjekatServer serverObjekat = null;
            OpstaSistemskaOperacija sistemskaOperacija = null;
            try {
                primljenObjekat = (TransferObjekatKlijent) input.readObject();
                System.out.println("Primljeno na serveru: " + primljenObjekat.getOperacija() + "  " + primljenObjekat.getDomenskiObjekat());

                if (primljenObjekat.getOperacija() == Util.KREIRAJ_RADNIKA) {
                    serverObjekat = KontrolerAL.getInstance().kreirajNovogRadnika(primljenObjekat);

                } else if (primljenObjekat.getOperacija() == Util.ZAPAMTI_RADNIKA) {
                    serverObjekat = KontrolerAL.getInstance().zapamtiRadnika(primljenObjekat);

                } else if (primljenObjekat.getOperacija() == Util.KREIRAJ_ZADATAK) {
                    serverObjekat = KontrolerAL.getInstance().kreirajZadatak(primljenObjekat);

                } else if (primljenObjekat.getOperacija() == Util.ZAPAMTI_ZADATAK) {
                    serverObjekat = KontrolerAL.getInstance().zapamtiZadatak(primljenObjekat);

                } else if (primljenObjekat.getOperacija() == Util.IZMENI_ZADATAK) {
                    serverObjekat = KontrolerAL.getInstance().izmeniZadatak(primljenObjekat);

                } else if (primljenObjekat.getOperacija() == Util.OBRISI_ZADATAK) {
                    serverObjekat = KontrolerAL.getInstance().obrisiZadatak(primljenObjekat);

                } else if (primljenObjekat.getOperacija() == Util.SACUVAJ_ZADATAK) {
                    serverObjekat = KontrolerAL.getInstance().sacuvajZadatak(primljenObjekat);

                } else if (primljenObjekat.getOperacija() == Util.PREDAJ_ZADATAK) {
                    serverObjekat = KontrolerAL.getInstance().predajZadatak(primljenObjekat);

                } else if (primljenObjekat.getOperacija() == Util.KREIRAJ_EVIDENCIJU) {
                    serverObjekat = KontrolerAL.getInstance().kreirajEvidenciju(primljenObjekat);

                } else if (primljenObjekat.getOperacija() == Util.ZAPAMTI_EVIDENCIJU) {
                    serverObjekat = KontrolerAL.getInstance().zapamtiEvidenciju(primljenObjekat);

                } else if (primljenObjekat.getOperacija() == Util.KREIRAJ_ZADUZENJE) {
                    serverObjekat = KontrolerAL.getInstance().kreirajZaduzenje(primljenObjekat);

                } else if (primljenObjekat.getOperacija() == Util.PRONADJI_MESTA) {
                    serverObjekat = KontrolerAL.getInstance().pronadjiMesta(primljenObjekat);

                } else if (primljenObjekat.getOperacija() == Util.PRONADJI_ZADATAKE) {
                    serverObjekat = KontrolerAL.getInstance().pronadjiZadatke(primljenObjekat);

                } else if (primljenObjekat.getOperacija() == Util.PRONADJI_RADNIKE) {
                    serverObjekat = KontrolerAL.getInstance().pronadjiRadnike(primljenObjekat);

                } else if (primljenObjekat.getOperacija() == Util.PRIJAVI_SE) {
                    serverObjekat = KontrolerAL.getInstance().prijaviSe(primljenObjekat);

                }
                output.writeObject(serverObjekat);

            } catch (EOFException ex) {
                System.out.println("Klijent se otkacio.");
                break;
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
                break;
            }
        }

    }

}
