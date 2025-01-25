public class RDisappeared implements Role 
{
	//Generate team contact message for the member
	public String genTeamContactMsg(Team team)
	{
		Member leader = team.getLeader();
		return "When you are back, please contact your leader: "+leader.getName(); 
	}
	
	//Return name[+role] strings
	public String getNameAndRole(Member member)
	{
		return member.getName()+"[x]";
	}	
}