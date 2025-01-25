import java.io.*;

public class Main_iii {
    public static void main(String args[]) throws FileNotFoundException {

        ClassList c = new ClassList("data.txt");

        c.listStudents();

        c.listPairs();

        c.greeting();
    }
}