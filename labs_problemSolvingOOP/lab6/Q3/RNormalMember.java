public class RNormalMember implements Role 
{
	//Generate team contact message for the member
	public String genTeamContactMsg(Team team)
	{
		Member leader = team.getLeader();
		if (leader==null)
			return "There is no leader in your team.  Please contact your instructor.";
		else
			return "Please contact your leader: " + leader.getName();
	}
	
	//Return name[+role] strings
	public String getNameAndRole(Member member)
	{
		return member.getName();
	}	
}