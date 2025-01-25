public class EquipmentSet implements Comparable<EquipmentSet> { // implements Comparable<EquipmentSet>
    private Member member;
    private String setCode;
    private String equipName;
    private boolean isAvailable; // available or borrowed
    private Day startDate;
    private Day endDate;

    public EquipmentSet(String setCode, String equipName){
        this.member = null;
        this.setCode = setCode;
        this.isAvailable = true;
        this.startDate = null;
        this.endDate = null;
        this.equipName = equipName;
    }

    public void setIsAvailable(boolean status){
        isAvailable = status;
    }
   
    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void borrowEquipmentSet(Member member, Day startDate, Day endDate, boolean announce) {
        this.member = member;
        isAvailable = false;
        this.startDate = startDate;
        this.endDate = endDate;

        if(announce){
            System.out.printf(member + " " + announceBorrow());
            System.out.println();
        }
    }

    public String announceBorrow(){
        String result = String.format("borrows %s (%s) for %s to %s", this.setCode, this.equipName, this.startDate, this.endDate);
        return result;
    }
    public void removeBorrowedEquipmentSet() {
        this.member = null;
        isAvailable = true;
        this.startDate = null;
        this.endDate = null;
    }


    // @Override
    // public String toString(){
    //     return setCode + " (" + equipName + ")";
    // }

    public Object getSetCode() {
        return setCode;
    }

    public Member getMember() {
        return member;
    }

    public String announceBorrowForListEquipSets() {
        String result = String.format("borrows for %s to %s", this.startDate, this.endDate);
        return result;
    }

    @Override
    public String toString(){
        return setCode + "(" + member.getID() + ")";
    }

    @Override
    public int compareTo(EquipmentSet another){
        return this.setCode.compareTo(another.setCode);
    }


    public void requestEquipmentSet(Member member, Day startDate, Day endDate) {
        this.member = member;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isAvailable = false;
        System.out.printf("%s requests %s (%s) for %s to %s\n", member, this.setCode, this.equipName, this.startDate, this.endDate);
    }

    private boolean checkAvailableInPeriod(Day startDate, Day endDate) {
        for(EquipmentSet es: requestedEquipmentSetList){
            if(startDate.compareTo(endDate) < 0 && endDate.compareTo(startDate) > 0){
                return false;
            }
        }
        return true;
    }

    public void removeRequest() {
        this.member = null;
        this.startDate = null;
        this.endDate = null;
        this.isAvailable = true;
    }

    public boolean checkAvailableInPeriod(Day startDate2, Day endDate2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkAvailableInPeriod'");
    }
}
