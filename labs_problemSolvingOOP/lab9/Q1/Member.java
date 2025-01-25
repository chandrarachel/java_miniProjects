import java.util.ArrayList;

public class Member implements Comparable<Member> {
    private String id;
    private String name;
    private Day joinDate;

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
        this.joinDate = SystemDate.getInstance().clone();

        Club.getInstance().addMember(this);
    }

    public static void list(ArrayList<Member> allMembers) {
        //Learn: "-" means left-aligned
        System.out.printf("%-5s%-9s%11s%11s%13s\n",
        "ID", "Name", "Join Date ", "#Borrowed", "#Requested");
        for (Member m: allMembers) {
            System.out.printf("%-5s%-9s%11s%7d%13d\n", m.id, m.name,
            m.joinDate, 0, 0);
        }
    }

    @Override
    public int compareTo(Member another) {
        return this.id.compareTo(another.id);
    }
}
