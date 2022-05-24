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
public class AjouterOrdi extends javax.swing.JFrame {
    
    Connexion connect = new Connexion();
    int heureSyst = 0;
    
    public AjouterOrdi() {
        initComponents();
        Voir_Abonnes_Dans_JTable ();
        
       

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
                txt_codeOrdi.getText() == null
             || CB_Marque.getSelectedItem() == "------"
             || CB_Emplacement.getSelectedItem()== "------"
             
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
      
      public ArrayList <OrdinateursEnregistrer> getOrdiList()
    {
            ArrayList <OrdinateursEnregistrer> listeOrdi = new ArrayList <OrdinateursEnregistrer>();
            Connection cnx = connect.ConnecterBDD();
            String query = "SELECT * FROM gestionetsuividesabonnes.ordinateurs";
            
            Statement st;
            ResultSet rs;
        
        try {
            
             st = cnx.createStatement();
             rs = st.executeQuery(query);
             OrdinateursEnregistrer ordi;
            
            while (rs.next())
            {
                ordi = new OrdinateursEnregistrer(rs.getInt("NUM_ORDI"), rs.getInt("CODE_ORDI"), rs.getString("MARQUE"), rs.getString("EMPLACEMENT"), rs.getBytes("PHOTO"));
                listeOrdi.add(ordi);
            }
            
              
        } catch (SQLException ex) {
            Logger.getLogger(AjouterOrdi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeOrdi;
    }
    
     
      public void Voir_Abonnes_Dans_JTable ()
    {
        ArrayList <OrdinateursEnregistrer> liste  = getOrdiList();
        DefaultTableModel model = (DefaultTableModel) jTable_ordi.getModel();
        
        model.setRowCount(0);
        
        Object[] row = new Object[5];
       for (int i = 0; i < liste.size(); i++)
        {
            row[0] = liste.get(i).getNumOrd();
            row[1] = liste.get(i).getCodeOrd();
            row[2] = liste.get(i).getMarque();
            row[3] = liste.get(i).getEmplacement();
            row[4] = liste.get(i).getPhoto();
            
           model.addRow(row);
        }
    }
    
      
       public void ShowItem(int index)
    {
        txt_numOrdi.setText(Integer.toString(getOrdiList().get(index).getNumOrd()));
        txt_codeOrdi.setText(Integer.toString(getOrdiList().get(index).getCodeOrd()));
        CB_Marque.setSelectedItem(getOrdiList().get(index).getMarque());
        CB_Emplacement.setSelectedItem(getOrdiList().get(index).getEmplacement());
        lbl_image.setIcon(ResizeImage(null, getOrdiList().get(index).getPhoto()));
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
        txt_numOrdi = new javax.swing.JTextField();
        txt_codeOrdi = new javax.swing.JTextField();
        CB_Marque = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        CB_Emplacement = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        lbl_image = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btn_Actualiser = new javax.swing.JButton();
        btn_AjouterOrdi = new javax.swing.JButton();
        btn_Retour = new javax.swing.JButton();
        btn_ChoixImage = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_ordi = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 4));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 255), 4));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("AJOUT DES ORDINATEURS");

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

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153), 3));

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Marque Ordinateur: ");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 2));
        jLabel5.setOpaque(true);

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Code Ordinateur : ");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 2));
        jLabel3.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText(" Numéro : ");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 2));
        jLabel2.setOpaque(true);

        txt_numOrdi.setEditable(false);
        txt_numOrdi.setBackground(javax.swing.UIManager.getDefaults().getColor("TextField.background"));
        txt_numOrdi.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N

        txt_codeOrdi.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N

        CB_Marque.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        CB_Marque.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "------", "Hp", "Lenovo", "Dell", "Toshiba", "Positivo", "Acer", "Apple", "Asus", "Microsoft", "Samsung", "MSI", "FUJITSU", "Compaq", "SONY" }));

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Agency FB", 1, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 153));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Emplacement : ");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 2));
        jLabel6.setOpaque(true);

        CB_Emplacement.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        CB_Emplacement.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "------", "Fenêtres-Droit", "Fenêtres-Centre", "Fenêtres-Gauche", "Porte", "Coin Gauche", "Coin Droit" }));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        lbl_image.setBackground(new java.awt.Color(51, 0, 102));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 2));

        btn_Actualiser.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        btn_Actualiser.setForeground(new java.awt.Color(0, 102, 0));
        btn_Actualiser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/new-badge-3-32.png"))); // NOI18N
        btn_Actualiser.setText("NOUVEAU");
        btn_Actualiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ActualiserActionPerformed(evt);
            }
        });

        btn_AjouterOrdi.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        btn_AjouterOrdi.setForeground(new java.awt.Color(0, 102, 0));
        btn_AjouterOrdi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/add-32.png"))); // NOI18N
        btn_AjouterOrdi.setText("AJOUTER");
        btn_AjouterOrdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AjouterOrdiActionPerformed(evt);
            }
        });

        btn_Retour.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        btn_Retour.setForeground(new java.awt.Color(0, 102, 0));
        btn_Retour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/RETOUR.png"))); // NOI18N
        btn_Retour.setText("RETOUR");
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
                .addComponent(btn_AjouterOrdi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Actualiser, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(306, 306, 306))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Actualiser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_AjouterOrdi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Retour, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_ChoixImage.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        btn_ChoixImage.setForeground(new java.awt.Color(0, 102, 0));
        btn_ChoixImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/PIECE JOINTE.png"))); // NOI18N
        btn_ChoixImage.setText("CHOIX IMAGE");
        btn_ChoixImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ChoixImageActionPerformed(evt);
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
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_numOrdi, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                                .addComponent(txt_codeOrdi))
                            .addComponent(CB_Marque, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CB_Emplacement, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_ChoixImage, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_numOrdi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_codeOrdi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CB_Marque, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CB_Emplacement, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_ChoixImage, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jTable_ordi.setBackground(new java.awt.Color(204, 102, 0));
        jTable_ordi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTable_ordi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTable_ordi.setForeground(new java.awt.Color(255, 255, 153));
        jTable_ordi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NUMERO", "CODE", "MARQUE", "EMPLACEMENT", "IMAGE"
            }
        ));
        jTable_ordi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_ordiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_ordi);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addContainerGap())
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
                        .addGap(20, 20, 20)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 15, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenu1.setForeground(new java.awt.Color(0, 102, 0));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/menu-4-24.png"))); // NOI18N
        jMenu1.setText("Options ");
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

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setBackground(new java.awt.Color(0, 0, 102));
        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jMenuItem3.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/ORDI MENU.png"))); // NOI18N
        jMenuItem3.setText("Menu Ordinateurs");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setForeground(new java.awt.Color(0, 102, 0));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/help-24-1.png"))); // NOI18N
        jMenu2.setText("Aide");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItem9.setBackground(new java.awt.Color(0, 0, 102));
        jMenuItem9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenuItem9.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/help-24-1.png"))); // NOI18N
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ActualiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ActualiserActionPerformed
        txt_numOrdi.setText("");
        txt_codeOrdi.setText("");
        CB_Marque.setSelectedItem("------");
        CB_Emplacement.setSelectedItem("------");
        lbl_image.setIcon(null);
    }//GEN-LAST:event_btn_ActualiserActionPerformed

    private void btn_AjouterOrdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AjouterOrdiActionPerformed
        
         if (checkInputs() != false && ImgPath != null)
        {
            
            try {
                Connection con = connect.ConnecterBDD();
                PreparedStatement pss = con.prepareStatement("INSERT INTO gestionetsuividesabonnes.ordinateurs (CODE_ORDI, MARQUE, EMPLACEMENT, PHOTO)"
                        + " values (?,?,?,?)");
                pss.setString(1, txt_codeOrdi.getText());
                pss.setString(2, (String) CB_Marque.getSelectedItem());
                pss.setString(3, (String) CB_Emplacement.getSelectedItem());
                
                InputStream img = new FileInputStream (new File (ImgPath));
                
                pss.setBlob(4, img);
                pss.executeUpdate();
                Voir_Abonnes_Dans_JTable ();
                
                JOptionPane.showMessageDialog(null, "Ajout Réussi");
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Un ou plusieurs champs sont nul(s)");
        }
        
    }//GEN-LAST:event_btn_AjouterOrdiActionPerformed

    private void btn_RetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RetourActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_RetourActionPerformed

    private void btn_ChoixImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ChoixImageActionPerformed
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
    
    }//GEN-LAST:event_btn_ChoixImageActionPerformed

    private void jTable_ordiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ordiMouseClicked
       int indexe = jTable_ordi.getSelectedRow();
       ShowItem(indexe);
    }//GEN-LAST:event_jTable_ordiMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       ModifierOrdi modif = new ModifierOrdi ();
        this.setVisible(false);
        modif.pack();
        modif.setLocationRelativeTo(null);
        modif.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
            java.util.logging.Logger.getLogger(AjouterOrdi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjouterOrdi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjouterOrdi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjouterOrdi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AjouterOrdi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox CB_Emplacement;
    private javax.swing.JComboBox CB_Marque;
    private javax.swing.JButton btn_Actualiser;
    private javax.swing.JButton btn_AjouterOrdi;
    private javax.swing.JButton btn_ChoixImage;
    private javax.swing.JButton btn_Retour;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_ordi;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JTextField txt_codeOrdi;
    private javax.swing.JTextField txt_numOrdi;
    // End of variables declaration//GEN-END:variables
}
