import java.util.*;

import java.io.*;

public class Team{
	
	//Instance data field
	private ArrayList<Member> allMembers;
	
	//Constructor	
	public Team(String filepathname) throws FileNotFoundException
	{
		Scanner inFile = new Scanner(new File(filepathname));
		
		int tot = inFile.nextInt(); //Read from file: nextInt();
		inFile.nextLine(); //skip line break after the count: inFile.nextLine(); 
		allMembers = new ArrayList<Member>(tot); //Create the array: new Member[tot];

		for (int i=0; i<tot;i++) //loop how many times?
		{
			String name = inFile.next();
			char roleType = inFile.next().charAt(0); //Read a string of one character and get that character: inFile.next().charAt(0);
			
			Role r;		
			if (roleType=='l')	r = new RLeader(); //create a RLeader role object: new RLeader();
			else if(roleType=='n')	r = new RNormalMember(); //create a RNormalMember role object: new RNormalMember();
			else r = new RDisappeared();
			
			Member m = new Member(name, r);
			allMembers.add(m); // Create a member object: new ____________;
		}
				
		inFile.close(); //close the file
	}
	
	//Return total count of members (simply allMembers.length)
	int getMemberCount()
	{
		return allMembers.size();
	}
	
	//Return a string of listing of all members
	public String getStringOfAllMembers()
	{
		String result="";
		for (int i=0; i<allMembers.size(); i++) //loop for each member
				result+= allMembers.get(i).getNameAndRole()+" ";
		result=result.trim(); //.trim() is for removing leading and trailing spaces 
		return result;
	}

	//Display team contact messages
	public void printTeamContactMessages()
	{
		for (int i=0;i<allMembers.size();i++)
		{
			String name_i = allMembers.get(i).getName(); //e.g. "Helena"
			System.out.print("Dear " + name_i + ",  ");
			String msg = allMembers.get(i).getRole().genTeamContactMsg(this);
			System.out.println(msg); // msg
		}
	}	

	public Member getLeader()
	{
		for (int i=0;i<allMembers.size();i++)
			if (allMembers.get(i).getRole() instanceof RLeader)
				return allMembers.get(i);
		return null; //not found
	}
	public String getStringOfNormalMembers()
	{
		String result="";
		for (int i=0;i<allMembers.size();i++)
			if (allMembers.get(i).getRole() instanceof RNormalMember)
				result+= allMembers.get(i).getNameAndRole()+" ";
		result=result.trim(); //.trim() is for removing leading and trailing spaces 
		return result;
	}

	public Member findMember(String name){
		for (int i=0;i<allMembers.size();i++){
			if(allMembers.get(i).getName().equals(name)){
				return allMembers.get(i);
			}
		}
		return null;
	}

	public void changeLeader(String newLeaderName){
		Member currLeader = getLeader();
		currLeader.setRole(new RNormalMember());

		Member newLeader = findMember(newLeaderName);
		newLeader.setRole(new RLeader());
	}

}
