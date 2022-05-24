/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package monprojet;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class ImpressionLivre extends javax.swing.JFrame {

    Connexion connect = new Connexion();
    int heureSyst = 0;
    
    /**
     * Creates new form ImpressionLivre
     */
    public ImpressionLivre() {
        initComponents();

                    AlerteHeureSortie alertCyber = new AlerteHeureSortie();
                    AlerteHeureSortie alertBiblio = new AlerteHeureSortie();
                    alertCyber.alerte();
                    alertBiblio.alerteBiblio();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jRadioTout = new javax.swing.JRadioButton();
        jRadioTitre = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jRadioNbre = new javax.swing.JRadioButton();
        titre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 51, 51));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255), 3));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jRadioTout.setBackground(new java.awt.Color(204, 204, 204));
        jRadioTout.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        jRadioTout.setForeground(new java.awt.Color(0, 0, 204));
        jRadioTout.setText("Liste de tous les livres");
        jRadioTout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 255)));
        jRadioTout.setBorderPainted(true);
        jRadioTout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioTout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioToutActionPerformed(evt);
            }
        });

        jRadioTitre.setBackground(new java.awt.Color(204, 204, 204));
        jRadioTitre.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        jRadioTitre.setForeground(new java.awt.Color(0, 0, 204));
        jRadioTitre.setText("Liste des livres par titre");
        jRadioTitre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 255)));
        jRadioTitre.setBorderPainted(true);
        jRadioTitre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioTitre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioTitreActionPerformed(evt);
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

        jButton3.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/printer-24.png"))); // NOI18N
        jButton3.setText("IMPRIMER");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LISTES DES LIVRES");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jRadioNbre.setBackground(new java.awt.Color(204, 204, 204));
        jRadioNbre.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        jRadioNbre.setForeground(new java.awt.Color(0, 0, 204));
        jRadioNbre.setText("Livres et leurs nombres");
        jRadioNbre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 255)));
        jRadioNbre.setBorderPainted(true);
        jRadioNbre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioNbre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioNbreActionPerformed(evt);
            }
        });

        titre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        titre.setForeground(new java.awt.Color(0, 102, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jRadioNbre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioTout, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioTitre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titre)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jRadioTout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioTitre)
                    .addComponent(titre, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioNbre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(338, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(299, 299, 299))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(205, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioToutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioToutActionPerformed
        jRadioTitre.setSelected(false);
        jRadioNbre.setSelected(false);
        titre.setEnabled(false);
    }//GEN-LAST:event_jRadioToutActionPerformed

    private void jRadioTitreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioTitreActionPerformed
        jRadioTout.setSelected(false);
        jRadioNbre.setSelected(false);
        titre.setEnabled(true);
    }//GEN-LAST:event_jRadioTitreActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        MenuEtats mE = new MenuEtats();
//        mE.pack();
//        mE.setLocationRelativeTo(null);
//        mE.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        StyleBuilder boldStyle = stl.style().bold();
        StyleBuilder boldCenteredStyle = stl.style(boldStyle).setHorizontalAlignment(HorizontalAlignment.CENTER);
        StyleBuilder columnTitleStyle = stl.style(boldCenteredStyle).setBorder(stl.pen1Point()).setBackgroundColor(Color.pink);
        StyleBuilder titleStyle = stl.style(boldCenteredStyle).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(20).setForegroundColor(Color.cyan).setBackgroundColor(Color.BLACK);
        StyleBuilder titleStyl = stl.style(boldCenteredStyle).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(16).setForegroundColor(Color.WHITE).setBackgroundColor(Color.DARK_GRAY);
        
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy"+"  à"+"  HH:mm:ss");
        String dat = format.format(date);
        
        try{  
        
        JasperReportBuilder repor =  DynamicReports.report();
        JasperReportBuilder repor2 =  DynamicReports.report();
        repor
                .columns(
                Columns.column("NUM", "num_livre", DataTypes.stringType()),
                Columns.column("CODE", "code_livre", DataTypes.stringType()),
                Columns.column("TITRE", "titre", DataTypes.stringType()),
                Columns.column("AUTEUR", "auteur", DataTypes.stringType()),
                Columns.column("PAGES", "nombre_pages", DataTypes.stringType()),
                Columns.column("MAISON EDIT", "maison_edition", DataTypes.stringType()),
                Columns.column("VILLE EDIT", "ville_edition", DataTypes.stringType()),
                Columns.column("ANNEE EDIT", "annee_edition", DataTypes.dateYearType()),
                Columns.column("EXEMPLAIRES", "num_exemplaire", DataTypes.integerType())
                )
                
                .title(

            Components.horizontalList()
            .add(Components.image(("test/Logo_AUF.png"))

            )//.add(Components.image("test/Logo_AUF.png").setHorizontalAlignment(HorizontalAlignment.RIGHT))
                ).pageFooter(Components.pageXofY())
                .pageFooter(Components.line()).pageFooter(Components.currentDate().setFormatExpression(dat))
                .setPageFormat(PageType.A4, PageOrientation.LANDSCAPE);
        repor.setColumnTitleStyle(columnTitleStyle).highlightDetailOddRows().title(cmp.text("CAMPUS NUMERIQUE FRANCOPHONE PARTENAIRE DE BUKAVU\nC.N.F.P/BUKAVU\n").setStyle(boldCenteredStyle).setStyle(titleStyle));
        if(jRadioTout.isSelected()){
                   repor.setDataSource("select * from livres", connect.ConnecterBDD())
                   .title(
                   Components.text("LISTE DES LIVRES DE LA BIBLIOTHEQUE\n")
                   .setHorizontalAlignment(HorizontalAlignment.CENTER).setStyle(boldCenteredStyle).setStyle(titleStyl));
        } else if (jRadioTitre.isSelected()){
            
            repor.setDataSource("select * from livres where titre ='"+titre.getText().toString().replaceAll("'", "''")+"'", connect.ConnecterBDD())
                   .title(
                   Components.text(" LIVRE INTITULE : "+titre.getText()+"\n")
                   .setHorizontalAlignment(HorizontalAlignment.CENTER).setStyle(boldCenteredStyle).setStyle(titleStyl));
        }else if(jRadioNbre.isSelected()){
            repor2
              .columns(
                    Columns.column("TITRE", "titre", DataTypes.stringType()),
                    Columns.column("NOMBRE", "COUNT(titre)", DataTypes.integerType())
              )
           .title(

                    Components.horizontalList()
                    .add(Components.image(("test/Logo_AUF.png"))

                    )
                    .add(Components.image("test/Logo_AUF.png").setHorizontalAlignment(HorizontalAlignment.RIGHT))
                )
                .pageFooter(Components.pageXofY())
                .pageFooter(Components.line()).pageFooter(Components.currentDate().setFormatExpression(dat))
                .setPageFormat(PageType.A4, PageOrientation.PORTRAIT);
            
                repor2.setColumnTitleStyle(columnTitleStyle).highlightDetailOddRows().title(cmp.text("CAMPUS NUMERIQUE FRANCOPHONE PARTENAIRE DE BUKAVU\nC.N.F.P/BUKAVU\n").setStyle(boldCenteredStyle).setStyle(titleStyle))
                .setDataSource("select titre, COUNT(titre) FROM livres GROUP BY titre", connect.ConnecterBDD())
                   .title(
                   Components.text("LISTE DES LIVRES DE LA BIBLIOTHEQUE ET LE NOMBRE DE CHACUN\n")
                   .setHorizontalAlignment(HorizontalAlignment.CENTER).setStyle(boldCenteredStyle).setStyle(titleStyl));
            
        }
        if(jRadioTout.isSelected() || jRadioTitre.isSelected())
        {
            try{
                repor.show(false);
        
            }catch(DRException e){
                JOptionPane.showMessageDialog(null,"erreur"+e.getMessage());;
        }
        }else if(jRadioNbre.isSelected()){
            try{
            repor2.show(false);
        
            }catch(DRException e){
            JOptionPane.showMessageDialog(null,"erreur"+e.getMessage());
     }
        }
     }catch (Exception e){
         JOptionPane.showMessageDialog(null,"erreur"+e);
     }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jRadioTout.setSelected(true);
        titre.setEnabled(false);
    }//GEN-LAST:event_formWindowOpened

    private void jRadioNbreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioNbreActionPerformed
        jRadioTout.setSelected(false);
        jRadioTitre.setSelected(false);
        titre.setEnabled(false);
    }//GEN-LAST:event_jRadioNbreActionPerformed

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
            java.util.logging.Logger.getLogger(ImpressionLivre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImpressionLivre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImpressionLivre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImpressionLivre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImpressionLivre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioNbre;
    private javax.swing.JRadioButton jRadioTitre;
    private javax.swing.JRadioButton jRadioTout;
    private javax.swing.JTextField titre;
    // End of variables declaration//GEN-END:variables
}
