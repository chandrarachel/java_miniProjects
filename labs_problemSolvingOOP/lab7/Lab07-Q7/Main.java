import java.util.*;
import java.io.*;

public class Main{
	
	//Add the method called findAccount
	private static Account findAccount(ArrayList<Account> list, String account_no){
		for (Account i: list){
			if (i.getAccountNumber().equals(account_no))
				return i;
		}
		return null;
	}
	
	
	
	
	
	public static void main(String [] args) throws FileNotFoundException
	{	
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Please input the file pathname: ");
		String filepathname = in.nextLine();
		
		ArrayList<Account> acs = new ArrayList<>();
		
		Scanner infile = new Scanner(new File(filepathname));
		
		while(infile.hasNextLine()){
			String currAccountNum = infile.next();
			
			if(currAccountNum.charAt(0) >= '0' && currAccountNum.charAt(0) <= '5'){
				SavingsAccount sa = new SavingsAccount(currAccountNum, infile.nextDouble());
				acs.add(sa);
			} else if(currAccountNum.charAt(0) >= '6' && currAccountNum.charAt(0) <= '8'){
				CreditCardAccount cca = new CreditCardAccount(currAccountNum, infile.nextDouble(), infile.nextDouble());
				acs.add(cca);
			} else{
				String currSAnumber = infile.next();
				String currCCAnumber = infile.next();
				SavingsAccount existingSA = (SavingsAccount) findAccount(acs, currSAnumber);
				CreditCardAccount existingCCA = (CreditCardAccount) findAccount(acs, currCCAnumber);
				PowerAdvantageAccount paa = new PowerAdvantageAccount(currAccountNum, existingSA, existingCCA);
				acs.add(paa);
			}
		}
		
		
		
		infile.close();
		System.out.print("\nInput an account number to search: ");
		
		String inpAno = in.nextLine();
		Account foundAccount = findAccount(acs, inpAno);
		
		if (findAccount(acs, inpAno)!=null)
			System.out.println("\n[Result]\n"+foundAccount);
		else
			System.out.println("\n[Result]\nThe account is not found.");
			
		in.close();
	}
}
