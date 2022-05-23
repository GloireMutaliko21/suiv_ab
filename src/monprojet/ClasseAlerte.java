

package monprojet;

public class ClasseAlerte {
    
    private int id;
    private String nom;
    private String prenom;
    private String sortie;
    
    public ClasseAlerte(int Pid, String Pnom, String Pprenom, String heureSortie){
        
        this.id = Pid;
        this.nom = Pnom;
        this.prenom = Pprenom;
        this.sortie = heureSortie;
        
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSortie() {
        return sortie;
    }
    
}
