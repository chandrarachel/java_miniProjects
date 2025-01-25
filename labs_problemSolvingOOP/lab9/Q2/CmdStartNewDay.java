public class CmdStartNewDay extends RecordedCommand {
    
    private String sOld, sNew;

    @Override
    public void execute(String[] cmdParts) {
        SystemDate sd = SystemDate.getInstance();
        sNew = cmdParts[1];
        sOld = sd.toString();
        sd.set(cmdParts[1]);
        addUndoCommand(this);
        clearRedoList();
        System.out.println("Done.");
    }

    @Override
    public void undoMe(){
        SystemDate sd = SystemDate.getInstance();
        sd.set(sOld);
        addRedoCommand(this);
    }

    @Override
    public void redoMe(){
        SystemDate sd = SystemDate.getInstance();
        sd.set(sNew);
        addUndoCommand(this);
    }
}
