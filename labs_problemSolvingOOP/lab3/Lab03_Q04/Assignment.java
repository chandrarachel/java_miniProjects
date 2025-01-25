public class Assignment 
{
	private Team team;
	private Task task;
	
	//Constructor
	public Assignment(Team aTeam, Task aTask)
	{
		team = aTeam;
		task = aTask;
	}
	
	//Return the task name
	public String getTaskName()
	{
		return task.toString();
	}
	
	//Return the String representation for this assignment
	public String toString()
	{
		return task.toString() + " " + team.toString();
	}
	
	//print the team who are assigned with a task of the given task name
	public static void printTaskTeam(String taskName, Assignment[] assignments)
	{
		for (int i=0;i<assignments.length;i++)
			if (assignments[i].getTaskName().equals(taskName))
				System.out.println(assignments[i].toString()); 
	}
}