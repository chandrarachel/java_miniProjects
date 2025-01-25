import java.util.ArrayList;

public class Offering {
    private String semID;
    private ArrayList<Student> students;

    public Offering(String semID){
        this.semID = semID;
        students = new ArrayList<>();
    }

    public static Offering findOffering(ArrayList<Offering> offerings, String wanted){
        for(Offering o: offerings){
            if(o.semID.equals(wanted)){
                return o;
            }
        }
        return null;
    }

    public void addStudents(Student s){
        students.add(s);
    }

    public void listStudentsID(){
        for(Student s: students){
            System.out.print(s.getID() + " ");
        }
    }

    @Override
    public String toString(){
        return semID;
    }
}
