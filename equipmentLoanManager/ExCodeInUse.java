public class ExCodeInUse extends Exception{
    public ExCodeInUse(Equipment e){
        super("Equipment code already in use: " + e);
    }
    public ExCodeInUse(String message) { super(message); }
}