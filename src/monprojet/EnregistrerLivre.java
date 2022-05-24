

package monprojet;


public class EnregistrerLivre {
    
    private int idLivre;
    private int codeLivre;
    private String titre;
    private String auteur;
    private int nbrePages;
    private String maisonEdition;
    private String villeEdition;
    private String anneeEdition;
    private int numExemplaire;
    
    public EnregistrerLivre (int pidLivre, int pcodeLivre, String ptitre, String pauteur, int pnbrePages, String pmaisonEdition, String pvilleEdition, String panneeEdition, int pNumExemplaire){
        
        this.idLivre = pidLivre;
        this.codeLivre = pcodeLivre;
        this.titre = ptitre;
        this.auteur = pauteur;
        this.nbrePages = pnbrePages;
        this.maisonEdition = pmaisonEdition;
        this.villeEdition = pvilleEdition;
        this.anneeEdition = panneeEdition;
        this.numExemplaire = pNumExemplaire;
    }

    public int getIdLivre() {
        return idLivre;
    }

    public int getCodeLivre() {
        return codeLivre;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public int getNbrePages() {
        return nbrePages;
    }

    public String getMaisonEdition() {
        return maisonEdition;
    }

    public String getVilleEdition() {
        return villeEdition;
    }

    public String getAnneeEdition() {
        return anneeEdition;
    }

    public int getNumExemplaire() {
        return numExemplaire;
    }
    
    
}
