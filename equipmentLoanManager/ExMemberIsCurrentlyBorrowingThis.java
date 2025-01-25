public class ExMemberIsCurrentlyBorrowingThis extends Exception{
    public ExMemberIsCurrentlyBorrowingThis(){
        super("The member is currently borrowing a set of this equipment. He/she cannot borrow one more at the same time.");
    }
    public ExMemberIsCurrentlyBorrowingThis(String message){
        super(message);
    }
}
