public class RLeader implements Role 
{
	//Generate team contact message for the member
	public String genTeamContactMsg(Team team)
	{
		String teammates = team.getStringOfNormalMembers();
		return "Please contact your members: "+teammates; 
	}
	
	//Return name[+role] strings
	public String getNameAndRole(Member member)
	{
		return member.getName()+"[Leader]";
	}	
}