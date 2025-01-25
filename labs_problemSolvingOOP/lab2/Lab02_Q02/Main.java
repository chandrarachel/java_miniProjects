import java.util.*;
public class Main {

	public static void main(String[] args) {
		
		
		int width, height;
        Scanner scannerObj = new Scanner(System.in);
		
		System.out.print("Input the width of the multiplication table (2-10): ");
		width = scannerObj.nextInt();
		System.out.print("Input the height of the multiplication table (2-10): ");
        height = scannerObj.nextInt();

        for (int r=0; r<height; r++) {
            for (int c=0; c<width; c++) {
                System.out.printf("%5d", (c+1)*(r+1));
                System.out.print("|");
            }
            System.out.println();
        }
        scannerObj.close();

		
	}
}

