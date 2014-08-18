/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemskeoperacije;

import baza.BrokerBaze;
import domen.OpstiDomenskiObjekat;
import komunikacija.TransferObjekatKlijent;
import komunikacija.TransferObjekatServer;

/**
 *
 * @author aleksandar
 */
public abstract class OpstaSistemskaOperacija {

    protected static BrokerBaze broker;
    protected static String porukaMetode;

    static {
        broker = new BrokerBaze();
    }

    public TransferObjekatServer izvrsiOpstuSistemskuOperaciju(TransferObjekatKlijent transferObjekat) {
        
        TransferObjekatServer serverObjekat = new TransferObjekatServer();
        OpstiDomenskiObjekat domenskiObjekat = (OpstiDomenskiObjekat) transferObjekat.getDomenskiObjekat();
        try {
            broker.otvoriKonekciju();
            proveriPredusloveOperacije(domenskiObjekat);
            serverObjekat.setRezultat((Object)izvrsiSistemskuOperaciju(domenskiObjekat));
            serverObjekat.setPoruka(porukaMetode);
            broker.komitujTranskakciju();
        } catch (Exception ex) {
            serverObjekat.setPoruka(ex.getMessage());
            broker.povuciTranskaciju();
        } finally {
            broker.zatvoriKonekciju();
        }
        return serverObjekat;

    }

    public abstract Object izvrsiSistemskuOperaciju(OpstiDomenskiObjekat domenskiObjekat) throws Exception;
    public abstract void proveriPredusloveOperacije(OpstiDomenskiObjekat domenskiObjekat) throws Exception;
}
