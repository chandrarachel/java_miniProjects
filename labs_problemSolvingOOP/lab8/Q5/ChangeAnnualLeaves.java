public class ChangeAnnualLeaves extends RecordedCommand {
    private Employee e;
    private int prevLeaves;
    private int newLeaves;
    
    @Override
    public void execute(String[] cmdParts){
        Company company = Company.getInstance();
		e = company.findEmployee(cmdParts[1]);
		newLeaves=Integer.parseInt(cmdParts[2]);

        prevLeaves = e.getLeaves();
        e.changeLeaves(newLeaves);

        addUndoCommand(this);
        clearRedoList();

        System.out.println("Done.");
    
    }

    @Override
	public void undoMe()
	{
		e.changeLeaves(prevLeaves);
		addRedoCommand(this);
	}
	
	@Override
	public void redoMe()
	{
		e.changeLeaves(newLeaves);
		addUndoCommand(this);
	}
}
