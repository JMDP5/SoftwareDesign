/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panel.radnik;

import view.panel.opstaekranskaforma.OpstaEkranskaForma;
import domen.Mesto;
import domen.Radnik;
import domen.Zadatak;
import java.awt.Color;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import validacija.Validacija;
import view.kontorler.menadzer.UnosRadnikaKontroler;

/**
 *
 * @author Aleksandar
 */
public class UnosRadnikaPanel extends javax.swing.JPanel implements OpstaEkranskaForma {

    UnosRadnikaKontroler kontroler;

    /**
     * Creates new form KreirajBiciklistuPanel
     */
    public UnosRadnikaPanel() {
        initComponents();
        kontroler = new UnosRadnikaKontroler(this);
        popuniCombo();
        jButtonSacuvaj.setEnabled(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonNoviRadnik = new javax.swing.JButton();
        jButtonSacuvaj = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        imeTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        prezimeTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        korisnickoImeTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lozinkaTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxGrad = new javax.swing.JComboBox();

        jButtonNoviRadnik.setText("Novi Radnik");
        jButtonNoviRadnik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNoviRadnikActionPerformed(evt);
            }
        });

        jButtonSacuvaj.setText("Sacuvaj");
        jButtonSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSacuvajActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Unos novog radnika"));

        jLabel1.setText("Radnik ID:");

        idTextField.setEnabled(false);

        jLabel2.setText("Ime:");

        imeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imeTextFieldActionPerformed(evt);
            }
        });

        jLabel3.setText("Prezime:");

        jLabel4.setText("Korisnicko ime");

        jLabel5.setText("Lozinka:");

        jLabel6.setText("Grad:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(imeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(prezimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(korisnickoImeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lozinkaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jComboBoxGrad, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prezimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(korisnickoImeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lozinkaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxGrad, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jButtonNoviRadnik)
                .addGap(29, 29, 29)
                .addComponent(jButtonSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNoviRadnik)
                    .addComponent(jButtonSacuvaj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNoviRadnikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNoviRadnikActionPerformed
        try {
            kontroler.kreirajNovogRadnika();
            jButtonSacuvaj.setEnabled(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_jButtonNoviRadnikActionPerformed

    private void jButtonSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSacuvajActionPerformed
        lozinkaTextField.setBackground(Color.WHITE);
        korisnickoImeTextField.setBackground(Color.WHITE);
        
        if (!Validacija.daLiSuSvaPopunjena(korisnickoImeTextField.getText(), lozinkaTextField.getText())) {
            JOptionPane.showMessageDialog(this, "Korisnicko ime i lozinka moraju biti uneseni!");
            lozinkaTextField.setBackground(Color.RED);
            korisnickoImeTextField.setBackground(Color.RED);
            return;
        }

        try {
            if (!kontroler.daLiJeKorisnickoImeJedinstveno(korisnickoImeTextField.getText())) {
                JOptionPane.showMessageDialog(this, "Korisnicko ime zauzeto, molimo izaberite drugo.");
                korisnickoImeTextField.setBackground(Color.RED);
                return;

            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        try {
            kontroler.zapamtiRadnika();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_jButtonSacuvajActionPerformed

    private void imeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imeTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField idTextField;
    private javax.swing.JTextField imeTextField;
    private javax.swing.JButton jButtonNoviRadnik;
    private javax.swing.JButton jButtonSacuvaj;
    private javax.swing.JComboBox jComboBoxGrad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField korisnickoImeTextField;
    private javax.swing.JTextField lozinkaTextField;
    private javax.swing.JTextField prezimeTextField;
    // End of variables declaration//GEN-END:variables

    public String getId() {
        return idTextField.getText();
    }

    public String getIme() {
        return imeTextField.getText();
    }

    public Mesto getMesto() {
        return (Mesto) jComboBoxGrad.getSelectedItem();
    }

    public String getKorisnickoIme() {
        return korisnickoImeTextField.getText();
    }

    public String getLozinka() {
        return lozinkaTextField.getText();
    }

    public String getPrezime() {
        return prezimeTextField.getText();
    }

    public void setIdTextField(String id) {
        this.idTextField.setText(id);
    }

    public void setIme(String ime) {
        this.imeTextField.setText(ime);
    }

    private void popuniCombo() {
        List<Mesto> mesta;
        try {
            mesta = kontroler.vratiMesta();
            jComboBoxGrad.setModel(new DefaultComboBoxModel(mesta.toArray()));
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void resetujSvaPolja() {
        idTextField.setText("");
        prezimeTextField.setText("");
        imeTextField.setText("");
        korisnickoImeTextField.setText("");
        lozinkaTextField.setText("");
    }
}
