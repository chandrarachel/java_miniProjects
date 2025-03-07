public interface Role //It should be: public interface Role 
{
	//getNameAndRole: Return name[+role] strings
	public String getNameAndRole(Member member);

	//genTeamContactMsg: Generate team contact message for the member
	public String genTeamContactMsg(Team team);

	public String getRoleDescription();
}