import java.util.ArrayList;

public class Offering {
    private String semID;

    public Offering(String semID){
        this.semID = semID;
    }

    public static Offering findOffering(ArrayList<Offering> offerings, String wanted){
        for(Offering o: offerings){
            if(o.semID.equals(wanted)){
                return o;
            }
        }
        return null;
    }
}
