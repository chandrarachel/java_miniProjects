
public class Pair {
    private Student s1;
    private Student s2;

    // DO NOT add any extra object fields
    public Pair(Student s1, Student s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    // no need
    public String getS1() {
        return s1.toString();
    }

    // no need
    public String getS2() {
        return s2.toString();
    }

    // instead of the above two methods, you can override toString() method
    // public String toString() {
    //     return s1 + " " + s2;
    //}

    // public static Student findPartner(Pair[] pairs, Student s) {
    //     for(Pair p: pairs){
    //         if(p.s1 == s){
    //             return p.s2;
    //         } else if (p.s2 == s){
    //             return p.s1;
    //         }
    //     }
    //     return null;
    // }
}