/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Radnik;
import domen.Zadatak;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author aleksandar
 */
public class ZadaciTableModel extends AbstractTableModel {

    private List<Zadatak> zadaci;

    public ZadaciTableModel() {
        zadaci = new ArrayList<>();
    }

    public ZadaciTableModel(List<Zadatak> zadaci) {
        this.zadaci = zadaci;
    }

    @Override
    public int getRowCount() {
        return zadaci.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Zadatak z = zadaci.get(i);
        switch (i1) {
            case 0:
                return z.getId();
            case 1:
                return z.getNaziv();
            case 2:
                Date datum = z.getRok();
                SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                String sDatum = formater.format(datum.getTime());
                return sDatum;
            case 3:
                return z.getStatus();
            case 4:
                return z.getOpis();
            default:
                return "-----";
        }
    }

    @Override
    public String getColumnName(int i) {
        switch (i) {
            case 0:
                return "ID";
            case 1:
                return "Naziv";
            case 2:
                return "Rok";
            case 3:
                return "Status";
            case 4:
                return "Opis";
            default:
                return "-----";

        }
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return i1 != 0;
    }

    @Override
    public void setValueAt(Object o, int i, int i1) {
        Zadatak z = zadaci.get(i);
        switch (i1) {
            case 1:
                z.setNaziv((String) o);
                break;
            case 2:
                SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                String sDatum = (String) o;
                Date datum = null;
                try {
                    datum = formater.parse(sDatum);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                z.setRok(datum);
                break;
            case 3:
                z.setStatus((String) o);
                break;
            case 4:
                z.setOpis((String) o);
                break;
        }
    }

    public List<Zadatak> getZadaci() {
        return zadaci;
    }

    public void setZadaci(List<Zadatak> zadaci) {
        this.zadaci = zadaci;
        fireTableDataChanged();
    }

    public Zadatak vratiZadatak(int index) {
        return zadaci.get(index);
    }
    
    public void prikaziZadatak(Zadatak z) {
        zadaci = new ArrayList<>();
        zadaci.add(z);
        fireTableDataChanged();
    }

}
