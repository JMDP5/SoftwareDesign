/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesija;

import domen.Korisnik;
import domen.Mesto;
import domen.Radnik;
import domen.Zaduzenje;
import java.util.ArrayList;

/**
 *
 * @author aleksandar
 */
public class Sesija {

    private static Sesija instance;
    //Ovo treba da bude neki interfejs Korisnik...
    private Korisnik korisnik;

    private Sesija() {
    }

    public static Sesija getInstance() {
        if (instance == null) {
            instance = new Sesija();
        }
        return instance;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

}
