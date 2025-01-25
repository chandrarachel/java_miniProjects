import java.util.ArrayList;
import java.util.Collections;

public class Member implements Comparable<Member> {
    private String id;
    private String name;

    private Day joinDate;
    private ArrayList<Equipment> borrowedEquipment;
    private ArrayList<EquipmentSet> borrowedEquipmentSet;

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
        this.joinDate = SystemDate.getInstance().clone();
        this.borrowedEquipment = new ArrayList<>();
        this.borrowedEquipmentSet = new ArrayList<>();

        Club.getInstance().addMember(this);
    }

    public static void list(ArrayList<Member> allMembers) {
        //Learn: "-" means left-aligned
        System.out.printf("%-5s%-9s%11s%11s%13s\n",
        "ID", "Name", "Join Date ", "#Borrowed", "#Requested");
        Collections.sort(allMembers);
        for (Member m: allMembers) {
            System.out.printf("%-5s%-9s%11s%7d%13d\n", m.id, m.name,
            m.joinDate, m.borrowedEquipmentSet.size(), 0);
        }
    }

    public void borrowEquipment(Equipment e, Day startDate, Day endDate, boolean announce) throws ExNoAvailableEquipmentSet, ExMemberIsCurrentlyBorrowingThis {
        EquipmentSet es = e.findAvailableEquipmentSet();
        if(es != null){
            if(!isEquipmentBorrowedByMember(e)){
                e.borrowEquipmentSet(this, es, startDate, endDate, announce);
                borrowedEquipment.add(e);
                borrowedEquipmentSet.add(es);
            } else{
                throw new ExMemberIsCurrentlyBorrowingThis();
            }
        } else{
            throw new ExNoAvailableEquipmentSet();
        }
    }

    private boolean isEquipmentBorrowedByMember(Equipment e) {
        for(Equipment eq: borrowedEquipment){
            if(eq == e){
                return true;
            }
        }
        return false;
    }

    public void removeBorrowedEquipment(Equipment eq){
        EquipmentSet es = eq.findEquipmentSet(eq.getCode() + "_" + borrowedEquipmentSet.size());
        eq.removeBorrowedEquipmentSet(es);
        borrowedEquipment.remove(eq);
        borrowedEquipmentSet.remove(es);
    }

    public String getId() { return id; }

    public void listBorrowedEquipment() {
        if(borrowedEquipment.size() == 0){
            System.out.println("No record.");
        } else{
            Collections.sort(borrowedEquipmentSet);
            for(EquipmentSet es: borrowedEquipmentSet){
                System.out.println("- " + es.announceBorrow());
            }
        }
    }

    public String getID() {
        return id;
    }

    @Override
    public int compareTo(Member another) {
        return this.id.compareTo(another.id);
    }

    @Override
    public String toString() {
        return id + " " + name;
    }
}
