public class CmdRequest extends RecordedCommand{
    private Member member;
    private Equipment equipment;
    private Day startDate;
    private Day endDate;
    
    @Override
    public void execute(String[] cmdParts){
        try{
            if (cmdParts.length < 5)
                throw new ExInsufficientArguments();

            Club c = Club.getInstance();
            member = c.findMember(cmdParts[1]);
            equipment = c.findEquipment(cmdParts[2]);
            startDate = new Day(cmdParts[3]);
            endDate = startDate.countEndDate(startDate, Integer.parseInt(cmdParts[4]));
            equipment.request(member, equipment, startDate, endDate);
            
            addUndoCommand(this);
            clearRedoList();
        } catch (ExInsufficientArguments e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void undoMe(){
        equipment.removeRequest(member, equipment, startDate, endDate);
        addRedoCommand(this);
    }

    @Override
    public void redoMe(){
        equipment.request(member, equipment, startDate, endDate);
        addUndoCommand(this);
    }
}
