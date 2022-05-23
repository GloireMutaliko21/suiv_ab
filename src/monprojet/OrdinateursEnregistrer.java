

package monprojet;


public class OrdinateursEnregistrer {
    
    private int numOrd;
    private int codeOrd;
    private String marque;
    private String emplacement;
    private byte[] photo;
    
    public OrdinateursEnregistrer (int pnumOrd, int pcodeOrd, String pmarque, String pemplacement, byte[] pimg){
        
        this.numOrd = pnumOrd;
        this.codeOrd = pcodeOrd;
        this.marque = pmarque;
        this.emplacement = pemplacement;
        this.photo = pimg;
    }

    public int getNumOrd() {
        return numOrd;
    }

    public int getCodeOrd() {
        return codeOrd;
    }

    public String getMarque() {
        return marque;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public byte[] getPhoto() {
        return photo;
    }
    
}
