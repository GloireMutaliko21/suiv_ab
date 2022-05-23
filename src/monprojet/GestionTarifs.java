/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package monprojet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gloire Salva
 */
public class GestionTarifs extends javax.swing.JFrame {

    Connexion connect = new Connexion();
    int heureSyst = 0;
    
    public GestionTarifs() {
        initComponents();
        connect.ConnecterBDD();
        Combos();
        Voir_Tarif_Dans_JTable ();
        Voir_TarifEnseignant_Dans_JTable ();
        Voir_Autre_Dans_JTable ();
        
       this.prev.setEnabled(false);
       this.first.setEnabled(false);
       this.prev2.setEnabled(false);
       this.first2.setEnabled(false);
       this.prev3.setEnabled(false);
       this.first3.setEnabled(false);
       
       
       AlerteHeureSortie alertCyber = new AlerteHeureSortie();
                    AlerteHeureSortie alertBiblio = new AlerteHeureSortie();
                    alertCyber.alerte();
                    alertBiblio.alerteBiblio();
    }

    int pos = 0;
   
    private void Combos(){
        PreparedStatement pst = null;
        ResultSet rs;
        Connection conn = connect.ConnecterBDD();
        try {
            String sql2 = "Select * from tarif_etudiant";
            pst = conn.prepareStatement(sql2);
            rs = pst.executeQuery();

            while (rs.next()){
                cb_numEt.addItem(rs.getString("id_tarif"));
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        try {
            String sql = "Select * from tarif_enseignant";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while (rs.next()){
                cb_numEn.addItem(rs.getString("id_tarif"));
            }
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        try {
            String sql3 = "Select * from tarif_autre";
            pst = conn.prepareStatement(sql3);
            rs = pst.executeQuery();
            
            while (rs.next()){
                cb_numTi.addItem(rs.getString("id_tarif"));
            }
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    
    
    
    public ArrayList <Tarif> getTarifList()
    {
            ArrayList <Tarif> listeTarifEt = new ArrayList <Tarif>();
            Connection cnx = connect.ConnecterBDD();
            String query = "SELECT * FROM tarif_etudiant";
            
            
            Statement st;
            ResultSet rs;
        
        try {
            
             st = cnx.createStatement();
             rs = st.executeQuery(query);
             Tarif tarf;
            
            while (rs.next())
            {
                tarf = new Tarif(rs.getInt("id_tarif"), rs.getString("intitule"), rs.getString("montant"));
                listeTarifEt.add(tarf);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionTarifs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeTarifEt;
    }
    
    public ArrayList <Tarif> getTarifEnseignantList()
    {
            ArrayList <Tarif> listeTarifEt = new ArrayList <Tarif>();
            Connection cnx = connect.ConnecterBDD();
            String query2 = "SELECT * FROM tarif_enseignant";
            
            
            Statement st;
            ResultSet rs;
        
        
        try {
            
             st = cnx.createStatement();
             rs = st.executeQuery(query2);
             Tarif tarf2;
            
            while (rs.next())
            {
                tarf2 = new Tarif(rs.getInt("id_tarif"), rs.getString("intitule"), rs.getString("montant"));
                listeTarifEt.add(tarf2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionTarifs.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listeTarifEt;
    }
    
    
    public ArrayList <Tarif> getTarifAutreList()
    {
            ArrayList <Tarif> listeTarifEt = new ArrayList <Tarif>();
            Connection cnx = connect.ConnecterBDD();
            String query2 = "SELECT * FROM tarif_autre";
            
            
            Statement st;
            ResultSet rs;
        
        
        try {
            
             st = cnx.createStatement();
             rs = st.executeQuery(query2);
             Tarif tarf2;
            
            while (rs.next())
            {
                tarf2 = new Tarif(rs.getInt("id_tarif"), rs.getString("intitule"), rs.getString("montant"));
                listeTarifEt.add(tarf2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionTarifs.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listeTarifEt;
    }
    
    
    public void Voir_Tarif_Dans_JTable ()
    {
        ArrayList <Tarif> liste  = getTarifList();
        DefaultTableModel model = (DefaultTableModel) tableEt.getModel();
        
        Object[] row = new Object[3];
       for (int i = 0; i < liste.size(); i++)
        {
            row[0] = liste.get(i).getId();
            row[1] = liste.get(i).getIntitule();
            row[2] = liste.get(i).getPrix();;
            
           model.addRow(row);
        }
    }
    
    public void Voir_TarifEnseignant_Dans_JTable ()
    {
        ArrayList <Tarif> liste  = getTarifEnseignantList();
        DefaultTableModel model = (DefaultTableModel) tableEn.getModel();
        
        Object[] row = new Object[3];
       for (int i = 0; i < liste.size(); i++)
        {
            row[0] = liste.get(i).getId();
            row[1] = liste.get(i).getIntitule();
            row[2] = liste.get(i).getPrix();;
            
           model.addRow(row);
        }
    }
    
    
    public void Voir_Autre_Dans_JTable ()
    {
        ArrayList <Tarif> liste  = getTarifAutreList();
        DefaultTableModel model = (DefaultTableModel) tableTi.getModel();
        
        Object[] row = new Object[3];
       for (int i = 0; i < liste.size(); i++)
        {
            row[0] = liste.get(i).getId();
            row[1] = liste.get(i).getIntitule();
            row[2] = liste.get(i).getPrix();;
            
           model.addRow(row);
        }
    }
    
    
     public void ShowItem1(int index)
    {
            cb_numEt.setSelectedItem((Integer.toString(getTarifList().get(index).getId())));
            txt_typeEt.setText(getTarifList().get(index).getIntitule());
            txt_PrixEt.setText(getTarifList().get(index).getPrix());
    }
     
     public void ShowItem2(int index)
    {
            cb_numEn.setSelectedItem((Integer.toString(getTarifEnseignantList().get(index).getId())));
            txt_typeEn.setText(getTarifEnseignantList().get(index).getIntitule());
            txt_PrixEn.setText(getTarifEnseignantList().get(index).getPrix());
    }
     
     public void ShowItem3(int index)
    {
            cb_numTi.setSelectedItem((Integer.toString(getTarifAutreList().get(index).getId())));
            txt_typeTi.setText(getTarifAutreList().get(index).getIntitule());
            txt_PrixTi.setText(getTarifAutreList().get(index).getPrix());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Etudiant = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_typeEt = new javax.swing.JTextField();
        txt_PrixEt = new javax.swing.JTextField();
        cb_numEt = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEt = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        update = new javax.swing.JButton();
        Retour4 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        first = new javax.swing.JButton();
        last = new javax.swing.JButton();
        next = new javax.swing.JButton();
        prev = new javax.swing.JButton();
        Enseignant = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_typeEn = new javax.swing.JTextField();
        txt_PrixEn = new javax.swing.JTextField();
        cb_numEn = new javax.swing.JComboBox();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableEn = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        updateEn = new javax.swing.JButton();
        Retour2 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        first2 = new javax.swing.JButton();
        last2 = new javax.swing.JButton();
        next2 = new javax.swing.JButton();
        prev2 = new javax.swing.JButton();
        Tiers = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_typeTi = new javax.swing.JTextField();
        txt_PrixTi = new javax.swing.JTextField();
        cb_numTi = new javax.swing.JComboBox();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableTi = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        updateTi = new javax.swing.JButton();
        Retour1 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        first3 = new javax.swing.JButton();
        last3 = new javax.swing.JButton();
        next3 = new javax.swing.JButton();
        prev3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 5));

        Etudiant.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255), 4));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153), 3));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TARIF DES ETUDIANTS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153), 3));

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Numero : ");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 51, 255), 2));
        jLabel2.setOpaque(true);

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Type abonnement : ");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 51, 255), 2));
        jLabel3.setOpaque(true);

        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Prix : ");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 51, 255), 2));
        jLabel4.setOpaque(true);

        txt_typeEt.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        txt_typeEt.setFont(new java.awt.Font("Lucida Fax", 1, 16)); // NOI18N

        txt_PrixEt.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        txt_PrixEt.setFont(new java.awt.Font("Lucida Fax", 1, 16)); // NOI18N

        cb_numEt.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_numEtItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_typeEt, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_PrixEt, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cb_numEt, 0, 169, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(cb_numEt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_typeEt)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_PrixEt))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 102, 0));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 204), 3));

        tableEt.setBackground(new java.awt.Color(102, 51, 255));
        tableEt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tableEt.setForeground(new java.awt.Color(255, 255, 255));
        tableEt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NUM", "TYPE", "PRIX"
            }
        ));
        jScrollPane1.setViewportView(tableEt);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(0, 51, 51));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0), 2));

        update.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        update.setForeground(new java.awt.Color(0, 0, 204));
        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/MODIF.png"))); // NOI18N
        update.setText("MODIFIER");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        Retour4.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        Retour4.setForeground(new java.awt.Color(0, 102, 0));
        Retour4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/RETOUR.png"))); // NOI18N
        Retour4.setText("RETOUR");
        Retour4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Retour4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Retour4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(update)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Retour4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        first.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/FIRST.png"))); // NOI18N
        first.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstActionPerformed(evt);
            }
        });

        last.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/LAST.png"))); // NOI18N
        last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastActionPerformed(evt);
            }
        });

        next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/NEXT.png"))); // NOI18N
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        prev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/PREV.png"))); // NOI18N
        prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(first, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(prev, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 60, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(last, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prev, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(last, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(first, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout EtudiantLayout = new javax.swing.GroupLayout(Etudiant);
        Etudiant.setLayout(EtudiantLayout);
        EtudiantLayout.setHorizontalGroup(
            EtudiantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EtudiantLayout.createSequentialGroup()
                .addGroup(EtudiantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EtudiantLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(EtudiantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EtudiantLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(EtudiantLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(EtudiantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(EtudiantLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        EtudiantLayout.setVerticalGroup(
            EtudiantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EtudiantLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Enseignant.setBackground(new java.awt.Color(204, 204, 204));
        Enseignant.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 153), 4));

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153), 3));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("TARIF DES ENSEIGNANTS");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153), 3));

        jLabel6.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Numero : ");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 51, 255), 2));
        jLabel6.setOpaque(true);

        jLabel7.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 0, 204));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Type abonnement : ");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 51, 255), 2));
        jLabel7.setOpaque(true);

        jLabel8.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 0, 204));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Prix : ");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 51, 255), 2));
        jLabel8.setOpaque(true);

        txt_typeEn.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        txt_typeEn.setFont(new java.awt.Font("Lucida Fax", 1, 16)); // NOI18N

        txt_PrixEn.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        txt_PrixEn.setFont(new java.awt.Font("Lucida Fax", 1, 16)); // NOI18N

        cb_numEn.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_numEnItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_typeEn, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_PrixEn, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cb_numEn, 0, 169, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(cb_numEn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_typeEn)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_PrixEn))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(0, 153, 153));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 204), 3));

        tableEn.setBackground(new java.awt.Color(153, 0, 204));
        tableEn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tableEn.setForeground(new java.awt.Color(255, 255, 204));
        tableEn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NUM", "TYPE", "PRIX"
            }
        ));
        jScrollPane2.setViewportView(tableEn);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(0, 0, 102));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        updateEn.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        updateEn.setForeground(new java.awt.Color(0, 102, 0));
        updateEn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/MODIF.png"))); // NOI18N
        updateEn.setText("MODIFIER");
        updateEn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateEnActionPerformed(evt);
            }
        });

        Retour2.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        Retour2.setForeground(new java.awt.Color(0, 102, 0));
        Retour2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/RETOUR.png"))); // NOI18N
        Retour2.setText("RETOUR");
        Retour2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Retour2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Retour2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(updateEn)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateEn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Retour2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        first2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/FIRST.png"))); // NOI18N
        first2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                first2ActionPerformed(evt);
            }
        });

        last2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/LAST.png"))); // NOI18N
        last2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                last2ActionPerformed(evt);
            }
        });

        next2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/NEXT.png"))); // NOI18N
        next2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next2ActionPerformed(evt);
            }
        });

        prev2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/PREV.png"))); // NOI18N
        prev2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prev2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(first2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(prev2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(next2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(last2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prev2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(next2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(last2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(first2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout EnseignantLayout = new javax.swing.GroupLayout(Enseignant);
        Enseignant.setLayout(EnseignantLayout);
        EnseignantLayout.setHorizontalGroup(
            EnseignantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EnseignantLayout.createSequentialGroup()
                .addGroup(EnseignantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EnseignantLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(EnseignantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(EnseignantLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(EnseignantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EnseignantLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(EnseignantLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        EnseignantLayout.setVerticalGroup(
            EnseignantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EnseignantLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Tiers.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 204), 4));

        jPanel15.setBackground(new java.awt.Color(204, 204, 204));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153), 3));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 204));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("TARIF DES TIERS");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel16.setBackground(new java.awt.Color(204, 204, 204));
        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153), 3));

        jLabel10.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 153));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Numero : ");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 51, 255), 2));
        jLabel10.setOpaque(true);

        jLabel11.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 153));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Type abonnement : ");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 51, 255), 2));
        jLabel11.setOpaque(true);

        jLabel12.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 153));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Prix : ");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 51, 255), 2));
        jLabel12.setOpaque(true);

        txt_typeTi.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        txt_typeTi.setFont(new java.awt.Font("Lucida Fax", 1, 16)); // NOI18N

        txt_PrixTi.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        txt_PrixTi.setFont(new java.awt.Font("Lucida Fax", 1, 16)); // NOI18N

        cb_numTi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_numTiItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_typeTi, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_PrixTi, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cb_numTi, 0, 169, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(cb_numTi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_typeTi)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_PrixTi))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel17.setBackground(new java.awt.Color(51, 0, 153));
        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 204), 3));

        tableTi.setBackground(new java.awt.Color(51, 51, 51));
        tableTi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tableTi.setForeground(new java.awt.Color(255, 0, 255));
        tableTi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NUM", "TYPE", "PRIX"
            }
        ));
        jScrollPane3.setViewportView(tableTi);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel18.setBackground(new java.awt.Color(0, 204, 153));
        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 2));

        updateTi.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        updateTi.setForeground(new java.awt.Color(0, 102, 0));
        updateTi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/MODIF.png"))); // NOI18N
        updateTi.setText("MODIFIER");
        updateTi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateTiActionPerformed(evt);
            }
        });

        Retour1.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        Retour1.setForeground(new java.awt.Color(0, 102, 0));
        Retour1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/RETOUR.png"))); // NOI18N
        Retour1.setText("RETOUR");
        Retour1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Retour1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(154, Short.MAX_VALUE)
                .addComponent(updateTi)
                .addContainerGap())
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel18Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Retour1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(154, Short.MAX_VALUE)))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(updateTi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel18Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Retour1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel19.setBackground(new java.awt.Color(204, 204, 204));
        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        first3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/FIRST.png"))); // NOI18N
        first3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                first3ActionPerformed(evt);
            }
        });

        last3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/LAST.png"))); // NOI18N
        last3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                last3ActionPerformed(evt);
            }
        });

        next3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/NEXT.png"))); // NOI18N
        next3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next3ActionPerformed(evt);
            }
        });

        prev3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/PREV.png"))); // NOI18N
        prev3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prev3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(first3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(prev3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(next3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(last3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prev3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(next3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(last3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(first3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout TiersLayout = new javax.swing.GroupLayout(Tiers);
        Tiers.setLayout(TiersLayout);
        TiersLayout.setHorizontalGroup(
            TiersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TiersLayout.createSequentialGroup()
                .addGroup(TiersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TiersLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(TiersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TiersLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(TiersLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(TiersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TiersLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        TiersLayout.setVerticalGroup(
            TiersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TiersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Etudiant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Enseignant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Tiers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(409, 409, 409))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Tiers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Enseignant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Etudiant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu2.setForeground(new java.awt.Color(0, 102, 0));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/help-24.gif"))); // NOI18N
        jMenu2.setText("Aide");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItem9.setBackground(new java.awt.Color(0, 0, 102));
        jMenuItem9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenuItem9.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/help-24.gif"))); // NOI18N
        jMenuItem9.setText("Guide Utilisateur");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem9);

        jMenuItem11.setBackground(new java.awt.Color(0, 0, 102));
        jMenuItem11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenuItem11.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem11.setText("Contactez-nous");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem11);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1187, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_numEtItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_numEtItemStateChanged
        Statement state = null;
        ResultSet res;
        Connection cnx = connect.ConnecterBDD();
        try {
            state = cnx.createStatement();
            res = state.executeQuery("select * from tarif_etudiant where id_tarif = '" +cb_numEt.getSelectedItem() + "'");
            if (res.next()){
                String type = res.getString("intitule");
                String prix = res.getString("montant");

                this.txt_typeEt.setText(type);
                this.txt_PrixEt.setText(prix);  
                
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur non spécifié" +e);
        }
    }//GEN-LAST:event_cb_numEtItemStateChanged

    private void cb_numEnItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_numEnItemStateChanged
        Statement state = null;
        ResultSet res;
        Connection cnx = connect.ConnecterBDD();
        try {
            state = cnx.createStatement();
            res = state.executeQuery("select * from tarif_enseignant where id_tarif = '" +cb_numEn.getSelectedItem() + "'");
            if (res.next()){
                String type = res.getString("intitule");
                String prix = res.getString("montant");

                this.txt_typeEn.setText(type);
                this.txt_PrixEn.setText(prix);  
                
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur non spécifié" +e);
        }
    }//GEN-LAST:event_cb_numEnItemStateChanged

    private void cb_numTiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_numTiItemStateChanged
        Statement state = null;
        ResultSet res;
        Connection cnx = connect.ConnecterBDD();
        try {
            state = cnx.createStatement();
            res = state.executeQuery("select * from tarif_autre where id_tarif = '" +cb_numTi.getSelectedItem() + "'");
            if (res.next()){
                String type = res.getString("intitule");
                String prix = res.getString("montant");

                this.txt_typeTi.setText(type);
                this.txt_PrixTi.setText(prix);  
                
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur non spécifié" +e);
        }
    }//GEN-LAST:event_cb_numTiItemStateChanged

    private void Retour1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Retour1ActionPerformed
        Paiements paie = new Paiements();
        this.setVisible(false);
        paie.pack();
        paie.setLocationRelativeTo(null);
        paie.setVisible(true);
    }//GEN-LAST:event_Retour1ActionPerformed

    private void Retour2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Retour2ActionPerformed
        Paiements paie = new Paiements();
        this.setVisible(false);
        paie.pack();
        paie.setLocationRelativeTo(null);
        paie.setVisible(true);
    }//GEN-LAST:event_Retour2ActionPerformed

    private void Retour4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Retour4ActionPerformed
        Paiements paie = new Paiements();
        this.setVisible(false);
        paie.pack();
        paie.setLocationRelativeTo(null);
        paie.setVisible(true);
    }//GEN-LAST:event_Retour4ActionPerformed

    private void firstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstActionPerformed
        pos = 0;
        ShowItem1(pos);
        this.prev.setEnabled(false);
        this.first.setEnabled(false);
        this.next.setEnabled(true);
        this.last.setEnabled(true);
    }//GEN-LAST:event_firstActionPerformed

    private void prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevActionPerformed
        pos--;

        if(pos == 0)
        {
            this.prev.setEnabled(false);
            this.first.setEnabled(false);
        }
        this.next.setEnabled(true);
        this.last.setEnabled(true);
        ShowItem1(pos);
    }//GEN-LAST:event_prevActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        pos++;

        if(pos == getTarifList().size() - 1)
        {
            this.next.setEnabled(false);
            this.last.setEnabled(false);

        }
        this.prev.setEnabled(true);
        this.first.setEnabled(true);
        ShowItem1(pos);
    }//GEN-LAST:event_nextActionPerformed

    private void lastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastActionPerformed
        pos = getTarifList().size() - 1;
        ShowItem1(pos);
        this.next.setEnabled(false);
        this.last.setEnabled(false);
        this.prev.setEnabled(true);
        this.first.setEnabled(true);
    }//GEN-LAST:event_lastActionPerformed

    private void first2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_first2ActionPerformed
        pos = 0;
        ShowItem2(pos);
        this.prev2.setEnabled(false);
        this.first2.setEnabled(false);
        this.next2.setEnabled(true);
        this.last2.setEnabled(true);
    }//GEN-LAST:event_first2ActionPerformed

    private void prev2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prev2ActionPerformed
        pos--;

        if(pos == 0)
        {
            this.prev2.setEnabled(false);
            this.first2.setEnabled(false);
        }
        this.next2.setEnabled(true);
        this.last2.setEnabled(true);
        ShowItem2(pos);
    }//GEN-LAST:event_prev2ActionPerformed

    private void next2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next2ActionPerformed
        pos++;

        if(pos == getTarifEnseignantList().size() - 1)
        {
            this.next2.setEnabled(false);
            this.last2.setEnabled(false);

        }
        this.prev2.setEnabled(true);
        this.first2.setEnabled(true);
        ShowItem2(pos);
    }//GEN-LAST:event_next2ActionPerformed

    private void last2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_last2ActionPerformed
        pos = getTarifEnseignantList().size() - 1;
        ShowItem2(pos);
        this.next2.setEnabled(false);
        this.last2.setEnabled(false);
        this.prev2.setEnabled(true);
        this.first2.setEnabled(true);
    }//GEN-LAST:event_last2ActionPerformed

    private void first3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_first3ActionPerformed
        pos = 0;
        ShowItem3(pos);
        this.prev3.setEnabled(false);
        this.first3.setEnabled(false);
        this.next3.setEnabled(true);
        this.last3.setEnabled(true);
    }//GEN-LAST:event_first3ActionPerformed

    private void prev3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prev3ActionPerformed
        pos--;

        if(pos == 0)
        {
            this.prev3.setEnabled(false);
            this.first3.setEnabled(false);
        }
        this.next3.setEnabled(true);
        this.last3.setEnabled(true);
        ShowItem3(pos);
    }//GEN-LAST:event_prev3ActionPerformed

    private void next3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next3ActionPerformed
        pos++;

        if(pos == getTarifAutreList().size() - 1)
        {
            this.next3.setEnabled(false);
            this.last3.setEnabled(false);

        }
        this.prev3.setEnabled(true);
        this.first3.setEnabled(true);
        ShowItem3(pos);
    }//GEN-LAST:event_next3ActionPerformed

    private void last3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_last3ActionPerformed
        pos = getTarifAutreList().size() - 1;
        ShowItem3(pos);
        this.next3.setEnabled(false);
        this.last3.setEnabled(false);
        this.prev3.setEnabled(true);
        this.first3.setEnabled(true);
    }//GEN-LAST:event_last3ActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        if(txt_typeEt.getText() == null || txt_PrixEt.getText() == null){
            JOptionPane.showMessageDialog(null, "Completez les champs vides");
        } else {
            
            String update = null;
            PreparedStatement ps = null;
            Connection con = connect.ConnecterBDD();

            try {

                update = "UPDATE tarif_etudiant SET intitule = ?, montant = ? WHERE id_tarif = '"+ cb_numEt.getSelectedItem()+"'";
                ps = con.prepareStatement(update);
                
                ps.setString(1, txt_typeEt.getText());
                ps.setString(2, txt_PrixEt.getText());
                
                ps.executeUpdate();
                
                
                Voir_Tarif_Dans_JTable ();
                JOptionPane.showMessageDialog(null, "Modification Réussie");
                
                    
            }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Erreur d'enregistrement  " +e.getMessage());
            }
         
        }
        
    }//GEN-LAST:event_updateActionPerformed

    private void updateEnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateEnActionPerformed
         if(txt_typeEn.getText() == null || txt_PrixEn.getText() == null){
            JOptionPane.showMessageDialog(null, "Completez les champs vides");
        } else {
            
            String update = null;
            PreparedStatement ps = null;
            Connection con = connect.ConnecterBDD();

            try {

                update = "UPDATE tarif_enseignant SET intitule = ?, montant = ? WHERE id_tarif = '"+ cb_numEn.getSelectedItem()+"'";
                ps = con.prepareStatement(update);
                
                ps.setString(1, txt_typeEn.getText());
                ps.setString(2, txt_PrixEn.getText());
                
                ps.executeUpdate();
                
                
                Voir_TarifEnseignant_Dans_JTable ();
                JOptionPane.showMessageDialog(null, "Modification Réussie");
                
                    
            }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Erreur d'enregistrement  " +e.getMessage());
            }
         
        }
    }//GEN-LAST:event_updateEnActionPerformed

    private void updateTiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateTiActionPerformed
        if(txt_typeTi.getText() == null || txt_PrixTi.getText() == null){
            JOptionPane.showMessageDialog(null, "Completez les champs vides");
        } else {
            
            String update = null;
            PreparedStatement ps = null;
            Connection con = connect.ConnecterBDD();

            try {

                update = "UPDATE tarif_autre SET intitule = ?, montant = ? WHERE id_tarif = '"+ cb_numTi.getSelectedItem()+"'";
                ps = con.prepareStatement(update);
                
                ps.setString(1, txt_typeTi.getText());
                ps.setString(2, txt_PrixTi.getText());
                
                ps.executeUpdate();
                
                
                Voir_Autre_Dans_JTable ();
                JOptionPane.showMessageDialog(null, "Modification Réussie");
                
                    
            }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Erreur d'enregistrement  " +e.getMessage());
            }
         
        }
    }//GEN-LAST:event_updateTiActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        Interfaces inter = new Interfaces();
        inter.setLocationRelativeTo(null);
        inter.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        MeContacter mc = new MeContacter();
        mc.pack();
        mc.setLocationRelativeTo(null);
        mc.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

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
            java.util.logging.Logger.getLogger(GestionTarifs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionTarifs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionTarifs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionTarifs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionTarifs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Enseignant;
    private javax.swing.JPanel Etudiant;
    private javax.swing.JButton Retour1;
    private javax.swing.JButton Retour2;
    private javax.swing.JButton Retour4;
    private javax.swing.JPanel Tiers;
    private javax.swing.JComboBox cb_numEn;
    private javax.swing.JComboBox cb_numEt;
    private javax.swing.JComboBox cb_numTi;
    private javax.swing.JButton first;
    private javax.swing.JButton first2;
    private javax.swing.JButton first3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton last;
    private javax.swing.JButton last2;
    private javax.swing.JButton last3;
    private javax.swing.JButton next;
    private javax.swing.JButton next2;
    private javax.swing.JButton next3;
    private javax.swing.JButton prev;
    private javax.swing.JButton prev2;
    private javax.swing.JButton prev3;
    private javax.swing.JTable tableEn;
    private javax.swing.JTable tableEt;
    private javax.swing.JTable tableTi;
    private javax.swing.JTextField txt_PrixEn;
    private javax.swing.JTextField txt_PrixEt;
    private javax.swing.JTextField txt_PrixTi;
    private javax.swing.JTextField txt_typeEn;
    private javax.swing.JTextField txt_typeEt;
    private javax.swing.JTextField txt_typeTi;
    private javax.swing.JButton update;
    private javax.swing.JButton updateEn;
    private javax.swing.JButton updateTi;
    // End of variables declaration//GEN-END:variables
}
