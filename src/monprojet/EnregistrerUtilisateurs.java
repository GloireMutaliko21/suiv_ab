

package monprojet;


public class EnregistrerUtilisateurs {
    
    private int num;
    private String UserName;
    private String PassCode;
    private String fonctionUtil;
    private byte [] photo;
    
    public EnregistrerUtilisateurs (int pnum, String pUserName, String pPassCode, String pfonctionUtil, byte[] pphoto)
    {
        this.num = pnum;
        this.UserName = pUserName;
        this.PassCode = pPassCode;
        this.fonctionUtil = pfonctionUtil;
        this.photo = pphoto;
    }

    public String getPassCode() {
        return PassCode;
    }

    public int getNum() {
        return num;
    }

    public String getUserName() {
        return UserName;
    }

   

    public String getFonctionUtil() {
        return fonctionUtil;
    }

    public byte[] getPhoto() {
        return photo;
    } 
}
