/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package monprojet;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gloire Salva
 */
public class ModifierUser extends javax.swing.JFrame {
    
    Connexion connect = new Connexion();
    int heureSyst = 0;
    
    public ModifierUser() {
        initComponents();
        connect.ConnecterBDD();
        Voir_Users_Dans_JTable ();
        Combo();

                    AlerteHeureSortie alertCyber = new AlerteHeureSortie();
                    AlerteHeureSortie alertBiblio = new AlerteHeureSortie();
                    alertCyber.alerte();
                    alertBiblio.alerteBiblio();
    }

   String ImgPath;
    int pos = 0;
    
    private void Combo(){
        PreparedStatement pst = null;
        ResultSet rs;
        Connection conn = connect.ConnecterBDD();
        try {
            String sql = "Select * from percepteurs";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while (rs.next()){
                txt_num.addItem(rs.getString("ID_PERCEPTEUR"));
            }
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public boolean checkInputs()
    {
        if (
               UserName.getText() == ""
             ||PassWord.getPassword() == null
             ||NewPassWord.getPassword() == null
             ||PassWordConfirm.getPassword() == null
             ||CB_Fonction.getSelectedItem() == "------"
            ){
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
        Image img2 = img.getScaledInstance(lbl_image.getWidth(), lbl_image.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        return image;
    }

     public ArrayList <EnregistrerUtilisateurs> getUsersList()
    {
            ArrayList <EnregistrerUtilisateurs> listeUser = new ArrayList <EnregistrerUtilisateurs>();
            Connection cnx = connect.ConnecterBDD();
            String query = "SELECT * FROM gestionetsuividesabonnes.percepteurs";
            
            Statement st;
            ResultSet rs;
        
        try {
            
             st = cnx.createStatement();
             rs = st.executeQuery(query);
             EnregistrerUtilisateurs User;
            
            while (rs.next())
            {
                User = new EnregistrerUtilisateurs(rs.getInt("ID_PERCEPTEUR"), rs.getString("USER_NAME"), rs.getString("PASSWORD"), rs.getString("FONCTION"), rs.getBytes("PHOTO"));
                listeUser.add(User);
            }
            
              
        } catch (SQLException ex) {
            Logger.getLogger(AjoutPerc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeUser;
    }
    
     
      public void Voir_Users_Dans_JTable ()
    {
        ArrayList <EnregistrerUtilisateurs> liste  = getUsersList();
        DefaultTableModel model = (DefaultTableModel) table_User.getModel();
        
        model.setRowCount(0);
        
        Object[] row = new Object[4];
       for (int i = 0; i < liste.size(); i++)
        {
            row[0] = liste.get(i).getNum();
            row[1] = liste.get(i).getUserName();
            row[2] = liste.get(i).getFonctionUtil();
            row[3] = liste.get(i).getPhoto();
            
           model.addRow(row);
        }
    }
    
      
       public void ShowItem(int index)
    {
        txt_num.setSelectedItem(Integer.toString(getUsersList().get(index).getNum()));
        UserName.setText((getUsersList().get(index).getUserName()));
        CB_Fonction.setSelectedItem((getUsersList().get(index).getFonctionUtil()));
        lbl_image.setIcon(ResizeImage(null, getUsersList().get(index).getPhoto()));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        UserName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        NewPassWord = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        PassWordConfirm = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        CB_Fonction = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        lbl_image = new javax.swing.JLabel();
        btn_choixPic = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btn_retour = new javax.swing.JButton();
        btn_Modifier = new javax.swing.JButton();
        btn_actualiser = new javax.swing.JButton();
        btn_MP = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        PassWord = new javax.swing.JPasswordField();
        txt_num = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_User = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        btn_premier = new javax.swing.JButton();
        btn_prev = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        btn_dernier = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MODIFICATION DES UTILISATEURS");

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gloire Salva\\Desktop\\Apple\\businessman-48.png")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 4));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel6.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Numéro : ");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255), 2));
        jLabel6.setOpaque(true);

        jLabel7.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("User Name : ");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255), 2));
        jLabel7.setOpaque(true);

        UserName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        UserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserNameActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 204));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("New PassWord : ");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255), 2));
        jLabel8.setOpaque(true);

        NewPassWord.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 204));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Confirm PassWord : ");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255), 2));
        jLabel9.setOpaque(true);

        PassWordConfirm.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 204));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Fonction : ");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255), 2));
        jLabel10.setOpaque(true);

        CB_Fonction.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CB_Fonction.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "------", "Administrateur", "Bibliothécaire", "Gestionnaire Cyber", "Secrétaire" }));

        jPanel5.setBackground(new java.awt.Color(0, 0, 153));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 4));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_image, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_choixPic.setFont(new java.awt.Font("Eras Bold ITC", 1, 14)); // NOI18N
        btn_choixPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/paperclip-24.png"))); // NOI18N
        btn_choixPic.setText("CHOIX DE LA PHOTO");
        btn_choixPic.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_choixPic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_choixPicActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 204), 3));

        btn_retour.setFont(new java.awt.Font("Eras Bold ITC", 1, 14)); // NOI18N
        btn_retour.setForeground(new java.awt.Color(153, 0, 0));
        btn_retour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/arrow-80-24.png"))); // NOI18N
        btn_retour.setText("RETOUR");
        btn_retour.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_retourActionPerformed(evt);
            }
        });

        btn_Modifier.setFont(new java.awt.Font("Eras Bold ITC", 1, 14)); // NOI18N
        btn_Modifier.setForeground(new java.awt.Color(153, 0, 0));
        btn_Modifier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/MODIFIER ECRIT.png"))); // NOI18N
        btn_Modifier.setText("MODIFIER");
        btn_Modifier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ModifierActionPerformed(evt);
            }
        });

        btn_actualiser.setFont(new java.awt.Font("Eras Bold ITC", 1, 14)); // NOI18N
        btn_actualiser.setForeground(new java.awt.Color(153, 0, 0));
        btn_actualiser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/new-badge-3-24.png"))); // NOI18N
        btn_actualiser.setText("ACTUALISER");
        btn_actualiser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_actualiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualiserActionPerformed(evt);
            }
        });

        btn_MP.setFont(new java.awt.Font("Eras Bold ITC", 1, 14)); // NOI18N
        btn_MP.setForeground(new java.awt.Color(153, 0, 0));
        btn_MP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/home-3-24.png"))); // NOI18N
        btn_MP.setText("MENU PRINCIPAL");
        btn_MP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_MP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_retour)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Modifier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_actualiser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_MP)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_retour, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_actualiser, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_MP, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        jLabel11.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 204));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("PassWord : ");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255), 2));
        jLabel11.setOpaque(true);

        PassWord.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txt_num.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txt_numItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NewPassWord, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(UserName, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                            .addComponent(txt_num, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PassWordConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CB_Fonction, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PassWord, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_choixPic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txt_num)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(UserName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PassWord, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NewPassWord, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PassWordConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_choixPic, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CB_Fonction, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        table_User.setBackground(new java.awt.Color(0, 0, 153));
        table_User.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        table_User.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        table_User.setForeground(new java.awt.Color(255, 255, 255));
        table_User.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NUMERO", "USER NAME", "FONCTION", "PHOTO"
            }
        ));
        table_User.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_UserMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_User);

        jPanel7.setBackground(new java.awt.Color(51, 0, 51));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255), 3));

        btn_premier.setBackground(new java.awt.Color(255, 153, 255));
        btn_premier.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        btn_premier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/FIRST.png"))); // NOI18N
        btn_premier.setText("PREMIER");
        btn_premier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_premier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_premierMouseClicked(evt);
            }
        });
        btn_premier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_premierActionPerformed(evt);
            }
        });

        btn_prev.setBackground(new java.awt.Color(255, 153, 255));
        btn_prev.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        btn_prev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/PREV.png"))); // NOI18N
        btn_prev.setText("PRECEDENT");
        btn_prev.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prevActionPerformed(evt);
            }
        });

        btn_next.setBackground(new java.awt.Color(255, 153, 255));
        btn_next.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        btn_next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/NEXT.png"))); // NOI18N
        btn_next.setText("SUIVANT");
        btn_next.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        btn_dernier.setBackground(new java.awt.Color(255, 153, 255));
        btn_dernier.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        btn_dernier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/LAST.png"))); // NOI18N
        btn_dernier.setText("DERNIER");
        btn_dernier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_dernier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dernierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_premier, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_prev, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_next, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_dernier, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btn_premier, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_prev, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_next, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_dernier, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setForeground(new java.awt.Color(0, 102, 0));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/menu-4-24.png"))); // NOI18N
        jMenu1.setText("Options");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem4.setBackground(new java.awt.Color(0, 0, 0));
        jMenuItem4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jMenuItem4.setForeground(new java.awt.Color(204, 204, 255));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/available-updates-16.png"))); // NOI18N
        jMenuItem4.setText("Aller à Ajouter");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem6.setBackground(new java.awt.Color(0, 0, 102));
        jMenuItem6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jMenuItem6.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/USER MENU.png"))); // NOI18N
        jMenuItem6.setText("Menu Utilisateurs");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem7.setBackground(new java.awt.Color(0, 0, 102));
        jMenuItem7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jMenuItem7.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/home-3-16.png"))); // NOI18N
        jMenuItem7.setText("Menu Principal");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuBar1.add(jMenu1);

        jMenu2.setForeground(new java.awt.Color(0, 102, 0));
        jMenu2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gloire Salva\\Desktop\\Apple\\embleme-faq.png")); // NOI18N
        jMenu2.setText("Aide");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItem9.setBackground(new java.awt.Color(0, 0, 102));
        jMenuItem9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenuItem9.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem9.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gloire Salva\\Desktop\\Apple\\help-24-1.png")); // NOI18N
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

    private void UserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserNameActionPerformed

    private void btn_choixPicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_choixPicActionPerformed
        JFileChooser fichier = new JFileChooser ();
        fichier.setCurrentDirectory(new File(System.getProperty("user.home")));

        FileNameExtensionFilter filtre = new FileNameExtensionFilter("*,images", "jpg","png");
        fichier.addChoosableFileFilter(filtre);
        int resultat = fichier.showSaveDialog(null);
        if (resultat == JFileChooser.APPROVE_OPTION)
        {
            File fichierSelectione = fichier.getSelectedFile();
            String path = fichierSelectione.getAbsolutePath();
            lbl_image.setIcon(ResizeImage(path, null));
            ImgPath = path;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Aucune image selectionnée");
        }
    }//GEN-LAST:event_btn_choixPicActionPerformed

    private void btn_retourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_retourActionPerformed
        Percepteurs perc = new Percepteurs ();
        this.setVisible(false);
        perc.pack();
        perc.setLocationRelativeTo(null);
        perc.setVisible(true);
    }//GEN-LAST:event_btn_retourActionPerformed

    private void btn_ModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ModifierActionPerformed
        Statement state = null;
        ResultSet res;
        Connection cnx = connect.ConnecterBDD();
        String MotDePasse = PassWord.getText();
        String id =  (String) txt_num.getSelectedItem();
        try {
            state = cnx.createStatement();
            String sql = "SELECT PASSWORD FROM percepteurs WHERE ID_PERCEPTEUR = '" + id + "'";
            res = state.executeQuery(sql);

        if (res.next()) 
        {
           String code = res.getString("PASSWORD");
            
          if (code.equals(MotDePasse) && (NewPassWord.getText() == null ? PassWordConfirm.getText() == null : NewPassWord.getText().equals(PassWordConfirm.getText())))   
          {  
            
                String UpdateQuery = null;
                PreparedStatement ps = null;
                Connection con = connect.ConnecterBDD();
            
                    
                 
                try {
                InputStream img = new FileInputStream(new File(ImgPath)); 
                
                UpdateQuery = "UPDATE percepteurs SET PASSWORD = ?, USER_NAME = ?, FONCTION = ?, PHOTO = ?  WHERE ID_PERCEPTEUR = ?";
                
                    ps = con.prepareStatement(UpdateQuery);
                    ps.setString(1, PassWordConfirm.getText());
                    ps.setString(2, UserName.getText());
                    ps.setString(3, (String) CB_Fonction.getSelectedItem());
                    ps.setBlob(4, img);
                    ps.setInt(5, Integer.parseInt((String) txt_num.getSelectedItem()));
                    //ps.setInt(5, Integer.parseInt(txt_codeOrdi.getText()));
                    
                    ps.executeUpdate(); 
                    Voir_Users_Dans_JTable ();
                    JOptionPane.showMessageDialog(null, "Donées modifiées avec succès !!!");
                
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
          } else {
              JOptionPane.showMessageDialog(null, "Mots de passe incorrects");
          }   
        } else {
            JOptionPane.showMessageDialog(null, "Erreur");
        } 
        
        
        } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
    }//GEN-LAST:event_btn_ModifierActionPerformed

    private void btn_actualiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualiserActionPerformed
        UserName.setText("");
        PassWord.setText("");
        NewPassWord.setText("");
        PassWordConfirm.setText("");
        CB_Fonction.setSelectedItem("------");
        lbl_image.setIcon(null);
    }//GEN-LAST:event_btn_actualiserActionPerformed

    private void btn_MPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MPActionPerformed
        MenuPrinc menu = new MenuPrinc ();
        this.setVisible(false);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }//GEN-LAST:event_btn_MPActionPerformed

    private void table_UserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_UserMouseClicked
        int indexe = table_User.getSelectedRow();
        ShowItem(indexe);
    }//GEN-LAST:event_table_UserMouseClicked

    private void btn_premierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_premierMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_premierMouseClicked

    private void btn_premierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_premierActionPerformed
        pos = 0;
        ShowItem(pos);

    }//GEN-LAST:event_btn_premierActionPerformed

    private void btn_prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prevActionPerformed
        pos--;

        if(pos < 0)
        {
            pos = 0;
        }

        ShowItem(pos);
    }//GEN-LAST:event_btn_prevActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        pos++;

        if(pos >= getUsersList().size())
        {
            pos = getUsersList().size() - 1;
        }

        ShowItem(pos);
    }//GEN-LAST:event_btn_nextActionPerformed

    private void btn_dernierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dernierActionPerformed
        pos = getUsersList().size() - 1;
        ShowItem(pos);
    }//GEN-LAST:event_btn_dernierActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        AjoutPerc user = new AjoutPerc();
        this.setVisible(false);
        user.pack();
        user.setLocationRelativeTo(null);
        user.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        this.setVisible(false);
        Percepteurs perc = new Percepteurs();
        perc.pack();
        perc.setLocationRelativeTo(null);
        perc.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        MenuPrinc menu = new MenuPrinc ();
        this.setVisible(false);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void txt_numItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txt_numItemStateChanged
        Statement state = null;
        ResultSet res;
        Connection cnx = connect.ConnecterBDD();
         try {
             state = cnx.createStatement();
             res = state.executeQuery("select * from percepteurs where ID_PERCEPTEUR = '" +txt_num.getSelectedItem() + "'");
             if (res.next()){
                 String user = res.getString("USER_NAME");
                 String fonction = res.getString("FONCTION");
                 
                 this.UserName.setText(user);
                 this.CB_Fonction.setSelectedItem(fonction);
             }
             
             
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Erreur non spécifié" +e);
         }
    }//GEN-LAST:event_txt_numItemStateChanged

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
            java.util.logging.Logger.getLogger(ModifierUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifierUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifierUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifierUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifierUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox CB_Fonction;
    private javax.swing.JPasswordField NewPassWord;
    private javax.swing.JPasswordField PassWord;
    private javax.swing.JPasswordField PassWordConfirm;
    private javax.swing.JTextField UserName;
    private javax.swing.JButton btn_MP;
    private javax.swing.JButton btn_Modifier;
    private javax.swing.JButton btn_actualiser;
    private javax.swing.JButton btn_choixPic;
    private javax.swing.JButton btn_dernier;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_premier;
    private javax.swing.JButton btn_prev;
    private javax.swing.JButton btn_retour;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JTable table_User;
    private javax.swing.JComboBox txt_num;
    // End of variables declaration//GEN-END:variables
}
