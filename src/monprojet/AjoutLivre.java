

package monprojet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gloire Salva
 */
public class AjoutLivre extends javax.swing.JFrame {
    
    Connexion connect = new Connexion();
    int heureSyst = 0;
    
    public AjoutLivre() {
        initComponents();
        Voir_Abonnes_Dans_JTable();

                    AlerteHeureSortie alertCyber = new AlerteHeureSortie();
                    AlerteHeureSortie alertBiblio = new AlerteHeureSortie();
                    alertCyber.alerte();
                    alertBiblio.alerteBiblio();
    }

    
    int pos = 0;
    
    public boolean checkInputs()
    {
        if (
               txt_code.getText() == null
             ||txt_titre.getText() == null
             ||txt_auteur.getText() == null
             ||txt_NbPages.getText() == null
             ||txt_MaisonEdit.getText() == null
             ||txt_VilleEdit.getText() == null
               
           )
        {
            return false;
        }
        else {
            try{
                //String.valueOf(txt_nomAB.getText());
                   return true;
           }catch (Exception ex)
           {
               return false;
            }
        }
    }
    
    public boolean exist(){
            
            Connection cnx = connect.ConnecterBDD();
            Statement st2;
            ResultSet rs2;
            String query2 = "SELECT * FROM gestionetsuividesabonnes.livres  where titre ='"+txt_titre.getText().replaceAll("'", "''")+"' and auteur ='"+txt_auteur.getText()+"'";
        try {
            st2 = cnx.createStatement();
            rs2 = st2.executeQuery(query2);
            if(rs2.next()){
                
                JOptionPane.showMessageDialog(null, "Ce livre existe déjà");
                return true;
            }else{
               return false; 
            }
        } catch (SQLException ex) {
            Logger.getLogger(AjoutLivre.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean codeLivre(){
            
            Connection cnx = connect.ConnecterBDD();
            Statement st2;
            ResultSet rs2;
            String query2 = "SELECT * FROM gestionetsuividesabonnes.livres  where code_livre ='"+txt_code.getText()+"'";
        try {
            st2 = cnx.createStatement();
            rs2 = st2.executeQuery(query2);
            if(rs2.next()){
                
                JOptionPane.showMessageDialog(null, "Le code entré existe déja pour un autre livre!");
                return true;
            }else{
               return false; 
            }
        } catch (SQLException ex) {
            Logger.getLogger(AjoutLivre.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
     public ArrayList <EnregistrerLivre> getLivreListe()
    {
            ArrayList <EnregistrerLivre> listeLivre = new ArrayList <EnregistrerLivre>();
            Connection cnx = connect.ConnecterBDD();
            String query = "SELECT * FROM gestionetsuividesabonnes.livres  where titre like'%"+txt_titre.getText().replaceAll("'", "''")+"%'";
            
            Statement st;
            ResultSet rs;
        
        try {
             st = cnx.createStatement();
             rs = st.executeQuery(query);
             EnregistrerLivre livre;
            
            while (rs.next())
            {
                livre = new EnregistrerLivre(rs.getInt("NUM_LIVRE"), rs.getInt("CODE_LIVRE"), rs.getString("TITRE"), rs.getString("AUTEUR"), rs.getInt("NOMBRE_PAGES"), rs.getString("MAISON_EDITION"), rs.getString("VILLE_EDITION"), rs.getString("ANNEE_EDITION"),rs.getInt("NUM_EXEMPLAIRE"));
                listeLivre.add(livre);
            }
              
        } catch (SQLException ex) {
            Logger.getLogger(AjoutLivre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeLivre;
    }
    
    
    public void Exemplaire(){
        ArrayList <EnregistrerLivre> liste  = getLivreListe();
        DefaultTableModel model = (DefaultTableModel) jTable_Livre.getModel();
        
        Object[] row = new Object[9];
       for (int i = 0; i < liste.size(); i++)
        {
            row[0] = liste.get(i).getIdLivre();
            row[1] = liste.get(i).getCodeLivre(); 
            row[2] = liste.get(i).getTitre();
            row[3] = liste.get(i).getAuteur();
            row[4] = liste.get(i).getNbrePages();
            row[5] = liste.get(i).getMaisonEdition();
            row[6] = liste.get(i).getVilleEdition();
            row[7] = liste.get(i).getAnneeEdition();
            row[8] = liste.get(i).getNumExemplaire();
            
           model.addRow(row);
        }
    }
    
    
      public ArrayList <EnregistrerLivre> getLivreList()
    {
            ArrayList <EnregistrerLivre> listeLivre = new ArrayList <EnregistrerLivre>();
            Connection cnx = connect.ConnecterBDD();
            String query = "SELECT * FROM gestionetsuividesabonnes.livres";
            
            Statement st;
            ResultSet rs;
        
        try {
            
             st = cnx.createStatement();
             rs = st.executeQuery(query);
             EnregistrerLivre livre;
            
            while (rs.next())
            {
                livre = new EnregistrerLivre(rs.getInt("NUM_LIVRE"), rs.getInt("CODE_LIVRE"), rs.getString("TITRE"), rs.getString("AUTEUR"), rs.getInt("NOMBRE_PAGES"), rs.getString("MAISON_EDITION"), rs.getString("VILLE_EDITION"), rs.getString("ANNEE_EDITION"),rs.getInt("NUM_EXEMPLAIRE"));
                listeLivre.add(livre);
            }
            
              
        } catch (SQLException ex) {
            Logger.getLogger(AjoutLivre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeLivre;
    }
    
    public void Voir_Abonnes_Dans_JTable ()
    {
        ArrayList <EnregistrerLivre> liste  = getLivreList();
        DefaultTableModel model = (DefaultTableModel) jTable_Livre.getModel();
        
        Object[] row = new Object[9];
       for (int i = 0; i < liste.size(); i++)
        {
            row[0] = liste.get(i).getIdLivre();
            row[1] = liste.get(i).getCodeLivre(); 
            row[2] = liste.get(i).getTitre();
            row[3] = liste.get(i).getAuteur();
            row[4] = liste.get(i).getNbrePages();
            row[5] = liste.get(i).getMaisonEdition();
            row[6] = liste.get(i).getVilleEdition();
            row[7] = liste.get(i).getAnneeEdition();
            row[8] = liste.get(i).getNumExemplaire();
            
           model.addRow(row);
        }
    }
    
     public void ShowItem(int index)
    {
            txt_num.setText(Integer.toString(getLivreList().get(index).getIdLivre()));
            txt_code.setText(Integer.toString(getLivreList().get(index).getCodeLivre()));
            txt_titre.setText(getLivreList().get(index).getTitre());
            txt_auteur.setText(getLivreList().get(index).getAuteur());
            txt_NbPages.setText(Integer.toString(getLivreList().get(index).getNbrePages()));
            txt_MaisonEdit.setText(getLivreList().get(index).getMaisonEdition());
            txt_VilleEdit.setText(getLivreList().get(index).getVilleEdition());
            txt_exemplaire.setValue(getLivreList().get(index).getNumExemplaire());
            
        try {
             int anneeEdit = (jYearChooser_AnneeEdit.getYear());
                String year = new String();
                year = year.valueOf(anneeEdit);
                jYearChooser_AnneeEdit.setYear(anneeEdit);
                
        } catch (Exception ex) {
            Logger.getLogger(AjoutLivre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_num = new javax.swing.JTextField();
        txt_code = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btn_Actualiser = new javax.swing.JButton();
        btn_AjouterLivre = new javax.swing.JButton();
        btn_Retour = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_titre = new javax.swing.JTextField();
        txt_auteur = new javax.swing.JTextField();
        txt_NbPages = new javax.swing.JTextField();
        txt_MaisonEdit = new javax.swing.JTextField();
        txt_VilleEdit = new javax.swing.JTextField();
        jYearChooser_AnneeEdit = new com.toedter.calendar.JYearChooser();
        jLabel10 = new javax.swing.JLabel();
        txt_exemplaire = new javax.swing.JSpinner();
        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Livre = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        btn_premier = new javax.swing.JButton();
        btn_prev = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        btn_dernier = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255), 4));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("AJOUT DES LIVRES");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 3));

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Titre : ");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153), 2));
        jLabel5.setOpaque(true);

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Code Livre : ");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153), 2));
        jLabel3.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText(" Numéro : ");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153), 2));
        jLabel2.setOpaque(true);

        txt_num.setEditable(false);
        txt_num.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N

        txt_code.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 153));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Auteur : ");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153), 2));
        jLabel6.setOpaque(true);

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255), 2));

        btn_Actualiser.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        btn_Actualiser.setForeground(new java.awt.Color(0, 102, 0));
        btn_Actualiser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/new-badge-3-24.png"))); // NOI18N
        btn_Actualiser.setText("NOUVEAU");
        btn_Actualiser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Actualiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ActualiserActionPerformed(evt);
            }
        });

        btn_AjouterLivre.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        btn_AjouterLivre.setForeground(new java.awt.Color(0, 102, 0));
        btn_AjouterLivre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/add-24.png"))); // NOI18N
        btn_AjouterLivre.setText("AJOUTER");
        btn_AjouterLivre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_AjouterLivre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AjouterLivreActionPerformed(evt);
            }
        });

        btn_Retour.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        btn_Retour.setForeground(new java.awt.Color(0, 102, 0));
        btn_Retour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/arrow-80-24.png"))); // NOI18N
        btn_Retour.setText("RETOUR");
        btn_Retour.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RetourActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Retour)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_AjouterLivre, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Actualiser, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(325, 325, 325))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Actualiser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_AjouterLivre, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Retour, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText(" Nombre Pages : ");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153), 2));
        jLabel4.setOpaque(true);

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 153));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Maison d'édition : ");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153), 2));
        jLabel7.setOpaque(true);

        jLabel8.setBackground(new java.awt.Color(204, 204, 204));
        jLabel8.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 153));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Ville : ");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153), 2));
        jLabel8.setOpaque(true);

        jLabel9.setBackground(new java.awt.Color(204, 204, 204));
        jLabel9.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 153));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Année d'édition : ");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153), 2));
        jLabel9.setOpaque(true);

        txt_titre.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        txt_titre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_titreMouseClicked(evt);
            }
        });
        txt_titre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_titreActionPerformed(evt);
            }
        });
        txt_titre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_titreFocusGained(evt);
            }
        });
        txt_titre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_titreKeyReleased(evt);
            }
        });

        txt_auteur.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N

        txt_NbPages.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N

        txt_MaisonEdit.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N

        txt_VilleEdit.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N

        jYearChooser_AnneeEdit.setBackground(javax.swing.UIManager.getDefaults().getColor("TextField.background"));

        jLabel10.setBackground(new java.awt.Color(204, 204, 204));
        jLabel10.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 153));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Nombre  Exemplaires :");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153), 2));
        jLabel10.setOpaque(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_num)
                                .addComponent(txt_code, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_titre)
                                .addComponent(txt_auteur, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_NbPages)
                                    .addComponent(txt_MaisonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_VilleEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jYearChooser_AnneeEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_exemplaire)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_num, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_code, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txt_titre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_auteur, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_NbPages, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txt_MaisonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_VilleEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jYearChooser_AnneeEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_exemplaire, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel.setBackground(new java.awt.Color(153, 153, 153));
        panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));

        jTable_Livre.setBackground(new java.awt.Color(204, 102, 0));
        jTable_Livre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTable_Livre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTable_Livre.setForeground(new java.awt.Color(255, 255, 153));
        jTable_Livre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NUMERO", "CODE", "TITRE", "AUTEUR", "PAGES", "MAISON EDIT", "VILLE EDIT", "ANNEE EDIT", "N° EXEMPLAIRE"
            }
        ));
        jTable_Livre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_LivreMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Livre);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(51, 0, 51));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255), 3));

        btn_premier.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        btn_premier.setForeground(new java.awt.Color(0, 102, 0));
        btn_premier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/arrow-70-24.png"))); // NOI18N
        btn_premier.setText("PREMIER");
        btn_premier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_premier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_premierActionPerformed(evt);
            }
        });

        btn_prev.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        btn_prev.setForeground(new java.awt.Color(0, 102, 0));
        btn_prev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/arrow-72-24.png"))); // NOI18N
        btn_prev.setText("PRECEDENT");
        btn_prev.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prevActionPerformed(evt);
            }
        });

        btn_next.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        btn_next.setForeground(new java.awt.Color(0, 102, 0));
        btn_next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/arrow-47-24.png"))); // NOI18N
        btn_next.setText("SUIVANT");
        btn_next.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        btn_dernier.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        btn_dernier.setForeground(new java.awt.Color(0, 102, 0));
        btn_dernier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/arrow-45-24.png"))); // NOI18N
        btn_dernier.setText("DERNIER");
        btn_dernier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_dernier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dernierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_premier, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_prev, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btn_next, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_dernier, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_premier, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_prev, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_next, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_dernier, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(127, 127, 127)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 13, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        jMenu1.setForeground(new java.awt.Color(0, 102, 0));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/menu-4-24.png"))); // NOI18N
        jMenu1.setText("Options");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setBackground(new java.awt.Color(0, 0, 0));
        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jMenuItem1.setForeground(new java.awt.Color(204, 204, 255));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/available-updates-16.png"))); // NOI18N
        jMenuItem1.setText("Aller à Modifier");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setBackground(new java.awt.Color(0, 0, 102));
        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jMenuItem3.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/LIVRE MENU.png"))); // NOI18N
        jMenuItem3.setText("Menu Livres");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ActualiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ActualiserActionPerformed
        txt_num.setText("");
        txt_code.setText("");
        txt_titre.setText("");
        txt_auteur.setText("");
        txt_NbPages.setText("");
        txt_MaisonEdit.setText("");
        txt_VilleEdit.setText("");
        DefaultTableModel model = (DefaultTableModel) jTable_Livre.getModel();
        model.setRowCount(0);
        Voir_Abonnes_Dans_JTable ();
        
    }//GEN-LAST:event_btn_ActualiserActionPerformed

    private void btn_AjouterLivreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AjouterLivreActionPerformed
        
        if (txt_titre.getText().isEmpty() || txt_code.getText().isEmpty() || txt_auteur.getText().isEmpty() || txt_NbPages.getText().isEmpty() || txt_MaisonEdit.getText().isEmpty() || txt_VilleEdit.getText().isEmpty())
        {

            JOptionPane.showMessageDialog(null, "Un ou plusieurs champs sont vide(s)");
        } else{
            try {
                
                if(codeLivre() == false){
                
                if (exist() == false){
                
                Connection con = connect.ConnecterBDD();
                PreparedStatement pss = con.prepareStatement("INSERT INTO gestionetsuividesabonnes.livres (CODE_LIVRE, TITRE, AUTEUR, NOMBRE_PAGES, MAISON_EDITION, VILLE_EDITION, ANNEE_EDITION, NUM_EXEMPLAIRE)"
                    + " values (?,?,?,?,?,?,?,?)");
                pss.setString(1, txt_code.getText());
                pss.setString(2, txt_titre.getText());
                pss.setString(3, txt_auteur.getText());
                pss.setString(4, txt_NbPages.getText());
                pss.setString(5, txt_MaisonEdit.getText());
                pss.setString(6, txt_VilleEdit.getText());
                
               //Date anneeEdit = new Date ("yyyy");
                int anneeEdit = (jYearChooser_AnneeEdit.getYear());
                String year = new String();
                year = year.valueOf(anneeEdit);
                pss.setString(7, year);
                
                int exemplaire = (int) (txt_exemplaire.getValue());
                String SonNum = new String();
                SonNum = SonNum.valueOf(exemplaire);
                pss.setString(8, SonNum);
                
                pss.executeUpdate();
                DefaultTableModel model = (DefaultTableModel) jTable_Livre.getModel();
                model.setRowCount(0);
                Voir_Abonnes_Dans_JTable();
                txt_num.setText("");
                txt_code.setText("");
                txt_titre.setText("");
                txt_auteur.setText("");
                txt_NbPages.setText("");
                txt_MaisonEdit.setText("");
                txt_VilleEdit.setText("");
                
                JOptionPane.showMessageDialog(null, "Ajout Réussi");
                }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        } 

    }//GEN-LAST:event_btn_AjouterLivreActionPerformed

    private void btn_RetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RetourActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_RetourActionPerformed

    private void jTable_LivreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_LivreMouseClicked
//            int indexe = jTable_Livre.getSelectedRow();
//            ShowItem(indexe);
    }//GEN-LAST:event_jTable_LivreMouseClicked

    private void btn_premierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_premierActionPerformed
        pos = 0;
        ShowItem(pos);
        this.btn_premier.setEnabled(false);
        this.btn_prev.setEnabled(false);
        this.btn_next.setEnabled(true);
        this.btn_dernier.setEnabled(true);
    }//GEN-LAST:event_btn_premierActionPerformed

    private void btn_prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prevActionPerformed
        pos--;

        if(pos == 0)
        {
            this.btn_premier.setEnabled(false);
            this.btn_prev.setEnabled(false);
        }
        this.btn_next.setEnabled(true);
        this.btn_dernier.setEnabled(true);
        ShowItem(pos);
    }//GEN-LAST:event_btn_prevActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        pos++;

        if(pos == getLivreListe().size() - 1)
        {
            this.btn_next.setEnabled(false);
            this.btn_dernier.setEnabled(false);
            
        }
        this.btn_prev.setEnabled(true);
        this.btn_premier.setEnabled(true);
        ShowItem(pos);
    }//GEN-LAST:event_btn_nextActionPerformed

    private void btn_dernierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dernierActionPerformed
        pos = getLivreListe().size() - 1;
        ShowItem(pos);
        this.btn_dernier.setEnabled(false);
        this.btn_next.setEnabled(false);
        this.btn_prev.setEnabled(true);
        this.btn_premier.setEnabled(true);
    }//GEN-LAST:event_btn_dernierActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.setVisible(false);
        ModifierLivre modif = new ModifierLivre();
        modif.pack();
        modif.setLocationRelativeTo(null);
        modif.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void txt_titreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_titreMouseClicked
        
    }//GEN-LAST:event_txt_titreMouseClicked

    private void txt_titreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_titreFocusGained
 
    }//GEN-LAST:event_txt_titreFocusGained

    private void txt_titreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_titreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_titreActionPerformed

    private void txt_titreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_titreKeyReleased
//        exist();
//        DefaultTableModel model = (DefaultTableModel) jTable_Livre.getModel();
//        model.setRowCount(0);
//        Exemplaire();
        
    }//GEN-LAST:event_txt_titreKeyReleased

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
            java.util.logging.Logger.getLogger(AjoutLivre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjoutLivre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjoutLivre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjoutLivre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AjoutLivre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Actualiser;
    private javax.swing.JButton btn_AjouterLivre;
    private javax.swing.JButton btn_Retour;
    private javax.swing.JButton btn_dernier;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_premier;
    private javax.swing.JButton btn_prev;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Livre;
    private com.toedter.calendar.JYearChooser jYearChooser_AnneeEdit;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField txt_MaisonEdit;
    private javax.swing.JTextField txt_NbPages;
    private javax.swing.JTextField txt_VilleEdit;
    private javax.swing.JTextField txt_auteur;
    private javax.swing.JTextField txt_code;
    private javax.swing.JSpinner txt_exemplaire;
    private javax.swing.JTextField txt_num;
    private javax.swing.JTextField txt_titre;
    // End of variables declaration//GEN-END:variables
}
