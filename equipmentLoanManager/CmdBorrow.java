public class CmdBorrow extends RecordedCommand{
    private Member m;

    private Equipment eq;

    private Day startDate;
    private Day endDate;

    @Override
    public void execute(String[] cmdParts){
        try {
            if(cmdParts.length < 3)
                throw new ExInsufficientArguments();

            Club c = Club.getInstance();
            String id = cmdParts[1];
            String code = cmdParts[2];

            m = c.findMember(id);
            if(m == null){
                throw new ExMemberNotFound();
            }

            eq = c.findEquipment(code);
            if(eq == null){
                throw new ExEquipmentRecordNotFound();
            }

            startDate = SystemDate.getInstance();
            if(cmdParts.length == 3){
                endDate = startDate.countEndDate(startDate, 7);
            } else{
                endDate = startDate.countEndDate(startDate, Integer.parseInt(cmdParts[3]));
            }

            m.borrowEquipment(eq, startDate, endDate, true);

            addUndoCommand(this);
            clearRedoList();
            System.out.println("Done.");
        } catch (ExInsufficientArguments e) {
            System.out.println(e.getMessage());
        } catch (ExNoAvailableEquipmentSet e){
            System.out.println(e.getMessage());
        } catch (ExMemberIsCurrentlyBorrowingThis e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e){
            System.out.println("Member not found.");
        } catch (ExMemberNotFound e){
            System.out.println(e.getMessage());
        } catch (ExEquipmentRecordNotFound e){
            System.out.println(e.getMessage());
        }
    }


    static public boolean isLeapYear(int y) {
		if (y%400==0)
			return true;
		else if (y%100==0)
			return false;
		else if (y%4==0)
			return true;
		else
			return false;
	}

    @Override
    public void undoMe(){
        m.removeBorrowedEquipment(eq);
        addRedoCommand(this);
    }
    @Override
    public void redoMe(){
        try {
            m.borrowEquipment(eq, startDate, endDate, false);
        } catch (ExNoAvailableEquipmentSet e) {
            System.out.println(e.getMessage());
        } catch (ExMemberIsCurrentlyBorrowingThis e) {
            System.out.println(e.getMessage());
        }
        addUndoCommand(this);
    }
}
