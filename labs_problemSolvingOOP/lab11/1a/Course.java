import java.util.ArrayList;

public class Course {
    private String code;
    private ArrayList<Offering> offerings;

    public Course(String code){
        this.code = code;
        this.offerings = new ArrayList<>();
    }

    public void addOffering(String semID){
        Offering newOffering = new Offering(semID);
        offerings.add(newOffering);
    }

    public Offering findOffering(String semID){
        return Offering.findOffering(this.offerings, semID);
    }

}
