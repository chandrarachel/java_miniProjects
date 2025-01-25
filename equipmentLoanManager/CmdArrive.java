public class CmdArrive extends RecordedCommand{
    private Equipment eq;

    @Override
    public void execute(String[] cmdParts) {
        try {
            if (cmdParts.length<2)
                throw new ExInsufficientArguments();

            Club c = Club.getInstance();
            eq = c.findEquipment(cmdParts[1]);

            c.equipmentArrived(eq);
        
            addUndoCommand(this);
            clearRedoList();
            System.out.println("Done.");
        } catch (ExInsufficientArguments e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e){
            System.out.println("Missing record for Equipment " + cmdParts[1] + ".  Cannot mark this item arrival.");
        }
    }

    @Override
    public void undoMe() {
        Club c = Club.getInstance();
        c.removeEquipmentArrived(eq);
        addRedoCommand(this);
    }

    @Override
    public void redoMe() {
        Club c = Club.getInstance();
        c.equipmentArrived(eq);
        addUndoCommand(this);
    }
    
}
