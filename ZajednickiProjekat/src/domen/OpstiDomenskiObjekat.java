/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author aleksandar
 */
public abstract class OpstiDomenskiObjekat {

    public abstract String vratiNaziv();

    public abstract String vratiVrednostiAtributaZaInsert();

    public abstract String vratiAtributeZaInsert();

    public abstract String vratiVrednostiZaZapamti();

    public abstract String vratiUslov();

    public abstract String vratiPrimarniKljuc();

    public abstract String vratiUslovZaSelect();

    public abstract List<OpstiDomenskiObjekat> popuniListuIzBaze(ResultSet rs);

    public abstract void setID(int id);

    public abstract int vratiBrojSlabihObjekata();

    public abstract int vratiBrojVeza();

    public abstract OpstiDomenskiObjekat vratiPovezanObjekat(int i);

    public abstract void dopuniPovezanAtribut(List<OpstiDomenskiObjekat> lista, int i);

    public abstract OpstiDomenskiObjekat vratiSlabObjekat(int i);

}
