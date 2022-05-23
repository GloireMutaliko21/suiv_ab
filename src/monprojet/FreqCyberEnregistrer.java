
package monprojet;

public class FreqCyberEnregistrer {
    
    private int num;
    private String date;
    private String heureEntree;
    private String heureSortie;
    private String motifFreq;
    private String observation;
    private int codeOrdi;
    private int idAbo;
    
    public FreqCyberEnregistrer(int Pnum, String Pdate, String PheureEntree, String PheureSortie, String PmotifFreq, String Pobservation, int PcodeOrdi, int PidAbo)
    {
        
        this.num = Pnum;
        this.date = Pdate;
        this.heureEntree = PheureEntree;
        this.heureSortie = PheureSortie;
        this.motifFreq = PmotifFreq;
        this.observation = Pobservation;
        this.codeOrdi = PcodeOrdi;
        this.idAbo = PidAbo;
    }

    public int getNum() {
        return num;
    }

    public String getDate() {
        return date;
    }

    public String getHeureEntree() {
        return heureEntree;
    }

    public String getHeureSortie() {
        return heureSortie;
    }

    public String getMotifFreq() {
        return motifFreq;
    }

    public String getObservation() {
        return observation;
    }

    public int getCodeOrdi() {
        return codeOrdi;
    }

    public int getIdAbo() {
        return idAbo;
    }
    
    
}
