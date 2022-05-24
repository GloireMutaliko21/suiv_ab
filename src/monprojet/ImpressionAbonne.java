/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package monprojet;

import com.lowagie.text.Font;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import net.sf.dynamicreports.report.builder.style.FontBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.constant.VerticalAlignment;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Gloire Salva
 */
public class ImpressionAbonne extends javax.swing.JFrame {
    
    Connexion connect = new Connexion();
    int heureSyst = 0;
    
    public ImpressionAbonne() {
        initComponents();
        connect.ConnecterBDD();

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
        jPanel3 = new javax.swing.JPanel();
        jRadioTout = new javax.swing.JRadioButton();
        jRadioSexe = new javax.swing.JRadioButton();
        jComboBox1 = new javax.swing.JComboBox();
        jRadioProfession = new javax.swing.JRadioButton();
        jComboBox2 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jRadioAbonmTout = new javax.swing.JRadioButton();
        jRadioAbonmEtudi = new javax.swing.JRadioButton();
        jRadioAbonmEnseig = new javax.swing.JRadioButton();
        jRadioAbonmAutre = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 2));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jRadioTout.setBackground(new java.awt.Color(204, 204, 204));
        jRadioTout.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        jRadioTout.setForeground(new java.awt.Color(0, 0, 204));
        jRadioTout.setText("Liste de tous les abonnés");
        jRadioTout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 255)));
        jRadioTout.setBorderPainted(true);
        jRadioTout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioTout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioToutActionPerformed(evt);
            }
        });

        jRadioSexe.setBackground(new java.awt.Color(204, 204, 204));
        jRadioSexe.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        jRadioSexe.setForeground(new java.awt.Color(0, 0, 204));
        jRadioSexe.setText("Liste des abonnés par sexe");
        jRadioSexe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 255)));
        jRadioSexe.setBorderPainted(true);
        jRadioSexe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioSexe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioSexeActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(0, 102, 0));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selectionner ici", "M", "F" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jRadioProfession.setBackground(new java.awt.Color(204, 204, 204));
        jRadioProfession.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        jRadioProfession.setForeground(new java.awt.Color(0, 0, 204));
        jRadioProfession.setText("Liste des abonnés par profession");
        jRadioProfession.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 255)));
        jRadioProfession.setBorderPainted(true);
        jRadioProfession.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioProfession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioProfessionActionPerformed(evt);
            }
        });

        jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(0, 102, 0));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selectionner ici", "Etudiant(e)", "Enseignant", "Autre" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
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

        jRadioAbonmTout.setBackground(new java.awt.Color(204, 204, 204));
        jRadioAbonmTout.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        jRadioAbonmTout.setForeground(new java.awt.Color(0, 0, 204));
        jRadioAbonmTout.setText("Tous les bonnements en cours");
        jRadioAbonmTout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 255)));
        jRadioAbonmTout.setBorderPainted(true);
        jRadioAbonmTout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioAbonmTout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioAbonmToutActionPerformed(evt);
            }
        });

        jRadioAbonmEtudi.setBackground(new java.awt.Color(204, 204, 204));
        jRadioAbonmEtudi.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        jRadioAbonmEtudi.setForeground(new java.awt.Color(0, 0, 204));
        jRadioAbonmEtudi.setText("Tous les bonnements en cours/Etudiants");
        jRadioAbonmEtudi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 255)));
        jRadioAbonmEtudi.setBorderPainted(true);
        jRadioAbonmEtudi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioAbonmEtudi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioAbonmEtudiActionPerformed(evt);
            }
        });

        jRadioAbonmEnseig.setBackground(new java.awt.Color(204, 204, 204));
        jRadioAbonmEnseig.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        jRadioAbonmEnseig.setForeground(new java.awt.Color(0, 0, 204));
        jRadioAbonmEnseig.setText("Tous les bonnements en cours/Enseignants");
        jRadioAbonmEnseig.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 255)));
        jRadioAbonmEnseig.setBorderPainted(true);
        jRadioAbonmEnseig.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioAbonmEnseig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioAbonmEnseigActionPerformed(evt);
            }
        });

        jRadioAbonmAutre.setBackground(new java.awt.Color(204, 204, 204));
        jRadioAbonmAutre.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        jRadioAbonmAutre.setForeground(new java.awt.Color(0, 0, 204));
        jRadioAbonmAutre.setText("Tous les bonnements en cours/Autres");
        jRadioAbonmAutre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 255)));
        jRadioAbonmAutre.setBorderPainted(true);
        jRadioAbonmAutre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioAbonmAutre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioAbonmAutreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jButton3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jRadioTout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jRadioSexe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jRadioProfession))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jRadioAbonmEtudi, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jRadioAbonmTout, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jRadioAbonmEnseig, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioAbonmAutre, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jRadioTout, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioSexe, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox2)
                    .addComponent(jRadioProfession, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioAbonmTout, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioAbonmEtudi, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioAbonmEnseig, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioAbonmAutre, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("IMPRESSION DES LISTES DES ABONNES & ABONNEMENTS EN COURS");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioToutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioToutActionPerformed
        jRadioSexe.setSelected(false);
        jRadioProfession.setSelected(false);
        jComboBox1.setEnabled(false);
        jComboBox2.setEnabled(false);
        jRadioAbonmTout.setSelected(false);
        jRadioAbonmEtudi.setSelected(false);
        jRadioAbonmEnseig.setSelected(false);
        jRadioAbonmAutre.setSelected(false);
    }//GEN-LAST:event_jRadioToutActionPerformed

    private void jRadioSexeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioSexeActionPerformed
        jRadioTout.setSelected(false);
        jRadioProfession.setSelected(false);
        jComboBox1.setEnabled(true);
        jComboBox2.setEnabled(false);
        jRadioAbonmTout.setSelected(false);
        jRadioAbonmEtudi.setSelected(false);
        jRadioAbonmEnseig.setSelected(false);
        jRadioAbonmAutre.setSelected(false);
    }//GEN-LAST:event_jRadioSexeActionPerformed

    private void jRadioProfessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioProfessionActionPerformed
        jRadioSexe.setSelected(false);
        jRadioTout.setSelected(false);
        jComboBox1.setEnabled(false);
        jComboBox2.setEnabled(true);
        jRadioAbonmTout.setSelected(false);
        jRadioAbonmEtudi.setSelected(false);
        jRadioAbonmEnseig.setSelected(false);
        jRadioAbonmAutre.setSelected(false);
    }//GEN-LAST:event_jRadioProfessionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MenuEtats mE = new MenuEtats();
        mE.pack();
        mE.setLocationRelativeTo(null);
        mE.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        StyleBuilder boldStyle = stl.style().bold();
        StyleBuilder boldCenteredStyle = stl.style(boldStyle).setHorizontalAlignment(HorizontalAlignment.CENTER);
        StyleBuilder columnTitleStyle = stl.style(boldCenteredStyle).setBorder(stl.pen1Point()).setBackgroundColor(Color.pink);
        StyleBuilder titleStyle = stl.style(boldCenteredStyle).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(20).setForegroundColor(Color.cyan).setBackgroundColor(Color.black);
        StyleBuilder titleStyl = stl.style(boldCenteredStyle).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(16).setForegroundColor(Color.WHITE).setBackgroundColor(Color.DARK_GRAY);
        
        Date date1 = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy"+"  à"+"  HH:mm:ss");
        String dat = format.format(date1);
        
        Date today = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String date=sdf.format(today);
        
         try{  
        
        JasperReportBuilder repor =  DynamicReports.report();
        repor
                .columns(
                Columns.column("ID", "id_abonne", DataTypes.stringType()).setMinWidth(25),
                Columns.column("NOM ET POST NOM", "nom_postnom_ab", DataTypes.stringType()).setMinWidth(100),
                Columns.column("PRENOM", "prenom_ab", DataTypes.stringType()).setMinWidth(55),
                Columns.column("SEXE", "sexe", DataTypes.stringType()).setMinWidth(35),
                Columns.column("ADRESSE", "adresse", DataTypes.stringType()),
                Columns.column("TELEPHONE", "telephone", DataTypes.stringType()),
                Columns.column("MAIL", "mail", DataTypes.stringType()),
                Columns.column("PROFESSION", "profession", DataTypes.stringType())
                //Columns.column("PHOTO", "photo", DataTypes.stringType())
                )
                
                .title(

            Components.horizontalList()
            .add(Components.image(("test/Logo_AUF.png"))

            )//.add(Components.image("test/Logo_AUF.png").setHorizontalAlignment(HorizontalAlignment.RIGHT))
                ).setPageFormat(PageType.A4, PageOrientation.LANDSCAPE)
                .pageFooter(Components.line()).pageFooter(Components.currentDate().setFormatExpression(dat))
                .pageFooter(Components.pageXofY());
        repor.setColumnTitleStyle(columnTitleStyle).highlightDetailOddRows().title(cmp.text("CAMPUS NUMERIQUE FRANCOPHONE PARTENAIRE DE BUKAVU\nC.N.F.P/BUKAVU\n").setStyle(boldCenteredStyle).setStyle(titleStyle));
        if (jRadioTout.isSelected()){
                   repor.title(
                   Components.text("===================================================\nLISTE DES ABONNES\n===================================================\n")
                   .setHorizontalAlignment(HorizontalAlignment.CENTER).setStyle(boldCenteredStyle).setStyle(titleStyl));
                   repor.setDataSource("select * from abonnes", connect.ConnecterBDD());
        }else if (jRadioSexe.isSelected()){
            repor.title(
                   Components.text("===========================================================================\nLISTE DES ABONNES DONT LE SEXE EST "+jComboBox1.getSelectedItem()+"\n===========================================================================\n")
                   .setHorizontalAlignment(HorizontalAlignment.CENTER).setStyle(boldCenteredStyle).setStyle(titleStyl));
            repor.setDataSource("select * from abonnes where sexe = '"+jComboBox1.getSelectedItem()+"'", connect.ConnecterBDD());
        }else if (jRadioProfession.isSelected()){
            repor.title(
                   Components.text("===========================================================================\nLISTE DES ABONNES DONT LA PROFESSION EST "+jComboBox2.getSelectedItem()+"\n===========================================================================\n")
                   .setHorizontalAlignment(HorizontalAlignment.CENTER).setStyle(boldCenteredStyle).setStyle(titleStyl));
            repor.setDataSource("select * from abonnes where profession = '"+jComboBox2.getSelectedItem()+"'", connect.ConnecterBDD());
        }else if(jRadioAbonmTout.isSelected()){
                    repor.setDataSource("select * from paiement, abonnes where'"+date+"' <= date_expiration and paiement.id_abonne=abonnes.id_abonne", connect.ConnecterBDD())
                   .title(
                   Components.text("LES ABONNES DONT LES ABONNEMENTS SONT EN COURS DE VALIDITE\n")
                   .setHorizontalAlignment(HorizontalAlignment.CENTER).setStyle(boldCenteredStyle).setStyle(titleStyl));
         }else if(jRadioAbonmEtudi.isSelected()){
                    repor.setDataSource("select * from paiement, abonnes where'"+date+"' <= date_expiration and abonnes.profession = 'Etudiant(e)' and paiement.id_abonne=abonnes.id_abonne", connect.ConnecterBDD())
                   .title(
                   Components.text("LES ETUDIANTS DONT LES ABONNEMENTS SONT COURS DE VALIDITE\n")
                   .setHorizontalAlignment(HorizontalAlignment.CENTER).setStyle(boldCenteredStyle).setStyle(titleStyl));
         }else if(jRadioAbonmEnseig.isSelected()){
                    repor.setDataSource("select * from paiement, abonnes where'"+date+"' <= date_expiration and abonnes.profession = 'Enseignant' and paiement.id_abonne=abonnes.id_abonne", connect.ConnecterBDD())
                   .title(
                   Components.text("LES ENSEIGNANTS DONT LES ABONNEMENTS SONT COURS DE VALIDITE\n")
                   .setHorizontalAlignment(HorizontalAlignment.CENTER).setStyle(boldCenteredStyle).setStyle(titleStyl));
         }else if(jRadioAbonmAutre.isSelected()){
                    repor.setDataSource("select * from paiement, abonnes where'"+date+"' <= date_expiration and abonnes.profession IN ('Autre','Travailleur externe') and paiement.id_abonne=abonnes.id_abonne", connect.ConnecterBDD())
                   .title(
                   Components.text("AUTRES ABONNES DONT LES ABONNEMENTS SONT COURS DE VALIDITE\n")
                   .setHorizontalAlignment(HorizontalAlignment.CENTER).setStyle(boldCenteredStyle).setStyle(titleStyl));
         }
        
        try{
            
            //repor.toPdf(new FileOutputStream("D:/report.pdf"));
            repor.show(false);
            
        
        }catch(DRException e){
            JOptionPane.showMessageDialog(null,"erreur0 "+e.getLocalizedMessage());
     }
     }catch (Exception e){
         JOptionPane.showMessageDialog(null,"erreur1 "+e);
     }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        int i = 167;
        int j = 200;
        jComboBox1.setEnabled(false);
        jComboBox2.setEnabled(false);
        jRadioTout.setSelected(true);
       
    }//GEN-LAST:event_formWindowOpened

    private void jRadioAbonmToutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioAbonmToutActionPerformed
        jRadioTout.setSelected(false);
        jRadioAbonmEtudi.setSelected(false);
        jRadioAbonmEnseig.setSelected(false);
        jRadioAbonmAutre.setSelected(false);
        jRadioSexe.setSelected(false);
        jRadioProfession.setSelected(false);
        jComboBox1.setEnabled(false);
        jComboBox2.setEnabled(false);
    }//GEN-LAST:event_jRadioAbonmToutActionPerformed

    private void jRadioAbonmEtudiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioAbonmEtudiActionPerformed
        jRadioTout.setSelected(false);
        jRadioAbonmTout.setSelected(false);
        jRadioAbonmEnseig.setSelected(false);
        jRadioAbonmAutre.setSelected(false);
        jRadioSexe.setSelected(false);
        jRadioProfession.setSelected(false);
        jComboBox1.setEnabled(false);
        jComboBox2.setEnabled(false);
    }//GEN-LAST:event_jRadioAbonmEtudiActionPerformed

    private void jRadioAbonmEnseigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioAbonmEnseigActionPerformed
        jRadioTout.setSelected(false);
        jRadioAbonmTout.setSelected(false);
        jRadioAbonmEtudi.setSelected(false);
        jRadioAbonmAutre.setSelected(false);
        jRadioSexe.setSelected(false);
        jRadioProfession.setSelected(false);
        jComboBox1.setEnabled(false);
        jComboBox2.setEnabled(false);
    }//GEN-LAST:event_jRadioAbonmEnseigActionPerformed

    private void jRadioAbonmAutreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioAbonmAutreActionPerformed
        jRadioTout.setSelected(false);
        jRadioAbonmTout.setSelected(false);
        jRadioAbonmEtudi.setSelected(false);
        jRadioAbonmEnseig.setSelected(false);
        jRadioSexe.setSelected(false);
        jRadioProfession.setSelected(false);
        jComboBox1.setEnabled(false);
        jComboBox2.setEnabled(false);
    }//GEN-LAST:event_jRadioAbonmAutreActionPerformed

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
            java.util.logging.Logger.getLogger(ImpressionAbonne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImpressionAbonne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImpressionAbonne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImpressionAbonne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new ImpressionAbonne().setVisible(true);
                ImpressionAbonne i = new ImpressionAbonne();
                i.setLocationRelativeTo(null);
                i.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioAbonmAutre;
    private javax.swing.JRadioButton jRadioAbonmEnseig;
    private javax.swing.JRadioButton jRadioAbonmEtudi;
    private javax.swing.JRadioButton jRadioAbonmTout;
    private javax.swing.JRadioButton jRadioProfession;
    private javax.swing.JRadioButton jRadioSexe;
    private javax.swing.JRadioButton jRadioTout;
    // End of variables declaration//GEN-END:variables
}
