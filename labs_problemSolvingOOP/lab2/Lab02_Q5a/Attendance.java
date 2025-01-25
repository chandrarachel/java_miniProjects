import java.io.*;
import java.util.Scanner;

public class Attendance {

	private int[] students;
	private int[] attendees;

	public Attendance() throws FileNotFoundException {
		students = new int[20];
		attendees = new int[20];
		Scanner sStudents = new Scanner(new File("StudentList.txt"));
		Scanner sAttendees = new Scanner(new File("AttendanceLog.txt"));
		
        for (int i=0; i<20; i++) {
            students[i] = sStudents.nextInt();
            attendees[i] = sAttendees.nextInt();
        }

		sStudents.close();
		sAttendees.close();
	}

	public boolean isPresent(int id) {
        for(int i=0; i<20; i++) {
            if(id == attendees[i])
                return true;
        }
        return false;
	}

	public boolean belongToClass(int id) {
        for(int i=0; i<20; i++) {
            if(id == students[i])
                return true;
        }
        return false;
	}

	public void listAbsentees() {
		System.out.println("List of absentees:");

	}

	public void listWalkIn() {
		System.out.println("List of walk-in students:");


	}

}