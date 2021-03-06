/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import domen.Menadzer;
import domen.OpstiDomenskiObjekat;
import domen.Radnik;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import javax.swing.JOptionPane;
import properties.ProgramProperties;
import validacija.Validacija;
import view.kontroler.logovanje.LogovanjeKontroler;
import view.panel.opstaekranskaforma.OpstaEkranskaForma;

/**
 *
 * @author aleksandar
 */
public class FLogovanje extends javax.swing.JFrame implements OpstaEkranskaForma {

    LogovanjeKontroler kontroler;

    /**
     * Creates new form FLogovanje form.
     */
    public FLogovanje() {
        initComponents();
        kontroler = new LogovanjeKontroler(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupLogovanje = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldUser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButtonLogovanje = new javax.swing.JButton();
        jTextFieldPass = new javax.swing.JPasswordField();
        jRadioButtonMenadzer = new javax.swing.JRadioButton();
        jRadioButtonRadnik = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Log in");

        jLabel1.setText("Korisnicko ime");

        jLabel2.setText("Lozinka");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Unesite potrebne podatke");

        jButtonLogovanje.setText("Uloguj se");
        jButtonLogovanje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogovanjeActionPerformed(evt);
            }
        });

        jTextFieldPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPassActionPerformed(evt);
            }
        });

        buttonGroupLogovanje.add(jRadioButtonMenadzer);
        jRadioButtonMenadzer.setText("Menadzer");

        buttonGroupLogovanje.add(jRadioButtonRadnik);
        jRadioButtonRadnik.setSelected(true);
        jRadioButtonRadnik.setText("Radnik");
        jRadioButtonRadnik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonRadnikActionPerformed(evt);
            }
        });

        jLabel4.setText("Prijavljujem se kao:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jButtonLogovanje, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldPass, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(133, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 106, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonRadnik, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonMenadzer))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonMenadzer)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonRadnik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jButtonLogovanje)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPassActionPerformed

    private void jButtonLogovanjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogovanjeActionPerformed

        //Sredi ovo da kad se loguje da izabere!!
        String newLoc = JOptionPane.showInputDialog(this, "Unesite novu lokaciju za slike: ", ProgramProperties.getInstance().getLocation());
        if (newLoc != null && !newLoc.isEmpty()) {
            ProgramProperties.getInstance().setLocation(newLoc);
        } else {
            JOptionPane.showMessageDialog(this, "Nije unesena nova lokacija");
        }

        if (!Validacija.daLiSuSvaPopunjena(getKorisnickoIme(), getPass())) {
            JOptionPane.showMessageDialog(this, "Molimo unesite i korisnicko ime i lozinku!");
            return;
        }
        try {
            kontroler.prijaviKorisnika();
        } catch (SocketException ex) {
            JOptionPane.showMessageDialog(this, "Server nije pokernut!");
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_jButtonLogovanjeActionPerformed

    private void jRadioButtonRadnikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonRadnikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonRadnikActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FLogovanje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FLogovanje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FLogovanje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FLogovanje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FLogovanje().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupLogovanje;
    private javax.swing.JButton jButtonLogovanje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jRadioButtonMenadzer;
    private javax.swing.JRadioButton jRadioButtonRadnik;
    private javax.swing.JPasswordField jTextFieldPass;
    private javax.swing.JTextField jTextFieldUser;
    // End of variables declaration//GEN-END:variables

    public String getPass() {
        String s = new String(jTextFieldPass.getPassword());
        return s;
    }

    public String getKorisnickoIme() {
        return jTextFieldUser.getText();
    }

    public OpstiDomenskiObjekat vratiTipPrijave() {
        String korisnickoIme = getKorisnickoIme();
        String lozinka = getPass();
        if (jRadioButtonRadnik.isSelected()) {
            Radnik r = new Radnik();
            r.setKorisnickoIme(korisnickoIme);
            r.setLozinka(lozinka);
            return r;
        } else {
            Menadzer m = new Menadzer();
            m.setKorisnickoIme(korisnickoIme);
            m.setLozinka(lozinka);
            return m;
        }
    }

}
