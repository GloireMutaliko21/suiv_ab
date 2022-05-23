/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package monprojet;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.constant.VerticalAlignment;
import net.sf.dynamicreports.report.exception.DRException;

/**
 *
 * @author Gloire Salva
 */
public class ImpressionPaiem extends javax.swing.JFrame {
    
    Connexion connect = new Connexion();
    int heureSyst = 0;
    
    public ImpressionPaiem() {
        initComponents();

                    AlerteHeureSortie alertCyber = new AlerteHeureSortie();
                    AlerteHeureSortie alertBiblio = new AlerteHeureSortie();
                    alertCyber.alerte();
                    alertBiblio.alerteBiblio();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jRadioTout = new javax.swing.JRadioButton();
        jRadioJour = new javax.swing.JRadioButton();
        jRadioMois = new javax.swing.JRadioButton();
        jRadioAnnee = new javax.swing.JRadioButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        ChoixMois = new javax.swing.JComboBox();
        ChoixAnnee = new com.toedter.calendar.JYearChooser();
        ChoixAnnee1 = new com.toedter.calendar.JYearChooser();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255), 3));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jRadioTout.setBackground(new java.awt.Color(204, 204, 204));
        jRadioTout.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        jRadioTout.setForeground(new java.awt.Color(0, 0, 204));
        jRadioTout.setText("Relevé des paiements");
        jRadioTout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 255)));
        jRadioTout.setBorderPainted(true);
        jRadioTout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioTout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioToutActionPerformed(evt);
            }
        });

        jRadioJour.setBackground(new java.awt.Color(204, 204, 204));
        jRadioJour.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        jRadioJour.setForeground(new java.awt.Color(0, 0, 204));
        jRadioJour.setText("Paiements journaliers");
        jRadioJour.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 255)));
        jRadioJour.setBorderPainted(true);
        jRadioJour.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioJour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioJourActionPerformed(evt);
            }
        });

        jRadioMois.setBackground(new java.awt.Color(204, 204, 204));
        jRadioMois.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        jRadioMois.setForeground(new java.awt.Color(0, 0, 204));
        jRadioMois.setText("Paiements mensuels");
        jRadioMois.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 255)));
        jRadioMois.setBorderPainted(true);
        jRadioMois.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioMois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioMoisActionPerformed(evt);
            }
        });

        jRadioAnnee.setBackground(new java.awt.Color(204, 204, 204));
        jRadioAnnee.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        jRadioAnnee.setForeground(new java.awt.Color(0, 0, 204));
        jRadioAnnee.setText("Paiements annuels");
        jRadioAnnee.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 255)));
        jRadioAnnee.setBorderPainted(true);
        jRadioAnnee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioAnnee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioAnneeActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/printer-24.png"))); // NOI18N
        jButton3.setText("IMPRIMER");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/QUITTER MENU.png"))); // NOI18N
        jButton1.setText("FERMER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ChoixMois.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ChoixMois.setForeground(new java.awt.Color(0, 102, 0));
        ChoixMois.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mois", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        ChoixMois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChoixMoisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jRadioTout, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioJour, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                            .addComponent(jRadioMois, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ChoixMois, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ChoixAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jRadioAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ChoixAnnee1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioTout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioJour)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ChoixAnnee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioMois, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ChoixMois)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ChoixAnnee1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioAnnee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LISTES DES PAIEMENTS");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioToutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioToutActionPerformed
        jRadioJour.setSelected(false);
        jRadioMois.setSelected(false);
        jRadioAnnee.setSelected(false);
        ChoixMois.setEnabled(false);
        ChoixAnnee.setEnabled(false);
        ChoixAnnee1.setEnabled(false);
    }//GEN-LAST:event_jRadioToutActionPerformed

    private void jRadioJourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioJourActionPerformed
        jRadioTout.setSelected(false);
        jRadioMois.setSelected(false);
        jRadioAnnee.setSelected(false);
        ChoixMois.setEnabled(false);
        ChoixAnnee.setEnabled(false);
        ChoixAnnee1.setEnabled(false);
    }//GEN-LAST:event_jRadioJourActionPerformed

    private void jRadioMoisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioMoisActionPerformed
        jRadioJour.setSelected(false);
        jRadioTout.setSelected(false);
        jRadioAnnee.setSelected(false);
        ChoixMois.setEnabled(true);
        ChoixAnnee.setEnabled(true);
        ChoixAnnee1.setEnabled(false);
    }//GEN-LAST:event_jRadioMoisActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MenuEtats mE = new MenuEtats();
        mE.pack();
        mE.setLocationRelativeTo(null);
        mE.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioAnneeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioAnneeActionPerformed
        jRadioJour.setSelected(false);
        jRadioTout.setSelected(false);
        jRadioMois.setSelected(false);
        ChoixMois.setEnabled(false);
        ChoixAnnee.setEnabled(false);
        ChoixAnnee1.setEnabled(true);
    }//GEN-LAST:event_jRadioAnneeActionPerformed

    private void ChoixMoisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChoixMoisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChoixMoisActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ChoixMois.setEnabled(false);
        ChoixAnnee.setEnabled(false);
        ChoixAnnee1.setEnabled(false);
        jRadioTout.setSelected(true);
    }//GEN-LAST:event_formWindowOpened

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Date today = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String date=sdf.format(today);
        
        StyleBuilder boldStyle = stl.style().bold();
        StyleBuilder boldCenteredStyle = stl.style(boldStyle).setHorizontalAlignment(HorizontalAlignment.CENTER);
        StyleBuilder columnTitleStyle = stl.style(boldCenteredStyle).setBorder(stl.pen1Point()).setBackgroundColor(Color.pink);
        StyleBuilder titleStyle = stl.style(boldCenteredStyle).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(20).setForegroundColor(Color.cyan).setBackgroundColor(Color.BLACK);
        StyleBuilder titleStyl = stl.style(boldCenteredStyle).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(16).setForegroundColor(Color.WHITE).setBackgroundColor(Color.DARK_GRAY);
        
        Date date1 = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy"+"  à"+"  HH:mm:ss");
        String dat = format.format(date1);
        
        try{  
        
        JasperReportBuilder repor =  DynamicReports.report();
        repor
                .columns(
                Columns.column("NUM", "num_paiement", DataTypes.stringType()),
                Columns.column("DATE", "date_paiement", DataTypes.stringType()),
                Columns.column("MONTANT", "montant", DataTypes.stringType()),
                Columns.column("TYPE ABONNEMENT", "type_abonnement", DataTypes.stringType()),
                Columns.column("DATE EXP", "date_expiration", DataTypes.stringType()),
                Columns.column("ID ABONNE", "id_abonne", DataTypes.stringType()),
                Columns.column("NOM ABONNE", "nom_postnom_ab", DataTypes.stringType()),
                Columns.column("PROFESSION ABONNE", "profession", DataTypes.stringType())
                //Columns.column("PHOTO", "photo", DataTypes.stringType())
                )
                
                .title(

            Components.horizontalList()
            .add(Components.image(("test/Logo_AUF.png"))

            )//.add(Components.image("test/Logo_AUF.png").setHorizontalAlignment(HorizontalAlignment.RIGHT))
                ).pageFooter(Components.pageXofY())
                .pageFooter(Components.line()).pageFooter(Components.currentDate().setFormatExpression(dat))
                .setPageFormat(PageType.A4, PageOrientation.LANDSCAPE);
        repor.setColumnTitleStyle(columnTitleStyle).highlightDetailOddRows().title(cmp.text("CAMPUS NUMERIQUE FRANCOPHONE PARTENAIRE DE BUKAVU\nC.N.F.P/BUKAVU\n").setStyle(boldCenteredStyle).setStyle(titleStyle));
        if(jRadioJour.isSelected()){
                   repor.setDataSource("select * from paiement,abonnes where date_paiement ='"+date+"'and paiement.id_abonne=abonnes.id_abonne", connect.ConnecterBDD())
                   .title(
                   Components.text("PAIEMENTS DU JOUR "+date+"\n")
                   .setHorizontalAlignment(HorizontalAlignment.CENTER).setStyle(boldCenteredStyle).setStyle(titleStyl));
         }else if(jRadioMois.isSelected()){
                    String ref = ChoixAnnee.getValue()+"-"+ChoixMois.getSelectedItem();
                    repor.setDataSource("select * from paiement, abonnes where date_paiement like '"+ref+"%' and paiement.id_abonne=abonnes.id_abonne", connect.ConnecterBDD())
                   .title(
                   Components.text("PAIEMENTS DU MOIS DE "+ChoixMois.getSelectedItem()+"/"+ChoixAnnee.getYear()+"\n")
                   .setHorizontalAlignment(HorizontalAlignment.CENTER).setStyle(boldCenteredStyle).setStyle(titleStyl));
         }else if(jRadioAnnee.isSelected()){
                    repor.setDataSource("select * from paiement, abonnes where date_paiement like'%"+ChoixAnnee1.getYear()+"%' and paiement.id_abonne=abonnes.id_abonne", connect.ConnecterBDD())
                   .title(
                   Components.text("PAIEMENTS DE L'ANNEE "+ChoixAnnee1.getYear()+"\n")
                   .setHorizontalAlignment(HorizontalAlignment.CENTER).setStyle(boldCenteredStyle).setStyle(titleStyl));
         }else if(jRadioTout.isSelected()){
                    repor.setDataSource("select * from paiement, abonnes where paiement.id_abonne=abonnes.id_abonne", connect.ConnecterBDD())
                   .title(
                   Components.text("TOUS LES PAIEMENTS\n")
                   .setHorizontalAlignment(HorizontalAlignment.CENTER).setStyle(boldCenteredStyle).setStyle(titleStyl));
         }
        try{
            repor.show(false);
        
        }catch(DRException e){
            JOptionPane.showMessageDialog(null,"erreur"+e.getMessage());
     }
     }catch (Exception e){
         JOptionPane.showMessageDialog(null,"erreur"+e);
     }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(ImpressionPaiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImpressionPaiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImpressionPaiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImpressionPaiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImpressionPaiem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JYearChooser ChoixAnnee;
    private com.toedter.calendar.JYearChooser ChoixAnnee1;
    private javax.swing.JComboBox ChoixMois;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioAnnee;
    private javax.swing.JRadioButton jRadioJour;
    private javax.swing.JRadioButton jRadioMois;
    private javax.swing.JRadioButton jRadioTout;
    // End of variables declaration//GEN-END:variables
}
