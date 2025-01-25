public class CmdRegister extends RecordedCommand{
    private Member m;

    @Override
    public void execute(String[] cmdParts) {
        m = new Member(cmdParts[1], cmdParts[2]);
        addUndoCommand(this);
        clearRedoList();
        System.out.println("Done.");
    }

    @Override
    public void undoMe() {
        Club c = Club.getInstance();
        c.removeMember(this.m);
        addRedoCommand(this);
    }

    @Override
    public void redoMe() {
        Club c = Club.getInstance();
        c.addMember(this.m);
        addUndoCommand(this);
    }
    
}
