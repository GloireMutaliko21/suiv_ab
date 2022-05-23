
package monprojet;


public class Tarif {
    
    private int id;
    private String intitule;
    private String prix;
    
    public Tarif(int Pid, String Pintitule, String Pprix){
        
        this.id = Pid;
        this.intitule = Pintitule;
        this.prix = Pprix;
        
    }

    public int getId() {
        return id;
    }

    public String getIntitule() {
        return intitule;
    }

    public String getPrix() {
        return prix;
    }
    
    
}
