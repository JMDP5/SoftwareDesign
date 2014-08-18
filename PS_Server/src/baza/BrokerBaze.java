/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import domen.Mesto;
import domen.OpstiDomenskiObjekat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Procitaj ovo:
 * http://northconcepts.com/blog/2013/01/18/6-tips-to-improve-your-exception-handling/
 *
 *
 *
 * @author aleksandar
 */
public class BrokerBaze {

    Connection konekcija;

    public void ucitajDrajver() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Drajver nije pronadjen! \n Greska:" + ex.getMessage());
            throw ex;
        }
    }

    public void otvoriKonekciju() {
        try {
            konekcija = DriverManager.getConnection("jdbc:mysql://localhost/baza_prosoft?user=root&password=root");
            konekcija.setAutoCommit(false);
        } catch (SQLException ex) {
            System.out.println("Url ne postoji!");
        }
    }

    public void zatvoriKonekciju() {
        try {
            konekcija.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void komitujTranskakciju() {
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void povuciTranskaciju() {
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int ubaciSlog(OpstiDomenskiObjekat domenskiObjekat) throws Exception {
        int idMax = 1;
        try {
            Statement s = konekcija.createStatement();
            String upit = "INSERT INTO " + domenskiObjekat.vratiNaziv() + domenskiObjekat.vratiAtributeZaInsert() + " VALUES"
                    + domenskiObjekat.vratiVrednostiAtributaZaInsert();
            System.out.println(upit);
            s.executeUpdate(upit);
            upit = "SELECT max(" + domenskiObjekat.vratiPrimarniKljuc() + ") FROM " + domenskiObjekat.vratiNaziv();
            System.out.println(upit);
            ResultSet rs = s.executeQuery(upit);
            while (rs.next()) {
                idMax = rs.getInt(1);
                System.out.println("Trenutni id: " + idMax);
            }

        } catch (Exception ex) {
            throw new Exception(domenskiObjekat.vratiNaziv() + " nije uspesno ubacen!");
        }
        return idMax;

    }

    public void zapamti(OpstiDomenskiObjekat domenskiObjekat) throws Exception {
        try {
            Statement s = konekcija.createStatement();
            String upit = "UPDATE " + domenskiObjekat.vratiNaziv() + " SET "
                    + domenskiObjekat.vratiVrednostiZaZapamti() + " WHERE "
                    + domenskiObjekat.vratiUslov();
            System.out.println(upit);
            s.executeUpdate(upit);

            for (int i = 0; i < domenskiObjekat.vratiBrojSlabihObjekata(); i++) {
                OpstiDomenskiObjekat povezanObjekat = domenskiObjekat.vratiSlabObjekat(i);
                upit = "INSERT INTO " + povezanObjekat.vratiNaziv() + povezanObjekat.vratiAtributeZaInsert() + " VALUES"
                        + povezanObjekat.vratiVrednostiAtributaZaInsert();
                System.out.println(upit);
                s.execute(upit);
            }

        } catch (SQLException ex) {
            throw new Exception(domenskiObjekat.vratiNaziv() + " nije sacuvan!");
        }

    }

    public void obrisi(OpstiDomenskiObjekat domenskiObjekat) throws Exception {
        try {
            Statement s = konekcija.createStatement();
            String upit = "DELETE FROM " + domenskiObjekat.vratiNaziv() + " WHERE " + domenskiObjekat.vratiUslov();
            System.out.println(upit);
            s.executeUpdate(upit);
        } catch (SQLException ex) {
            throw new Exception(domenskiObjekat.vratiNaziv() + " nije obrisan!");
        }
    }

    public List<OpstiDomenskiObjekat> pretrazi(OpstiDomenskiObjekat domenskiObjekat) throws Exception {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();

        Statement s = konekcija.createStatement();
        String upit = "SELECT * FROM " + domenskiObjekat.vratiNaziv() + " WHERE " + domenskiObjekat.vratiUslovZaSelect();
        System.out.println(upit);
        ResultSet rs = s.executeQuery(upit);
        lista = domenskiObjekat.popuniListuIzBaze(rs);
        for (OpstiDomenskiObjekat odo : lista) {
            for (int i = 0; i < odo.vratiBrojVeza(); i++) {
                List<OpstiDomenskiObjekat> lista2 = pretrazi(odo.vratiPovezanObjekat(i));
                odo.dopuniPovezanAtribut(lista2, i);
            }

        }
        return lista;
    }

}
