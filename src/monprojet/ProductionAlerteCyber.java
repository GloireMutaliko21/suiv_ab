

package monprojet;

import java.util.logging.Level;
import java.util.logging.Logger;


public class ProductionAlerteCyber {
    
public void Production()
{
        final int timerun = 0;
        new Thread() {
            
            public void run() {
                
                while (timerun == 0) {
                    try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProductionAlerteCyber.class.getName()).log(Level.SEVERE, null, ex);
        }
                    AlerteHeureSortie alert = new AlerteHeureSortie();
                    alert.alerte();
                }
            }
        }.start();
    }
}