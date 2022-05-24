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
import java.util.Calendar;
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
public class ImpressionsFreqPeriode extends javax.swing.JFrame {
    
    Connexion connect = new Connexion();
    int heureSyst = 0;
    
    public ImpressionsFreqPeriode() {
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Date1 = new com.toedter.calendar.JDateChooser();
        Date2 = new com.toedter.calendar.JDateChooser();
        jRadioCyber = new javax.swing.JRadioButton();
        jRadioBiblio = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("IMPRESSION DES FREQUENTATIONS PERIODIQUES");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("DATE DE DEBUT : ");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel2.setOpaque(true);

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("DATE DE FIN : ");
        jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel3.setOpaque(true);

        jButton1.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 0));
        jButton1.setText("RETOUR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 102, 0));
        jButton2.setText("IMPRIMER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Date1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Date1.setDateFormatString("yyyy-MM-dd");
        Date1.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N

        Date2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Date2.setDateFormatString("yyyy-MM-dd");
        Date2.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N

        jRadioCyber.setBackground(new java.awt.Color(0, 0, 0));
        jRadioCyber.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRadioCyber.setForeground(new java.awt.Color(255, 255, 153));
        jRadioCyber.setText("CYBER-CAFE");
        jRadioCyber.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioCyber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioCyberActionPerformed(evt);
            }
        });

        jRadioBiblio.setBackground(new java.awt.Color(0, 0, 0));
        jRadioBiblio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRadioBiblio.setForeground(new java.awt.Color(255, 255, 153));
        jRadioBiblio.setText("BIBLIOTHEQUE");
        jRadioBiblio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioBiblio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioBiblioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Date1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Date2, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jRadioCyber, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioBiblio)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioCyber)
                    .addComponent(jRadioBiblio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Date1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(Date2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ImpressionFreq mE = new ImpressionFreq();
        mE.pack();
        mE.setLocationRelativeTo(null);
        mE.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        StyleBuilder boldStyle = stl.style().bold();
        StyleBuilder boldCenteredStyle = stl.style(boldStyle).setHorizontalAlignment(HorizontalAlignment.CENTER);
        StyleBuilder columnTitleStyle = stl.style(boldCenteredStyle).setBorder(stl.pen1Point()).setBackgroundColor(Color.pink);
        StyleBuilder titleStyle = stl.style(boldCenteredStyle).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(20).setForegroundColor(Color.cyan).setBackgroundColor(Color.black);
        StyleBuilder titleStyl = stl.style(boldCenteredStyle).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(16).setForegroundColor(Color.WHITE).setBackgroundColor(Color.DARK_GRAY);
        
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy"+"  à"+"  HH:mm:ss");
        String dat = format.format(date);
        
        SimpleDateFormat dateF = new SimpleDateFormat("yyyy-MM-dd");
        String dt = dateF.format(Date1.getDate());
        String dt2 = dateF.format(Date2.getDate());
        
        SimpleDateFormat ref = new SimpleDateFormat("dd MMM yyyy");
        String dtRef = ref.format(Date1.getDate());
        String dt2Ref = ref.format(Date2.getDate());
       try{
           JasperReportBuilder repor =  DynamicReports.report();
         if(jRadioCyber.isSelected()){
           repor
                   .columns(
                   Columns.column("NOM DE L'ABONNE", "abonnes.nom_postnom_ab", DataTypes.stringType()),
                   Columns.column("NOMBRE DES FOIS", "COUNT(frequentationsccybercafe.id_abonne)", DataTypes.integerType())
                   )
                   .title(
                    Components.horizontalList()
                    .add(Components.image(("test/Logo_AUF.png")))
                    ).setPageFormat(PageType.A4, PageOrientation.PORTRAIT)
                .pageFooter(Components.line()).pageFooter(Components.currentDate().setFormatExpression(dat))
                .pageFooter(Components.pageXofY());
        repor.setColumnTitleStyle(columnTitleStyle).highlightDetailOddRows().title(cmp.text("CAMPUS NUMERIQUE FRANCOPHONE PARTENAIRE DE BUKAVU\nC.N.F.P/BUKAVU\n\nSTATISTIQUES DES FREQUENTATIONS CYBER-CAFE DE LA PERIODE DU "+dtRef+" AU "+dt2Ref+"\n").setStyle(boldCenteredStyle).setStyle(titleStyl));
        repor.setDataSource("SELECT frequentationsccybercafe.id_abonne,abonnes.nom_postnom_ab, COUNT(frequentationsccybercafe.id_abonne) FROM frequentationsccybercafe,abonnes  where frequentationsccybercafe.id_abonne=abonnes.id_abonne and date_frequentation >= '"+dt+"'and date_frequentation <= '"+dt2+"'GROUP BY frequentationsccybercafe.id_abonne", connect.ConnecterBDD());
        try{
               repor.show(false);
           }catch(DRException e){
               JOptionPane.showMessageDialog(null,"erreur"+e.getMessage());
           }
        
         }else if(jRadioBiblio.isSelected()){
             repor
                   .columns(
                   Columns.column("NOM DE L'ABONNE", "nom_postnom_ab", DataTypes.stringType()),
                   Columns.column("NOMBRE DES FOIS", "COUNT(frequentations_bibliotheque.id_abonne)", DataTypes.integerType())
                   
                   )
                   .title(

                    Components.horizontalList()
                    .add(Components.image(("test/Logo_AUF.png"))

                    )//.add(Components.image("test/Logo_AUF.png").setHorizontalAlignment(HorizontalAlignment.RIGHT))
                    ).setPageFormat(PageType.A4, PageOrientation.PORTRAIT)
                .pageFooter(Components.line()).pageFooter(Components.currentDate().setFormatExpression(dat))
                .pageFooter(Components.pageXofY());
        repor.setColumnTitleStyle(columnTitleStyle).highlightDetailOddRows().title(cmp.text("CAMPUS NUMERIQUE FRANCOPHONE PARTENAIRE DE BUKAVU\nC.N.F.P/BUKAVU\n\nSTATISTIQUES DES FREQUENTATIONS BIBLIOTHEQUE DE LA PERIODE DU "+dtRef+" AU "+dt2Ref+"\n").setStyle(boldCenteredStyle).setStyle(titleStyl));
           repor.setDataSource("SELECT frequentations_bibliotheque.id_abonne,nom_postnom_ab, COUNT(frequentations_bibliotheque.id_abonne) FROM frequentations_bibliotheque,abonnes  where frequentations_bibliotheque.id_abonne=abonnes.id_abonne and date_frequentation >= '"+dt+"'and date_frequentation <= '"+dt2+"'GROUP BY frequentations_bibliotheque.id_abonne", connect.ConnecterBDD());
           try{
               
               repor.show(false);
           }catch(DRException e){
               JOptionPane.showMessageDialog(null,"erreur"+e.getMessage());
           }
         }else{
             JOptionPane.showMessageDialog(null, "Cochez une option !!!");
         }
           
           
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,"erreur"+e.getMessage());
       }
         
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jRadioCyber.setSelected(true);
        Date dt=new Date();
        this.Date2.setDate(dt);
        this.Date1.setDate(dt);
    }//GEN-LAST:event_formWindowOpened

    private void jRadioCyberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioCyberActionPerformed
        jRadioBiblio.setSelected(false);
    }//GEN-LAST:event_jRadioCyberActionPerformed

    private void jRadioBiblioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioBiblioActionPerformed
        jRadioCyber.setSelected(false);
    }//GEN-LAST:event_jRadioBiblioActionPerformed

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
            java.util.logging.Logger.getLogger(ImpressionsFreqPeriode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImpressionsFreqPeriode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImpressionsFreqPeriode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImpressionsFreqPeriode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImpressionsFreqPeriode().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Date1;
    private com.toedter.calendar.JDateChooser Date2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioBiblio;
    private javax.swing.JRadioButton jRadioCyber;
    // End of variables declaration//GEN-END:variables
}
