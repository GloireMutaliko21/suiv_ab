/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package monprojet;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import monprojet.AlerteHeureSortie;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
/**
 *
 * @author Gloire Salva
 */
public class MonProjet {

    Connexion connect = new Connexion();    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Accueil ac = new Accueil();
//        alerte al = new alerte();
//        al.show();
        ac.jProgressBar1.setVisible(false);
        ac.setVisible(true);
        Login log = new Login();
    try {
        for (int i = 0; i <= 100; i+= 1)
        {
            Thread.sleep(80);
            ac.jProgressBar1.setValue(i);
            if (i == 100) 
            {
                ac.setVisible(false); 
                log.pack();
                log.setLocationRelativeTo(null);
                log.setVisible(true);
                
            }
            
            String message = "";
          if (i == 0 || i == 5 || i == 30 || i == 60 || i ==90  )
          {
          
          message = "Préparation des fonctionnalités... ";
          ac.LabelMessage.setText(message);
          } else if ( i == 6 || i == 36 || i == 66 ) {
          message = "Chargement des fichiers en cours...";
          ac.LabelMessage.setText(message);
          } else if (i == 12 || i == 42 || i == 72 ) {
          message = "Veuillez patienter !!! cela peut prendre jusqu'à une minute...";
          ac.LabelMessage.setText(message);
          }else if (i ==18 || i == 48 || i == 78) {
          message = "Lecture des fichiers en cours...";
          ac.LabelMessage.setText(message);
          } else if (i == 24 || i == 54 || i == 84 ||  i == 95 || i == 97 || i == 100 ) {
          message = "Démarrage du programme...";
          ac.LabelMessage.setText(message);
          } 
          else if (i >= 95 ) {
//          SonAlerte s = new SonAlerte();
//          s.sonBienvenu();
          message = "Prêt";
          ac.LabelMessage.setText(message);
          }
          
        }
       
    } catch (Exception e){
        
    }
    } 
    
  
}
