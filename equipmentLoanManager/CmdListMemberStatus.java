public class CmdListMemberStatus extends RecordedCommand{
    @Override
    public void execute(String[] cmdParts){
        Club c = Club.getInstance();
        c.listMemberStatus();
    }

    @Override
    public void undoMe(){}

    @Override
    public void redoMe(){}
}
