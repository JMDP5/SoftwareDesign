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
public class TransferObjekatKlijent implements Serializable {

    private int operacija;
    private Object domenskiObjekat;

    public TransferObjekatKlijent(int operacija, Object domenskiObjekat) {
        this.operacija = operacija;
        this.domenskiObjekat = domenskiObjekat;
    }

    public TransferObjekatKlijent() {
    }

    public Object getDomenskiObjekat() {
        return domenskiObjekat;
    }

    public void setDomenskiObjekat(Object domenskiObjekat) {
        this.domenskiObjekat = domenskiObjekat;
    }


    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }
}
