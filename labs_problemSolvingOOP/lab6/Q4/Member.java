public class Member 
{
	private String name;
	private Role role;

	public Member(String n, Role r){
		name = n;
		role = r;
	}
	public String getName(){
		return name;
	}
	public Role getRole(){
		return role;
	}
	public String getNameAndRole(){
		return role.getNameAndRole(this);
	}
	public void setRole(Role r){
		role = r;
	}
}