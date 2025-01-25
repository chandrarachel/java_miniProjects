import java.util.ArrayList;
import java.util.Collections; //Provides sorting

public class Club {
    private ArrayList<Member> allMembers;
    private static Club instance = new Club();
    private Club() { allMembers = new ArrayList<>(); }
    public static Club getInstance() { return instance; }

    public void addMember(Member m) {// See how it is called in Member constructor (Step 3)
        this.allMembers.add(m); //
        Collections.sort(allMembers); // allMembers
    }

    public void listClubMembers() {
        Member.list(this.allMembers);
    }
}
