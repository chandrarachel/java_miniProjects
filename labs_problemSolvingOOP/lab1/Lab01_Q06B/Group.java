public class Group {
    private Customer[] customer;
    private int custIdx;
    
    public Group() {
        customer = new Customer[10];
        custIdx = 0;
    }

    public void add(Customer c) {
        customer[custIdx] = c;
        custIdx++;
    }

    public void spend(int value) {
        for (int i=0; i<custIdx; i++) {
            customer[i].spend(value/custIdx);
        }
    }

}
