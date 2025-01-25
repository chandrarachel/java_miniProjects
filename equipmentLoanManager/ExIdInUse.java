public class ExIdInUse extends Exception {
    public ExIdInUse(Member member) {
        super("Member ID already in use: " + member);
    }
    public ExIdInUse(String message) { super(message); }
}
