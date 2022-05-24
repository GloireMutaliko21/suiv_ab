

package monprojet;

public class AbonnesEnregistrer {
    private int idAb;
    private String nomAb;
    private String prenomAb;
    private String sexeAb;
    private String adresse;
    private String telephone;
    private String mail;
    private String profession;
    private byte[] photo;
    
    public AbonnesEnregistrer (int pidAb,String pnomAb, String pprenomAb, String psexeAb, String padresse, String ptelephone, String pmail, String pprofession, byte[] pimg){
        
        this.idAb = pidAb;
        this.nomAb = pnomAb;
        this.prenomAb = pprenomAb;
        this.sexeAb = psexeAb;
        this.adresse = padresse;
        this.telephone = ptelephone;
        this.mail = pmail;
        this.profession = pprofession;
        this.photo = pimg;
    }

    public int getIdAb() {
        return idAb;
    }

    public String getNomAb() {
        return nomAb;
    }

    public String getPrenomAb() {
        return prenomAb;
    }

    public String getSexeAb() {
        return sexeAb;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getMail() {
        return mail;
    }

    public String getProfession() {
        return profession;
    }

    public byte[] getPhoto() {
        return photo;
    }
    
    
}
