/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package monprojet;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.Barcode;
import com.lowagie.text.pdf.Barcode128;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import static javax.swing.text.StyleConstants.ALIGN_CENTER;

/**
 *
 * @author Gloire Salva
 */
public class ModifierAb2 extends javax.swing.JFrame {
    
        Connexion connect = new Connexion();
        int heureSyst = 0;
        
    public ModifierAb2() {
        initComponents();
        connect.ConnecterBDD();
        
        Voir_Abonnes_Dans_JTable ();
        Combo();

                    AlerteHeureSortie alertCyber = new AlerteHeureSortie();
                    AlerteHeureSortie alertBiblio = new AlerteHeureSortie();
                    alertCyber.alerte();
                    alertBiblio.alerteBiblio();
        
    }
        String ImgPath = null;
        int pos = 0;
     
      public boolean checkInputs()
    {
        if (
                txt_NomAb.getText() == null
             || txt_PrenomAb.getText() == null
             || CB_Sexe.getSelectedItem()== null
             || txt_Adresse.getText() == null
             || txt_phone.getText() == null
             || txt_Mail.getText() == null
             || CB_Profession.getSelectedItem() == null
            ){
            return false;
        }
        else {
            try{
                String.valueOf(txt_NomAb.getText());
                   return true;
           }catch (Exception ex)
           {
               return false;
            }
        }
    }
     
    private void Combo(){
        PreparedStatement pst = null;
        ResultSet rs;
        Connection conn = connect.ConnecterBDD();
        try {
            String sql = "Select * from abonnes";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while (rs.next()){
                txt_idAB.addItem(rs.getString("ID_ABONNE"));
               
            }
              
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
        
     public ImageIcon ResizeImage (String ImagePath, byte[] pic)
    {
        ImageIcon monImage = null;
        if (ImagePath != null)
        {
            monImage = new ImageIcon (ImagePath);
        }else{
            monImage = new ImageIcon (pic);
        }
        Image img = monImage.getImage(); //<>
        Image img2 = img.getScaledInstance(lbl_Photo.getWidth(), lbl_Photo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        return image;
    } 
    
     public ArrayList <AbonnesEnregistrer> getAbonnesList()
    {
            ArrayList <AbonnesEnregistrer> listeAbonnes = new ArrayList <AbonnesEnregistrer>();
            Connection cnx = connect.ConnecterBDD();
            String query = "SELECT * FROM gestionetsuividesabonnes.abonnes";
            
            Statement st;
            ResultSet rs;
        
        try {
            
             st = cnx.createStatement();
             rs = st.executeQuery(query);
             AbonnesEnregistrer abonne;
            
            while (rs.next())
            {
                abonne = new AbonnesEnregistrer(rs.getInt("ID_ABONNE"), rs.getString("NOM_POSTNOM_AB"), rs.getString("PRENOM_AB"), rs.getString("SEXE"), rs.getString("ADRESSE"), rs.getString("TELEPHONE"), rs.getString("MAIL"), rs.getString("PROFESSION"), rs.getBytes("PHOTO"));
                listeAbonnes.add(abonne);
            }
            
              
        } catch (SQLException ex) {
            Logger.getLogger(EnregistrerAb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeAbonnes;
    }
     
     
     public void Voir_Abonnes_Dans_JTable ()
    {
        ArrayList <AbonnesEnregistrer> liste  = getAbonnesList();
        DefaultTableModel model = (DefaultTableModel) jTable_ab.getModel();
        
        model.setRowCount(0);
        
        Object[] row = new Object[9];
       for (int i = 0; i < liste.size(); i++)
        {
            row[0] = liste.get(i).getIdAb();
            row[1] = liste.get(i).getNomAb(); 
            row[2] = liste.get(i).getPrenomAb();
            row[3] = liste.get(i).getSexeAb();
            row[4] = liste.get(i).getAdresse();
            row[5] = liste.get(i).getTelephone();
            row[6] = liste.get(i).getMail();
            row[7] = liste.get(i).getProfession();
            row[8] = liste.get(i).getPhoto();
            
           model.addRow(row);
        }
    }
     
  
       
   
     
     public void ShowItem(int index)
    {
        txt_idAB.setSelectedItem(Integer.toString(getAbonnesList().get(index).getIdAb()));
        txt_NomAb.setText(getAbonnesList().get(index).getNomAb());
        txt_PrenomAb.setText(getAbonnesList().get(index).getPrenomAb());
        CB_Sexe.setSelectedItem(getAbonnesList().get(index).getSexeAb());
        txt_Adresse.setText(getAbonnesList().get(index).getAdresse());
        txt_phone.setText(getAbonnesList().get(index).getTelephone());
        txt_Mail.setText(getAbonnesList().get(index).getMail());
        CB_Profession.setSelectedItem(getAbonnesList().get(index).getProfession());
        lbl_Photo.setIcon(ResizeImage(null, getAbonnesList().get(index).getPhoto()));
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
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_NomAb = new javax.swing.JTextField();
        txt_PrenomAb = new javax.swing.JTextField();
        txt_Adresse = new javax.swing.JTextField();
        txt_phone = new javax.swing.JTextField();
        txt_Mail = new javax.swing.JTextField();
        CB_Profession = new javax.swing.JComboBox();
        CB_Sexe = new javax.swing.JComboBox();
        btn_ChoixPhoto = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lbl_Photo = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btn_MenuPricipal = new javax.swing.JButton();
        btn_ACTUALISER = new javax.swing.JButton();
        btn_MODIFIER = new javax.swing.JButton();
        btn_Retour = new javax.swing.JButton();
        txt_idAB = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_ab = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        btn_first = new javax.swing.JButton();
        btn_prev = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        btn_last = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 4));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MODIFICATION DES ABONNES");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1099, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 4));

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("      Identification :");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204), 2));
        jLabel2.setOpaque(true);

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText(" Nom et post-nom :");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204), 2));
        jLabel3.setOpaque(true);

        jLabel5.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("               Prénom :");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204), 2));
        jLabel5.setOpaque(true);

        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("                    Sexe :");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204), 2));
        jLabel4.setOpaque(true);

        jLabel8.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 153));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("           Adresse :");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204), 2));
        jLabel8.setOpaque(true);

        jLabel10.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 153));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("    Num Téléphone:");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204), 2));
        jLabel10.setOpaque(true);

        jLabel7.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 153));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("             Fonction :");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204), 2));
        jLabel7.setOpaque(true);

        jLabel9.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 153));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("                    Mail :");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204), 2));
        jLabel9.setOpaque(true);

        txt_NomAb.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N

        txt_PrenomAb.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N

        txt_Adresse.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N

        txt_phone.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N

        txt_Mail.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N

        CB_Profession.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        CB_Profession.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-----", "Etudiant(e)", "Enseignant", "Autre" }));

        CB_Sexe.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        CB_Sexe.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "M", "F" }));

        btn_ChoixPhoto.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        btn_ChoixPhoto.setForeground(new java.awt.Color(0, 0, 204));
        btn_ChoixPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/PIECE JOINTE.png"))); // NOI18N
        btn_ChoixPhoto.setText("CHOIX DE LA PHOTO");
        btn_ChoixPhoto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ChoixPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ChoixPhotoActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        lbl_Photo.setBackground(new java.awt.Color(102, 102, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Photo, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Photo, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 2));

        btn_MenuPricipal.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        btn_MenuPricipal.setForeground(new java.awt.Color(0, 102, 0));
        btn_MenuPricipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/home-5-32.png"))); // NOI18N
        btn_MenuPricipal.setText("MENU PRINCIPAL");
        btn_MenuPricipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_MenuPricipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MenuPricipalActionPerformed(evt);
            }
        });

        btn_ACTUALISER.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        btn_ACTUALISER.setForeground(new java.awt.Color(0, 102, 0));
        btn_ACTUALISER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/new-badge-3-32.png"))); // NOI18N
        btn_ACTUALISER.setText("NOUVEAU");
        btn_ACTUALISER.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ACTUALISER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ACTUALISERActionPerformed(evt);
            }
        });

        btn_MODIFIER.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        btn_MODIFIER.setForeground(new java.awt.Color(0, 102, 0));
        btn_MODIFIER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/MODIFIER ECRIT.png"))); // NOI18N
        btn_MODIFIER.setText("MODIFIER");
        btn_MODIFIER.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_MODIFIER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MODIFIERActionPerformed(evt);
            }
        });

        btn_Retour.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        btn_Retour.setForeground(new java.awt.Color(0, 102, 0));
        btn_Retour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/RETOUR.png"))); // NOI18N
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
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(btn_Retour, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_MODIFIER, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_ACTUALISER, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_MenuPricipal, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ACTUALISER, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_MODIFIER, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Retour, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_MenuPricipal, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txt_idAB.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_idAB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txt_idABItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txt_PrenomAb)
                                        .addGap(18, 18, 18))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(CB_Sexe, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_NomAb, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                                    .addComponent(txt_idAB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Adresse, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Mail, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CB_Profession, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ChoixPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_ChoixPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Adresse, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_idAB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_NomAb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_PrenomAb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CB_Profession, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Mail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CB_Sexe, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102), 4));

        jTable_ab.setBackground(new java.awt.Color(255, 204, 255));
        jTable_ab.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0), 3));
        jTable_ab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOM ET POST-NOM", "lPRENOM", "SEXE", "ADRESSE", "NUM TEL", "MAIL", "PROFESSION", "PHOTO"
            }
        ));
        jTable_ab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_abMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_ab);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 975, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(51, 0, 51));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 3));

        btn_first.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        btn_first.setForeground(new java.awt.Color(0, 102, 0));
        btn_first.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/FIRST.png"))); // NOI18N
        btn_first.setText("PREMIER");
        btn_first.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_first.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_firstActionPerformed(evt);
            }
        });

        btn_prev.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        btn_prev.setForeground(new java.awt.Color(0, 102, 0));
        btn_prev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/PREV.png"))); // NOI18N
        btn_prev.setText("PRECEDENT");
        btn_prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prevActionPerformed(evt);
            }
        });

        btn_next.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        btn_next.setForeground(new java.awt.Color(0, 102, 0));
        btn_next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/NEXT.png"))); // NOI18N
        btn_next.setText("SUIVANT");
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        btn_last.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        btn_last.setForeground(new java.awt.Color(0, 102, 0));
        btn_last.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/LAST.png"))); // NOI18N
        btn_last.setText("DERNIER");
        btn_last.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lastActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_first, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_prev)
                .addGap(2, 2, 2)
                .addComponent(btn_next, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_last, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_first, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_prev, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_next, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_last, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setForeground(new java.awt.Color(0, 102, 0));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/menu-4-24.png"))); // NOI18N
        jMenu1.setText("Options");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setBackground(new java.awt.Color(0, 0, 0));
        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jMenuItem1.setForeground(new java.awt.Color(204, 204, 255));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/add-user-2-16.png"))); // NOI18N
        jMenuItem1.setText("Aller à Ajouter");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setBackground(new java.awt.Color(0, 0, 102));
        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jMenuItem3.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/conference-call-16.png"))); // NOI18N
        jMenuItem3.setText("Menu Abonnés");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem4.setBackground(new java.awt.Color(0, 0, 102));
        jMenuItem4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jMenuItem4.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/home-3-16.png"))); // NOI18N
        jMenuItem4.setText("Menu Principal");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_RetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RetourActionPerformed
        Abonnes ab = new Abonnes();
        this.setVisible(false);
        ab.pack();
        ab.setLocationRelativeTo(null);
        ab.setVisible(true);
    }//GEN-LAST:event_btn_RetourActionPerformed

    private void btn_MenuPricipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MenuPricipalActionPerformed
        MenuPrinc menu = new MenuPrinc ();
        this.setVisible(false);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }//GEN-LAST:event_btn_MenuPricipalActionPerformed

    private void btn_ChoixPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ChoixPhotoActionPerformed
        JFileChooser fichier = new JFileChooser ();
        fichier.setCurrentDirectory(new File(System.getProperty("user.home")));
        
        FileNameExtensionFilter filtre = new FileNameExtensionFilter("*,images", "jpg","png");
        fichier.addChoosableFileFilter(filtre);
        int resultat = fichier.showSaveDialog(null);
        if (resultat == JFileChooser.APPROVE_OPTION)
        {
            File fichierSelectione = fichier.getSelectedFile();
            String path = fichierSelectione.getAbsolutePath();
            lbl_Photo.setIcon(ResizeImage(path, null));
            ImgPath = path;
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "Aucune image selectionnée");
        }
    }//GEN-LAST:event_btn_ChoixPhotoActionPerformed

    private void btn_ACTUALISERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ACTUALISERActionPerformed
        txt_idAB.setSelectedItem("");
        txt_NomAb.setText("");
        txt_PrenomAb.setText("");
        CB_Sexe.setSelectedItem("");
        txt_Adresse.setText("");
        txt_phone.setText("");
        txt_Mail.setText("");
        CB_Profession.setSelectedItem("");
        lbl_Photo.setIcon(null);
    }//GEN-LAST:event_btn_ACTUALISERActionPerformed

    private void btn_MODIFIERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MODIFIERActionPerformed
        if (checkInputs() && txt_idAB != null)
        {
            
            String UpdateQuery = null;
            PreparedStatement ps = null;
            Connection con = connect.ConnecterBDD();
            
            if (ImgPath == null)
            {
                try {
                    UpdateQuery = "UPDATE gestionetsuividesabonnes.abonnes SET NOM_POSTNOM_AB = ?, PRENOM_AB = ?, SEXE = ?, ADRESSE = ?, TELEPHONE = ?, MAIL = ?, PROFESSION = ? WHERE ID_ABONNE = ?";
                    ps = con.prepareStatement(UpdateQuery);
                    
                    ps.setString(1, txt_NomAb.getText());
                    ps.setString(2, txt_PrenomAb.getText());
                    ps.setString(3, (String) CB_Sexe.getSelectedItem());
                    ps.setString(4, txt_Adresse.getText());
                    ps.setString(5, txt_phone.getText());
                    ps.setString(6, txt_Mail.getText());
                    ps.setString(7, (String) CB_Profession.getSelectedItem());
                    
                    ps.setInt(8, Integer.parseInt((String) txt_idAB.getSelectedItem()));
                    
                    ps.executeUpdate(); 
                    JOptionPane.showMessageDialog(null, "Donées modifiées avec succès !!!");
                    
                    Voir_Abonnes_Dans_JTable ();
                    
                } catch (SQLException ex) {
                    Logger.getLogger(ModifierAb2.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else {
                
                try {
                InputStream img = new FileInputStream(new File(ImgPath)); 
                
                UpdateQuery = "UPDATE gestionetsuividesabonnes.abonnes SET NOM_POSTNOM_AB = ?, PRENOM_AB = ?, SEXE = ?, ADRESSE = ?, TELEPHONE = ?, MAIL = ?, PROFESSION = ?, PHOTO = ? WHERE ID_ABONNE = ?";
                
                    ps = con.prepareStatement(UpdateQuery);
                    
                    ps.setString(1, txt_NomAb.getText());
                    ps.setString(2, txt_PrenomAb.getText());
                    ps.setString(3, (String) CB_Sexe.getSelectedItem());
                    ps.setString(4, txt_Adresse.getText());
                    ps.setString(5, txt_phone.getText());
                    ps.setString(6, txt_Mail.getText());
                    ps.setString(7, (String) CB_Profession.getSelectedItem());
                    ps.setBlob(8, img);
                    
                    ps.setInt(9, Integer.parseInt((String) txt_idAB.getSelectedItem()));
                    
                    ps.executeUpdate(); 
                    Voir_Abonnes_Dans_JTable ();
                
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                
            }
        } else {
            JOptionPane.showMessageDialog(null, "Un ou plusieurs champs sont vide(s)");
        }
    }//GEN-LAST:event_btn_MODIFIERActionPerformed

    private void jTable_abMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_abMouseClicked
       int indexe = jTable_ab.getSelectedRow();
       ShowItem(indexe);
    }//GEN-LAST:event_jTable_abMouseClicked

    private void btn_firstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_firstActionPerformed
        pos = 0;
        ShowItem(pos);
        this.btn_last.setEnabled(true);
        this.btn_next.setEnabled(true);
        this.btn_prev.setEnabled(false);
        this.btn_first.setEnabled(false);
    }//GEN-LAST:event_btn_firstActionPerformed

    private void btn_prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prevActionPerformed
        pos--;

        if(pos == 0)
        {
            this.btn_first.setEnabled(false);
            this.btn_prev.setEnabled(false);
        }
        this.btn_next.setEnabled(true);
        this.btn_last.setEnabled(true);
        ShowItem(pos);
    }//GEN-LAST:event_btn_prevActionPerformed

    private void btn_lastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lastActionPerformed
        pos = getAbonnesList().size() - 1;
        ShowItem(pos);
        this.btn_last.setEnabled(false);
        this.btn_next.setEnabled(false);
        this.btn_prev.setEnabled(true);
        this.btn_first.setEnabled(true);
    }//GEN-LAST:event_btn_lastActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
      pos++;

        if(pos == getAbonnesList().size() - 1)
        {
            this.btn_next.setEnabled(false);
            this.btn_last.setEnabled(false);
            
        }
        this.btn_first.setEnabled(true);
        this.btn_prev.setEnabled(true);
        ShowItem(pos);
    }//GEN-LAST:event_btn_nextActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        EnregistrerAb enregistrerAb = new EnregistrerAb();
        this.setVisible(false);
        enregistrerAb.pack();
        enregistrerAb.setLocationRelativeTo(null);
        enregistrerAb.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Abonnes ab = new Abonnes();
        this.setVisible(false);
        ab.pack();
        ab.setLocationRelativeTo(null);
        ab.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        MenuPrinc menu = new MenuPrinc ();
        this.setVisible(false);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void txt_idABItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txt_idABItemStateChanged
        Statement state = null;
        ResultSet res;
        Connection cnx = connect.ConnecterBDD();
         try {
             
             state = cnx.createStatement();
             res = state.executeQuery("select * from abonnes where ID_ABONNE = '" +txt_idAB.getSelectedItem() + "'");
             if (res.next()){
                 String nom = res.getString("NOM_POSTNOM_AB");
                 String prenom = res.getString("PRENOM_AB");
                 String sexe = res.getString("SEXE");
                 String adresse = res.getString("ADRESSE");
                 String tel = res.getString("TELEPHONE");
                 String mail = res.getString("MAIL");
                 String profession = res.getString("PROFESSION");
                 
                 this.txt_NomAb.setText(nom);
                 this.txt_PrenomAb.setText(prenom);
                 this.CB_Sexe.setSelectedItem(sexe);
                 this.txt_Adresse.setText(adresse);
                 this.txt_Mail.setText(mail);
                 this.txt_phone.setText(tel);
                 this.CB_Profession.setSelectedItem(profession);
             }
             
             
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Erreur non spécifié" +e);
         }
    }//GEN-LAST:event_txt_idABItemStateChanged

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
            java.util.logging.Logger.getLogger(ModifierAb2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifierAb2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifierAb2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifierAb2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifierAb2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox CB_Profession;
    private javax.swing.JComboBox CB_Sexe;
    private javax.swing.JButton btn_ACTUALISER;
    private javax.swing.JButton btn_ChoixPhoto;
    private javax.swing.JButton btn_MODIFIER;
    private javax.swing.JButton btn_MenuPricipal;
    private javax.swing.JButton btn_Retour;
    private javax.swing.JButton btn_first;
    private javax.swing.JButton btn_last;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_prev;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable jTable_ab;
    private javax.swing.JLabel lbl_Photo;
    private javax.swing.JTextField txt_Adresse;
    private javax.swing.JTextField txt_Mail;
    private javax.swing.JTextField txt_NomAb;
    private javax.swing.JTextField txt_PrenomAb;
    private javax.swing.JComboBox txt_idAB;
    private javax.swing.JTextField txt_phone;
    // End of variables declaration//GEN-END:variables
}
