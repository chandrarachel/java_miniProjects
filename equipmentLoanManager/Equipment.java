import java.util.*;

public class Equipment implements Comparable<Equipment> {
    private String code;
    private String name;
    private Club c;
    private ArrayList<EquipmentSet> allEquipmentsSet;
    private ArrayList<EquipmentSet> borrowedEquipmentSetList = new ArrayList<>();
    private ArrayList<EquipmentSet> requestedEquipmentSetList = new ArrayList<>();

    public Equipment(String code, String name){
        this.code = code;
        this.name = name;
        allEquipmentsSet = new ArrayList<>();

        c = Club.getInstance();
        c.addEquipment(this);
    }

    public String getCode(){
        return code;
    }

    public void addEquipmentSet(){
        String setCode = code + "_" + (allEquipmentsSet.size()+1);
        EquipmentSet es = new EquipmentSet(setCode, name);
        allEquipmentsSet.add(es);
    }

    public void removeEquipmentSet(){
        String setCode = code + "_" + allEquipmentsSet.size();
        EquipmentSet es = findEquipmentSet(setCode);
        allEquipmentsSet.remove(es);
    }

    public EquipmentSet findEquipmentSet(String setCode){
        for(EquipmentSet es: allEquipmentsSet){
            if(es.getSetCode().equals(setCode)){
                return es;
            }
        }
        return null;
    }

    // public void listEquipmentSets(){
    //     EquipmentSet.list(this.allEquipmentsSet);
    // }

    public EquipmentSet findAvailableEquipmentSet() {
        for(EquipmentSet es: allEquipmentsSet){
            if(es.getIsAvailable()){
                return es;
            }
        }
        return null;
    }

    public void borrowEquipmentSet(Member member, EquipmentSet es, Day startDate, Day endDate, boolean announce) {
        es.borrowEquipmentSet(member, startDate, endDate, announce);
        borrowedEquipmentSetList.add(es);
    }
    public void removeBorrowedEquipmentSet(EquipmentSet es) {
        es.removeBorrowedEquipmentSet();
        borrowedEquipmentSetList.remove(es);
    }

    public Object getName() {
        return name;
    }

    public int getNumberOfEquipmentSets() {
        return allEquipmentsSet.size();
    }

    public String listBorrowedSets() {
        String result = "";
        for(int i=0; i<allEquipmentsSet.size(); i++){
            EquipmentSet es = allEquipmentsSet.get(i);
            if(!es.getIsAvailable()){
                result += es;
                if(i != borrowedEquipmentSetList.size()-1){
                    result += ", ";
                }
            }
        }
        return result;
    }

    public String listEquipmentSets() {
        String result = "";
        Collections.sort(borrowedEquipmentSetList);
        for(EquipmentSet es: allEquipmentsSet){
            result += String.format("%6s\n", es.getSetCode());
            result += String.format("%4sCurrent status: ", "");
            if(es.getMember() != null){
                result += String.format(es.getMember() + " " + es.announceBorrowForListEquipSets() + "\n");
            } else{
                result += "Available\n";
            }
        }
        return result;
    }

    @Override
    public String toString(){
        return code + " " + name;
    }

    @Override
    public int compareTo(Equipment another) {
        return this.code.compareTo(another.code);
    }

    public void request(Member member, Equipment equipment, Day startDate, Day endDate) {
        EquipmentSet es = findAvailableEquipmentSet();
        if(es != null && es.checkAvailableInPeriod(startDate, endDate)){
            es.requestEquipmentSet(member, startDate, endDate);
            requestedEquipmentSetList.add(es);
        }
    }

    public void removeRequest(Member member, Equipment equipment, Day startDate, Day endDate) {
        EquipmentSet es = findEquipmentSetByMember(member);
        es.removeRequest();
        requestedEquipmentSetList.remove(es);
    }

    private EquipmentSet findEquipmentSetByMember(Member member) {
        for(EquipmentSet es: requestedEquipmentSetList){
            if(es.getMember() == member){
                return es;
            }
        }
        return null;
    }
        
            

    

}