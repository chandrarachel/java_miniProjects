public class CmdRegister extends RecordedCommand{
    private Member m;

    @Override
    public void execute(String[] cmdParts) {
        try {
            if (cmdParts.length<3)
                throw new ExInsufficientArguments();

            Club c = Club.getInstance();
            try {
                Member memberFound = c.findMember(cmdParts[1]);
                if(memberFound != null){
                    throw new ExIdInUse(memberFound);
                }
                m = new Member(cmdParts[1], cmdParts[2]);
            
                addUndoCommand(this);
                clearRedoList();
                System.out.println("Done.");
            } catch (ExIdInUse e) {
                System.out.println(e.getMessage());
            }
        } catch (ExInsufficientArguments e) {
            System.out.println(e.getMessage());
        }
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
