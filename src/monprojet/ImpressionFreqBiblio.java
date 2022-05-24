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
public class ImpressionFreqBiblio extends javax.swing.JFrame {
    
    Connexion connect = new Connexion();
    int heureSyst = 0;
    
    public ImpressionFreqBiblio() {
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
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jRadioJour = new javax.swing.JRadioButton();
        jRadioMois = new javax.swing.JRadioButton();
        jRadioAnnee = new javax.swing.JRadioButton();
        jRadioTout = new javax.swing.JRadioButton();
        jRadioMoisSexe = new javax.swing.JRadioButton();
        jRadioAnneeSexe = new javax.swing.JRadioButton();
        ChoixAnnee4 = new com.toedter.calendar.JYearChooser();
        ChoixSexe2 = new javax.swing.JComboBox();
        ChoixAnnee3 = new com.toedter.calendar.JYearChooser();
        ChoixMois2 = new javax.swing.JComboBox();
        ChoixSexe1 = new javax.swing.JComboBox();
        ChoixAnnee2 = new com.toedter.calendar.JYearChooser();
        ChoixMois = new javax.swing.JComboBox();
        ChoixAnnee = new com.toedter.calendar.JYearChooser();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jRadioMoisProfession = new javax.swing.JRadioButton();
        jRadioAnneeProfession = new javax.swing.JRadioButton();
        ChoixMois3 = new javax.swing.JComboBox();
        ChoixAnnee5 = new com.toedter.calendar.JYearChooser();
        Profession1 = new javax.swing.JComboBox();
        ChoixAnnee6 = new com.toedter.calendar.JYearChooser();
        Profession2 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255), 3));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LISTES DES FREQUENTATIONS DE LA BIBLIOTHEQUE");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jRadioJour.setBackground(new java.awt.Color(204, 204, 204));
        jRadioJour.setFont(new java.awt.Font("Lucida Fax", 1, 16)); // NOI18N
        jRadioJour.setForeground(new java.awt.Color(0, 102, 102));
        jRadioJour.setText("Liste des fréquentations journalières");
        jRadioJour.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 255)));
        jRadioJour.setBorderPainted(true);
        jRadioJour.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioJour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioJourActionPerformed(evt);
            }
        });

        jRadioMois.setBackground(new java.awt.Color(204, 204, 204));
        jRadioMois.setFont(new java.awt.Font("Lucida Fax", 1, 16)); // NOI18N
        jRadioMois.setForeground(new java.awt.Color(0, 102, 102));
        jRadioMois.setText("Liste des fréquentations mensuelles");
        jRadioMois.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 255)));
        jRadioMois.setBorderPainted(true);
        jRadioMois.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioMois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioMoisActionPerformed(evt);
            }
        });

        jRadioAnnee.setBackground(new java.awt.Color(204, 204, 204));
        jRadioAnnee.setFont(new java.awt.Font("Lucida Fax", 1, 16)); // NOI18N
        jRadioAnnee.setForeground(new java.awt.Color(0, 102, 102));
        jRadioAnnee.setText("Liste des fréquentations annuelles");
        jRadioAnnee.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 255)));
        jRadioAnnee.setBorderPainted(true);
        jRadioAnnee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioAnnee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioAnneeActionPerformed(evt);
            }
        });

        jRadioTout.setBackground(new java.awt.Color(204, 204, 204));
        jRadioTout.setFont(new java.awt.Font("Lucida Fax", 1, 16)); // NOI18N
        jRadioTout.setForeground(new java.awt.Color(0, 102, 102));
        jRadioTout.setText("Liste de toutes les fréquentations");
        jRadioTout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 255)));
        jRadioTout.setBorderPainted(true);
        jRadioTout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioTout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioToutActionPerformed(evt);
            }
        });

        jRadioMoisSexe.setBackground(new java.awt.Color(204, 204, 204));
        jRadioMoisSexe.setFont(new java.awt.Font("Lucida Fax", 1, 16)); // NOI18N
        jRadioMoisSexe.setForeground(new java.awt.Color(51, 51, 255));
        jRadioMoisSexe.setText("Fréquentations mensuelles selon le sexe des abonnés");
        jRadioMoisSexe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 255)));
        jRadioMoisSexe.setBorderPainted(true);
        jRadioMoisSexe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioMoisSexe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioMoisSexeActionPerformed(evt);
            }
        });

        jRadioAnneeSexe.setBackground(new java.awt.Color(204, 204, 204));
        jRadioAnneeSexe.setFont(new java.awt.Font("Lucida Fax", 1, 16)); // NOI18N
        jRadioAnneeSexe.setForeground(new java.awt.Color(51, 51, 255));
        jRadioAnneeSexe.setText("Fréquentations annuelles selon le sexe des abonnés");
        jRadioAnneeSexe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 255)));
        jRadioAnneeSexe.setBorderPainted(true);
        jRadioAnneeSexe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioAnneeSexe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioAnneeSexeActionPerformed(evt);
            }
        });

        ChoixSexe2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ChoixSexe2.setForeground(new java.awt.Color(0, 102, 0));
        ChoixSexe2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sexe", "M", "F" }));
        ChoixSexe2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChoixSexe2ActionPerformed(evt);
            }
        });

        ChoixMois2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ChoixMois2.setForeground(new java.awt.Color(0, 102, 0));
        ChoixMois2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mois", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        ChoixMois2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChoixMois2ActionPerformed(evt);
            }
        });

        ChoixSexe1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ChoixSexe1.setForeground(new java.awt.Color(0, 102, 0));
        ChoixSexe1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sexe", "M", "F" }));
        ChoixSexe1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChoixSexe1ActionPerformed(evt);
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

        jRadioMoisProfession.setBackground(new java.awt.Color(204, 204, 204));
        jRadioMoisProfession.setFont(new java.awt.Font("Lucida Fax", 1, 16)); // NOI18N
        jRadioMoisProfession.setForeground(new java.awt.Color(51, 51, 255));
        jRadioMoisProfession.setText("Fréquentations mensuelles par profession des abonnés");
        jRadioMoisProfession.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 255)));
        jRadioMoisProfession.setBorderPainted(true);
        jRadioMoisProfession.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioMoisProfession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioMoisProfessionActionPerformed(evt);
            }
        });

        jRadioAnneeProfession.setBackground(new java.awt.Color(204, 204, 204));
        jRadioAnneeProfession.setFont(new java.awt.Font("Lucida Fax", 1, 16)); // NOI18N
        jRadioAnneeProfession.setForeground(new java.awt.Color(51, 51, 255));
        jRadioAnneeProfession.setText("Fréquentations annuelles par profession des abonnés");
        jRadioAnneeProfession.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 255)));
        jRadioAnneeProfession.setBorderPainted(true);
        jRadioAnneeProfession.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioAnneeProfession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioAnneeProfessionActionPerformed(evt);
            }
        });

        ChoixMois3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ChoixMois3.setForeground(new java.awt.Color(0, 102, 0));
        ChoixMois3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mois", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        ChoixMois3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChoixMois3ActionPerformed(evt);
            }
        });

        Profession1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Profession1.setForeground(new java.awt.Color(0, 102, 0));
        Profession1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selectionner ici", "Etudiant(e)", "Enseignant", "Autre" }));

        Profession2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Profession2.setForeground(new java.awt.Color(0, 102, 0));
        Profession2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selectionner ici", "Etudiant(e)", "Enseignant", "Autre" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jRadioMoisProfession, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioJour, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioMois, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioAnnee, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioTout, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioMoisSexe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioAnneeSexe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jRadioAnneeProfession, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(ChoixMois, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ChoixAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ChoixAnnee2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(ChoixMois2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ChoixAnnee3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(ChoixAnnee4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ChoixSexe2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ChoixSexe1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(ChoixMois3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ChoixAnnee5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Profession1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(ChoixAnnee6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Profession2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ChoixSexe1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jRadioJour, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioMois, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(ChoixMois)
                                    .addGap(3, 3, 3))
                                .addComponent(ChoixAnnee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ChoixAnnee2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jRadioTout, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jRadioMoisSexe, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ChoixMois2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(ChoixAnnee3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jRadioAnneeSexe, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ChoixSexe2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ChoixAnnee4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioMoisProfession, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ChoixMois3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ChoixAnnee5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Profession1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ChoixAnnee6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Profession2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jRadioAnneeProfession, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jRadioJourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioJourActionPerformed
        jRadioMois.setSelected(false);
        jRadioAnnee.setSelected(false);
        jRadioTout.setSelected(false);
        jRadioMoisSexe.setSelected(false);
        jRadioAnneeSexe.setSelected(false);
        jRadioMoisProfession.setSelected(false);
        jRadioAnneeProfession.setSelected(false);
        ChoixMois.setEnabled(false);ChoixAnnee.setEnabled(false);
        ChoixAnnee2.setEnabled(false);ChoixAnnee3.setEnabled(false);
        ChoixAnnee4.setEnabled(false);ChoixMois2.setEnabled(false);ChoixSexe1.setEnabled(false);ChoixSexe2.setEnabled(false); ChoixMois3.setEnabled(false); ChoixAnnee5.setEnabled(false);
        Profession1.setEnabled(false); ChoixAnnee6.setEnabled(false); Profession2.setEnabled(false);
    }//GEN-LAST:event_jRadioJourActionPerformed

    private void jRadioMoisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioMoisActionPerformed
        jRadioJour.setSelected(false);
        jRadioAnnee.setSelected(false);
        jRadioTout.setSelected(false);
        jRadioMoisSexe.setSelected(false);
        jRadioAnneeSexe.setSelected(false);
        jRadioMoisProfession.setSelected(false);
        jRadioAnneeProfession.setSelected(false);
        ChoixMois.setEnabled(true);
        ChoixAnnee.setEnabled(true);
        ChoixAnnee2.setEnabled(false);
        ChoixAnnee3.setEnabled(false);
        ChoixAnnee4.setEnabled(false);
        ChoixMois2.setEnabled(false);
        ChoixSexe1.setEnabled(false);
        ChoixSexe2.setEnabled(false);
        ChoixMois3.setEnabled(false);
        ChoixAnnee5.setEnabled(false);
        Profession1.setEnabled(false);
        ChoixAnnee6.setEnabled(false);
        Profession2.setEnabled(false);
    }//GEN-LAST:event_jRadioMoisActionPerformed

    private void jRadioAnneeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioAnneeActionPerformed
        jRadioMois.setSelected(false);
        jRadioJour.setSelected(false);
        jRadioTout.setSelected(false);
        jRadioMoisSexe.setSelected(false);
        jRadioAnneeSexe.setSelected(false);
        jRadioMoisProfession.setSelected(false);
        jRadioAnneeProfession.setSelected(false);
        ChoixMois.setEnabled(false);
        ChoixAnnee.setEnabled(false);
        ChoixAnnee2.setEnabled(true);
        ChoixAnnee3.setEnabled(false);
        ChoixAnnee4.setEnabled(false);
        ChoixMois2.setEnabled(false);
        ChoixSexe1.setEnabled(false);
        ChoixSexe2.setEnabled(false);
        ChoixMois3.setEnabled(false);
        ChoixAnnee5.setEnabled(false);
        Profession1.setEnabled(false);
        ChoixAnnee6.setEnabled(false);
        Profession2.setEnabled(false);
    }//GEN-LAST:event_jRadioAnneeActionPerformed

    private void jRadioToutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioToutActionPerformed
        jRadioJour.setSelected(false);
        jRadioAnnee.setSelected(false);
        jRadioMois.setSelected(false);
        jRadioMoisSexe.setSelected(false);
        jRadioAnneeSexe.setSelected(false);
        jRadioMoisProfession.setSelected(false);
        jRadioAnneeProfession.setSelected(false);
        ChoixMois.setEnabled(false);
        ChoixAnnee.setEnabled(false);
        ChoixAnnee2.setEnabled(false);
        ChoixAnnee3.setEnabled(false);
        ChoixAnnee4.setEnabled(false);
        ChoixMois2.setEnabled(false);
        ChoixSexe1.setEnabled(false);
        ChoixSexe2.setEnabled(false);
        ChoixMois3.setEnabled(false);
        ChoixAnnee5.setEnabled(false);
        Profession1.setEnabled(false);
        ChoixAnnee6.setEnabled(false);
        Profession2.setEnabled(false);
    }//GEN-LAST:event_jRadioToutActionPerformed

    private void jRadioMoisSexeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioMoisSexeActionPerformed
        jRadioJour.setSelected(false);
        jRadioAnnee.setSelected(false);
        jRadioTout.setSelected(false);
        jRadioMois.setSelected(false);
        jRadioAnneeSexe.setSelected(false);
        jRadioMoisProfession.setSelected(false);
        jRadioAnneeProfession.setSelected(false);
        ChoixMois.setEnabled(false);
        ChoixAnnee.setEnabled(false);
        ChoixAnnee2.setEnabled(false);
        ChoixAnnee3.setEnabled(true);
        ChoixAnnee4.setEnabled(false);
        ChoixMois2.setEnabled(true);
        ChoixSexe1.setEnabled(true);
        ChoixSexe2.setEnabled(false);
        ChoixMois3.setEnabled(false);
        ChoixAnnee5.setEnabled(false);
        Profession1.setEnabled(false);
        ChoixAnnee6.setEnabled(false);
        Profession2.setEnabled(false);
    }//GEN-LAST:event_jRadioMoisSexeActionPerformed

    private void jRadioAnneeSexeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioAnneeSexeActionPerformed
        jRadioJour.setSelected(false);
        jRadioAnnee.setSelected(false);
        jRadioTout.setSelected(false);
        jRadioMoisSexe.setSelected(false);
        jRadioMois.setSelected(false);
        jRadioMoisProfession.setSelected(false);
        jRadioAnneeProfession.setSelected(false);
        ChoixMois.setEnabled(false);
        ChoixAnnee.setEnabled(false);
        ChoixAnnee2.setEnabled(false);
        ChoixAnnee3.setEnabled(false);
        ChoixAnnee4.setEnabled(true);
        ChoixMois2.setEnabled(false);
        ChoixSexe1.setEnabled(false);
        ChoixSexe2.setEnabled(true);
        ChoixMois3.setEnabled(false);
        ChoixAnnee5.setEnabled(false);
        Profession1.setEnabled(false);
        ChoixAnnee6.setEnabled(false);
        Profession2.setEnabled(false);
    }//GEN-LAST:event_jRadioAnneeSexeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        ImpressionFreq mE = new ImpressionFreq();
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
         
        Date date1 = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy"+ "  à"+"  HH:mm:ss");
        String dat = format.format(date1);
        
        Date today = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String date=sdf.format(today);
        try{  
        
        JasperReportBuilder repor =  DynamicReports.report();
        repor
                .columns(
                Columns.column("NUM", "num_frequentation", DataTypes.stringType()),
                Columns.column("DATE", "date_frequentation", DataTypes.stringType()),
                Columns.column("HEURE D'ENTREE", "heure_entree", DataTypes.stringType()),
                Columns.column("HEURE DE SORTIE", "heure_sortie", DataTypes.stringType()),
                Columns.column("MOTIF", "motif_freq", DataTypes.stringType()),
                Columns.column("ID ABONNE", "id_abonne", DataTypes.stringType()),
                Columns.column("NOM ABONNE", "nom_postnom_ab", DataTypes.stringType()),
                Columns.column("LIVRE", "id_livre", DataTypes.stringType()),
                Columns.column("OBS", "observation", DataTypes.stringType())
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
                   repor.setDataSource("select * from frequentations_bibliotheque,abonnes where date_frequentation ='"+date+"'and frequentations_bibliotheque.id_abonne=abonnes.id_abonne", connect.ConnecterBDD())
                   .title(
                   Components.text("FREQUENTATIONS JOURNALIERES DE LA BIBLIOTHEQUE DU "+date+"\n")
                   .setHorizontalAlignment(HorizontalAlignment.CENTER).setStyle(boldCenteredStyle).setStyle(titleStyl));
         }else if(jRadioMois.isSelected()){
                    String ref = ChoixAnnee.getValue()+"-"+ChoixMois.getSelectedItem();
                    repor.setDataSource("select * from frequentations_bibliotheque, abonnes where date_frequentation like '"+ref+"%' and frequentations_bibliotheque.id_abonne=abonnes.id_abonne", connect.ConnecterBDD())
                   .title(
                   Components.text("FREQUENTATIONS DE LA BIBLIOTHEQUE DU MOIS DE "+ChoixMois.getSelectedItem()+"/"+ChoixAnnee.getYear()+"\n")
                   .setHorizontalAlignment(HorizontalAlignment.CENTER).setStyle(boldCenteredStyle).setStyle(titleStyl));
         }else if(jRadioAnnee.isSelected()){
                    repor.setDataSource("select * from frequentations_bibliotheque, abonnes where date_frequentation like'%"+ChoixAnnee2.getYear()+"%' and frequentations_bibliotheque.id_abonne=abonnes.id_abonne", connect.ConnecterBDD())
                   .title(
                   Components.text("FREQUENTATIONS DE LA BIBLIOTHEQUE DE L'ANNEE "+ChoixAnnee2.getYear()+"\n")
                   .setHorizontalAlignment(HorizontalAlignment.CENTER).setStyle(boldCenteredStyle).setStyle(titleStyl));
         }else if(jRadioTout.isSelected()){
                    repor.setDataSource("select * from frequentations_bibliotheque, abonnes where frequentations_bibliotheque.id_abonne=abonnes.id_abonne", connect.ConnecterBDD())
                   .title(
                   Components.text("TOUTES LES FREQUENTATIONS DE LA BIBLIOTHEQUE\n")
                   .setHorizontalAlignment(HorizontalAlignment.CENTER).setStyle(boldCenteredStyle).setStyle(titleStyl));
         }else if(jRadioMoisSexe.isSelected()){
                    String ref = ChoixAnnee3.getValue()+"-"+ChoixMois2.getSelectedItem();
                   repor.setDataSource("select * from frequentations_bibliotheque,abonnes where date_frequentation like '"+ref+"%' and frequentations_bibliotheque.id_abonne=abonnes.id_abonne and abonnes.sexe ='"+ChoixSexe1.getSelectedItem()+"'", connect.ConnecterBDD())
                   .title(
                   Components.text("FREQUENTATIONS DE LA BIBLIOTHEQUE  "+ChoixMois2.getSelectedItem()+"/"+ChoixAnnee3.getYear()+" ABONNES DU SEXE "+ ChoixSexe1.getSelectedItem()+"\n")
                   .setHorizontalAlignment(HorizontalAlignment.CENTER).setStyle(boldCenteredStyle).setStyle(titleStyl));        
         }else if(jRadioAnneeSexe.isSelected()){
                    repor.setDataSource("select * from frequentations_bibliotheque,abonnes where date_frequentation like'%"+ChoixAnnee4.getYear()+"%' and frequentations_bibliotheque.id_abonne=abonnes.id_abonne and abonnes.sexe ='"+ChoixSexe2.getSelectedItem()+"'", connect.ConnecterBDD())
                   .title(
                   Components.text("FREQUENTATIONS DE LA BIBLIOTHEQUE  "+ChoixAnnee4.getYear()+" / ABONNES DU SEXE "+ ChoixSexe2.getSelectedItem()+"\n")
                   .setHorizontalAlignment(HorizontalAlignment.CENTER).setStyle(boldCenteredStyle).setStyle(titleStyl));
         }else if(jRadioMoisProfession.isSelected()){
                    String ref = ChoixAnnee5.getValue()+"-"+ChoixMois3.getSelectedItem();
                   repor.setDataSource("select * from frequentations_bibliotheque,abonnes where date_frequentation like '"+ref+"%' and frequentations_bibliotheque.id_abonne=abonnes.id_abonne and abonnes.profession ='"+Profession1.getSelectedItem()+"'", connect.ConnecterBDD())
                   .title(
                   Components.text("FREQUENTATIONS DE LA BIBLIOTHEQUE  "+ChoixMois3.getSelectedItem()+"/"+ChoixAnnee5.getYear()+" ABONNES DONT LA PROFESSION EST "+ Profession1.getSelectedItem()+"\n")
                   .setHorizontalAlignment(HorizontalAlignment.CENTER).setStyle(boldCenteredStyle).setStyle(titleStyl)); 
        }else if(jRadioAnneeProfession.isSelected()){
                    repor.setDataSource("select * from frequentations_bibliotheque,abonnes where date_frequentation like'%"+ChoixAnnee6.getYear()+"%' and frequentations_bibliotheque.id_abonne=abonnes.id_abonne and abonnes.profession ='"+Profession2.getSelectedItem()+"'", connect.ConnecterBDD())
                   .title(
                   Components.text("FREQUENTATIONS DE LA BIBLIOTHEQUE  "+ChoixAnnee6.getYear()+" / ABONNES DONT LA PROFESSION EST "+ Profession2.getSelectedItem()+"\n")
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

    private void ChoixMoisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChoixMoisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChoixMoisActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ChoixMois.setEnabled(false);
        ChoixAnnee.setEnabled(false);
        ChoixAnnee2.setEnabled(false);
        ChoixAnnee3.setEnabled(false);
        ChoixAnnee4.setEnabled(false);
        ChoixMois2.setEnabled(false);
        ChoixSexe1.setEnabled(false);
        ChoixSexe2.setEnabled(false);
        ChoixMois3.setEnabled(false);
        ChoixAnnee5.setEnabled(false);
        Profession1.setEnabled(false);
        ChoixAnnee6.setEnabled(false);
        Profession2.setEnabled(false);
        jRadioJour.setSelected(true);
    }//GEN-LAST:event_formWindowOpened

    private void ChoixMois2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChoixMois2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChoixMois2ActionPerformed

    private void ChoixSexe1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChoixSexe1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChoixSexe1ActionPerformed

    private void ChoixSexe2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChoixSexe2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChoixSexe2ActionPerformed

    private void jRadioMoisProfessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioMoisProfessionActionPerformed
        jRadioJour.setSelected(false);
        jRadioAnnee.setSelected(false);
        jRadioTout.setSelected(false);
        jRadioMoisSexe.setSelected(false);
        jRadioMois.setSelected(false);
        jRadioAnneeSexe.setSelected(false);
        jRadioAnneeProfession.setSelected(false);
        ChoixMois.setEnabled(false);
        ChoixAnnee.setEnabled(false);
        ChoixAnnee2.setEnabled(false);
        ChoixAnnee3.setEnabled(false);
        ChoixAnnee4.setEnabled(false);
        ChoixMois2.setEnabled(false);
        ChoixSexe1.setEnabled(false);
        ChoixSexe2.setEnabled(false);
        ChoixMois3.setEnabled(true);
        ChoixAnnee5.setEnabled(true);
        Profession1.setEnabled(true);
        ChoixAnnee6.setEnabled(false);
        Profession2.setEnabled(false);
    }//GEN-LAST:event_jRadioMoisProfessionActionPerformed

    private void jRadioAnneeProfessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioAnneeProfessionActionPerformed
        jRadioJour.setSelected(false);
        jRadioAnnee.setSelected(false);
        jRadioTout.setSelected(false);
        jRadioMoisSexe.setSelected(false);
        jRadioMois.setSelected(false);
        jRadioMoisProfession.setSelected(false);
        jRadioAnneeSexe.setSelected(false);
        ChoixMois.setEnabled(false);
        ChoixAnnee.setEnabled(false);
        ChoixAnnee2.setEnabled(false);
        ChoixAnnee3.setEnabled(false);
        ChoixAnnee4.setEnabled(false);
        ChoixMois2.setEnabled(false);
        ChoixSexe1.setEnabled(false);
        ChoixSexe2.setEnabled(false);
        ChoixMois3.setEnabled(false);
        ChoixAnnee5.setEnabled(false);
        Profession1.setEnabled(false);
        ChoixAnnee6.setEnabled(true);
        Profession2.setEnabled(true);
    }//GEN-LAST:event_jRadioAnneeProfessionActionPerformed

    private void ChoixMois3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChoixMois3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChoixMois3ActionPerformed

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
            java.util.logging.Logger.getLogger(ImpressionFreqBiblio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImpressionFreqBiblio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImpressionFreqBiblio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImpressionFreqBiblio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImpressionFreqBiblio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JYearChooser ChoixAnnee;
    private com.toedter.calendar.JYearChooser ChoixAnnee2;
    private com.toedter.calendar.JYearChooser ChoixAnnee3;
    private com.toedter.calendar.JYearChooser ChoixAnnee4;
    private com.toedter.calendar.JYearChooser ChoixAnnee5;
    private com.toedter.calendar.JYearChooser ChoixAnnee6;
    private javax.swing.JComboBox ChoixMois;
    private javax.swing.JComboBox ChoixMois2;
    private javax.swing.JComboBox ChoixMois3;
    private javax.swing.JComboBox ChoixSexe1;
    private javax.swing.JComboBox ChoixSexe2;
    private javax.swing.JComboBox Profession1;
    private javax.swing.JComboBox Profession2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioAnnee;
    private javax.swing.JRadioButton jRadioAnneeProfession;
    private javax.swing.JRadioButton jRadioAnneeSexe;
    private javax.swing.JRadioButton jRadioJour;
    private javax.swing.JRadioButton jRadioMois;
    private javax.swing.JRadioButton jRadioMoisProfession;
    private javax.swing.JRadioButton jRadioMoisSexe;
    private javax.swing.JRadioButton jRadioTout;
    // End of variables declaration//GEN-END:variables
}
