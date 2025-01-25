public class CmdListEquipmentStatus extends RecordedCommand{
    @Override
    public void execute(String[] cmdParts){
        Club c = Club.getInstance();
        c.listEquipmentStatus();
    }

    @Override
    public void undoMe(){}
    @Override
    public void redoMe(){}
}
