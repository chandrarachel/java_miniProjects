public class CmdCreate extends RecordedCommand{
    private Equipment eq;

    @Override
    public void execute(String[] cmdParts) {
        try {
            if (cmdParts.length<3)
                throw new ExInsufficientArguments();

            Club c = Club.getInstance();
            try {
                Equipment equipmentFound = c.findEquipment(cmdParts[1]);
                if(equipmentFound != null){
                    throw new ExCodeInUse(equipmentFound);
                }
                eq = new Equipment(cmdParts[1], cmdParts[2]);
        
                addUndoCommand(this);
                clearRedoList();
                System.out.println("Done.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (ExInsufficientArguments e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void undoMe() {
        Club c = Club.getInstance();
        c.removeEquipment(this.eq);
        addRedoCommand(this);
    }

    @Override
    public void redoMe() {
        Club c = Club.getInstance();
        c.addEquipment(this.eq);
        addUndoCommand(this);
    }
    
}
