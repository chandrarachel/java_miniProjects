import java.util.ArrayList;
import java.util.Collections; //Provides sorting

public class Club {
    private ArrayList<Member> allMembers;
    private static Club instance = new Club();
    private Club() { allMembers = new ArrayList<>(); }
    public static Club getInstance() { return instance; }

    private static ArrayList<Equipment> allEquipments = new ArrayList<>();

    public void addMember(Member m) {// See how it is called in Member constructor (Step 3)
        this.allMembers.add(m); //
        Collections.sort(allMembers); // allMembers
    }

    public void removeMember(Member m) {
        allMembers.remove(m);
    }

    public void listClubMembers() {
        Member.list(this.allMembers);
    }

    public Member findMember(String id){
        for(Member m:allMembers){
            if(m.getId().equals(id)){
                return m;
            }
        }
        return null;
    }

    public void addEquipment(Equipment e){
        allEquipments.add(e);
    }
    public void removeEquipment(Equipment e){
        allEquipments.remove(e);
    }


    public Equipment findEquipment(String code) {
        for(Equipment e: allEquipments){
            if(e.getCode().equals(code)){
                return e;
            }
        }
        return null;
    }

    public void equipmentArrived(Equipment eq) {
        eq.addEquipmentSet();
    }
    public void removeEquipmentArrived(Equipment eq) {
        eq.removeEquipmentSet();
    }
    public void listEquipments() {
        System.out.printf("%-5s%-18s%5s\n", "Code", "Name", "#sets");
        Collections.sort(allEquipments);
        for(Equipment e: allEquipments){
            System.out.printf("%-5s%-18s%3d", e.getCode(), e.getName(), e.getNumberOfEquipmentSets());

            String listBorrowedSetString= e.listBorrowedSets();
            if(listBorrowedSetString != ""){
                System.out.print(" (Borrowed set(s): " + listBorrowedSetString + ")");
            }

            System.out.println();
        }
    }
    public void listMemberStatus() {
        for(Member m: allMembers){
            System.out.println("[" + m + "]");
            m.listBorrowedEquipment();
            System.out.println();
        }
    }
    public void listEquipmentStatus() {
        Collections.sort(allEquipments);
        for(Equipment e: allEquipments){
            System.out.println("[" + e + "]");
            if(e.getNumberOfEquipmentSets() > 0){
                System.out.println(e.listEquipmentSets());
            } else{
                System.out.println("We do not have any sets for this equipment.");
            }
        }
    }



}
