public class ExInvalidNewDay extends Exception{
    public ExInvalidNewDay(String sOld) { super("Invalid new day. The new day has to be later than the current date " + sOld + "."); }
}
