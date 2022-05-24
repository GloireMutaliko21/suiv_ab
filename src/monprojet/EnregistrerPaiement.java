

package monprojet;

public class EnregistrerPaiement {
    
    private int idAb;
    private int idPerc;
    private int numPaie;
    private String datePaie;
    private String montant;
    private String typeAbonment;
    private String dateExp;
    
    
    public EnregistrerPaiement(int num, String PdatePaie, String Pmontant, String type, String PdateExp, int PidAb, int PidPerc){
        
        this.numPaie = num;
        this.datePaie = PdatePaie;
        this.montant = Pmontant;
        this.typeAbonment = type;
        this.dateExp = PdateExp;
        this.idAb = PidAb;
        this.idPerc = PidPerc;
       
    }

    public int getIdAb() {
        return idAb;
    }

    public int getIdPerc() {
        return idPerc;
    }

    public int getNumPaie() {
        return numPaie;
    }

    public String getDatePaie() {
        return datePaie;
    }

    public String getMontant() {
        return montant;
    }

    public String getTypeAbonment() {
        return typeAbonment;
    }

    public String getDateExp() {
        return dateExp;
    }
   
    
}
