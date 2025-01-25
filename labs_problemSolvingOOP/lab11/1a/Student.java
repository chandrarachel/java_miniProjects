import java.util.ArrayList;

public class Student {
    private String id;
    private ArrayList<Offering> studies;

    public Student(String id){
        this.id = id;
        studies = new ArrayList<>();
    }

    public void takeCourse(Course course, String semID){
        Offering o = course.findOffering(semID);
        studies.add(o);
    }

    public boolean hasBeenClassmateOf(Student s2){
        for(Offering o: this.studies){
            if(s2.hasTaken(o)){
                return true;
            }
        }
        return false;
    }

    private boolean hasTaken(Offering oSearch){
        for(Offering o: this.studies){
            if(o==oSearch){
                return true;
            }
        }
        return false;
    }
}
