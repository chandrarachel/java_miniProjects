public class ExchangeSalaries extends RecordedCommand{
    private Employee e1;
    private Employee e2;

    @Override
    public void execute(String[] cmdParts){
        Company company = Company.getInstance();
		e1 = company.findEmployee(cmdParts[1]);
		e2 = company.findEmployee(cmdParts[2]);

        e1.exchangeSalaries(e2);

        addUndoCommand(this);
        clearRedoList();

        System.out.println("Done.");
    
    }

    @Override
	public void undoMe()
	{
		e1.exchangeSalaries(e2);
		addRedoCommand(this);
	}
	
	@Override
	public void redoMe()
	{
		e1.exchangeSalaries(e2);
		addUndoCommand(this);
	}
}