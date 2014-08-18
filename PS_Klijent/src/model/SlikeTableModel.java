/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Slika;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author aleksandar
 */
public class SlikeTableModel extends AbstractTableModel {

    private List<Slika> slike;

    public SlikeTableModel() {
        this.slike = new ArrayList<>();
    }

    public SlikeTableModel(List<Slika> slike) {
        this.slike = slike;
    }

    @Override
    public int getRowCount() {
        return slike.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Slika s = slike.get(i);
        switch (i1) {
            case (0):
                return s.getId();
            case 1:
                return s.getNaziv();
            case 2:
                return s.getOpis();
            default:
                return "---";

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
                return "Opis";
            default:
                return "---";
        }

    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return (i1 == 2);
    }

    @Override
    public void setValueAt(Object o, int i, int i1) {
        Slika s = slike.get(i);
        switch (i1) {
            case 2:
                s.setOpis((String) o);
                break;
        }
    }

    public void dodajSliku(Slika slika) {
        this.slike.add(slika);
        fireTableDataChanged();
    }

    public List<Slika> getSlike() {
        return slike;
    }

    public void setSlike(List<Slika> slike) {
        this.slike = slike;
        fireTableDataChanged();
    }

}
