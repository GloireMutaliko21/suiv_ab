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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class AlerteHeureSortie {
    Connexion connect = new Connexion();
    SonAlerte n = new SonAlerte();
    Connection conn = connect.ConnecterBDD();
    PreparedStatement pst = null;
    ResultSet rs;
    
    
    public void alerte()
    {
        
        //Connection conn = ConnecterBDD();
        Date today = new Date();
     
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String date=sdf.format(today);
        
        SimpleDateFormat sdf2=new SimpleDateFormat("HH:mm:ss");
        String heure=sdf2.format(today);
        
        try {
            String sql1 = "Select * from frequentationsccybercafe,abonnes where date_frequentation ='"+date+"' AND '"+heure+"' >= HEURE_SORTIE AND frequentationsccybercafe.id_abonne=abonnes.id_abonne AND etat = 0";
            pst = conn.prepareStatement(sql1);
            rs = pst.executeQuery(sql1);
            
            while (rs.next()){
                String etat = "UPDATE frequentationsccybercafe SET etat = 1 Where num_frequentation ='"+ rs.getString("num_frequentation")+"'";
                pst=conn.prepareStatement(etat);
                pst.executeUpdate(etat);
                System.out.println(rs.getString("ID_ABONNE") +" "+rs.getString("NOM_POSTNOM_AB") +" "+rs.getString("PRENOM_AB"));
                n.son();
                
                JOptionPane.showMessageDialog(null, "L'abonné dont l'identifiant est  "+rs.getString("ID_ABONNE") +"\nNoms : "+rs.getString("NOM_POSTNOM_AB") +" "+rs.getString("PRENOM_AB")+" a déjà épuisé ses heures\nHeure de sortie prévisionnelle : "+rs.getString("heure_sortie"));
                
                
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage()+" 111");
            System.out.println(e.getMessage());
        }
    }
    
 public void alerteBiblio(){
     
     Date today = new Date();
     
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String date=sdf.format(today);
        
        SimpleDateFormat sdf2=new SimpleDateFormat("HH:mm:ss");
        String heure=sdf2.format(today);
        
        try {
            String sql1 = "Select * from frequentations_bibliotheque,abonnes where date_frequentation ='"+date+"' AND '"+heure+"' >= HEURE_SORTIE AND frequentations_bibliotheque.id_abonne=abonnes.id_abonne AND etat = 0";
            pst = conn.prepareStatement(sql1);
            rs = pst.executeQuery(sql1);
            
            while (rs.next()){
                String etat = "UPDATE frequentations_bibliotheque SET etat = 1 Where num_frequentation ='"+ rs.getString("num_frequentation")+"'";
                pst=conn.prepareStatement(etat);
                pst.executeUpdate(etat);
                System.out.println(rs.getString("ID_ABONNE") +" "+rs.getString("NOM_POSTNOM_AB") +" "+rs.getString("PRENOM_AB"));
                n.son();
                
                JOptionPane.showMessageDialog(null, "L'abonné dont l'identifiant est "+rs.getString("ID_ABONNE") +"\nNoms : "+rs.getString("NOM_POSTNOM_AB") +" "+rs.getString("PRENOM_AB")+" a déjà épuisé ses heures\nHeure de sortie prévisionnelle : "+rs.getString("heure_sortie"));
                
                
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage()+" 111");
            System.out.println(e.getMessage());
        }
     
 }
    
    

}
