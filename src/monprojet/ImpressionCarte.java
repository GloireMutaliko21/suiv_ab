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
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.FileOutputStream;
import java.sql.Connection;
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
import static javax.swing.text.StyleConstants.ALIGN_CENTER;

/**
 *
 * @author Gloire Salva
 */
public class ImpressionCarte extends javax.swing.JFrame {

    Connexion connect = new Connexion();
    int heureSyst = 0;
    
    /**
     * Creates new form ImpressionCarte
     */
    public ImpressionCarte() {
        initComponents();
        //Combo();
        //this.jButton2.setVisible(false);
        Voir_Abonnes_Dans_JTable ();
        AlerteHeureSortie alertCyber = new AlerteHeureSortie();
                    AlerteHeureSortie alertBiblio = new AlerteHeureSortie();
                    alertCyber.alerte();
                    alertBiblio.alerteBiblio();
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
        txt_Num.setText(Integer.toString(getAbonnesList().get(index).getIdAb()));
        txt_NomAb.setText(getAbonnesList().get(index).getNomAb());
        txt_PrenomAb.setText(getAbonnesList().get(index).getPrenomAb());
        txt_sexe.setText(getAbonnesList().get(index).getSexeAb());
        txt_Adresse.setText(getAbonnesList().get(index).getAdresse());
        txt_phone.setText(getAbonnesList().get(index).getTelephone());
        txt_Mail.setText(getAbonnesList().get(index).getMail());
        txt_profess.setText(getAbonnesList().get(index).getProfession());
        lbl_photo.setIcon(ResizeImage(null, getAbonnesList().get(index).getPhoto()));
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
        Image img2 = img.getScaledInstance(lbl_photo.getWidth(), lbl_photo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        return image;
    } 
    
    public void print(){
        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setJobName("Carte d'abonné");
        
        Printable printable = new Printable() {
            public int print(Graphics pg, PageFormat pf, int pageNum){
                if(pageNum > 0){
                    return Printable.NO_SUCH_PAGE;
                }
                
                Dimension size= jPanel3.getSize();
                BufferedImage bufferedImage = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_BGR);
                jPanel3.print(bufferedImage.getGraphics());
                
                Graphics2D g2 = (Graphics2D) pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.drawImage(bufferedImage, 0, 0,(int) pf.getWidth(), (int)pf.getHeight(), null);
                //jPanel3.paintAll(g2);
                return Printable.PAGE_EXISTS;
            }
        };
        
        Paper paper = new Paper();
        paper.setImageableArea(0, 0, 1000, 1000);
        //paper.setSize(250, 200);
        
        PageFormat format = new PageFormat();
        format.setPaper(paper);
        format.setOrientation(PageFormat.LANDSCAPE);
        
        pj.setPrintable(printable, format);
        
        if(pj.printDialog() == false)
            return;
            try{
                pj.print();
            }catch(PrinterException ex){
                JOptionPane.showMessageDialog(null, "Erreur d'impression "+ex);
            }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lbl_photo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_Num = new javax.swing.JTextField();
        txt_NomAb = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_PrenomAb = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_sexe = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_Adresse = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_phone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_profess = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_Mail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_ab = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btn_Retour = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 4));

        jLabel11.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 153));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("CARTE D'ABONNE CNFP");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204), 2));
        jLabel11.setOpaque(true);

        jLabel12.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 153));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/Capture d’écran (2).png"))); // NOI18N
        jLabel12.setOpaque(true);

        jLabel13.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 153));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.jpg"))); // NOI18N
        jLabel13.setOpaque(true);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 3));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 204), 2));

        lbl_photo.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_photo, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_photo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Eras Medium ITC", 0, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Identifiant :");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel2.setOpaque(true);

        txt_Num.setEditable(false);
        txt_Num.setBackground(new java.awt.Color(204, 204, 204));
        txt_Num.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        txt_Num.setText("...............................................................");
        txt_Num.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        txt_NomAb.setEditable(false);
        txt_NomAb.setBackground(new java.awt.Color(204, 204, 204));
        txt_NomAb.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        txt_NomAb.setText("...............................................................");
        txt_NomAb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Eras Medium ITC", 0, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Nom et post-nom :");
        jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel3.setOpaque(true);

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setFont(new java.awt.Font("Eras Medium ITC", 0, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Prénom :");
        jLabel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel5.setOpaque(true);

        txt_PrenomAb.setEditable(false);
        txt_PrenomAb.setBackground(new java.awt.Color(204, 204, 204));
        txt_PrenomAb.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        txt_PrenomAb.setText("...............................................................");
        txt_PrenomAb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Eras Medium ITC", 0, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Sexe :");
        jLabel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel4.setOpaque(true);

        txt_sexe.setEditable(false);
        txt_sexe.setBackground(new java.awt.Color(204, 204, 204));
        txt_sexe.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        txt_sexe.setText("...............................................................");
        txt_sexe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel8.setBackground(new java.awt.Color(204, 204, 204));
        jLabel8.setFont(new java.awt.Font("Eras Medium ITC", 0, 22)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Adresse :");
        jLabel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel8.setOpaque(true);

        txt_Adresse.setEditable(false);
        txt_Adresse.setBackground(new java.awt.Color(204, 204, 204));
        txt_Adresse.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        txt_Adresse.setText("...............................................................");
        txt_Adresse.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel10.setBackground(new java.awt.Color(204, 204, 204));
        jLabel10.setFont(new java.awt.Font("Eras Medium ITC", 0, 22)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 102));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Num Téléphone:");
        jLabel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel10.setOpaque(true);

        txt_phone.setEditable(false);
        txt_phone.setBackground(new java.awt.Color(204, 204, 204));
        txt_phone.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        txt_phone.setText("...............................................................");
        txt_phone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setFont(new java.awt.Font("Eras Medium ITC", 0, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Profession :");
        jLabel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel7.setOpaque(true);

        txt_profess.setEditable(false);
        txt_profess.setBackground(new java.awt.Color(204, 204, 204));
        txt_profess.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        txt_profess.setText("...............................................................");
        txt_profess.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel9.setBackground(new java.awt.Color(204, 204, 204));
        jLabel9.setFont(new java.awt.Font("Eras Medium ITC", 0, 22)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Mail :");
        jLabel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel9.setOpaque(true);

        txt_Mail.setEditable(false);
        txt_Mail.setBackground(new java.awt.Color(204, 204, 204));
        txt_Mail.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        txt_Mail.setText("...............................................................");
        txt_Mail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel6.setFont(new java.awt.Font("Eras Medium ITC", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("PHOTO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_Mail)
                            .addComponent(txt_profess, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_phone)
                            .addComponent(txt_Adresse)
                            .addComponent(txt_PrenomAb)
                            .addComponent(txt_Num)
                            .addComponent(txt_NomAb, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_sexe))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Num, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_NomAb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_PrenomAb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_sexe, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_Adresse)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(txt_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_profess, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_Mail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Eras Medium ITC", 1, 22)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Antenne Afrique des Grands Lacs");
        jLabel14.setOpaque(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel12)
                .addGap(53, 53, 53)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(59, 59, 59)
                .addComponent(jLabel13)
                .addGap(45, 45, 45))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)
                        .addGap(34, 34, 34)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

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

        jButton1.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/printer-4-24.png"))); // NOI18N
        jButton1.setText("IMPRIMER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(btn_Retour, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Retour, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_RetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RetourActionPerformed
        MenuEtats me = new MenuEtats();
        this.setVisible(false);
        me.pack();
        me.setLocationRelativeTo(null);
        me.setVisible(true);
    }//GEN-LAST:event_btn_RetourActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        print();
//        String valu1 = (String) txt_idAB.getSelectedItem();
//        String valu2 = txt_NomAb.getText();
//        String valu3 = txt_PrenomAb.getText();
//        String valu4 = (String) CB_Sexe.getSelectedItem();
//        String valu5 = txt_Adresse.getText();
//        String valu6 = txt_phone.getText();
//        String valu7 = (String) CB_Profession.getSelectedItem();
//        String valu8 = txt_Mail.getText();
//
//        try{
//            Document document=new Document();
//            PdfWriter writer= PdfWriter.getInstance(document,new FileOutputStream("E:\\carte.pdf"));
//            document.open();
//            PdfContentByte cb=writer.getDirectContent();
//            Barcode128 barcode=new Barcode128();
//            barcode.setCode("CNFP"+valu1);
//            barcode.setCodeType(Barcode.CODE128);
//            barcode.setTextAlignment(20);
//            com.lowagie.text.Image code128Image=barcode.createImageWithBarcode(cb,null,null);
//            //Paragraph para=new Paragraph("CAMPUS NUMERIQUE FRANCOPHONE DE BUKAVU",(FontFactory.getFont(FontFactory.TIMES_BOLD,14,Font.BOLD)));
//            //com.lowagie.text.Image img=com.lowagie.text.Image.getInstance("D:\\burerre\\NetBeansProjects\\tfcapplication\\src\\Formulaire2\\image2\\ao.png");
//            //                      img.scaleAbsolute(50,50);
//            //                      img.scaleToFit(150,150);
//            //                      img.setBackgroundColor(Color.gray);
//            //                      img.setAlignment(Element.ALIGN_LEFT);
//            //                      document.add(img);
//            //                      para.setAlignment(Element.ALIGN_CENTER);
//            //                      document.add(para);
//            //document.add(new Paragraph("  "));
//            PdfPTable table=new PdfPTable(2);
//            table.setHorizontalAlignment(ALIGN_CENTER);
//            table.setWidthPercentage(50);
//            PdfPCell cell=new PdfPCell(new Paragraph("CARTE D'ABONNE CNFP/BUKAVU",FontFactory.getFont(FontFactory.COURIER_BOLD,14,Font.BOLD)));
//            cell.setColspan(10);
//            cell.setMinimumHeight(20);
//            cell.setRight(TOP_ALIGNMENT);
//            cell.getBorderWidth();
//            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            cell.setBackgroundColor(Color.yellow);
//            table.addCell(cell);
//            table.addCell("N°ABONNE");
//            table.addCell(valu1);
//            table.addCell("NOM ET POSTNOM");
//            table.addCell(valu2);
//            table.addCell("PRENOM");
//            table.addCell(valu3);
//            table.addCell("SEXE");
//            table.addCell(valu4);
//            table.addCell("ADRESSE");
//            table.addCell(valu5);
//            table.addCell("NUMERO");
//            table.addCell(valu6);
//            table.addCell("PROFESSION");
//            table.addCell(valu7);
//            table.addCell("MAIL");
//            table.addCell(valu8);
//            document.add(table);
//            com.lowagie.text.List list=new com.lowagie.text.List(false,40);
//            document.add(list);
//            document.add(code128Image);
//            document.close();
//            JOptionPane.showMessageDialog(null,"Carte sauvée dans 'mes documents'");
//
//        }
//        catch(Exception ex){JOptionPane.showMessageDialog(null,"erreur "+ex.getLocalizedMessage());}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable_abMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_abMouseClicked
        int indexe = jTable_ab.getSelectedRow();
        ShowItem(indexe);
    }//GEN-LAST:event_jTable_abMouseClicked

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
            java.util.logging.Logger.getLogger(ImpressionCarte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImpressionCarte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImpressionCarte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImpressionCarte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImpressionCarte().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Retour;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_ab;
    private javax.swing.JLabel lbl_photo;
    private javax.swing.JTextField txt_Adresse;
    private javax.swing.JTextField txt_Mail;
    private javax.swing.JTextField txt_NomAb;
    private javax.swing.JTextField txt_Num;
    private javax.swing.JTextField txt_PrenomAb;
    private javax.swing.JTextField txt_phone;
    private javax.swing.JTextField txt_profess;
    private javax.swing.JTextField txt_sexe;
    // End of variables declaration//GEN-END:variables
}
