/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.Serializable;

/**
 *
 * @author aleksandar
 */
public class TransferObjekatServer implements Serializable {

    private boolean uspesnostOperacije;
    private Object poruka;
    private Object rezultat;

    public TransferObjekatServer(boolean uspesnostOperacije, Object poruka, Object podaci) {
        this.uspesnostOperacije = uspesnostOperacije;
        this.poruka = poruka;
        this.rezultat = podaci;
    }

    public TransferObjekatServer() {
    }

    public boolean isUspesnostOperacije() {
        return uspesnostOperacije;
    }

    public void setUspesnostOperacije(boolean uspesnostOperacije) {
        this.uspesnostOperacije = uspesnostOperacije;
    }

    public Object getRezultat() {
        return rezultat;
    }

    public void setRezultat(Object rezultat) {
        this.rezultat = rezultat;
    }

    public Object getPoruka() {
        return poruka;
    }

    public void setPoruka(Object poruka) {
        this.poruka = poruka;
    }

}
