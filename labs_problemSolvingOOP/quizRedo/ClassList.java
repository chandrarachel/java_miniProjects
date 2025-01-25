import java.io.*;
import java.util.*;

public class ClassList {

    private Student[] sList;
    private Pair[] pList;

    // DO NOT add any extra object fields

    public ClassList(String fpn) throws FileNotFoundException {

        Scanner in = new Scanner(new File(fpn));
        
        sList = new Student[10];
        for (int i=0; i<10; i++) {
            String name = in.nextLine(); // in.next();
            sList[i] = new Student(name);
        }

        pList = new Pair[5];
        for (int i=0; i<5; i++) {
            int num1 = in.nextInt();
            int num2 = in.nextInt();
            in.nextLine(); // no need!
            pList[i] = new Pair(sList[num1-1], sList[num2-1]);
        }

        in.close();
    }

    public void listStudents() {
        System.out.println("Students: ");

        for (int i=0; i<10; i++) {
            System.out.println("[" + (i+1) + "] " + sList[i].toString()); // no need to mention .toString()
            // OR...
            // System.out.printf("[%d] %s\n", i+1, sList[i]);
        }
    }

    public void listPairs() {
        System.out.println("Pairs: ");

        for (int i=0; i<5; i++) {
            System.out.println("Pair " + (i+1) + ": " + pList[i].getS1() + " " + pList[i].getS2()); // no need
            // instead...
            // System.out.printf("Pair $d: $s\n", i+1, pList[i]);
        }
    }

    public void greeting() {
        System.out.println("Greeting messages: ");

        String sender;
        String receiver = null;

        // better to make the for loop below
        for (int i=0; i<10; i++) {
            sender = sList[i].toString();

            for (int j=0; j<5; j++) {
                if (pList[j].getS1().equals(sender))
                    receiver = pList[j].getS2();
                else if (pList[j].getS2().equals(sender))
                    receiver = pList[j].getS1();
            }
            System.out.println("Hi " + receiver + ", nice to meet you.  I am " + sender + ".");
        }

    //     for(Student s: sList) {
    //         Student partner = pair.findPartner(s);
    //         s.greet(partner);
    //     }
    // }
}